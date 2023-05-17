/* *************************************************** */

/* (C) Copyright IBM Corp. 2022                        */

/* *************************************************** */
package com.yourorganizationname.connect.calcite;

import com.ibm.connect.sdk.jdbc.JdbcConnector;
import com.ibm.connect.sdk.jdbc.JdbcSourceInteraction;
import com.ibm.connect.sdk.jdbc.JdbcTargetInteraction;
import com.ibm.wdp.connect.common.sdk.api.models.ConnectionProperties;
import com.ibm.wdp.connect.common.sdk.api.models.CustomFlightAssetDescriptor;
import org.apache.arrow.flight.Ticket;

import java.sql.Driver;

@SuppressWarnings({ "PMD.AvoidDollarSigns", "PMD.ClassNamingConventions" })
public class CalciteConnector extends JdbcConnector
{
    /**
     * Creates an Apache Calcite connector.
     *
     * @param properties
     *            connection properties
     */
    public CalciteConnector(ConnectionProperties properties)
    {
        super(properties);
    }

    // TODO: I don't know if this driver url is correct.
    @Override
    protected Driver getDriver() throws Exception {
        try {
            return (Driver) Class.forName("org.apache.calcite.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    // TODO: Probably need to add some params (host? port?)
    @Override
    protected String getConnectionURL() {
        return "jdbc:calcite:";
    }

    @Override
    public JdbcSourceInteraction getSourceInteraction(CustomFlightAssetDescriptor asset, Ticket ticket) throws Exception {
        return new CalciteSourceInteraction(this, asset, ticket);
    }

    @Override
    public JdbcTargetInteraction getTargetInteraction(CustomFlightAssetDescriptor asset) throws Exception {
        return new CalciteTargetInteraction(this, asset);
    }

//    @Override
//    public List<CustomFlightAssetDescriptor> discoverAssets(CustomFlightAssetsCriteria criteria) throws Exception
//    {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
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
