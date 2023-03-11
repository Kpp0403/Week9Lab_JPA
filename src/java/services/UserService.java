package services;

import dataAccess.UserDB;
import java.util.List;
import models.Role;
import models.User;

/**
 *
 * @author Krushang Prajapati
 */
public class UserService {
    
    public List<User> getAll() throws Exception {
        UserDB roleDB = new UserDB();
        List<User> users = roleDB.getAll();
        return users;
    }
    
    public User get(String email) throws Exception {
        UserDB roleDB = new UserDB();
        User user = roleDB.get(email);
        return user;
    }
    
    public void insert(String email, String firstName, String lastName, String password, Role role) throws Exception {
        User user = new User(email, firstName, lastName, password, role);
        UserDB userDB = new UserDB();
        userDB.insert(user);
    }
    
    public void update(String email, String firstName, String lastName, String password, Role role) throws Exception {
        User user = new User(email, firstName, lastName, password, role);
        UserDB userDB = new UserDB();
        userDB.update(user);
    }
    
    public void delete(String email) throws Exception {
        User user = new User();
        user.setEmail(email);
        UserDB userDB = new UserDB();
        userDB.delete(user);
    }
}
