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
import java.sql.ResultSet;

@WebServlet("/searchDestinatie")
public class SearchDestinatieServlet extends HttpServlet {

    // Metoda GET pentru căutare (există deja în codul tău)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idDestinatie = request.getParameter("idDestinatie");

        if (idDestinatie == null || idDestinatie.isEmpty()) {
            response.sendRedirect("searchDestinatie.jsp?errorMessage=Căutarea nu poate fi efectuată fără ID destinație!");
            return;
        }

        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM destinatie WHERE id_destinatie = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, idDestinatie);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        // Creăm un obiect Destinatie pentru a trimite datele în JSP
                        Destinatie destinatie = new Destinatie();
                        destinatie.setIdDestinatie(resultSet.getInt("id_destinatie"));
                        destinatie.setTaraDes(resultSet.getString("Tara_des"));
                        destinatie.setOrasDes(resultSet.getString("Oras_des"));
                        destinatie.setHotelDes(resultSet.getString("Hotel_des"));
                        destinatie.setAdresaDes(resultSet.getString("Adresa_des"));
                        destinatie.setTelefonDes(resultSet.getString("Telefon_des"));

                        // Setăm destinația în request pentru a fi accesibilă în JSP
                        request.setAttribute("destinatie", destinatie);

                        // Redirecționăm utilizatorul către pagina de actualizare
                        request.getRequestDispatcher("/updateDestinatie.jsp").forward(request, response);
                    } else {
                        // Dacă nu găsim destinația, trimitem un mesaj de eroare
                        response.sendRedirect("searchDestinatie.jsp?errorMessage=Destinația nu a fost găsită!");
                    }
                }
            } catch (Exception e) {
                // Gestionăm erorile de interacțiune cu baza de date
                response.sendRedirect("searchDestinatie.jsp?errorMessage=Eroare la căutarea destinației!");
            }
        } catch (Exception e1) {
            e1.printStackTrace();
            response.sendRedirect("searchDestinatie.jsp?errorMessage=Eroare de conexiune la baza de date!");
        }
    }

    // Metoda POST pentru ștergere
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idDestinatie = request.getParameter("idDestinatie");

        if (idDestinatie == null || idDestinatie.trim().isEmpty()) {
            response.sendRedirect("searchDestinatie.jsp?errorMessage=ID-ul destinației este obligatoriu pentru ștergere!");
            return;
        }

        try (Connection connection = DatabaseConnection.getConnection()) {
            String deleteQuery = "DELETE FROM destinatie WHERE id_destinatie = ?";
            try (PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)) {
                deleteStatement.setString(1, idDestinatie);

                int rowsAffected = deleteStatement.executeUpdate();

                if (rowsAffected > 0) {
                    // Dacă s-au șters rânduri, succes
                    response.sendRedirect("searchDestinatie.jsp?successMessage=Destinația a fost ștearsă cu succes!");
                } else {
                    // Dacă nu s-au șters rânduri, înseamnă că nu am găsit destinația
                    response.sendRedirect("searchDestinatie.jsp?errorMessage=Destinația cu acest ID nu a fost găsită pentru ștergere!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("searchDestinatie.jsp?errorMessage=Eroare la ștergerea destinației: " + e.getMessage());
        }
    }
}

