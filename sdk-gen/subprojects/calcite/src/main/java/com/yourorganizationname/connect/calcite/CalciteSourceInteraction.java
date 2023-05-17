/* *************************************************** */

/* (C) Copyright IBM Corp. 2022                        */

/* *************************************************** */
package com.yourorganizationname.connect.calcite;

import com.ibm.connect.sdk.api.TicketInfo;
import com.ibm.connect.sdk.jdbc.JdbcSourceInteraction;
import com.ibm.wdp.connect.common.sdk.api.models.CustomFlightAssetDescriptor;
import org.apache.arrow.flight.Ticket;

@SuppressWarnings({ "PMD.AvoidDollarSigns", "PMD.ClassNamingConventions" })
public class CalciteSourceInteraction extends JdbcSourceInteraction
{
//    private final CalciteConnector connector;
//    private final CustomFlightAssetDescriptor asset;

    /**
     * Creates an Apache Calcite source interaction.
     *
     * @param connector
     *            the connector managing the connection to the data source
     * @param asset
     *            the asset from which to read
     * @param ticket
     *            a Flight ticket to read a partition or null to get tickets
     * @throws Exception
     */
    public CalciteSourceInteraction(CalciteConnector connector, CustomFlightAssetDescriptor asset, Ticket ticket) throws Exception {
        super(connector, asset, ticket);
//        this.connector = connector;
//        this.asset = asset;
    }

    //TODO change return string!
    @Override
    protected String generateRowLimitPrefix(long rowLimit) {
        return "GENERATE ROW LIMIT PREFIX " + rowLimit;
    }

    @Override
    protected String generateRowLimitSuffix(long rowLimit) {
        return "FETCH FIRST " + rowLimit + " ROWS ONLY";
    }

    @Override
    protected String getPartitioningPredicate(TicketInfo partitionInfo) {
        return null;
    }
//    protected CalciteSourceInteraction(CalciteConnector connector, CustomFlightAssetDescriptor asset)
//    {
//        super();
//        setConnector(connector);
//        setAsset(asset);
//    }
//
//    @Override
//    public Record getRecord()
//    {
//        // TODO implement this
//        return null;
//    }
//
//    @Override
//    public void close() throws Exception
//    {
//        super.close();
//    }
//
//    @Override
//    public List<Ticket> getTickets() throws Exception
//    {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public List<CustomFlightAssetField> getFields()
//    {
//        // TODO Auto-generated method stub
//        return null;
//    }
}
