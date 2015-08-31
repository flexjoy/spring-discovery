package com.springapp.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 *  Spring application initializing class. Replaces web.xml file.
 *
 * @author Sergey Cherepanov
 */
public class WebAppInit implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) throws ServletException {
        // Создаем корневой (root) контекст Spring
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();

        // Регистрируем в контексте конфигурационный класс
        rootContext.register(WebAppConfig.class);

        // Листенер для управления жизненным циклом корневого контекста Spring
        container.addListener(new ContextLoaderListener(rootContext));

        // Регистрируем сервлет-диспетчер Spring MVC
        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(rootContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
