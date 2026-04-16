public class Main {
    public static void main(String[] args) {

        Payroll p1 = new Payroll(100000.0, 40000.0, 50000.0, 20000.0, 0);

        FullTimeEmployee f1 = new FullTimeEmployee("F1", 300000, p1);
        ContractEmp c1 = new ContractEmp("C1", 5000, 2000);
        Manager m1 = new Manager("M1", 500000, p1, 100000);

        // Table Header
        System.out
                .println("-------------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-12s %-12s %-10s %-10s %-10s %-10s\n",
                "EmpType", "BaseSal", "HealthIns", "Bonus", "Options", "PF", "CTC");
        System.out
                .println("-------------------------------------------------------------------------------------------");

        // Full Time Employee Row
        System.out.printf("%-10s %-12.2f %-12.2f %-10.2f %-10.2f %-10.2f %-10.2f\n",
                "F1",
                f1.baseSalary,
                p1.healthInsAmt,
                p1.bonus,
                p1.stockOptions,
                p1.pfContribution,
                f1.calcCTC());

        // Contract Employee Row (no payroll fields)
        System.out.printf("%-10s %-12.2f %-12s %-10s %-10s %-10s %-10.2f\n",
                "C1",
                c1.baseSalary,
                "-",
                "-",
                "-",
                "-",
                c1.calcCTC());

        // Manager Row
        System.out.printf("%-10s %-12.2f %-12.2f %-10.2f %-10.2f %-10.2f %-10.2f\n",
                "M1",
                m1.baseSalary,
                p1.healthInsAmt,
                p1.bonus,
                p1.stockOptions,
                p1.pfContribution,
                m1.calcCTC());

        System.out
                .println("-------------------------------------------------------------------------------------------");
    }
}