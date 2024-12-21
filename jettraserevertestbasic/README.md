# Jettra ServerBasic

# Jettra Server

```shell

mvn clean package -Pexec

java -jar target/jettraserver.jar



```



1. Importe la libreria a su proyecto Java SE
2. Crea el archivo src/main/resources/META-INF/beans.xml
3.Crea el archivo src/main/resources/META-INF/microprofile-config.properties

En el metodo main

```java

public class Main {


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


```

---

## Con HTTPS/TLSv1.2

```java
  JettraServer persona = new JettraServer.Builder()
                .protocol("HTTPS")
                .host("localhost")
                .port(8080)
                .tls("TLSv1.2")
                .application(
                        new JakartaRestConfiguration() {
                    @Override
                    public Set<Class<?>> getClasses() {
                        Set<Class<?>> classes = new HashSet<>();
                        classes.add(EmployeeController.class);
                        classes.add(HelloController.class);
                        return classes;
                    }
                }
                )
                .start();

```



```shell

mvn clean package -Pexec

java -jar target/jettraserver.jar



```