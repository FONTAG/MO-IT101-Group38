class Employee {
    // ================= BASIC INFO =================
    private String employeeNumber;
    private String lastName;
    private String firstName;
    private String birthday;

    // ================= SALARY DETAILS =================
    private double basicSalary;
    private double grossSemiMonthlyRate;
    private double hourlyRate;

    // ================= ALLOWANCES =================
    private double riceSubsidy;
    private double phoneAllowance;
    private double clothingAllowance;
    
    // Constructor initializes employee data.
    public Employee(String empNum, String lName, String fName, String bday,
                    double salary, double rice, double phone,
                    double clothing, double hourly) {

        this.employeeNumber = empNum;
        this.lastName = lName;
        this.firstName = fName;
        this.birthday = bday;

        this.basicSalary = salary;

        // Semi-monthly salary = Monthly / 2
        this.grossSemiMonthlyRate = salary / 2;

        this.riceSubsidy = rice;
        this.phoneAllowance = phone;
        this.clothingAllowance = clothing;
        this.hourlyRate = hourly;
    }
    
    // Computes daily working hours.
    // Formula:
    // (Time Out - Time In) - 1 hour lunch break
    
    public double calculateDailyHours(String timeIn, String timeOut) {
        LocalTime start = LocalTime.parse(timeIn);
        LocalTime end = LocalTime.parse(timeOut);

        long minutes = Duration.between(start, end).toMinutes();
        double hours = (minutes / 60.0) - 1.0;

        return (hours < 0) ? 0 : hours;
    }

    //Gross Salary = Hours Worked × Hourly Rate
    public double calculateGrossSalary(double hoursWorked) {
        return hoursWorked * hourlyRate;
    }

     //Total Allowances = Rice + Phone + Clothing
    public double getTotalAllowances() {
        return riceSubsidy + phoneAllowance + clothingAllowance;
    }

    // Simplified SSS Calculation
    public double calculateSSS() {
        if (basicSalary <= 3250) return 135.00;
        if (basicSalary >= 24750) return 1125.00;
        return (Math.floor((basicSalary - 3250) / 500) * 22.50) + 157.50;
    }

    // PhilHealth = 5% of salary divided by 2 (employee share)
    public double calculatePhilHealth() {
        return (basicSalary * 0.05) / 2;
    }

    // Pag-IBIG = Fixed 100 contribution
    public double calculatePagIbig() {
        return 100.00;
    }

    // Withholding Tax Calculation (Semi-monthly)
    // Taxable Income = Gross Pay - Deductions
    public double calculateTax(double gross, double deductions) {

        double taxableIncome = gross - deductions;

        if (taxableIncome <= 10417) return 0;
        if (taxableIncome <= 16667) return (taxableIncome - 10417) * 0.15;
        if (taxableIncome <= 33333) return ((taxableIncome - 16667) * 0.20) + 937.50;
        if (taxableIncome <= 83333) return ((taxableIncome - 33333) * 0.25) + 4270.83;
        if (taxableIncome <= 416667) return ((taxableIncome - 83333) * 0.30) + 16770.83;

        return ((taxableIncome - 416667) * 0.35) + 116770.83;
    }

    // ================= GETTERS =================
    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }
}
