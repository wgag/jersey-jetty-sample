# jersey-jetty-sample

A simple Jersey JAX-RS application on embedded Jetty.

## Usage

Build and run the application:

```
% mvn package
% java -jar target/jersey-jetty-sample.jar
```

Then you can access the deployed resources:

```
% curl -X GET "http://localhost:8080/"
<!DOCTYPE html><html><body>Hello!</body></html>
```

```
% curl -X GET "http://localhost:8080/api/hello?name=Jersey"
Hello, Jersey!
```

## References

* [Jersey](https://eclipse-ee4j.github.io/jersey/)
* [Jetty](https://www.eclipse.org/jetty/)
