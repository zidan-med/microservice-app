package com.sid.microservice;

import com.sid.microservice.web.CompteRestJaxRSAPI;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
//deploiment de jersey
@Configuration
public class MyConfig {
    //annulation du jerseyServlet(REstJaxRSAPI) avec (//)
    //@Bean
    public ResourceConfig resourceConfig(){
        ResourceConfig jerseyServlet =new ResourceConfig();
        jerseyServlet.register(CompteRestJaxRSAPI.class);
        return jerseyServlet;
    }
}
