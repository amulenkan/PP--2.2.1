package hiber.service;

import hiber.dao.UserDao;
import hiber.models.Car;
import hiber.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;


   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Override
   public void add(Car car) {
      userDao.add(car);
   }

   @Override
   public User getUserByCar(String model, int series) {
      return userDao.getUserByCar(model, series);
   }

   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

}
