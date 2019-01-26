# Samples for using Log4J2 in custom bundles with WSO2 Carbon 4.4.x

This repo contains a sample custom authentication handler for API Manager and a Class Mediator for EI to Log with Log4J2.

The steps are common for both samples unless for the places to deploy the bundles but for better clarity they are explained separately within each sample.
Refer README files in individual samples for testing.

1. Create the Log4J2 uber jar
2. Create the custom bundle for the Class Mediator / Custom Handler
3. Create the Log4J2 configuration file
4. Add the above to the necessary places in the WSO2 product
5. Modify the integrator.sh / wso2carbon.sh to add the system property to set the Log4J2 configuration file
6. Restart the WSO2 server
7. Create an API and test the Class mediator / Custom Handler
