package hiber;

import hiber.config.AppConfig;
import hiber.models.Car;
import hiber.models.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      User user1 = new User("Ivan", "Ivanov", "ivan@mail.ru");
      User user2 = new User("Petr", "Petrov", "petr@mail.ru");
      User user3 = new User("Maria", "Sidorova", "maria@mail.ru");

      Car car1 = new Car("Toyota", 123);
      Car car2 = new Car("KIA", 235);
      Car car3 = new Car("Volvo", 862);

      user1.setUserCar(car1);
      user2.setUserCar(car2);
      user3.setUserCar(car3);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);

      userService.getUserByCar("KIA", 235);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getUserCar());
         System.out.println();
      }

      context.close();
   }
}
