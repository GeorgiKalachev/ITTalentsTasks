package Homework14.people;

public class Employee extends Person {

    private final double daySalary;

    public Employee(String name, int age, boolean isMale, double daySalary) {
        super(name, age, isMale);
        this.daySalary = daySalary;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Employee salary per day : " + this.daySalary);
    }
    /*
    В случай че на работник се наложи да работи извън работно
време, на него му се дължи допълнителна сума пари (overtime) за
часовете които е работил. Сумата се пресмята по следния начин: ако
работника, няма навършени 18 години, дължимата сума е 0. В
противен случай, за всеки отработен час, на работника се заплаща
сумата която получава на час (зависи от дневната заплата) умножена
по 1,5.
метод calculateOvertime(double hours) който пресмята и връща стойността
на сумата която му се дължи при работа извън работно време
метод showEmployeeInfo(), който показва информация за човека, както и
информация за дневната му заплата
     */

    public void getOverTime(double hours) {
        double perHour = (this.daySalary / 8) * 1.5;
        if (this.getAge() >= 18) {
            System.out.println("Employee extra paid : " + hours * perHour);
        } else {
            System.out.println("Employee is under 18.");
        }
    }


}
