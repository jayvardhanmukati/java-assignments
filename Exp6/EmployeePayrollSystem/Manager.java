class Manager extends FullTimeEmployee {
    double performanceBonus;

    Manager(String empID, double baseSalary, Payroll payroll, double performanceBonus) {
        super(empID, baseSalary, payroll);
        this.performanceBonus = performanceBonus;
    }

    @Override
    double calcCTC() {
        return super.calcCTC() + performanceBonus;
    }
}