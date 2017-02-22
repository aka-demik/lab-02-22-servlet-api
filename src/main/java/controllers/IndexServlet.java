package controllers;

import models.User;
import persistent.db.DBConnection;
import persistent.db.UserDataObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDataObject dataObject = new UserDataObject(DBConnection.get());
        List<User> users = new ArrayList<>(250);
        try {
            dataObject.getAll(users);
            req.setAttribute("users", users);
        } catch (SQLException e) {
            req.setAttribute("error", e);
        }
        getServletContext().getRequestDispatcher("/main.jsp").forward(req, resp);
    }
}
