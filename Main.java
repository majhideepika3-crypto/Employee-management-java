import java.util.ArrayList;

// Employee ka data
class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    void display() {
        System.out.println(id + " | " + name + " | Salary: " + salary);
    }
}

// Main program
public class Main {
    public static void main(String[] args) {
        System.out.println("--- Employee Management System ---");
        
        ArrayList<Employee> list = new ArrayList<>();
        
        // 3 Employee add kiye
        list.add(new Employee(1, "Deepika Majhi", 35000));
        list.add(new Employee(2, "Rahul", 40000));
        list.add(new Employee(3, "Priya", 30000));
        
        // Sabko dikhao
        for (Employee e : list) {
            e.display();
        }
        
        System.out.println("Total Employees: " + list.size());
    }
}
