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

@WebServlet("/updateClient")
public class UpdateClientServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idCnp = request.getParameter("idCnp");
        String nume = request.getParameter("nume");
        String prenume = request.getParameter("prenume");
        String adresa = request.getParameter("adresa");
        String telefon = request.getParameter("telefon");

        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "UPDATE client SET Nume_Cli = ?, Prenume_Cli = ?, Adresa_Cli = ?, Telefon_Cli = ? WHERE Id_CNP = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, nume);
                statement.setString(2, prenume);
                statement.setString(3, adresa);
                statement.setString(4, telefon);
                statement.setString(5, idCnp);

                int rowsUpdated = statement.executeUpdate();
                if (rowsUpdated > 0) {
                    response.sendRedirect("home.jsp?message=Client actualizat cu succes!");
                } else {
                    response.sendRedirect("home.jsp?message=Eroare la actualizarea clientului!");
                }
            }
        } catch (Exception e) {
            response.sendRedirect("home.jsp?message=Eroare la procesarea actualizării clientului!");
        }
    }
}
