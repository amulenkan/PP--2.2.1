package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@Repository
public class UserDaoImp implements UserDao {
   private static final Logger logger = Logger.getLogger(UserDaoImp.class.getName());


   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   public void add(Car car) {
      sessionFactory.getCurrentSession().save(car);
   }

   @Override
   public User getUserByCar(String model, int series) {

      Query query = sessionFactory.getCurrentSession().createQuery("from User u where u.userCar.model=:paramName and u.userCar.series=:paramName2");
      query.setParameter("paramName", model);
      query.setParameter("paramName2", series);
      Object result = null;
      try {
         result = query.getSingleResult();
      } catch (NoResultException e) {
         logger.log(Level.INFO, "Владелец автомобиля {0} серии {1} не найден", new Object[]{model, series});
      }

      logger.log(Level.INFO, "Владелец автомобиля {0} серии {1} : {2}", new Object[]{model, series, result});
      return (User) result;

   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

}
