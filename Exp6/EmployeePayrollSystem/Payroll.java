class Payroll {
    double healthInsAmt;
    double bonus;
    double stockOptions;
    double pfContribution;
    double ptoCost;

    Payroll(double healthInsAmt, double bonus, double stockOptions, double pfContribution, double ptoCost) {
        this.healthInsAmt = healthInsAmt;
        this.bonus = bonus;
        this.stockOptions = stockOptions;
        this.pfContribution = pfContribution;
        this.ptoCost = ptoCost;
    }

    double calculateExtras() {
        return healthInsAmt + bonus + stockOptions + pfContribution;
    }

}