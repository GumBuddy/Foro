package Control;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import Model.Beans.Participante_Bean;
import Model.DAO.Participante_DAO;

@WebServlet(name = "Servlet_Control_Foro")
public class Servlet_Control_Foro extends HttpServlet {
    Integer ID_PARTICIPANTE;
    String Participante,Twit;
    Participante_Bean Build_Bean;
    
    protected void recibir_parametros(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        Participante = request.getParameter("Participante");
        Twit = request.getParameter("Twit");
    }
    protected void altas_DatosPersonales(){
        ID_PARTICIPANTE=0;
        Participante_DAO alta = new Participante_DAO();
        Build_Bean = new Participante_Bean(ID_PARTICIPANTE,Participante,Twit);
        alta.save(Build_Bean);
    }

    protected void PrintAPP(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)throws IOException
    {   PrintWriter out;
        out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html>");
        out.println("<head><title>CONTROL</title></head>");
        out.println("<body>");
        out.println("<h1>Servlet Funcionando</h1>");
        out.println("</body></html>");
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        recibir_parametros(request, response);
        altas_DatosPersonales();
        PrintAPP(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
