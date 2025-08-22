package servlet;

import model.Destinatie;
import util.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/updateDestinatie")
public class UpdateDestinatieServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idDestinatie = request.getParameter("idDestinatie");
        String taraDes = request.getParameter("taraDes");
        String orasDes = request.getParameter("orasDes");
        String hotelDes = request.getParameter("hotelDes");
        String adresaDes = request.getParameter("adresaDes");
        String telefonDes = request.getParameter("telefonDes");

        if (idDestinatie == null || idDestinatie.isEmpty()) {
            response.sendRedirect("searchDestinatie.jsp?errorMessage=ID-ul destinației este obligatoriu!");
            return;
        }

        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "UPDATE destinatie SET Tara_des = ?, Oras_des = ?, Hotel_des = ?, Adresa_des = ?, Telefon_des = ? WHERE id_destinatie = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, taraDes);
                statement.setString(2, orasDes);
                statement.setString(3, hotelDes);
                statement.setString(4, adresaDes);
                statement.setString(5, telefonDes);
                statement.setString(6, idDestinatie);

                int rowsUpdated = statement.executeUpdate();
                if (rowsUpdated > 0) {
                    response.sendRedirect("searchDestinatie.jsp?successMessage=Destinația a fost actualizată cu succes!");
                } else {
                    response.sendRedirect("searchDestinatie.jsp?errorMessage=Actualizarea nu a avut loc!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("searchDestinatie.jsp?errorMessage=Eroare la actualizarea destinației!");
        }
    }
}
