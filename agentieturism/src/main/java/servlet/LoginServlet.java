package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.DatabaseConnection;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        String tip = null;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT tip FROM login WHERE user = ? AND password = ?")) {

            statement.setString(1, user);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    tip = resultSet.getString("tip");
                    HttpSession session = request.getSession();
                    session.setAttribute("tip", tip);
                    session.setAttribute("user", user);

                    response.sendRedirect("home.jsp");
                } else {
                    response.sendRedirect("login.jsp?error=Invalid credentials");
                }
            }
        } catch (Exception e) {
            throw new ServletException("Eroare la autentificare", e);
        }
    }
}