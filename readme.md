# Logging test app

> A simple kotlin/SpringBoot application that schedules a periodic log. 
> It's provided with a docker-compose environment that deploys an ElasticSearch cluster, Kibana, Filebeat
> and some other containers for monitoring: portainer and httpbeat.
> In this environment, scheduled logs are collected by filebeat and sent to the cluster.
> Health status of the application is collected by httpbeat using SpringBoot health endpoint.  

## Requirements

 - JDK 8
 - Gradle

To run Elastic env.: 
 - Docker 
 - Docker Compose

## Usage

To start application directly on gradle:

``` sh
gradle bootRun
```

To start application with Elastic environment on Docker:

``` sh
cd ./docker
./docker-containers-start.sh
```

To destroy application with Elastic environment on Docker:

``` sh
cd ./docker
./docker-containers-destroy.sh
```