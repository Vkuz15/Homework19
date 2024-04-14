package pro.sky.employee.sevice;
import pro.sky.employee.model.Employee;
import java.util.Collection;

public interface EmployeeService {

    Employee add(String firstName, String lastName);
    Employee remove(String firstName, String lastName);
    Employee search(String firstName, String lastName);
    Collection<Employee> findAll();

}

