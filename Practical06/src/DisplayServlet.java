import java.io.*;
import javax.servlet.*;  
import javax.servlet.http.*;  
import java.sql.*;  
    
public class DisplayServlet extends HttpServlet  
{    
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
      {  
         PrintWriter out = res.getWriter();  
         res.setContentType("text/html");  
         out.println("<html><body>");  
         try 
         {  
             Class.forName("com.mysql.jdbc.Driver");  
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gautam", "root", "Vishwas@456");  
             
             Statement stmt = con.createStatement();  
             ResultSet rs = stmt.executeQuery("select * from employee");  
             out.println("<table border=1 width=50% height=50%>");  
             out.println("<tr><th>EmpId</th><th>EmpName</th><th>Gender</th><th>Designation</th><th>Salary</th><tr>");  
             while (rs.next()) 
             {  
                 int n = rs.getInt("id");  
                 String nm = rs.getString("name");
                 String g=rs.getString("gender");
                 String dn=rs.getString("designation");
                 float s = rs.getFloat("salary");   
                 out.println("<tr><td>" + n + "</td><td>" + nm + "</td>  <td>" + g + "</td> <td>" + dn + "</td>  <td>" + s + "</td></tr>");   
             }  
             out.println("</table>");  
             out.println("</html></body>");  
             con.close();  
            }  
             catch (Exception e) 
            {  
            	 e.printStackTrace();
             out.println("error");  
         }  
     }  
 }  