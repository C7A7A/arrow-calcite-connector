/* *************************************************** */

/* (C) Copyright IBM Corp. 2022                        */

/* *************************************************** */
package com.yourorganizationname.connect.calcite;

import com.ibm.connect.sdk.jdbc.JdbcTargetInteraction;
import com.ibm.wdp.connect.common.sdk.api.models.CustomFlightAssetDescriptor;

@SuppressWarnings({ "PMD.AvoidDollarSigns", "PMD.ClassNamingConventions" })
public class CalciteTargetInteraction extends JdbcTargetInteraction {
//    private static final Logger LOGGER = getLogger(CalciteTargetInteraction.class);
//    private final CalciteConnector connector;
//    private final CustomFlightAssetDescriptor asset;
//    private final Properties interactionProperties;
//    private final String schemaName;
//    private final String tableName;

    /**
     * Creates an Apache Calcite target interaction.
     *
     * @param connector the connector managing the connection to the data source
     * @param asset     the asset to which to write
     * @throws Exception
     */
    public CalciteTargetInteraction(CalciteConnector connector, CustomFlightAssetDescriptor asset) throws Exception {
        super(connector, asset);
//        this.connector = connector;
//        this.asset = asset;
//        interactionProperties = ModelMapper.toProperties(asset.getInteractionProperties());
//        schemaName = interactionProperties.getProperty("schema_name");
//        tableName = interactionProperties.getProperty("table_name");
    }
//    protected CalciteTargetInteraction(CalciteConnector connector, CustomFlightAssetDescriptor asset)
//    {
//        super();
//        this.setConnector(connector);
//        this.setAsset(asset);
//    }
//
//    @Override
//    public void putRecord(Record record)
//    {
//        // TODO Auto-generated method stub
//
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
//    public CustomFlightAssetDescriptor putSetup() throws Exception
//    {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public CustomFlightAssetDescriptor putWrapup() throws Exception
//    {
//        // TODO Auto-generated method stub
//        return null;
//    }

}
