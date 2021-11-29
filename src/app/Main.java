package app;

import dao.Dao;
import pojo.Employee;

import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Dao dao = new Dao();

    public static void main(String[] args) throws Exception{
        printMenu();
        while (true){
            System.out.println("Enter an option: ");
            int option = scanner.nextInt();

            if(option == 7){
                break;
            }

            switch (option){
                case 1:
                    viewEmployees();
                    break;
                case 2:
                    addEmployee();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    searchEmployee();
                    break;
                case 6:
                    createTable();
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }


    }

    public static void printMenu(){
        System.out.println("**********************");
        System.out.println("1. View Employees");
        System.out.println("2. Add Employee");
        System.out.println("3. Update Employee");
        System.out.println("4. Delete Employee");
        System.out.println("5. Search Employee");
        System.out.println("6. Create table");
        System.out.println("7. Exit");
        System.out.println("**********************");
    }


    public static void displayEmployee(Employee employee){
        System.out.println("Employee id: " + employee.getEmployeeId());
        System.out.println("Employee name: " + employee.getEmployeeName());
        System.out.println("Employee email: " + employee.getEmployeeEmail());
        System.out.println("Employee salary: " + employee.getEmployeeSalary());
        System.out.println("\n");
    }

    public static void viewEmployees(){
        System.out.println("*********************************");
        List<Employee> employeeList = dao.getAllEmployees();
        for(Employee employee: employeeList){
            displayEmployee(employee);
        }
        System.out.println("*******************************");
        System.out.println("\n");
    }

    public static void addEmployee() throws Exception{

        System.out.println("Enter Employee id: ");
        int employeeId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Employee name: ");
        String employeeName = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Enter Employee email: ");
        String employeeEmail = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Enter Employee salary: ");
        int employeeSalary = scanner.nextInt();

        Employee employee = new Employee();
        employee.setEmployeeId(employeeId);
        employee.setEmployeeName(employeeName);
        employee.setEmployeeEmail(employeeEmail);
        employee.setEmployeeSalary(employeeSalary);

        int status = dao.addEmployee(employee);
        if(status == 1){
            System.out.println("The employee was successfully added.");
        } else {
            System.out.println("ERROR while adding the employee.");
        }
        System.out.println("\n");
    }

    public static void updateEmployee() throws Exception{
        System.out.println("Enter employee id: ");
        int employeeId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter new employee name: ");
        String employeeName = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Enter new employee email: ");
        String employeeEmail = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Enter new employee salary: ");
        int salary = scanner.nextInt();

        Employee employee = new Employee();
        employee.setEmployeeId(employeeId);
        employee.setEmployeeName(employeeName);
        employee.setEmployeeEmail(employeeEmail);
        employee.setEmployeeSalary(salary);

        int status = dao.updateEmployee(employee);
        if(status == 1){
            System.out.println("The employee was successfully updated.");
        } else {
            System.out.println("ERROR while updating the employee.");
        }
        System.out.println("\n");

    }

    public static void deleteEmployee() throws  Exception{
        System.out.println("Enter employee id: ");
        int employeeId = scanner.nextInt();

        int status = dao.deleteEmployee(employeeId);
        if(status == 1){
            System.out.println("The employee was successfully deleted.");
        } else {
            System.out.println("ERROR while deleting the employee.");
        }
        System.out.println("\n");
    }

    public static void searchEmployee() throws Exception{
        System.out.println("Enter product id: ");
        int employeeId = scanner.nextInt();
        Employee employee = dao.getEmployeeById(employeeId);
        displayEmployee(employee);
        System.out.println("\n");
    }

    public static void createTable() throws Exception{
        int status = dao.createTable();
        if(status == 1){
            System.out.println("Table created successfully");
        } else {
            System.out.println("Table already exist.");
        }
    }

}
