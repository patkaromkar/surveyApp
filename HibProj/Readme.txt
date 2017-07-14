This folder is created to house project for hibernate part of the survey app
When running the application, the following jvm argument must be given, so that, 
log4j config file will be loaded from appropriate location
-Dlog4j.configuration=file:/${workspace_loc:/SurveyAppDal/config/log4j.properties}