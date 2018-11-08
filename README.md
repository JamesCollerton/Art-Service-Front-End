[![Build Status](https://travis-ci.com/JamesCollerton/Art_Service_Front_End.svg?branch=master)](https://travis-ci.com/JamesCollerton/Art_Service_Front_End)
[![codecov](https://codecov.io/gh/JamesCollerton/Art_Service_Front_End/branch/master/graph/badge.svg)](https://codecov.io/gh/JamesCollerton/Art_Service_Front_End)
[![Maintainability](https://api.codeclimate.com/v1/badges/e7f983e7d764d481c035/maintainability)](https://codeclimate.com/github/JamesCollerton/Art_Service_Front_End/maintainability)

# Art Service Front End

Welcome to the art services ecosystem! This is a test project I made in order to further my understanding of services. Although none of the services take precedence I am using this project to describe the ecosystem and roughly how it works. Currently there are the following components:

- [Front End](https://github.com/JamesCollerton/Art_Service_Front_End)
- [Manipulating Data Service](https://github.com/JamesCollerton/Art_Service_Manipulating_Data_Service)
- [Sourcing Data Service](https://github.com/JamesCollerton/Art_Service_Sourcing_Data_Service)
- [Eureka Server](https://github.com/JamesCollerton/Art_Service_Eureka_Server)
- [Zuul Server](https://github.com/JamesCollerton/Art_Service_Gateway)
- [Infrastructure as Code](https://github.com/JamesCollerton/Art_Service_Infrastructure_as_Code)

# Components

The purpose of each of the components is outlined below:

## Front End

This handles all of the UI for the service. It is a very simple web page which takes in and displays art piece information.

## Manipulating Data Service

This handles manipulating data. We have a reference data service that is used to pull data from a mock database. This service takes that data and would, if needed, do some manipulation.

## Sourcing Data Service

This handles sourcing data from a database. Ideally it would pull from a permanent DB, however for the case of demonstration it pulls only from an embedded H2 DB.

## Eureka Server

This is the server registry. All services register themselves here to make themselves discoverable to each other.

## Zuul Server

This is the edge service. Ideally when we connect to the site or any of the services we should do it through here.

## Infrastructure As Code

The infrastructure for the site is on AWS. This repository holds the Terraform for spinning up ECS clusters, making S3 buckets etc.

# Dependencies

This project uses a number of libraries and dependencies.

## Spring Data

Spring Data is used to ease data access technologies, relational and non-relational databases, map-reduce frameworks, and cloud-based data services. Particularly within this project we have used Spring Data JPA.

Spring Data JPA is part of the larger Spring Data family and makes it easy to implement JPA based repositories. It makes it easier to build Spring-powered applications that use data access technologies. As a developer you write your repository interfaces, including custom finder methods, and Spring will provide the implementation automatically.

## Eureka and Feign

Eureka provides client-side service discovery allowing services to find and communicate with each other without hard coding hostname and port. The only ‘fixed point’ in such an architecture consists of a service registry with which each service has to register.

With Netflix Eureka each client can simultaneously act as a server, to replicate its status to a connected peer. In other words, a client retrieves a list of all connected peers of a service registry and makes all further requests to any other services through a load-balancing algorithm

Feign is a declarative web service client and is used to handle REST requests. It interacts with the Eureka server in order to pick up application names, then employing the names to generate methods to call other services.

## Zuul

Zuul is a JVM based router and server side load balancer by Netflix. It allows us to do things like filter requests, apply authorisation etc.

## Swagger

Swagger is a set of open-source tools built around the OpenAPI Specification that can help you design, build, document and consume REST APIs. Primarily we use Swagger UI to renders OpenAPI specs generated from the end points as interactive API documentation.

## H2

H2 is an embedded, in-memory Java SQL database. Currently we have no concrete database implementation so this is used instead.

## Lombok

Lombok is a library used to generate getters, setters, equals and hashcode methods automatically.

## Spring Actuator

Actuator brings production-ready features to our application. This includes monitoring our app, gathering metrics, understanding traffic or the state of our database. It is mainly used to expose operational information about the running application – health, metrics, info, dump, env, etc.

## Thymeleaf

Thymeleaf is a modern server-side Java template engine for both web and standalone environments. Here we use it to generate our web page.

# Infrastructure and Deployment

The above covers the dependencies of the project. Below we cover the infrastructure.

## AWS

We use AWS to hold our repositories and deploy our containers. 

### ECS

I've used ECS to deploy to. However, ECS covers things like load balancing and scaling so perhaps I should have implemented that functionality there instead of employing the Netflix stack. There is only one cluster and all of our services run here.

### ECR

ECR is the image repository we push to. We have separate repositories for each service.

### S3

We have an S3 bucket for containing our Terraform remote state.

## Travis CI

Travis CI is our CI tool. It handles building each of the services, pushing the created Docker images to the repository and then redeploying them to the cluster.

## CodeCov 

This is our code coverage tool. It updates our repositories to give the percentage of code tested.

# Service Details

The service specific details are as below:

Detail | Value
------------ | -------------
Port Number | 8081
Spring Application Name | art-service-front-end
ECR Repository Name | art-service-front-end
ECS Service/ Task Name |

# Points for Improvement

I fully realise that this isn't a perfect service implementation and my suggested improvements would include:

- Permanent database in AWS.
- Spring cloud config.
- Prometheus with Slack integration for monitoring state.
- S3 bucket for holding the website images.
