package dao;

import dbutil.DBUtil;
import pojo.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Dao {

    private Connection connection;

    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS employee(id INTEGER PRIMARY KEY, name VARCHAR(30), email VARCHAR(45), salary INTEGER)";
    private static final String GET_ALL_EMPLOYEES = "SELECT * FROM employee ORDER BY id";
    private static final String GET_EMPLOYEE_BY_ID = "SELECT * FROM employee WHERE id = ?";
    private static final String ADD_EMPLOYEE = "INSERT INTO employee VALUES(?,?,?,?)";
    private static final String DELETE_EMPLOYEE = "DELETE FROM employee WHERE id = ?";
    private static final String UPDATE_EMPLOYEE = "UPDATE employee SET name = ?, email = ?, salary = ? WHERE id = ?";

    private static final String EMPLOYEE_ID = "id";
    private static final String EMPLOYEE_NAME = "name";
    private static final String EMPLOYEE_EMAIL = "email";
    private static final String EMPLOYEE_SALARY = "salary";



    public int createTable(){

        int status = 0;

        try {
            connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_TABLE);
            status = preparedStatement.executeUpdate();

            DBUtil.closeConnection(connection);

        }catch (SQLException e){
            e.printStackTrace();
        }

        return status;
    }


    // return all employees ordered by id
    public List<Employee> getAllEmployees(){

        List<Employee> employeeList = new ArrayList<>();

        try {
            connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_EMPLOYEES);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                Employee employee = new Employee();
                employee.setEmployeeId(rs.getInt(EMPLOYEE_ID));
                employee.setEmployeeName(rs.getString(EMPLOYEE_NAME));
                employee.setEmployeeEmail(rs.getString(EMPLOYEE_EMAIL));
                employee.setEmployeeSalary(rs.getInt(EMPLOYEE_SALARY));

                employeeList.add(employee);

            }

            DBUtil.closeConnection(connection);

        } catch (SQLException e){
            e.printStackTrace();
        }

        return employeeList;
    }

    // return employee by id
    public Employee getEmployeeById(int employeeId){

        Employee employee = new Employee();

        try {
            connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_EMPLOYEE_BY_ID);
            preparedStatement.setInt(1, employeeId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                employee.setEmployeeId(resultSet.getInt(EMPLOYEE_ID));
                employee.setEmployeeName(resultSet.getString(EMPLOYEE_NAME));
                employee.setEmployeeEmail(resultSet.getString(EMPLOYEE_EMAIL));
                employee.setEmployeeSalary(resultSet.getInt(EMPLOYEE_SALARY));
            }

            DBUtil.closeConnection(connection);

        }catch (SQLException e){
            e.printStackTrace();
        }

        return employee;
    }

    public int addEmployee(Employee employee){

        int status = 0;

        try {
            connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_EMPLOYEE);
            preparedStatement.setInt(1, employee.getEmployeeId());
            preparedStatement.setString(2, employee.getEmployeeName());
            preparedStatement.setString(3, employee.getEmployeeEmail());
            preparedStatement.setInt(4, employee.getEmployeeSalary());

            status = preparedStatement.executeUpdate();


            DBUtil.closeConnection(connection);

        }catch (SQLException e){
            e.printStackTrace();
        }

        return status;

    }

    public int deleteEmployee(int employeeId){

        int status = 0;

        try{
            connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE);
            preparedStatement.setInt(1, employeeId);

            status = preparedStatement.executeUpdate();

            DBUtil.closeConnection(connection);

        }catch (SQLException e){
            e.printStackTrace();
        }

        return status;
    }

    public int updateEmployee(Employee employee){

        int status = 0;
        try {
            connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE);
            preparedStatement.setString(1,employee.getEmployeeName());
            preparedStatement.setString(2,employee.getEmployeeEmail());
            preparedStatement.setInt(3,employee.getEmployeeSalary());
            preparedStatement.setInt(4, employee.getEmployeeId());
            status = preparedStatement.executeUpdate();

            DBUtil.closeConnection(connection);

        }catch (SQLException e){
            e.printStackTrace();
        }

        return status;
    }


}
