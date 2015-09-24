This framework is a distributed service framework enpowers applications with service import/export capability with high performance RPC.
               
               It's composed of three kernel parts:
               
               Remoting: a network communication framework provides sync-over-async and request-response messaging.
               
               Clustering: a remote procedure call abstraction with load-balancing/failover/clustering capabilities.
               
               Registry: a service directory framework for service registration and service event publish/subscription

It adds features like RESTful remoting, Kyro/FST serialization. 



## Framework main features

* **support restful （HTTP + JSON/XML)**：based on JBoss [RestEasy](http://resteasy.jboss.org/)framework，in this framework,it implements Restful （HTTP + JSON/XML）calls，make multi-language interface simpler，and make Open API developing simple


**TODO