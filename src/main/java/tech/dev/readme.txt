Spring MVC
http://localhost:8090/crm/spring-mvc/client
http://localhost:8090/crm/spring-mvc/client/new
http://localhost:8090/crm/spring-mvc/client/1            - consult
http://localhost:8090/crm/spring-mvc/client/1/edit
http://localhost:8090/crm/spring-mvc/client/1/delete

REST API:
http://localhost:8090/crm/api/clients
http://localhost:8090/crm/api/clients/1  -consult
http://localhost:8090/crm/api/clients/1/delete
http://localhost:8090/crm/api/clients/new

A simple client for REST api:
http://localhost:8090/crm/spring-mvc/rsclient
http://localhost:8090/crm/spring-mvc/rsclient/new
http://localhost:8090/crm/spring-mvc/rsclient/1  - consult
http://localhost:8090/crm/spring-mvc/rsclient/1/edit
http://localhost:8090/crm/spring-mvc/rsclient/1/delete

Data source from Path(pas obligatoire)
D:/java/projects.intellij/SampleSpring/src/main/resources/db/crm.mv.db
mdp: admin

SOAP:
Soap WS wsdl acces pour WSApplication.java(1. Standalone deployment)
http://localhost:1111/crm/jaxws/TestWebService?wsdl  - test WS
http://localhost:1234/crm/jaxws/ClientWebService?wsdl - client WS

Soap WS wsdl acces pour WebApplication.java(2 Deployment on to a servlet-container)
http://localhost:8090/crm/spring-ws/client?wsdl

Client for Client WS generation:
>mkdir SEI
>cd SEI (Service Endpoint Interface)
>mkdir src

For Standalone deployment(WSApplication):
>wsimport -keep -s src http://localhost:1111/crm/jaxws/TestWebService?wsdl
>wsimport -keep -s src http://localhost:1234/crm/jaxws/ClientWebService?wsdl

For servlet-container deployment(WebApplication):
>wsimport -keep -s src http://localhost:8090/crm/spring-ws/client?wsdl

Copy files from sei/src into new project package called sei ou seitest.

A simple client for SOAP WS:
http://localhost:8090/crm/spring-mvc/wsclient
http://localhost:8090/crm/spring-mvc/wsclient/new
http://localhost:8090/crm/spring-mvc/wsclient/1  - consult
http://localhost:8090/crm/spring-mvc/wsclient/1/edit
http://localhost:8090/crm/spring-mvc/wsclient/1/delete


