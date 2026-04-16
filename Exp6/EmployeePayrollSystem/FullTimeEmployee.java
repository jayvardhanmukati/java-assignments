class FullTimeEmployee extends Employee {
    Payroll payroll;

    FullTimeEmployee(String empID, double baseSalary, Payroll payroll) {
        super(empID, baseSalary);
        this.payroll = payroll;
    }

    @Override
    double calcCTC() {
        return baseSalary + payroll.calculateExtras();
    }
}