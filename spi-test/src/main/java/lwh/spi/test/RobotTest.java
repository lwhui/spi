package lwh.spi.test;

import lwh.spi.core.RobotFactory;

public class RobotTest {
    public static void main(String[] args) {
        RobotFactory factory = new RobotFactory();
        factory.invoke();
    }
}
