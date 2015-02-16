import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyServlet extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String value=null;
        HttpSession hp=request.getSession(true);
       
        value=(String)hp.getAttribute("p");
      
        if(value==null){
            value=request.getParameter("p");
            hp.setAttribute("p", value);
            hp.setMaxInactiveInterval(10000);
            
        }
        
        String value1=request.getParameter("q");
        request.setAttribute("p", value);
        request.setAttribute("q", value1);
        
        RequestDispatcher rd=request.getRequestDispatcher("/newservlet");
        rd.include(request,response);
        
        
    }

    @Override
    protected void doGet(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
