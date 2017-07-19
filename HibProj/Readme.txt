This folder is created to house project for hibernate part of the survey app
When running the application, the following jvm argument must be given, so that, 
log4j config file will be loaded from appropriate location
-Dlog4j.configuration=file:/${workspace_loc:/SurveyAppDal/config/log4j.properties}

Good link to know how to setup Hibernate maven project in eclipse
http://javapapers.com/hibernate/hibernate-development-environment-with-eclipse-and-maven/


when a jar file needs to be added into local m2 repository use the following command: -
mvn install:install-file -DgroupId=com.oracle -DartifactId=ojdbc14 -Dversion=10.2.0.1.0 -Dpackaging=jar -Dfile=G:\oraclexe\app\oracle\product\10.2.0\server\jdbc\lib\ojdbc14.jar -DgeneratePom=true