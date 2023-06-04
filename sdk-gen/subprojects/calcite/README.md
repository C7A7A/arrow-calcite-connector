# Apache ArrowFlight Calcite connector

Failed attempt to implement ArrowFlight Calcite connector.

Connector is based on generic JDBC connector.

Unfortunately connector cannot obtain connection to calcite because of error

<code>java.lang.LinkageError: loading constraint violation when resolving method "com/google/common/collect/Maps.asMa
p(Ljava/util/Set;Lcom/google/common/base/Function;)Ljava/util/Map;" : loader "com/ibm/ws/classloading/internal/AppClassLoader@48ed3412" of class "org/apache/calcite/util/NameSet" and loader "org/eclipse/osgi/int
ernal/loader/EquinoxClassLoader@1e135d33" of class "com/google/common/collect/Maps" have different types for the method signature</code>