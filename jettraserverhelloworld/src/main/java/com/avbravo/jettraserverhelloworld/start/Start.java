/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.avbravo.jettraserverhelloworld.start;

import com.avbravo.jettraserverhelloworld.configuration.JakartaRestConfiguration;
import com.avbravo.jettraserverhelloworld.controller.CountryController;
import com.avbravo.jettraserverhelloworld.controller.EmployeeController;
import com.avbravo.jettraserverhelloworld.controller.HelloController;
import com.avbravo.jettraserverhelloworld.view.EmpleadoView;
import com.avbravo.jettraserverhelloworld.view.template.AboutView;
import com.avbravo.jettraserverhelloworld.view.HomeView;
import com.avbravo.jettraserverhelloworld.view.J2htmlView;
import com.avbravo.jettraserverhelloworld.view.JmoordbJ2htmlView;
import com.avbravo.jettraserverhelloworld.view.template.TemplateView;
import com.jettraserver.JettraServer;
import com.jettraserver.health.JettraHealthController;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author avbravo
 */
public class Start {

    public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
        
              /**
         * Con RootPath
         */
        JettraServer local = new JettraServer.Builder()
                .protocol("HTTP")
                .host("localhost")
                .port(8080)
                .rootPath("api")
                .logo(Boolean.TRUE)
                .application(new JakartaRestConfiguration() {
                    @Override
                    public Set<Class<?>> getClasses() {
                        Set<Class<?>> classes = new HashSet<>();
                        classes.add(EmployeeController.class);
                        classes.add(HelloController.class);
                        classes.add(CountryController.class);
                        classes.add(JettraHealthController.class);

                        classes.add(TemplateView.class);
                        classes.add(HomeView.class);
                        classes.add(AboutView.class);

                        classes.add(EmpleadoView.class);
                        classes.add(J2htmlView.class);
                        classes.add(JmoordbJ2htmlView.class);
                        return classes;
                    }
                }
                )
                .start();
        
        
//SeBootstrap.start(JakartaRestConfiguration.class)
//        .thenApply(instance -> {
//            instance.stopOnShutdown((stopResult -> System.out.println("Container has stopped.")));
//            try (Client client = ClientBuilder.newClient()) {
//                final Response response = client.target(instance.configuration()
//                        .baseUriBuilder()
//                        .path("rest")).request().get();
//                System.out.println(response.readEntity(String.class));
//            }
//            return instance;
//        }).toCompletableFuture().get();
        /**
         * Con RootPath
         */
//        JettraServer local = new JettraServer.Builder()
//                .protocol("HTTP")
//                .host("localhost")
//                .port(8080)
//                .rootPath("api")
//                .logo(Boolean.TRUE)
//                .application(
//                        new JakartaRestConfiguration() {
//                    @Override
//                    public Set<Class<?>> getClasses() {
//                        Set<Class<?>> classes = new HashSet<>();
//                        classes.add(EmployeeController.class);
//                        classes.add(HelloController.class);
//                        classes.add(JettraHealthController.class);
//                        return classes;
//                    }
//                }
//                )
//                .jaxRun();

  
// http://localhost:8080/api/jettrahello       

        /**
         * Sin RootPath
         *
         */
//        JettraServer sinRootPath = new JettraServer.Builder()
//                .protocol("HTTP")
//                .host("localhost")
//                .port(8081)
//                 .rootPath("")
//.logo(Boolean.FALSEº)
//                .application(
//                        new JakartaRestConfiguration(){
//                    @Override
//                    public Set<Class<?>> getClasses() {
//                        Set<Class<?>> classes = new HashSet<>();
//                        classes.add(EmployeeController.class);
//                        classes.add(HelloController.class);
//                        classes.add(JettraHealthController.class);
//                        return classes;
//                    }
//                }
//                )
//                .start();
        // http://localhost:8081/jettrahello
//        //HTTPS/TLS
//        // Se necesita certificado
//        JettraServer local = new JettraServer.Builder()
//                .protocol("HTTPS")
//                .host("localhost")
//                .rootPath("api")
//                .tls("TLSv1.2")
//                .port(8080)
//                .application(
//                        new JakartaRestConfiguration(){
//                    @Override
//                    public Set<Class<?>> getClasses() {
//                        Set<Class<?>> classes = new HashSet<>();
//                        classes.add(EmployeeController.class);
//                        classes.add(HelloController.class);
//                        classes.add(JettraHealthController.class);
//                        return classes;
//                    }
//                }
//                )
//                .start();
    }
}
