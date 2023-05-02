
<%@page import="java.sql.*" %>
<%
    String emp_id = request.getParameter("emp_id");
    String message = "";

    // Check if emp_id is not null and is a positive integer
    if(emp_id != null && emp_id.matches("\\d+")) {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // Connect to the database
            String url = "jdbc:mysql://localhost:3306/gautam";
            String user = "root";
            String password = "Vishwas@456";
            Connection con = DriverManager.getConnection(url, user, password);
            
            // Create a prepared statement with the DELETE query
            PreparedStatement pstmt = con.prepareStatement("DELETE FROM employee WHERE id = ?");
            pstmt.setInt(1, Integer.parseInt(emp_id));

            // Execute the query and get the number of affected rows
            int rows = pstmt.executeUpdate();

            if(rows > 0) {
                message = "Employee record with emp_id " +emp_id + " deleted successfully.";
            } else {
                message = "No employee record found with emp_id " +emp_id;
            }

            // Close the prepared statement and database connection
            pstmt.close();
            con.close();

        } catch(Exception e) {
            message = "Error: " + e.getMessage();
        }
    }
%>
<html>
<head>
    <title>Delete Employee</title>
    <style>
        h1 {
            text-align: center;
            margin-top: 50px;
        }
        form {
            text-align: center;
            margin-top: 50px;
        }
        input[type=text] {
            padding: 10px;
            font-size: 16px;
            border-radius: 5px;
            border: none;
            box-shadow: 0px 0px 5px gray;
        }
        button[type=submit] {
            padding: 10px;
            font-size: 16px;
            border-radius: 5px;
            border: none;
            box-shadow: 0px 0px 5px gray;
            background-color: #4CAF50;
            color: white;
        }
        p {
            text-align: center;
            margin-top: 50px;
            font-size: 20px;
            color: blue;
        }
    </style>
</head>
<body>
    <h1>Delete Employee</h1>
    <form method="post">
        <label for="emp_id">Employee ID:</label>
        <input type="text" name="emp_id" id="emp_id" required>
        <button type="submit">Delete</button>
    </form>
    <p><%= message %></p>
</body>
</html>
