package com.example.employee;

import java.util.*;

public class EmployeeManagementSystem {
    private Map<Integer, Employee> employees = new HashMap<>();
    private int nextId = 1;

    // Create
    public Employee addEmployee(String name, String department, double salary) {
        Employee emp = new Employee(nextId++, name, department, salary);
        employees.put(emp.getId(), emp);
        return emp;
    }

    // Read
    public Employee getEmployee(int id) {
        return employees.get(id);
    }

    // Update
    public boolean updateEmployee(int id, String name, String department, double salary) {
        Employee emp = employees.get(id);
        if (emp != null) {
            emp.setName(name);
            emp.setDepartment(department);
            emp.setSalary(salary);
            return true;
        }
        return false;
    }

    // Delete
    public boolean removeEmployee(int id) {
        return employees.remove(id) != null;
    }

    // List all
    public List<Employee> listAllEmployees() {
        return new ArrayList<>(employees.values());
    }

    // Get all employee with prime ID
    public List<Integer> getPrimeEmployeeIds(HashMap<Integer, Employee> employeeMap) {
        List<Integer> primeIds = new ArrayList<>();
        for (Integer id : employeeMap.keySet()) {
            if (isPrime(id)) {
                primeIds.add(id);
            }
        }
        return primeIds;
    }
    
    // Check whether a number is prime or not
    private boolean isPrime(int num) {
        if (num <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

   public static void main(String[] args) {
    EmployeeManagementSystem ems = new EmployeeManagementSystem();

    ems.addEmployee("Alice", "HR", 50000);       // ID 1
    ems.addEmployee("Bob", "IT", 60000);         // ID 2
    ems.addEmployee("Charlie", "Finance", 55000); // ID 3
    ems.addEmployee("David", "Marketing", 52000); // ID 4
    ems.addEmployee("Eve", "Legal", 58000);       // ID 5
    ems.addEmployee("Frank", "Admin", 51000);     // ID 6
    ems.addEmployee("Grace", "IT", 62000);        // ID 7
    ems.addEmployee("Hank", "Finance", 57000);    // ID 8
    ems.addEmployee("Ivy", "HR", 59000);          // ID 9
    ems.addEmployee("John", "Legal", 53000);      // ID 10

    ems.updateEmployee(2, "Bob Marley", "IT", 62000);
    ems.removeEmployee(3);

    for (Employee emp : ems.listAllEmployees()) {
        System.out.println(emp);
    }

    // Test prime ID function
    List<Integer> primeIds = ems.getPrimeEmployeeIds(new HashMap<>(ems.employees));
    System.out.println("Prime Employee IDs: " + primeIds);
}

}

class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("Employee[ID=%d, Name=%s, Department=%s, Salary=%.2f]",
                id, name, department, salary);
    }
}