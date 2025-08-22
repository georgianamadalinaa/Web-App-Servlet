package servlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/angajati") // Mapează URL-ul "/angajati" la acest servlet
public class AngajatiServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Poți adăuga aici logica pentru a prelua datele angajaților dintr-o bază de date sau dintr-o sursă externă
        // De exemplu, poți adăuga lista de angajați într-un atribut al cererii (request)

        // Atribuie datele angajaților (dacă ai o bază de date)
        // request.setAttribute("angajati", listaDeAngajati);

        // Trimite utilizatorul către pagina JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("angajati.jsp");
        dispatcher.forward(request, response);
    }
}
