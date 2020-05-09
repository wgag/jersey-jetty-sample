# jersey-jetty-sample

A simple Jersey JAX-RS application on embedded Jetty.

## Instructions

```
% mvn package
% java -jar target/jersey-jetty-sample.jar
```

```
% curl -X GET "http://localhost:8080/hello?name=jersey"
hello, jersey!
```

## References

* [Jersey](https://eclipse-ee4j.github.io/jersey/)
* [Jetty](https://www.eclipse.org/jetty/)
