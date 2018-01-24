## Licenses Management System

This is a Spring cloud microservices exercise project, I use Spring Boot(Hibernate and Spring JPA included) to build and use Docker container to deploy the project finally into the Amazon AWS cloud.

First of all, you need install Apache Maven, Docker and Git client on your development PC.

**The features:**
1. A Spring Cloud Config server that is deployed as Docker container and can manage a services configuration information using a GitHub-based repository.
2. A Eureka server running as cloud-based microservice allows multiple service instances to register with it.  Clients that need to call a service will use Eureka to lookup the physical location of the target service
3. A organization microservice manages organization data used by eagle_eye_localdatabase.
4. A licensing microservice manages licensing data used by eagle_eye_localdatabase.
5. A PostgreSQL database stores the data for these two microservices mentioned above.

Run the command at the root of the project directory to build all of the projects(microservices):
**mvn clean package docker:build**

Run the docker-compose command to start the actual image:
**docker-compose -f docker/common/docker-compose.yml up**

Be patient, wait till you read something like this on your screen:
com.datesgreat.licenses.Application      : Started Application in xxx.yyy seconds

Here, depending on your server, "xxx" can range from 100 to 300.

Now you can copy
http://localhost:8761/eureka/apps/organizationservice

and paste it on your browser then press enter, aha... If you want to see the json format, then you might as well use Postman and set the Accept HTTP header to be application/json.
