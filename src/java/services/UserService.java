package services;

import dataAccess.RoleDB;
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
    
    public void insert(String email, String firstName, String lastName, String password, int roleID) throws Exception {
        User user = new User(email, firstName, lastName, password);
        
        RoleDB roledb = new RoleDB();
        Role role = roledb.get(roleID);
        user.setRole(role);
        
        UserDB userDB = new UserDB();
        userDB.insert(user);
    }
    
    public void update(String email, String firstName, String lastName, String password, int roleID) throws Exception {
        UserDB userdb = new UserDB();
        User user = userdb.get(email);
        RoleDB roledb = new RoleDB();
        Role role = roledb.get(roleID);
        
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        user.setRole(role);
        
        userdb.update(user);
    }
    
    public void delete(String email) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        userDB.delete(user);
    }
}
