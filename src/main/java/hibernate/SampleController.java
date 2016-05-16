package hibernate;

import hibernate.model.Bus;
import hibernate.model.impl.BusDAOImpl;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
@EnableAutoConfiguration
public class SampleController {

    @RequestMapping("/")
    @ResponseBody
    String home() throws SQLException {

        return "Hello World!";

    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);


    }
}