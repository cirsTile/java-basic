package day02;

/**
 * @Description:
 * @Author: PanYi
 * @Date: 2022/6/29
 */

public class Dog extends Animal {
    private String dagName;

    public String getDagName() {
        return dagName;
    }

    public void setDagName(String dagName) {
        this.dagName = dagName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Dog{");
        sb.append("dagName='").append(dagName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
