package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DatabaseConnection;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;


@WebServlet("/inserareContract")
public class AddContractServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Preluăm datele din formular
        String nrContract = request.getParameter("nrContract");
        String idAngajat = request.getParameter("idAngajat");
        String codCnp = request.getParameter("codCnp");
        String idDestinatie = request.getParameter("idDestinatie");
        String dataPlecare = request.getParameter("dataPlecare");
        String nrNopti = request.getParameter("nrNopti");
        String transport = request.getParameter("transport");
        String sumaPlata = request.getParameter("sumaPlata");

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO contract (Nr_contract, id_angajat, Cod_CNP, Id_destinatie, Data_plecare, Nr_nopti, Transport, Suma_plata) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");) {

            // Setăm valorile în interogarea SQL
            statement.setInt(1, Integer.parseInt(nrContract));  // Presupunem că Nr_contract este de tip int
            statement.setInt(2, Integer.parseInt(idAngajat));  // Presupunem că id_angajat este de tip int
            statement.setString(3, codCnp);  // CNP-ul clientului (String)
            statement.setInt(4, Integer.parseInt(idDestinatie));  // Presupunem că Id_destinatie este de tip int
            statement.setString(5, dataPlecare);  // Data plecare (String)
            statement.setString(6, nrNopti);  // Nr nopti (String)
            statement.setString(7, transport);  // Tipul transportului (String)
            statement.setString(8, sumaPlata);  // Suma de plata (String)

            // Executăm interogarea
            statement.executeUpdate();

            // Redirecționăm utilizatorul la o pagină de succes
            response.sendRedirect("home.jsp?message=Contract added successfully");
        } catch (Exception e) {
            throw new ServletException("Error inserting contract", e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Dacă parametru 'action' este 'graf', generăm graficul
        String action = request.getParameter("action");

        if ("graf".equals(action)) {
            generateContractChart(response);
        } else {
            request.getRequestDispatcher("/inserareContract.jsp").forward(request, response);
        }
    }

    // Funcția care generează graficul
    private void generateContractChart(HttpServletResponse response) throws IOException {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        try (Connection connection = DatabaseConnection.getConnection()) {
            // Interogăm baza de date pentru a obține numărul de contracte pe lună
            String query = "SELECT MONTH(Data_plecare) AS Month, COUNT(*) AS NumarContracte " +
                           "FROM contract " +
                           "GROUP BY MONTH(Data_plecare) " +
                           "ORDER BY Month";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {

                // Adăugăm datele în dataset
                while (resultSet.next()) {
                    int month = resultSet.getInt("Month");
                    int numarContracte = resultSet.getInt("NumarContracte");
                    dataset.addValue(numarContracte, "Contracte", "Luna " + month);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Eroare la generarea graficului.");
            return;
        }

        // Creăm graficul
        JFreeChart chart = ChartFactory.createBarChart(
                "Număr de Contracte pe Lună", // Titlul graficului
                "Luna", // Eticheta axei X
                "Număr Contracte", // Eticheta axei Y
                dataset // Datele
        );

        // Setăm tipul de conținut ca imagine PNG
        response.setContentType("image/png");
        org.jfree.chart.ChartUtils.writeChartAsPNG(response.getOutputStream(), chart, 800, 600);
    }
}
