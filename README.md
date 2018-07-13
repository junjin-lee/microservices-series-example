# microservice-series-example

## Reference
This example is a simple version of [Microservices Using Spring Boot and Spring Cloud](https://dzone.com/articles/microservices-using-spring-boot-amp-spring-cloud-p)

## Dependency
* Java 8
* docker and docker-compose

## Environment Setup
### Software
* [VirtualBox](https://www.virtualbox.org/)
* [CentOS](https://www.centos.org/)
* [Docker](https://www.docker.com/)
* [Docker-Compose](https://docs.docker.com/compose/)
* [IDEA Community Edition](https://www.jetbrains.com/idea/)
* [Git](https://git-scm.com/)

### Installation
* [Download Oracle VM Virtual Box for your Host](https://www.virtualbox.org/wiki/Downloads)
* [Download the CentOS 7 Minimal ISO](https://www.centos.org/download/)
* [Install CentOS 7 Minimal on VirtualBox](http://www.jeramysingleton.com/install-centos-7-minimal-in-virtualbox/)
* [Install Docker on CentOS 7](https://www.digitalocean.com/community/tutorials/how-to-install-and-use-docker-on-centos-7)
* [Install Docker Compose](https://docs.docker.com/compose/install/#install-compose)
* [Install Git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)

### Development
* Clone Code
    ```bash
    $ git clone git@github.ibm.com:dlyanxue/microservices-series-example.git
    ```
* Open the project with IDEA
* Follow the Start Sequence

## Start Sequence

You can also run the following mvn script to start or run the *Application per module in IDE

```bash
# 1. mysql and vault
microservices-series-example> docker-compose up

# 2. config-server
config-server> mvn spring-boot:run

# 3. service-registry
service-registry> mvn spring-boot:run

# 4. inventory-service
inventory-service> mvn spring-boot:run

# 5. catalog-service
catalog-service> mvn spring-boot:run

# 6. order-service
order-service> mvn spring-boot:run

# 7. shoppingcart-ui
shoppingcart-ui> mvn spring-boot:run
```

## Modules
* MySQL container:
     * Ports : 3306
     * Username/Password: root/admin

* Vault:
    * Ports: 8200
    * Root token: 0fbcac20-cc0a-4230-a0a2-7a3ac201a29b

* config-server:
    * Ports: 8888
    * URL: http://localhost:8888/

* service-registry:
    * Ports: 8761
    * URL: http://localhost:8761/
    
* hystrix-dashboard:
    * Ports: 8788
    * URL: http://localhost:8788/hystrix

* catalog-service:
    * Ports: 8181
    * URL: http://localhost:8181
    
* inventory-service
    * Ports: 8282
    * URL: http://localhost:8282
    
* order-service
    * Ports: 8383
    * URL: http://localhost:8383 
    
* shoppingcart-ui
    * Ports: 8080
    * URL: http://localhost:8080
