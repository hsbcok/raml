package com.gaoke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.*"})
public class RamlParserApplication {

    public static void main(String[] args) {
        SpringApplication.run(RamlParserApplication.class, args);
    }

//    @Bean
//    public TomcatServletWebServerFactory tomcatEmbedded() {
//        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
//        tomcat.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> {
//            if ((connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>)) {
////-1 means unlimited
//                ((AbstractHttp11Protocol<?>) connector.getProtocolHandler()).setMaxSwallowSize(-1);
//            }
//        });
//        return tomcat;
//    }
}
