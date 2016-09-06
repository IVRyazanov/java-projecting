package spring.xmlUsage;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by SBT-Ryazanov-IV on 05.09.2016.
 */
public class MainApp {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        for(int i = 0 ; i < 2; i ++){
            HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
            System.out.println(helloWorld.getMessage());
        }
        context.registerShutdownHook();

    }
}
