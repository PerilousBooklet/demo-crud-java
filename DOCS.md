## How to setup

Generate the base project with Maven:

```sh
mvn -B archetype:generate \
    -DgroupId=com.perilousbooklet.app \
    -DartifactId=src \
    -DarchetypeArtifactId=maven-archetype-quickstart \
    -DarchetypeVersion=1.4
# FIX
sed -i 's/<maven.compiler.source>1.7/<maven.compiler.source>1.8/g' ./src/pom.xml
sed -i 's/<maven.compiler.target>1.7/<maven.compiler.target>1.8/g' ./src/pom.xml

cp -v ./build.sh ./src/build.sh
```

Add the required blocks in `pom.xml`: 

```xml
<parent>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-parent</artifactId>
	<version>3.5.3</version>
	<relativePath/> <!-- lookup parent from repository -->
</parent>
```

Add the required dependencies in the `pom.xml`: 

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>

<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-validation</artifactId>
</dependency>

<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-test</artifactId>
	<scope>test</scope>
</dependency>

<dependency>
	<groupId>org.postgresql</groupId>
	<artifactId>postgresql</artifactId>
	<scope>runtime</scope>
	<version>42.7.3</version>
</dependency>
```

Add the required Maven plugin: 

```xml
<plugin>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-maven-plugin</artifactId>
  <!-- NEEDED to avoid missing MANIFEST file in jar file -->
  <executions>
    <execution>
      <goals>
        <goal>repackage</goal>
      </goals>
    </execution>
  </executions>
</plugin>
```

Create the required folders and files:

- `src/main/resources`
- `src/main/resources/static`
- `src/main/resources/static/css`
- `src/main/resources/static/js`
- `src/main/resources/static/images`
- `src/main/resources/templates`
- `src/main/resources/templates/fragments`
- `src/main/resources/application.properties`

> `application.properties` (use PostgreSQL): 

```
spring.application.name=src

spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://localhost:5432/demo-crud-java
spring.datasource.username=admin
spring.datasource.password=admin

spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update

server.port=8093
```

## How to build



## How to run


