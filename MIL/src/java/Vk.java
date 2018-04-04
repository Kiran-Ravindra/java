
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Vk extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String n[]=request.getParameterValues("habits");
        int count=0;
      String key[]=new String[6];
       
       
       for(String s:n)
       {
      key[count]=s;
      // out.println(s);
           count++;
           
       }
       
 if((count==3)&&(key[0].equals(key[1]))&&(key[1].equals(key[2]))&&(key[2].equals(key[0])))
{
    out.println("account has been  created successfully");
}
 else{
     out.println("use captcha again");
     RequestDispatcher rd = request.getRequestDispatcher("Form.html");
                    rd.forward(request, response);
    }
}
}
    

