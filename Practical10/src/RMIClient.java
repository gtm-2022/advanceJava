import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        EmployeeService employeeService = (EmployeeService) registry.lookup("EmployeeService");
        Employee employee = employeeService.getEmployeeDetails();
        if(employee!=null) {
        System.out.println("Employee details:");
        System.out.println("ID: " + employee.getId());
        System.out.println("Name: " + employee.getName());
        System.out.println("Gender: " + employee.getGender());
        System.out.println("Designation: " + employee.getDesignation());
        System.out.println("Salary: " + employee.getSalary());
        }
        else {
        	System.out.println("employee not found");
        }
        
    }
}
