package hiber.dao;

import hiber.models.Car;
import hiber.models.User;

import java.util.List;

public interface UserDao {
   void add(User user);

   void add(Car car);

   User getUserByCar(String model, int series);
   List<User> listUsers();
}
