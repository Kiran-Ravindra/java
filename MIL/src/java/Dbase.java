
import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

public class Dbase extends HttpServlet {
    String[] debug = new String[100];
    //Image image = new Image();

    HashMap<String, ArrayList> hm = new HashMap<>();
    ArrayList<String> arr1 = new ArrayList<>();
       
    String[] s = new String[20];
    String ss;
    int m;
    String mainpicpath[] = new String[15];
    Random r = new Random();
    int a[] = new int[20];
    int b[] = new int[20];
   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/karthik", "jdbc", "database");
            Statement stmt = con.createStatement();
            ResultSet myr = stmt.executeQuery("select distinct picname  from picture");
            int p = 0;
            while (myr.next()) {
                s[p] = myr.getString("picname");
                p++;
            }
            int size = p;
            for (m = 0; m <size; m++) {
                ArrayList<String> arr = new ArrayList<>();

                ResultSet my = stmt.executeQuery("select picpath from picture where picname=" + "'" + s[m] + "'");
                while (my.next()) {
                    String name = my.getString("picpath");
                    name = name.substring(11);
                    arr.add(name);
                }
                
                hm.put(s[m], arr);
                // out.println(arr)  ;  
            }
            //a is for selecting 3 random picname ex cat adn dog
            //b array is for selecting 6 different pictures
            a[0] = r.nextInt(4);
            arr1 = hm.get(s[a[0]]);
            b[0] = r.nextInt(6);
            b[1] = r.nextInt(6);
            b[2] = r.nextInt(6);
Integer[] arrr = new Integer[6];
    for (int i = 0; i < arrr.length; i++) {
        arrr[i] = i;
    }
    Collections.shuffle(Arrays.asList(arrr));
    out.println(Arrays.toString(arrr));
            int bbb,sss,aaa;
            mainpicpath[arrr[0]] = arr1.get(b[0]);
            mainpicpath[arrr[1]] = arr1.get(b[1]);
            mainpicpath[arrr[2]] = arr1.get(b[2]);
            mainpicpath[12]=s[a[0]];
            bbb=arrr[0];
            aaa=arrr[1];
            sss=arrr[2];
        do{
            a[1] = r.nextInt(4);
            arr1 = hm.get(s[a[1]]);
            b[3] = r.nextInt(5);
        }while(a[1]==a[0]);
          mainpicpath[arrr[3]] = arr1.get(b[3]);
       do{
            a[2] = r.nextInt(4);
            arr1 = hm.get(s[a[2]]);
            b[4] = r.nextInt(5);
       }while(a[2]==a[0]);
         mainpicpath[arrr[4]] = arr1.get(b[4]);
       do{
            a[3] = r.nextInt(4);
            arr1 = hm.get(s[a[3]]);
            b[4] = r.nextInt(5);
       }while(a[3]==a[0]);
            mainpicpath[arrr[5]] = arr1.get(b[5]);
         for(int i=0;i<6;i++)
         {
             if((i==bbb)||(i==aaa)|i==sss)
                 mainpicpath[i+6]=s[a[0]];
             else
                 mainpicpath[i+6]="kk";
         
        }
    request.setAttribute("picpath", mainpicpath);
            rd.forward(request, response);

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Dbase.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }
    }
}
