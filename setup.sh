#!/usr/bin/bash

# ?
mvn -B archetype:generate \
    -DgroupId=com.perilousbooklet.app \
    -DartifactId=src \
    -DarchetypeArtifactId=maven-archetype-quickstart \
    -DarchetypeVersion=1.4

# FIX
sed -i 's/<maven.compiler.source>1.7/<maven.compiler.source>1.8/g' ./src/pom.xml
sed -i 's/<maven.compiler.target>1.7/<maven.compiler.target>1.8/g' ./src/pom.xml

# ?
cat << EOT > ./src/build.sh
#!/usr/bin/bash
mvn compile
mvn test
mvn clean
mvn package
mvn exec:java -Dexec.mainClass="com.perilousbooklet.app.App"
EOT
