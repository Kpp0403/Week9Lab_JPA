package servlets;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Role;
import models.User;
import services.RoleService;
import services.UserService;

/**
 * @author Krushang Prajapati
 */
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserService usersv = new UserService();
        RoleService rolesv = new RoleService();

        String action = request.getParameter("action");

        try {

            if (action != null && action.equals("edit")) {

                String email = request.getParameter("email");
                User selectionUser = usersv.get(email);

                request.setAttribute("selectionUser", selectionUser);
                request.setAttribute("email", email);
            } else if (action != null && action.equals("delete")) {

                String email = request.getParameter("email");

                usersv.delete(email);

                List<User> users = usersv.getAll();

                if (users.isEmpty()) {
                    request.setAttribute("errorMessage", "No user found on database. Please add a user.");
                }
            }

            List<User> users = usersv.getAll();
            request.setAttribute("users", users);

            List<Role> roles = rolesv.getAll();
            request.setAttribute("roles", roles);

        } catch (Exception e) {

            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("errorMessage", "Error while updating or adding user.");
        }

        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserService usersv = new UserService();

        String action = request.getParameter("action");

        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");
        String roleOfUser = request.getParameter("role");

        Role role = new Role(roleOfUser);

        try {
            switch (action) {
                case "add":
                    usersv.insert(email, firstName, lastName, password, role);
                    break;
                case "update":
                    usersv.update(email, firstName, lastName, password, role);
                    break;
            }

            List<User> users = usersv.getAll();

            request.setAttribute("users", users);
        } catch (Exception e) {

            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("errorMessage", "Error while updating or adding user.");
        }

        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }

}
