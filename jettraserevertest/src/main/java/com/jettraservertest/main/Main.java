/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.jettraservertest.main;

import com.jettraserver.JettraServer;
import com.jettraserver.health.JettraHealthController;
import com.jettraservertest.configuration.JakartaRestConfiguration;
import com.jettraservertest.controller.EmployeeController;
import com.jettraservertest.controller.HelloController;
import jakarta.inject.Inject;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author avbravo
 */
public class Main {

    @Inject
    JakartaRestConfiguration jakartaRestConfiguration;

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
                .application(
                        new JakartaRestConfiguration() {
                    @Override
                    public Set<Class<?>> getClasses() {
                        Set<Class<?>> classes = new HashSet<>();
                        classes.add(EmployeeController.class);
                        classes.add(HelloController.class);
                        classes.add(JettraHealthController.class);
                        return classes;
                    }
                }
                )
                .start();
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
