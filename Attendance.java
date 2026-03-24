// Simple container for attendance record rows.

public class Attendance {
    private String employeeNumber;
    private String date;
    private String timeIn;
    private String timeOut;

    public Attendance(String empNum, String date, String in, String out) {
        this.employeeNumber = empNum;
        this.date = date;
        this.timeIn = in;
        this.timeOut = out;
    }

    public String getEmployeeNumber() { return employeeNumber; }
    public String getTimeIn() { return timeIn; }
    public String getTimeOut() { return timeOut; }
}
