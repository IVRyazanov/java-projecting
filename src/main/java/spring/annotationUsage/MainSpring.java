package spring.annotationUsage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by SBT-Ryazanov-IV on 06.09.2016.
 */
public class MainSpring {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(HelloSpringConf.class);
        HelloSpring helloSpring = applicationContext.getBean(HelloSpring.class);
        helloSpring.setMessage("Hello man");
        System.out.println(helloSpring.getMessage());
    }
}
