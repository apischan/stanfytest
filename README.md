# stanfytest

### Application area:
Application provides REST API for storing and retreiving candidates (for some vacancies) and their skills.

### Frameworks and tools:
* **Java 8** - as main language
* **Groovy** - for integration tests
* **Ratpack** - as HTTP framework
* **Google Guice** - for dependency injection
* **PostgreSQL** - as ORDBMS
* **JOOQ** - for querying database
* **HikariCP** - as connection pool
* **Slf4J/Logback** - for logging
* **Gradle** - ad build tool
* **Docker** - containerizer for deployment
* **Lombok** - for generation of boilerplate code
* **Spock** - for integration tests
* **H2** - as in-memory database for tests


### Available endpoints:

* **[GET]<root_path>/candidates** - to get all candidates with their skills
* **[GET]<root_path>/candidates/:id** - to get candidate by id
* **[POST]<root_path>/candidate** (with payload) - to store candidate and it's skills into database
* **[GET]<root_path>/skills** - to get all skills from database
* **[GET]<root_path>/skills/:id** - to get skill by id
* **[GET]<root_path>/skills?name=<?>** - to get skill by name

### Run the application:

For running the application you need to have installed Java 8 and docker-compose utility on your machine
```bash
user@host:~/stanfytest$ ./gradlew installShadowApp
user@host:~/stanfytest$ cd docker/
user@host:~/stanfytest/docker$ docker-compose up
```
Application will be available under http://localhost:8082