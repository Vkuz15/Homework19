package pro.sky.employee.sevice;

import org.springframework.stereotype.Service;
import pro.sky.employee.exception.EmployeeException;
import pro.sky.employee.exception.EmployeeFullException;
import pro.sky.employee.exception.EmployeeNotFoundException;
import pro.sky.employee.model.Employee;

import java.util.*;

@Service
public class EmployeeServiceMapImpl implements EmployeeService {
    private static final int constant = 5;
    public Map<String, Employee> employees = new HashMap<>(constant);

    @Override
    public Employee add(String firstName, String lastName) {
        if (employees.size() >= constant) {
            throw new EmployeeFullException("Превышен лимит сотрудников");
        }
        Employee employee = new Employee(firstName, lastName);

        if (employees.containsKey(firstName + lastName)) {
            throw new EmployeeException("Такой сотрудник уже есть");
        }
        employees.put(firstName + lastName, employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = employees.remove(firstName + lastName);
        if (employee != null) {
            return employee;
        }
        throw new EmployeeNotFoundException("Данный сотрудник отсутствует в хранилище" + firstName + lastName);
    }

    @Override
    public Employee search(String firstName, String lastName) {
        Employee employee = employees.get(firstName + lastName);
        if (employee != null) {
            return employee;
        }
        throw new EmployeeNotFoundException("Данного сотрудника нет");
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
}

