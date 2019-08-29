package lwh.spi.core;

import lwh.spi.Robot;

import java.util.Iterator;
import java.util.ServiceLoader;

public class RobotFactory {
    public void invoke() {
        ServiceLoader<Robot> services = ServiceLoader.load(Robot.class);
        Iterator<Robot> robots = services.iterator();
        boolean notFound = true;
        while (robots.hasNext()) {
            notFound = false;
            Robot robot = robots.next();
            robot.sayHello();
        }
        if (notFound) {
            throw new RuntimeException("not found service");
        }

    }
}
