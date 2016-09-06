package spring.innerBeans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by SBT-Ryazanov-IV on 06.09.2016.
 */
public class MainAuto {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        Auto auto = (Auto) ctx.getBean("auto");
        Auto auto1 = (Auto) ctx.getBean("auto");
        auto1.setName("RangeRover");
        List<Wheel> wheelList = auto.getWheels();
        for(Wheel wheel : wheelList){
            wheel.setName("Nhakkepellita");
        }
        System.out.println(auto);
        System.out.println(auto1);
    }

}
