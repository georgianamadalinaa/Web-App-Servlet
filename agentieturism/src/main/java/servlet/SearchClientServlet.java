package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Client;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DatabaseConnection;
@WebServlet("/searchClient")
public class SearchClientServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idCnp = request.getParameter("idCnp");

        if (idCnp == null || idCnp.isEmpty()) {
            request.setAttribute("errorMessage", "CNP-ul este obligatoriu pentru căutare!");
            request.getRequestDispatcher("/searchClient.jsp").forward(request, response);
            return;
        }

        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT Id_CNP, Nume_Cli, Prenume_Cli, Adresa_Cli, Telefon_Cli FROM client WHERE Id_CNP = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, idCnp);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        // Creăm un obiect Client pentru a trimite datele în JSP
                        Client client = new Client();
                        client.setIdCnp(resultSet.getString("Id_CNP"));
                        client.setNume(resultSet.getString("Nume_Cli"));
                        client.setPrenume(resultSet.getString("Prenume_Cli"));
                        client.setAdresa(resultSet.getString("Adresa_Cli"));
                        client.setTelefon(resultSet.getString("Telefon_Cli"));

                        // Setăm clientul în request pentru a fi accesibil în JSP
                        request.setAttribute("client", client);

                        // Redirecționăm utilizatorul către pagina de actualizare
                        request.getRequestDispatcher("/updateClient.jsp").forward(request, response);
                    } else {
                        // Dacă nu găsim clientul, trimitem un mesaj de eroare
                        request.setAttribute("errorMessage", "Clientul cu acest CNP nu a fost găsit!");
                        request.getRequestDispatcher("/searchClient.jsp").forward(request, response);
                    }
                }
            }
        } catch (SQLException e) {
            request.setAttribute("errorMessage", "Eroare la procesarea cererii: " + e.getMessage());
            request.getRequestDispatcher("/searchClient.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idCnp = request.getParameter("idCnp");

        if (idCnp == null || idCnp.isEmpty()) {
            request.setAttribute("errorMessage", "CNP-ul este șters!");
            request.getRequestDispatcher("/searchClient.jsp").forward(request, response);
            return;
        }

        try (Connection connection = DatabaseConnection.getConnection()) {
            String deleteQuery = "DELETE FROM client WHERE Id_CNP = ?";
            try (PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)) {
                deleteStatement.setString(1, idCnp);
                int rowsAffected = deleteStatement.executeUpdate();

                if (rowsAffected > 0) {
                    request.setAttribute("successMessage", "Clientul a fost șters cu succes!");
                } else {
                    request.setAttribute("errorMessage", "Clientul cu acest CNP nu a fost găsit pentru ștergere!");
                }
                request.getRequestDispatcher("/searchClient.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            request.setAttribute("errorMessage", "Eroare la ștergerea clientului: " + e.getMessage());
            request.getRequestDispatcher("/searchClient.jsp").forward(request, response);
        }
    }
}
