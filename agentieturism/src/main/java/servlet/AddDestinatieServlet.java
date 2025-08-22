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

@WebServlet("/inserareDestinatie")
public class AddDestinatieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Preluăm datele din formular
        String idDestinatie = request.getParameter("idDestinatie");
        String taraDes = request.getParameter("taraDes");
        String orasDes = request.getParameter("orasDes");
        String hotelDes = request.getParameter("hotelDes");
        String adresaDes = request.getParameter("adresaDes");
        String telefonDes = request.getParameter("telefonDes");

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO destinatie (id_destinatie, Tara_des, Oras_des, Hotel_des, Adresa_des, Telefon_des) VALUES (?, ?, ?, ?, ?, ?)");) {

            // Setăm valorile în interogarea SQL
            statement.setInt(1, Integer.parseInt(idDestinatie));  // Presupunem că id_destinatie este de tip int
            statement.setString(2, taraDes);  // Tara de destinație (String)
            statement.setString(3, orasDes);  // Orașul de destinație (String)
            statement.setString(4, hotelDes);  // Hotelul de destinație (String)
            statement.setString(5, adresaDes);  // Adresa de destinație (String)
            statement.setString(6, telefonDes);  // Telefonul de destinație (String)

            // Executăm interogarea
            statement.executeUpdate();

            // Redirecționăm utilizatorul la o pagină de succes
            response.sendRedirect("home.jsp?message=Destinatie added successfully");
        } catch (Exception e) {
            throw new ServletException("Error inserting destinatie", e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirecționăm utilizatorul către pagina de inserare a destinației
        request.getRequestDispatcher("/inserareDestinatie.jsp").forward(request, response);
    }
}
