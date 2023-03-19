<%-- 
    Document   : users
    Created on : 09-Mar-2023, 1:14:41 PM
    Author     : Krushang Prajapati
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
    </head>
    <body>
        <h1>
            Manage Users
        </h1>
        ${errorMessage}
        <table border="1">
            <tr>
                <th>
                    Email
                </th>
                <th>
                    First Name
                </th>
                <th>
                    Last Name
                </th>
                <th>
                    Role
                </th>
                <td></td>
                <td></td>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>
                        ${user.email}
                    </td>
                    <td>
                        ${user.firstName}
                    </td>
                    <td>
                        ${user.lastName}
                    </td>
                    <td>
                        ${user.role.roleName}
                    </td>
                    <td>
                        <c:url value="/users" var="editUser">
                            <c:param name="email" value="${user.email}" />
                            <c:param name="action" value="edit" />
                        </c:url>
                        <a href="${editUser}">
                            Edit
                        </a>
                    </td>
                    <td>
                        <c:url value="/users" var="deleteUser">
                            <c:param name="email" value="${user.email}" />
                            <c:param name="action" value="delete" />
                        </c:url>
                        <a href="${deleteUser}">
                            Delete
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <c:if test="${selectionUser eq null}">
            <h2>
                Add user
            </h2>
            <form action="users" method="post">
                <table>
                    <tr>
                        <th>
                            Email:
                        </th>
                        <td>
                            <input type="text" name="email" required>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            First Name:
                        </th>
                        <td>
                            <input type="text" name="firstName" required>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            Last Name:
                        </th>
                        <td>
                            <input type="text" name="lastName" required>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            Password:
                        </th>
                        <td>
                            <input type="text" name="password" required>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            Role:
                        </th>
                        <td>
                            <select name="role">
                                <option value="system admin">
                                    System Admin
                                </option>
                                <option value="regular user">
                                    Regular User
                                </option>
                            </select>
                        </td>
                    </tr>
                </table>
                <input type="hidden" name="action" value="add">
                <input type="submit" value="Add User">
            </form>
        </c:if>
        <c:if test="${selectionUser ne null}">
            <h2>
                Edit user
            </h2>
            <form action="users" method="post">
                <table>
                    <input type="hidden" name="email" value="${selectionUser.email}"
                           <tr>
                        <th>
                            Email:
                        </th>
                        <td>
                            ${selectionUser.email}
                        </td>
                    </tr>
                    <tr>
                        <th>
                            First Name:
                        </th>
                        <td>
                            <input type="text" name="firstName" value="${selectionUser.firstName}" required>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            Last Name:
                        </th>
                        <td>
                            <input type="text" name="lastName" value="${selectionUser.lastName}" required>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            Password:
                        </th>
                        <td>
                            <input type="text" name="password" required>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            Role:
                        </th>
                        <td>
                            <select name="role">
                                <option value="system admin">
                                    System Admin
                                </option>
                                <option value="regular user">
                                    Regular User
                                </option>
                            </select>
                        </td>
                    </tr>
                </table>
                <input type="hidden" name="action" value="update">
                <input type="submit" value="Update">
                <a href="\users" class="button">
                    Cancel
                </a>
            </form>
        </c:if>
        ${errorMessage}
    </body>
</html>
