package Loggerexample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class Basicconfiglogger {

    
    static Logger logger = LogManager.getLogger(Basicconfiglogger.class);

    @Test
    public void main1() {
        
        logger.info("This is an information message.");
        logger.error("This is an error message.");
    }

    
    
}
