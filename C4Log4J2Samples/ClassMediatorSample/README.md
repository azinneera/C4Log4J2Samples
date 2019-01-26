
This sample will print the log statements written in the Class Mediator to the Carbon Console and the log file through Log4j2. 
The sample given in the WSO2 EI 6.1.1 Manager official documentation for Class Mediator was used for this with a log statement 
added which should log to the Carbon console and <EI_HOME>/repository/logs/carbon.log file.

This also can be used with WSO2 ESB which is built on Carbon 4.4.x. 

#### Sample Content

1. The sample Log4j2 configuration file - log4j2.xml
2. The maven project of the class mediator - org.wso2.carbon.test.class.mediator
3. The maven project of Log4J2 uber jar - log4j2uber


#### Instructions for testing the sample

1. Build the maven projects and obtain the jars 
2. Copy log4j2-core-apiv2.11.1-1.0.0.jar and org.wso2.carbon.test.class.mediator-1.0-SNAPSHOT.jar to <EI_HOME>/dropins
2. Copy the log4j2.xml to <EI_HOME>/conf
3. Set the system property for log4j2 configuration by adding the following line to <EI_HOME>/bin/integrator.sh
```bash
-Dlog4j.configurationFile="$CARBON_HOME/conf/log4j2.xml" \
```
4. Restart the EI server

5. Add this class mediator to an API or a Proxy Service in EI and check for the log line printed 
by org.wso2.carbon.test.SimpleClassMediator in the Carbon Console and the 
<PRODUCT_HOME>/repository/logs/carbon.log file.
