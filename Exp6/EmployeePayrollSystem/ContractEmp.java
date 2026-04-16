class ContractEmp extends Employee {
    double contractAmount;

    ContractEmp(String empID, double baseSalary, double contractAmount) {
        super(empID, baseSalary);
        this.contractAmount = contractAmount;
    }

    @Override
    double calcCTC() {
        return baseSalary + contractAmount;
    }
}
