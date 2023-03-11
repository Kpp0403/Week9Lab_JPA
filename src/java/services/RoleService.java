package services;

import dataAccess.RoleDB;
import java.util.List;
import models.Role;

/**
 * @author Krushang Prajapati
 */
public class RoleService {

    public List<Role> getAll() throws Exception {
        RoleDB roleDB = new RoleDB();
        List<Role> roles = roleDB.getAll();
        return roles;
    }

    public int get(Role role) throws Exception {
        String name = role.getName();

        if (name.equals("system admin")) {
            return 1;
        } else {
            return 2;
        }
    }

}
