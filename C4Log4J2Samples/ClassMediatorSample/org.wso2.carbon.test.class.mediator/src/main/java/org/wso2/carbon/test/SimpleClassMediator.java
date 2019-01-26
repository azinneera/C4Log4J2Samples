package org.wso2.carbon.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.synapse.MessageContext;
import org.apache.synapse.mediators.AbstractMediator;

public class SimpleClassMediator extends AbstractMediator {

    private static final Logger logger = LogManager.getLogger(SimpleClassMediator.class);

    private String variable1="10";

    private String variable2="10";

    private int variable3=0;

    public SimpleClassMediator(){}

    public boolean mediate(MessageContext mc) {
        // Do somthing useful..
        // Note the access to the Synapse Message context
        logger.info("----------Simple Class Medaitor. This line is logged by Log4J2----------");
        return true;
    }

    public String getType() {
        return null;
    }

    public void setTraceState(int traceState) {
        traceState = 0;
    }

    public int getTraceState() {
        return 0;
    }

    public void setVariable1(String newValue) {
        variable1=newValue;
    }

    public String getVariable1() {
        return variable1;
    }

    public void setVariable2(String newValue){
        variable2=newValue;
    }

    public String getVariable2(){
        return variable2;
    }
}
