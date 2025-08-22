package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import util.DatabaseConnection;

@WebServlet("/inserare")
public class AddClientServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idCnp = request.getParameter("idCnp");
        String nume = request.getParameter("nume");
        String prenume = request.getParameter("prenume");
        String adresa = request.getParameter("adresa");
        String telefon = request.getParameter("telefon");

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO client (Id_CNP, Nume_Cli, Prenume_Cli, Adresa_Cli, Telefon_Cli) VALUES (?, ?, ?, ?, ?)");) {

            statement.setString(1, idCnp);
            statement.setString(2, nume);
            statement.setString(3, prenume);
            statement.setString(4, adresa);
            statement.setString(5, telefon);

            statement.executeUpdate();
            response.sendRedirect("home.jsp?message=Client added successfully");
        } catch (Exception e) {
            throw new ServletException("Eroare la adăugare client", e);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/inserare.jsp").forward(request, response);
    }
}
