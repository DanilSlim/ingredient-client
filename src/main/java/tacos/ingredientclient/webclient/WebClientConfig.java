package tacos.ingredientclient.webclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
@Profile("webclient")
public class WebClientConfig {

	
	
	final Logger log = LoggerFactory.getLogger(WebClientConfig.class);
	
	  @Bean
	  @LoadBalanced
	  public WebClient.Builder webClientBuilder() {
	    return WebClient.builder();
	  }
	  
	  @Bean
	  public CommandLineRunner startup() {
	    return args -> {
	      log.info("**************************************");
	      log.info("     Configuring with WebClient");
	      log.info("**************************************");
	    };
	  }
}
