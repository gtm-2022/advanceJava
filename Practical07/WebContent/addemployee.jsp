<%@ page import="java.sql.*" %>
<html>
<head>
    <title>Add Employee</title>
</head>
<body>
    <%-- Retrieve the employee details from the form and insert them into the database --%>
    <%
        String empid = request.getParameter("id");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String designation = request.getParameter("designation");
        String salary = request.getParameter("salary");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gautam", "root", "Vishwas@456");

            String query = "insert into employee (id, name, gender, designation, salary) values (?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,empid);
            pst.setString(2, name);
            pst.setString(3, gender);
            pst.setString(4, designation);
            pst.setString(5, salary);
           int x= pst.executeUpdate();
          
            

            out.println("Employee added successfully!");

            
            String query1="select *from employee";
            PreparedStatement pst1 = con.prepareStatement(query1);
          
            ResultSet rs = pst1.executeQuery(query1);  
            out.println("<table border=5 witdth=50% height=50% >");  
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
            pst.close();
            con.close();  
           
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    %>
</body>
</html>
