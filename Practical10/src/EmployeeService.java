import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EmployeeService extends Remote {
    public Employee getEmployeeDetails() throws RemoteException;
    

}
