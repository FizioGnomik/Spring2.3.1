package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDao{

    @PersistenceContext
    private  EntityManager entityManager;

    public List<User> getAllUsers() {

        return entityManager.createQuery("from User", User.class).getResultList();
    }

    public void deleteUser(int id) {
        entityManager.remove(getUser(id));
    }

    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    public void addUser(User user) {
        entityManager.persist(user);
    }

    public void updateUser(int id, User userForUpdate) {
        User user = getUser(id);
        user.setFirstName(userForUpdate.getFirstName());
        user.setLastName(userForUpdate.getLastName());
        user.setEmail(userForUpdate.getEmail());
    }

}
