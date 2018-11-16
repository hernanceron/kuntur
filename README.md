## Kigen Framework

### Definition
Kigen is a framework developed by Everis with the objective of demystifying the process
of building microservices following the best practices and focusing in modularity.

### Structure
Our component is a Gradle project that contains many sub-projects. In order to understand
the architecture we have to define every sub-project:

- **Core:** this project contains the extension of the functionality needed for every 
microservice project. This project contains the following packages:
    - logging: Contains the DDD components needed for the logging operations
    - audit: This package include the abstraction need to use the audit funcionality(In progress)
    - validation: Contains the  

### Microservices By Type
Following the best practices of architectural design, we have separated microservices
responsibility. The three main types of microservices that we are using are: 
BFF(Backend For Frontend), business and support. 

- **BFF(Backend For Frontend):** This type of microservice follows the principles of the
Backend For Frontend pattern. The main purpose of this type is dealing with multiple
representations that serve for multiple consumers. 

- **Business:** In this type, the microservices have the responsibility of applying business
rules, business validations and dealing with the connections to another services(business, support)
or multiple datasources related with the business model. 

- **Support:** This type is created to provide technical support to another type of
microservices. The technical support term is related with the connection to legacy
components that don't use the same communication protocol used by the microservices added
in our platform.

### Components
To get our objective of demystifying the building of microservices, we are using/developing 
many tools and even another frameworks.

- **Code generator(CLI):** We are using **Yeoman** to build our code generator. This
tool is used to help with the process of building the initial boilerplate. The code
generator can construct the initial project structure for every microservice with the
addition of several sub-components that can be added via Yeoman.

- **Web framework(s):** There are so many web frameworks in the market, so we have no
intentions on re-inventing the wheel. For this reason we are supporting our framework with
Spring framework and Vertex(In progress). For another features we are using pre-made
frameworks too such as Hibernate, Cucumber, Audit4J, etc. 

- **Validator frameworks**: We have two types of validations on our framework: integrity and business. 
Integrity validations are applied on the message entities to verify the validity of the message(This is 
a requirement for the reactive manifesto). In the other hand, business validations are linked with 
business rules to verify the business process.

- **Dependencies by microservice type**: Every microservice type in Kigen has one set of dependencies
provided by the framework in compilation time and runtime.


### Modules

Kuntur Framework contains several modules, each one with different and marked responsabilities

### Requirements

- Java 8 (any sub-version)

### Installation

 

     