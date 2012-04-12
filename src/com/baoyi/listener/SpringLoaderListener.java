package com.baoyi.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebListener;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

/**
 * Application Lifecycle Listener implementation class SpringLoaderListener
 *
 */
public class SpringLoaderListener extends ContextLoaderListener  {
       
    /**
     * @see ContextLoaderListener#ContextLoaderListener()
     */
    public SpringLoaderListener() {
        super();
        // TODO Auto-generated constructor stub
    }
       
    /**
     * @see ContextLoaderListener#ContextLoaderListener(WebApplicationContext)
     */
    public SpringLoaderListener(WebApplicationContext context) {
        super(context);
        // TODO Auto-generated constructor stub
    }
}
