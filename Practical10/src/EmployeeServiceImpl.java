import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeServiceImpl extends UnicastRemoteObject implements EmployeeService {

    protected EmployeeServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public Employee getEmployeeDetails() throws RemoteException {
        Employee employee = null;
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/gautam";
            String user = "root";
            String password = "Vishwas@456";
            conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employee");
            
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setGender(rs.getString("gender"));
                employee.setDesignation(rs.getString("designation"));
                employee.setSalary(rs.getFloat("salary"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return employee;
    }
}
