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

@WebServlet("/updateContract")
public class UpdateContractServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int nrContract = Integer.parseInt(request.getParameter("nrContract"));
        int idAngajat = Integer.parseInt(request.getParameter("idAngajat"));
        String codCnp = request.getParameter("codCnp");
        int idDestinatie = Integer.parseInt(request.getParameter("idDestinatie"));
        String dataPlecare = request.getParameter("dataPlecare");
        String nrNopti = request.getParameter("nrNopti");
        String transport = request.getParameter("transport");
        String sumaPlata = request.getParameter("sumaPlata");

        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "UPDATE contract SET id_angajat = ?, Cod_CNP = ?, Id_destinatie = ?, Data_plecare = ?, Nr_nopti = ?, Transport = ?, Suma_plata = ? WHERE Nr_contract = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, idAngajat);
                statement.setString(2, codCnp);
                statement.setInt(3, idDestinatie);
                statement.setString(4, dataPlecare);
                statement.setString(5, nrNopti);
                statement.setString(6, transport);
                statement.setString(7, sumaPlata);
                statement.setInt(8, nrContract);
                
                statement.executeUpdate();
                response.sendRedirect("home.jsp?message=Contract actualizat cu succes!");
            }
        } catch (Exception e) {
            throw new ServletException("Eroare la actualizarea contractului", e);
        }
    }
}
