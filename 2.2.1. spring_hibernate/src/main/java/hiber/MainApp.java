package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("Alessandro", "Del Piero", "delp@mail.com",
              new Car("RangeRover",3)));
      userService.add(new User("Roberto", "Carlos", "rcarlo@mail.com",
              new Car("Mercedes",220 )));
      userService.add(new User("Luis", "Figo", "luifig@mail.com",
              new Car("Labmorgini", 300)));
      userService.add(new User("Franchesco", "Totti", "frtoti@mail.com",
              new Car("Mitsubishi", 8)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("CarModel = " + user.getCar().getModel());
         System.out.println("CarSeries = " + user.getCar().getSeries());
         System.out.println("-----------------------------------------------------------------");
      }

      System.out.println(userService.getUserByCar("Mercedes", 220));

      context.close();
   }
}
