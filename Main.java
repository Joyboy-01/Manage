import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        Manage ems = new Manage();
        
        ems.addEmployee("A", 30);
        ems.addEmployee("B", 25);
        ems.addEmployee("C", 28);
        
        ems.deleteEmployee("B");
        
        ems.addEmployee("A", 35);  // A 已存在，提示重复
        ems.addEmployee("D", 22);

        ems.printEmployees();
    }
}
class Employee {
    String name;
    int age;

    public Employee() {}

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "姓名: " + name + ", 年龄: " + age;
    }
}
class Manage {
    private List<Employee> employees;

    public Manage() {
        employees = new ArrayList<>();
    }
    
    public void addEmployee(String name, int age) {
        for (Employee emp : employees) {
            if (emp.name.equals(name)) {
                System.out.println("员工 " + name + " 已经存在。");
                return;
            }
        }
        employees.add(new Employee(name, age));
        System.out.println("添加员工: " + name + ", 年龄: " + age);
    }
    
    public void deleteEmployee(String name) {
        employees.removeIf(emp -> emp.name.equals(name));
        System.out.println("删除员工: " + name);
    }
    
    public void printEmployees() {
        Collections.sort(employees, Comparator.comparing(emp -> emp.name));
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}