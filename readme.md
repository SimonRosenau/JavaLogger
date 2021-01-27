## Simple Java Logger

Install via maven:

```
<repository>
  <id>github</id>
  <name>GitHub Packages</name>
  <url>https://maven.pkg.github.com/SimonRosenau/java-logger</url>
</repository>
```
```
<dependency>
  <groupId>de.rosenau.simon</groupId>
  <artifactId>logger</artifactId>
  <version>2.0.0</version>
</dependency>
```

Initialize the logger with:

```
Logger.initialize();
```

And every time you use System.out the logger formats the output to something like this:

```
[15.06.2019 - 01:25] [Thread-1] LoggerTest.java:25: Output Message
```