package Employee;

/**
 * @Description:
 * @Author: PanYi
 * @Date: 2022/6/15
 */

public class Salary extends Employee {
    private double salary;
    public Salary(String name, String address, int number, double salary) {
        super(name, address,number);
        setSalary(salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void mailCheck() {
        System.out.println("Salary 类的 mailCheck 方法");
        System.out.println("邮寄支票给： " + getName()
                + "，工资为" + getSalary());
    }
}
