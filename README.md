# app-demo-spring

##  Overview

This is a simple poc to demonstrate the Observability patterns: 
   
*Tools used:* [jaeger], [micrometer] and [prometheus] to obtain the data and [grafana] to show visualize the data obtained

[jaeger]: https://www.jaegertracing.io/
[micrometer]: https://micrometer.io
[prometheus]: https://prometheus.io/
[grafana]: https://grafana.com/

## Requirements
- [docker] and [docker-compose]

[docker]: https://www.docker.com/
[docker-compose]: https://docs.docker.com/compose/

#Start

1 - Start all services grafana, prometheus, jaeger and application using this command:

 ``docker-compose up --build``
 

Exposes endpoints:

    - GET http://localhost:8080/api/v1/books
    - POST http://localhost:8080/api/v1/books
    - GET http://localhost:8080/api/v1/books/{id}
    - DELETE http://localhost:8080/api/v1/books/{id}
    - DELETE http://localhost:8080/api/v1/books
 

2 - Open and Check the prometheus

    - http://localhost:9090 


3 - Open and Check the grafana 
    
    - http://localhost:3000
    
###### authentication grafana

user: admin

password: admin

##

4 - Add prometheus datasource

5 - Import the template

    /grafana/grafana-template.json


6 - Open and Check the JaegerEvent-Based Observability

    - http://localhost:16686
