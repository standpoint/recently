

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Servlet1 extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException {
        
        String value=(String)request.getAttribute("p");
        String value1=(String)request.getAttribute("q");
        
        PrintWriter out = response.getWriter();                    out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet MyServlet</title>");            
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello, "+value +" "+value1+ "</h1>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }



}
