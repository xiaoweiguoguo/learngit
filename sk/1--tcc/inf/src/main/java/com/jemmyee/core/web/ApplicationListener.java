package com.jemmyee.core.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * ${DESCRIPTION}
 * @author jemmyee
 **/
public class ApplicationListener implements ServletContextListener{

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext application = servletContextEvent.getServletContext();
        String approotcom=application.getContextPath().equals("")?"":application.getContextPath();
        // 全局路径

        application.setAttribute(Constants.APPROOT,application.getContextPath().equals("")?"":application.getContextPath());

    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
