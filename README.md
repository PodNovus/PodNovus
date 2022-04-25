PodNovus
========
PodNovus aims to bring it into the current generation with a focus on podcasts, web streaming services, and a
expandable plugin system to open it to many more content sources.

How to Build
------------
PodNovus uses the Maven build system and we include the Maven Wrapper to make building PodNovus easier. You can 
build all of PodNovus by running the following command:
```
mvnw package
```

It will create the WAR file for the PodNovus Backend API's in backend, the PodNovus Client JAR in client,
the PodNovus React Web Application in webapp, and the API JAR in api.

How to Debug
------------
If you want to test PodNovus, you need to make sure the backend Spring application is running before starting
the client or the webapp. Development builds default to http://localhost:8080 for the Backend API

Requirements
------------
PodNovus was developed with SapMachine 17 and is tested on that platform, but any Java 17 JDK will
work for development. The webapp pom.xml will download a local Node.JS to download and build the React
Web Application so you do not require an installation of Node.JS.

Contributing
------------
We welcome anyone to contribute to PodNovus. You can report bugs in GitHub or via email to
bugs-podnovus@ntge.net. The code is hosted at NTGE at https://code.ntge.net/projects/PN/repos/podnovus
but is mirrored also at GitHub.