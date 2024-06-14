package autoevaluacion;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CalcularArea")
public class AreaServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
        // Obtener los parámetros del formulario
        String longitudParam = request.getParameter("longitud");
        String anchoParam = request.getParameter("ancho");
        
        // Convertir los parámetros a números
        double longitud = Double.parseDouble(longitudParam);
        double ancho = Double.parseDouble(anchoParam);
        
        // Calcular el área
        CalcularArea calculadora = new CalcularArea();
        double area = calculadora.calcularArea(longitud, ancho);
        
        // Establecer los atributos para la JSP
        request.setAttribute("area", area);
        
        // Redirigir a la JSP para mostrar el resultado
        request.getRequestDispatcher("/resultado.jsp").forward(request, response);
    }
}

