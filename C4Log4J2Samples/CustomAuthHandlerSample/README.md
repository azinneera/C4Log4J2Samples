
This sample will print the log statements written in the Custom Handler to the Carbon Console and the log file through Log4j2. 
The sample given in the API Manager official documentation for Writing a custom handler was used for this with a log statement 
added which should log to the Carbon console and <APIM_HOME>/repository/logs/carbon.log file.

This also can be used with WSO2 ESB which is built on Carbon 4.4.x. 

#### Sample Content

1. The sample Log4j2 configuration file - log4j2.xml
2. The maven project of the custom authentication handler - org.wso2.carbon.test.authenticator
3. The maven project of Log4J2 uber jar - log4j2uber


#### Instructions for testing the sample

1. Build the maven projects and obtain the jars 
2. Copy log4j2-core-apiv2.11.1-1.0.0.jar and org.wso2.carbon.test-1.0-SNAPSHOT.jar to <APIM_HOME>/repository/components/dropins/
2. Copy the log4j2.xml to <APIM_HOME>/repository/conf
3. Set the system property for log4j2 configuration by adding the following line to <APIM_HOME>/bin/wso2server.sh
```bash
-Dlog4j.configurationFile="$CARBON_HOME/repository/conf/log4j2.xml" \
```
4. Engage the handler by modifying the <handlers> section in <APIM_HOME>/repository/resources/api_templates/velocity_template.xml file as shown below. 
Please follow the instructions given in Engaging the custom handler section of the documentation for more details.
```xml 
   <handlers xmlns="http://ws.apache.org/ns/synapse">
   <handler class="org.wso2.carbon.test.CustomAPIAuthenticationHandler" />
   #foreach($handler in $handlers)
             #if(!($handler.className == "org.wso2.carbon.apimgt.gateway.handlers.security.APIAuthenticationHandler"))
              <handler xmlns="http://ws.apache.org/ns/synapse" class="$handler.className">
               #if($handler.hasProperties())
                   #set ($map = $handler.getProperties() )
                   #foreach($property in $map.entrySet())
                       <property name="$!property.key" value="$!property.value"/>
                   #end
               #end
              </handler>
            #end
           #end
   </handlers>
```   

5. Restart the API Manager server
6. Create a new API
7. Invoke the API and check for the log line printed by 
org.wso2.carbon.test.CustomAPIAuthenticationHandler 
in the Carbon Console and the <APIM_HOME>/repository/logs/carbon.log file