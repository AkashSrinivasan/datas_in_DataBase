package reg;
import java.io.IOException;  

import java.io.PrintWriter;  
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

@WebServlet("/SaveServlet")  
public class javalazy extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String name=request.getParameter("FirstName");  
        String password=request.getParameter("password");  
        System.err.println(""+name);
        System.err.println(""+password);
          
       try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/base","root","root");  
//here sonoo is database name, root is username and password  
PreparedStatement stmt=con.prepareStatement("insert into emp values(?,?)");  
stmt.setString(1,name);//1 specifies the first parameter in the query  
stmt.setString(2,password);  
  
int i=stmt.executeUpdate();  
System.out.println(i+" records inserted");  
  
con.close();  
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
}
}
