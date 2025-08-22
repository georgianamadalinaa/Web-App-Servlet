package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contract;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DatabaseConnection;

@WebServlet("/searchContract")
public class SearchContractServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String nrContract = request.getParameter("nrContract");
	    if (nrContract == null || nrContract.isEmpty()) {
	        request.setAttribute("errorMessage", "Numărul contractului este obligatoriu!");
	        request.getRequestDispatcher("/searchContract.jsp").forward(request, response);
	        return;
	    }

	    try (Connection connection = DatabaseConnection.getConnection()) {
	        String query = "SELECT * FROM contract WHERE Nr_contract = ?";
	        try (PreparedStatement statement = connection.prepareStatement(query)) {
	            statement.setString(1, nrContract);
	            try (ResultSet resultSet = statement.executeQuery()) {
	                if (resultSet.next()) {
	                    Contract contract = new Contract();
	                    contract.setNrContract(resultSet.getInt("Nr_contract"));
	                    contract.setIdAngajat(resultSet.getInt("id_angajat"));
	                    contract.setCodCnp(resultSet.getString("Cod_CNP"));
	                    contract.setIdDestinatie(resultSet.getInt("Id_destinatie"));
	                    contract.setDataPlecare(resultSet.getString("Data_plecare"));
	                    contract.setNrNopti(resultSet.getString("Nr_nopti"));
	                    contract.setTransport(resultSet.getString("Transport"));
	                    contract.setSumaPlata(resultSet.getString("Suma_plata"));

	                    request.setAttribute("contract", contract);
	                    request.getRequestDispatcher("/updateContract.jsp").forward(request, response);
	                } else {
	                    request.setAttribute("errorMessage", "Contractul cu acest număr nu a fost găsit!");
	                    request.getRequestDispatcher("/searchContract.jsp").forward(request, response);
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        request.setAttribute("errorMessage", "Eroare la căutarea contractului: " + e.getMessage());
	        request.getRequestDispatcher("/searchContract.jsp").forward(request, response);
	    }
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String nrContract = request.getParameter("nrContract");

	    if (nrContract == null || nrContract.trim().isEmpty()) {
	        request.setAttribute("errorMessage", "Numărul contractului este șters!");
	        request.getRequestDispatcher("/searchContract.jsp").forward(request, response);
	        return;
	    }

	    try (Connection connection = DatabaseConnection.getConnection()) {
	        String deleteQuery = "DELETE FROM contract WHERE Nr_contract = ?";
	        try (PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)) {
	            deleteStatement.setString(1, nrContract);

	            int rowsAffected = deleteStatement.executeUpdate();

	            if (rowsAffected > 0) {
	                request.setAttribute("successMessage", "Contractul a fost șters cu succes!");
	            } else {
	                request.setAttribute("errorMessage", "Contractul cu acest număr nu a fost găsit pentru ștergere!");
	            }

	            request.getRequestDispatcher("/searchContract.jsp").forward(request, response);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        request.setAttribute("errorMessage", "Eroare la ștergerea contractului: " + e.getMessage());
	        request.getRequestDispatcher("/searchContract.jsp").forward(request, response);
	    }
	}

}
