<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // Invalidarea sesiunii curente
    if (session != null) {
        session.invalidate();
    }

    // Redirecționarea utilizatorului către pagina de login cu un mesaj
    response.sendRedirect("login.jsp?message=You have been logged out successfully.");
%>
