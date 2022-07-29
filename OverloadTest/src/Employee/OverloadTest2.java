package Employee;

/**
 * @Description:
 * @Author: PanYi
 * @Date: 2022/6/15
 */

public class OverloadTest2 {
    public static void main(String[] args) {
        Salary salary = new Salary("员工 A", "Beijing", 123, 1000);
        Employee e = new Salary("员工 B", "ShangHai", 123, 24000.00);
        System.out.println("使用 Salary 的引用调用 mailCheck -- ");
        salary.mailCheck();
        System.out.println("\n使用 Employee 的引用调用 mailCheck--");
        e.mailCheck();
    }
}
