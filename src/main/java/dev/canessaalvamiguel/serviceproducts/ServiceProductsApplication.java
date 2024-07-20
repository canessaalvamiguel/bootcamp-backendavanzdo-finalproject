package dev.canessaalvamiguel.serviceproducts;

import dev.canessaalvamiguel.serviceproducts.configuration.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class ServiceProductsApplication {

  public static void main(String[] args) {
    SpringApplication.run(ServiceProductsApplication.class, args);
  }

}
