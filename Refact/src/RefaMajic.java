public class RefaMajic {
    public static void main(String[] args) {
        //8時間超えを残業とみなす。
        double overWorkingHours1 = EmployeePrac.calculateoverWorkingHours(6);
        System.out.println(overWorkingHours1);
        EmployeePrac e = new EmployeePrac();
        System.out.println(e.getPayment(8));
    }
}

class EmployeePrac {
    int paymentPerHour = 1000;
    public static int STANDARD_WORK_HOURS_PER_DAY = 8;
    public static double OVER_WORK_RATE = 1.5;

    public double getPayment(int workingHours) {
        double overWorkingHours = calculateoverWorkingHours(workingHours);
        double paymentForoverWorkingHours = this.paymentPerHour * OVER_WORK_RATE * overWorkingHours;
        double standardWorkingHours = workingHours - overWorkingHours;
        double paymentForStandardWorkHours = this.paymentPerHour * standardWorkingHours;
        return paymentForoverWorkingHours + paymentForStandardWorkHours;
    }

    public static double calculateoverWorkingHours(double workingHours) {
        if (workingHours < STANDARD_WORK_HOURS_PER_DAY) {
            return 0;
        } else {
            return workingHours - STANDARD_WORK_HOURS_PER_DAY;
        }
    }
}