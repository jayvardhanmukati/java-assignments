abstract class Employee {
    String empID;
    double baseSalary;

    Employee(String empID, double baseSalary) {
        this.empID = empID;
        this.baseSalary = baseSalary;
    }

    abstract double calcCTC();

    void display() {
        System.out.println("Employee ID: " + empID);
        System.out.println("Base Salary: " + baseSalary);
    }
}