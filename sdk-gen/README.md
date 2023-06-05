# Apache ArrowFlight Calcite connector

Failed attempt to implement ArrowFlight Calcite connector.

Connector is based on generic JDBC connector.

### What went wrong?  
Because of calcite libraries added to <code>sdk-gen/subprojects/calcite/build.gradle</code>\
<code>
implementation group: 'org.apache.calcite', name: 'calcite-core', version: project['calcite.version']
implementation group: 'org.postgresql', name: 'postgresql', version: project['postgresql.version'] 
</code>

Connector cannot obtain connection to calcite in <code>connect</code> method in <code>sdk-gen/subprojects/calcite/src/main/java/com/ibm/connect/sdk/jdbc/JdbcConnector.java</code>

Error message:\
<code>
java.lang.LinkageError: loading constraint violation when resolving method "com/google/common/collect/Maps.asMap(Ljava/util/Set;Lcom/google/common/base/Function;)Ljava/util/Map;" : loader "com/ibm/ws/classloading/internal/AppClassLoader@48ed3412" of class "org/apache/calcite/util/NameSet" and loader "org/eclipseosgi/internal/loader/EquinoxClassLoader@1e135d33" of class "com/google/common/collect/Maps" have different types for the method signature
</code>

Both libraries (Arrow Flight GRPC and Calcite Core) have in dependencies: <code>com.google.guava » guava</code> which is root of an error\
https://mvnrepository.com/artifact/org.apache.calcite/calcite-core/1.34.0 \
https://mvnrepository.com/artifact/org.apache.arrow/flight-grpc/11.0.0

### How to run
1. <code> ./gradlew build -x test </code>
2. Start docker service
3. <code> ./gradlew dockerBuild </code> if docker image is not built
4. <code> ./gradlew dockerStart </code> to start docker container
5. <code> docker exec -it wdp-connect-sdk-gen-calcite-flight bash </code> in terminal to connect to docker container
6. <code> tail -f /logs/trace.log </code> to see logs
7. open jupyter notebook (provided in repo) and run cells. You should see output in terminal.