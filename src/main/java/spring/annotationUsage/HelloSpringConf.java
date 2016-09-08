package spring.annotationUsage;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by SBT-Ryazanov-IV on 06.09.2016.
 */
@Configuration
public class HelloSpringConf {
    @Bean
    public HelloSpring helloSpring(){
        return new HelloSpring();
    }
}
