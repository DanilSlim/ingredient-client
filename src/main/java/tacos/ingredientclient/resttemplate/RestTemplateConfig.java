package tacos.ingredientclient.resttemplate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
@Conditional(NotFeignAndNotWebClientCondition.class)
public class RestTemplateConfig {
	
	   final Logger log = LoggerFactory.getLogger(RestTemplateConfig.class);
	
	  @Bean
	  @LoadBalanced
	  public RestTemplate restTemplate() {
	    return new RestTemplate();
	  }
	  
	  @Bean
	  public CommandLineRunner startup() {
	    return args -> {
	      log.info("**************************************");
	      log.info("    Configuring with RestTemplate");
	      log.info("**************************************");
	    };
	  }

}
