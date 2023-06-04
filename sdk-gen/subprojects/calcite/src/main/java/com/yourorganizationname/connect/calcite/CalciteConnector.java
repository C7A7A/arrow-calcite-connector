/* *************************************************** */

/* (C) Copyright IBM Corp. 2022                        */

/* *************************************************** */
package com.yourorganizationname.connect.calcite;

import com.ibm.connect.sdk.jdbc.JdbcConnector;
import com.ibm.connect.sdk.jdbc.JdbcSourceInteraction;
import com.ibm.connect.sdk.jdbc.JdbcTargetInteraction;
import com.ibm.wdp.connect.common.sdk.api.models.ConnectionProperties;
import com.ibm.wdp.connect.common.sdk.api.models.CustomFlightAssetDescriptor;
import com.ibm.wdp.connect.common.sdk.api.models.CustomFlightAssetsCriteria;
import org.apache.arrow.flight.Ticket;

import java.sql.Driver;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;
import org.slf4j.Logger;

@SuppressWarnings({ "PMD.AvoidDollarSigns", "PMD.ClassNamingConventions" })
public class CalciteConnector extends JdbcConnector
{
    private static final Logger LOGGER = getLogger(JdbcConnector.class);

    private ConnectionProperties props;
    /**
     * Creates an Apache Calcite connector.
     *
     * @param properties
     *            connection properties
     */
    public CalciteConnector(ConnectionProperties properties)
    {
        super(properties);
        this.props = properties;
    }

    // TODO: I don't know if this driver url is correct.
    @Override
    protected Driver getDriver() throws Exception {
//        try {
//            return (Driver) Class.forName("org.apache.calcite.jdbc.Driver").newInstance();
//        } catch (ClassNotFoundException e) {
//            return null;
//        }
        return null;
    }

    /*
    Example jupyter request:
    {
    "datasource_type_name": "calcite",
        "connection_properties": {
            "schemaFactory": "org.apache.calcite.adapter.jdbc.JdbcSchema$Factory",
            "schema": "public",
            "schema.jdbcDriver": "org.postgresql.Driver",
            "schema.jdbcUrl": "jdbc:postgresql://172.17.0.2:5432/postgres",
            "schema.jdbcUser": "postgres",
            "schema.jdbcPassword": "postgres"
        }
    }
    */
    @Override
    protected String getConnectionURL() {
        LOGGER.info("getConn: Before conn props");
        props.entrySet().stream().forEach(x -> LOGGER.info(x.getKey() + " : " + x.getValue()));

        final StringBuilder connUrl = new StringBuilder("jdbc:calcite:schemaType=CUSTOM; ");
        props.entrySet().stream().forEach(x -> connUrl.append(x.getKey() + "=" + x.getValue() + ";"));

        return connUrl.toString();
    }

    @Override
    public JdbcSourceInteraction getSourceInteraction(CustomFlightAssetDescriptor asset, Ticket ticket) throws Exception {
        return new CalciteSourceInteraction(this, asset, ticket);
    }

    @Override
    public JdbcTargetInteraction getTargetInteraction(CustomFlightAssetDescriptor asset) throws Exception {
        return new CalciteTargetInteraction(this, asset);
    }

    @Override
    public List<CustomFlightAssetDescriptor> discoverAssets(CustomFlightAssetsCriteria criteria) throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }

//    @Override
//    public void close() throws Exception
//    {
//        // TODO Auto-generated method stub
//
//    }
//
//    @Override
//    public void connect()
//    {
//        // TODO Auto-generated method stub
//
//    }
//
//    @Override
//    public ConnectionActionResponse performAction(String action, ConnectionActionConfiguration conf)
//    {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public void commit()
//    {
//        // TODO Auto-generated method stub
//
//    }
}
