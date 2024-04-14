package pro.sky.employee;
import pro.sky.employee.sevice.EmployeeServiceImpl;

public class Main {

    public static void main(String[] args) {


        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        employeeService.add("Иван", "Иванов");
        employeeService.add("Дмитрий", "Дмитров");
        employeeService.add("Петр", "Петров");
        employeeService.add("Марина", "Гавриловна");
        employeeService.add("Екатерина", "Попова");

        System.out.println(employeeService.employees);

    }
}
