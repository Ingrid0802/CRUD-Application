package pojo;

public class Employee {

    private int employeeId;
    private String employeeName;
    private String employeeEmail;
    private int employeeSalary;


    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public int getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(int employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String toString(){
        return "Employee [ id = " + employeeId + ", employeeName = " +  employeeName + ", employeeEmail = " + employeeEmail
        + ", employeeSalary = " + employeeSalary + "]";
    }
}
