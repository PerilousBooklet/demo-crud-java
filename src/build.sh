#!/usr/bin/bash
mvn clean
mvn compile
mvn test
mvn package
mvn javadoc:javadoc
mvn exec:java -Dexec.mainClass="com.perilousbooklet.app.App"
