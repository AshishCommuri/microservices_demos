# microservices_demos
My Microservices demo projects repo
---

# Microservices Demo Project

## Overview

This repository contains a collection of microservices demos built with Java and Spring Boot. These microservices are designed to showcase various essential concepts in a microservices architecture, including service discovery, API gateway, configuration management, and inter-service communication. The project is intended to demonstrate the integration of multiple services to create a scalable, distributed system using Spring Cloud and other relevant technologies.

The following microservices are included in this demo:

- **API Gateway Server** (`api-gateway-server`)
- **Currency Conversion Service** (`currency-conversion-service`)
- **Currency Exchange Service** (`currency-exchange-service`)
- **Eureka Naming Server** (`eureka-naming-server`)
- **Limits Services** (`limits-services`)
- **Netflix Eureka Naming Server** (`netflix-eureka-naming-server`)
- **Spring Cloud Config Server** (`spring-cloud-config-server`)

### Key Features

- **Service Discovery** with Eureka (both a custom and Netflix implementation)
- **API Gateway** routing requests to appropriate services
- **Configuration Management** using Spring Cloud Config Server
- **Centralized Configuration** for properties and metadata
- **Microservice Communication** for currency conversion and exchange rates
- **Spring Boot** for easy setup and rapid development

This repository will serve as the central location for all future microservices-related projects, and additional microservices will be added as the project evolves.

---

## Microservices Breakdown

### 1. **API Gateway Server** (`api-gateway-server`)
The **API Gateway** acts as the entry point for clients to interact with the various microservices in the system. It provides routing, load balancing, and sometimes additional features like authentication, rate limiting, and monitoring.

- **Technology Stack**: Spring Boot, Spring Cloud Gateway
- **Responsibilities**:
  - Acts as a reverse proxy for routing client requests to appropriate microservices.
  - Centralized entry point to the system.

---

### 2. **Currency Conversion Service** (`currency-conversion-service`)
The **Currency Conversion Service** provides functionality to convert an amount from one currency to another. It takes into account the exchange rates between currencies and returns the converted amount.

- **Technology Stack**: Spring Boot
- **Responsibilities**:
  - Exposes a REST API to receive a currency conversion request.
  - Converts the given amount using hardcoded or fetched exchange rates.

---

### 3. **Currency Exchange Service** (`currency-exchange-service`)
The **Currency Exchange Service** provides the exchange rates for different currencies. It acts as a provider for the Currency Conversion Service by returning real-time exchange rate data.

- **Technology Stack**: Spring Boot
- **Responsibilities**:
  - Exposes a REST API that provides exchange rates for different currency pairs.
  - Can simulate or fetch exchange rates from an external service.

---

### 4. **Eureka Naming Server** (`eureka-naming-server`)
The **Eureka Naming Server** is a **Service Discovery** server that enables microservices to register themselves and discover other services in the system. It helps to manage and track the instances of different services in a dynamic environment.

- **Technology Stack**: Spring Boot, Spring Cloud Eureka
- **Responsibilities**:
  - Acts as a service registry for other microservices to register themselves.
  - Provides a centralized list of available services and their statuses.
  - Ensures that microservices can locate and interact with each other dynamically.

---

### 5. **Limits Services** (`limits-services`)
The **Limits Service** provides configuration-related data such as maximum and minimum values for certain parameters (e.g., transaction limits, request limits). It serves as a reference for services that need configuration values.

- **Technology Stack**: Spring Boot
- **Responsibilities**:
  - Exposes a REST API to fetch the upper and lower limits for certain operations (e.g., financial transactions).
  - Acts as a centralized service for configurations and limits.

---

### 6. **Netflix Eureka Naming Server** (`netflix-eureka-naming-server`)
This is a version of the **Eureka Naming Server** using Netflix's open-source implementation of Eureka. It provides the same service discovery functionality as the `eureka-naming-server` but uses the Netflix-provided libraries for service registry and discovery.

- **Technology Stack**: Spring Boot, Spring Cloud Eureka (Netflix)
- **Responsibilities**:
  - Acts as a service registry and discovery server to manage microservices in the system.
  - Allows other services to register and discover each other dynamically.

