class Employee {
    // Basic Information
    private String employeeNumber;
    private String lastName;
    private String firstName;
    private String birthday;
    
    // Salary and Rates
    private double basicSalary;
    private double grossSemiMonthlyRate;
    private double hourlyRate;
    
    // Fixed Monthly Allowances (MotorPH specific)
    private double riceSubsidy;
    private double phoneAllowance;
    private double clothingAllowance;

    // MotorPH Employee list
    public Employee(String empNum, String lName, String fName, String bday, 
                    double salary, double rice, double phone, double clothing, double hourly) {
        this.employeeNumber = empNum;
        this.lastName = lName;
        this.firstName = fName;
        this.birthday = bday;
        this.basicSalary = salary;

        // Calculation for Gross Semi-monthly rate (even if not needed)
        this.grossSemiMonthlyRate = salary / 2;
        
        this.riceSubsidy = rice;
        this.phoneAllowance = phone;
        this.clothingAllowance = clothing;
        this.hourlyRate = hourly;
    }
    
    // Calculates time and subtracts 1 hour for lunch
    public double calculateDailyHours(String timeIn, String timeOut) {
        LocalTime start = LocalTime.parse(timeIn);
        LocalTime end = LocalTime.parse(timeOut);
        long minutes = Duration.between(start, end).toMinutes();
        double hours = (minutes / 60.0) - 1.0; // Subtracting 1 hour lunch
        return (hours < 0) ? 0 : hours;
    }
    
    public double calculateSSS() {
        if (basicSalary <= 3250) return 135.00;
        if (basicSalary >= 24750) return 1125.00;
        return (Math.floor((basicSalary - 3250) / 500) * 22.50) + 157.50;
    }
    public double calculatePhilHealth() {
    // 2026 Philippine Rule: 5% of Basic Salary split between Employee and Employer
    return (basicSalary * 0.05) / 2;
    }
    
    public double calculatePagIbig() {
    // Standard contribution is usually capped at 200 total (100 each for Emp/EE)
    // for salaries above 1,500
    return 100.00;
    }
    
    // Calculation Method for Gross Salary (Hours * Rate)
    public double calculateGrossSalary(double hoursWorked) {
        return hoursWorked * hourlyRate;
    }
    
    // 2026 Withholding Tax Calculation (Semi-monthly)
    public double calculateTax(double gross, double totalStatutory) {
        double taxableIncome = gross - totalStatutory;
        
        if (taxableIncome <= 10417) return 0;
        if (taxableIncome <= 16667) return (taxableIncome - 10417) * 0.15;
        if (taxableIncome <= 33333) return ((taxableIncome - 16667) * 0.20) + 937.50;
        if (taxableIncome <= 83333) return ((taxableIncome - 33333) * 0.25) + 4270.83;
        if (taxableIncome <= 416667) return ((taxableIncome - 83333) * 0.30) + 16770.83;
        
        return ((taxableIncome - 416667) * 0.35) + 116770.83;
    }

    // Getters to access data later
    public String getFullName() {
        return firstName + " " + lastName;
    }

    public double getTotalAllowances() {
        return riceSubsidy + phoneAllowance + clothingAllowance;
    }
    
    public double getBasicSalary() {
        return basicSalary;
    }
    public String getEmployeeNumber() {
        return employeeNumber;
    }
    public double getGrossSemiMonthlyRate() {
        return grossSemiMonthlyRate;
    }
    public String getBirthday() {
    return birthday;
    }
}
