    import java.util.ArrayList;
    import java.util.List;
    import java.util.Scanner;

public class EmployeeManagementSystem
{
        private List<Employee> employees;
        public EmployeeManagementSystem() {
            employees = new ArrayList<>();
        }
        public void addEmployee(Employee employee) {
            employees.add(employee);
        }
        public void removeEmployee(int id) {
            employees.removeIf(employee -> employee.getId() == id);
        }
        public Employee getEmployee(int id) {
            for (Employee employee : employees) {
                if (employee.getId() == id) {
                    return employee;
                }
            }
            return null;
        }
        public void updateEmployeeSalary(int id, double salary) {
            Employee employee = getEmployee(id);
            if (employee != null) {
                employee.setSalary(salary);
            }
        }
        public void displayEmployees() {
            for (Employee employee : employees) {
                System.out.println("ID: " + employee.getId());
                System.out.println("Name: " + employee.getName());
                System.out.println("Department: " + employee.getDepartment());
                System.out.println("Salary: " + employee.getSalary());
                System.out.println();
            }
        }

        public static void main(String[] args) {
            EmployeeManagementSystem ems = new EmployeeManagementSystem();
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("1. Add Employee");
                System.out.println("2. Remove Employee");
                System.out.println("3. Get Employee");
                System.out.println("4. Update Employee Salary");
                System.out.println("5. Display Employees");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter employee ID: ");
                        int id = scanner.nextInt();
                        System.out.print("Enter employee name: ");
                        String name = scanner.next();
                        System.out.print("Enter employee department: ");
                        String department = scanner.next();
                        System.out.print("Enter employee salary: ");
                        double salary = scanner.nextDouble();

                        Employee employee = new Employee(id, name, department, salary);
                        ems.addEmployee(employee);
                        break;
                    case 2:
                        System.out.print("Enter employee ID to remove: ");
                        int idToRemove = scanner.nextInt();
                        ems.removeEmployee(idToRemove);
                        break;
                    case 3:
                        System.out.print("Enter employee ID to get: ");
                        int idToGet = scanner.nextInt();
                        Employee employeeToGet = ems.getEmployee(idToGet);
                        if (employeeToGet != null) {
                            System.out.println("Employee found:");
                            System.out.println("ID: " + employeeToGet.getId());
                            System.out.println("Name: " + employeeToGet.getName());
                            System.out.println("Department: " + employeeToGet.getDepartment());
                            System.out.println("Salary: " + employeeToGet.getSalary());
                        } else {
                            System.out.println("Employee not found.");
                        }
                        break;
                    case 4:
                        System.out.print("Enter employee ID to update salary: ");
                        int idToUpdate = scanner.nextInt();
                        System.out.print("Enter new salary: ");
                        double newSalary = scanner.nextDouble();
                        ems.updateEmployeeSalary(idToUpdate, newSalary);
                        break;
                    case 5:
                        ems.displayEmployees();
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");

                }
            }
        }
}

