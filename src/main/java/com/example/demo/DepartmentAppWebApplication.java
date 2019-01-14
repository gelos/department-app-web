package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import uk.co.blackpepper.bowman.ClientFactory;
import uk.co.blackpepper.bowman.Configuration;

//@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
@SpringBootApplication
public class DepartmentAppWebApplication {

  public static void main(String[] args) {
    SpringApplication.run(DepartmentAppWebApplication.class, args);
  }

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

/*  @Value("${resource.departments}")
  private String resource;
  
  @Bean
  public ClientFactory clientFactory() {
    // return Configuration.build().buildClientFactory();  
    
    return Configuration.builder().setBaseUri(resource).build()
        .buildClientFactory();
  }*/

}

