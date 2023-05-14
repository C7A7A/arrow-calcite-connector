/* *************************************************** */

/* (C) Copyright IBM Corp. 2022                        */

/* *************************************************** */
package com.yourorganizationname.connect.calcite;

import java.util.Arrays;

import com.ibm.connect.sdk.api.Connector;
import com.ibm.connect.sdk.api.ConnectorFactory;
import com.ibm.connect.sdk.api.PooledConnectorFactory;
import com.ibm.wdp.connect.common.sdk.api.models.ConnectionProperties;
import com.ibm.wdp.connect.common.sdk.api.models.CustomFlightDatasourceTypes;

@SuppressWarnings({ "PMD.AvoidDollarSigns", "PMD.ClassNamingConventions" })
public class CalciteConnectorFactory extends PooledConnectorFactory {

    /**
     * A connector factory instance.
     */
    public static final CalciteConnectorFactory INSTANCE = new CalciteConnectorFactory();

    /**
     * The data source types supported by this factory.
     */
    private static final CustomFlightDatasourceTypes DATASOURCE_TYPES
            = new CustomFlightDatasourceTypes().addDatasourceTypesItem(CalciteDatasourceType.INSTANCE);

    @Override
    public CustomFlightDatasourceTypes getDatasourceTypes() {
        return DATASOURCE_TYPES;
    }

    @Override
    protected Connector<?, ?> createNewConnector(String datasourceTypeName, ConnectionProperties properties) {
        if (CalciteDatasourceType.INSTANCE.getName().equals(datasourceTypeName)) {
            return new CalciteConnector(properties);
        }
        throw new UnsupportedOperationException("Data source type " + datasourceTypeName + " is not supported");
    }
//
//    /**
//     * A connector factory instance.
//     *
//     * @return a connector factory instance
//     */
//    public static CalciteConnectorFactory getInstance()
//    {
//        return INSTANCE;
//    }
//
//    /**
//     * Creates a connector for the given data source type.
//     *
//     * @param datasourceTypeName
//     *            the name of the data source type
//     * @param properties
//     *            connection properties
//     * @return a connector for the given data source type
//     */
//    @Override
//    public CalciteConnector createConnector(String datasourceTypeName, ConnectionProperties properties)
//    {
//        if ("calcite".equals(datasourceTypeName)) {
//            return new CalciteConnector(properties);
//        }
//        throw new UnsupportedOperationException(datasourceTypeName + " is not supported!");
//    }
//
//    @Override
//    public CustomFlightDatasourceTypes getDatasourceTypes()
//    {
//        return new CustomFlightDatasourceTypes().datasourceTypes(Arrays.asList(new CalciteDatasourceType()));
//    }
}