---

### 7. **Spring Cloud Config Server** (`spring-cloud-config-server`)
The **Spring Cloud Config Server** is a centralized configuration management server that stores and serves configuration data for all the microservices. It allows for externalized configuration, making it easier to manage and change configurations across environments.

- **Technology Stack**: Spring Boot, Spring Cloud Config
- **Responsibilities**:
  - Serves configuration properties from a Git repository or file system to the microservices.
  - Provides a centralized way to manage application properties across all services.

---

## Architecture Diagram

![Microservices Architecture](link-to-your-architecture-diagram.png)

---

## Setup Instructions

### Prerequisites

- **JDK 11+** (or any other supported version)
- **Maven** for building and managing dependencies
- **Git** for version control

### Cloning the Repository

1. Clone this repository to your local machine:

   ```bash
   git clone https://github.com/yourusername/microservices-demo.git
   cd microservices-demo
   ```

### Running the Services

You can run each microservice individually using Maven, or you can set up a `docker-compose.yml` to run them all in containers.

#### Running Services Individually

1. Navigate to each service directory (e.g., `api-gateway-server`, `currency-conversion-service`, etc.).
2. Run the following Maven command to build and start the service:

   ```bash
   mvn spring-boot:run
   ```

#### Using Docker Compose (Optional)

If you'd prefer to use Docker, you can set up a `docker-compose.yml` file to manage the containers. Here's an example of how to set it up (replace paths and settings as appropriate):

```yaml
version: '3.8'

services:
  api-gateway-server:
    image: your-docker-image
    ports:
      - "8080:8080"
    depends_on:
      - eureka-naming-server
      - spring-cloud-config-server

  eureka-naming-server:
    image: your-docker-image
    ports:
      - "8761:8761"

  spring-cloud-config-server:
    image: your-docker-image
    ports:
      - "8888:8888"

  currency-exchange-service:
    image: your-docker-image
    ports:
      - "8000:8000"

  currency-conversion-service:
    image: your-docker-image
    ports:
      - "8100:8100"

  limits-services:
    image: your-docker-image
    ports:
      - "8200:8200"

  netflix-eureka-naming-server:
    image: your-docker-image
    ports:
      - "8762:8762"
```

Run the services using Docker Compose:

```bash
docker-compose up --build
```

---

## API Endpoints

### 1. **API Gateway Server**

- **GET** `/api-gateway/convert-currency`
  - Routes the request to the **Currency Conversion Service**.
  
- **GET** `/api-gateway/exchange-rates`
  - Routes the request to the **Currency Exchange Service**.

### 2. **Currency Conversion Service**

- **GET** `/currency-conversion/from/{fromCurrency}/to/{toCurrency}/amount/{amount}`
  - Converts the given amount from one currency to another.

### 3. **Currency Exchange Service**

- **GET** `/currency-exchange/from/{fromCurrency}/to/{toCurrency}`
  - Provides the exchange rate for the given currency pair.

### 4. **Eureka Naming Server**

- **GET** `/eureka`
  - Access the Eureka dashboard to view all registered services.

### 5. **Spring Cloud Config Server**

- **GET** `/config/{application}/{profile}`
  - Provides configuration properties for the specified application and profile.

---

## Technologies Used

- **Spring Boot**: Framework for creating standalone, production-grade Spring-based applications.
- **Spring Cloud**: Set of tools for building distributed systems with Spring.
- **Spring Cloud Config**: Centralized configuration management.
- **Spring Cloud Eureka**: Service registry and discovery server.
- **Spring Cloud Gateway**: API Gateway for routing requests to microservices.
- **Maven**: Build automation tool.
- **Docker** (Optional): For containerizing the services.

---

## Conclusion

This repository demonstrates a set of microservices that utilize popular Spring Cloud components to showcase concepts like service discovery, centralized configuration, and API gateways. It is a great starting point for learning and building scalable, distributed systems using Spring technologies.

Additionally, this repository will serve as the main location for all future microservices-related projects, and we will continue adding new services and features as the project grows.

---
