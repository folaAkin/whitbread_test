package com.whitebread.apps.helper;



import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;





public class Props {
	 private static final Log LOG = LogFactory.getLog(Props.class);
	   private static Properties properties;


	   
	   
	    public static Properties loadRunConfigProps()  throws Exception {
	    	properties = new Properties();
	    	InputStream input = null;

	    	try {

	    		input = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config/config.properties");
	    		LOG.info("Loading config.properties");

	    		// load a properties file
	    		properties.load(input);
	    		

	    	} catch (IOException ex) {
	    		LOG.warn(ex);
	    	} finally {
	    		if (input != null) {
	    			try {
	    				input.close();
	    			} catch (IOException e) {
	    				LOG.warn(e);
	    			}
	    		}
	    	}
			return properties;

	      }
	    }
	



