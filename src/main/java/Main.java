import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        MyRobot fizz = new MyRobot("Fizz", 20);
        MyRobot buzz = new MyRobot("Buzz", 40);

        List<MyRobot> robotList = new ArrayList<>();
        robotList.add(fizz);
        robotList.add(buzz);

        System.out.println("============================================================ Style 1");
        style1(robotList);
        System.out.println();
        System.out.println("============================================================ Style 2");
        style2(robotList);
        System.out.println();
        System.out.println("============================================================ Style 3");
        style3(robotList);
        System.out.println();
        System.out.println("============================================================ Style 4");
        style4(robotList);
        System.out.println();
    }

    private static void print(List<MyRobot> robotList) {
        for (MyRobot robot : robotList) {
            System.out.println(robot.toString());
        }
    }

    public static class MyRobot {

        private String name;
        private int speed;

        public MyRobot(String name, int speed) {
            this.name = name;
            this.speed = speed;
        }

        @Override
        public String toString() {
            return "Name: " + name + " Speed: " + speed;
        }

        public String getName() {
            return name;
        }

        public int getSpeed() {
            return speed;
        }
    }

    // ============================================================ Style 1
    /**
     * Style 1: Implement the comparable interface by creating two classes (RobotNameComparator and RobotSpeedComparator)
     * and implementing the compare(...) method in each.
     */
    private static void style1(List<MyRobot> robotList) {

        Comparator<MyRobot> nameComparator = new RobotNameComparator();
        Comparator<MyRobot> speedComparator = new RobotSpeedComparator();

        System.out.println("====== Sorted by name");
        robotList.sort(nameComparator);
        print(robotList);
        System.out.println();
        System.out.println("====== Sorted by speed");
        robotList.sort(speedComparator);
        print(robotList);
    }

    public static class RobotNameComparator implements Comparator<MyRobot> {

        @Override
        public int compare(MyRobot robot1, MyRobot robot2) {
            return robot1.getName().compareTo(robot2.getName());
        }
    }

    public static class RobotSpeedComparator implements Comparator<MyRobot> {

        @Override
        public int compare(MyRobot robot1, MyRobot robot2) {
            return robot1.getSpeed() - robot2.getSpeed();
        }
    }

    // ============================================================ Style 2
    /**
     * Style 2: Anonymous inner class
     * Implement the Comparable interface by creating two anonymous inner classes that override the compare(...) method
     */
    private static void style2(List<MyRobot> robotList) {

        Comparator<MyRobot> nameComparator = new Comparator<MyRobot>() {
            @Override
            public int compare(MyRobot robot1, MyRobot robot2) {
                return robot1.getName().compareTo(robot2.getName());
            }
        };

        Comparator<MyRobot> speedComparator = new Comparator<MyRobot>() {
            @Override
            public int compare(MyRobot robot1, MyRobot robot2) {
                return robot1.getSpeed() - robot2.getSpeed();
            }
        };

        System.out.println("====== Sorted by name");
        robotList.sort(nameComparator);
        print(robotList);
        System.out.println();
        System.out.println("====== Sorted by speed");
        robotList.sort(speedComparator);
        print(robotList);
    }

    // ============================================================ Style 3
    /**
     * Style 3: Lambda
     * Implement the Comparable interface by creating two lambdas to override the compare(...) method
     */
    private static void style3(List<MyRobot> robotList) {

        Comparator<MyRobot> nameComparator = (robot1, robot2) -> robot1.getName().compareTo(robot2.getName());
        Comparator<MyRobot> speedComparator = (robot1, robot2) -> robot1.getSpeed() - robot2.getSpeed();

        System.out.println("====== Sorted by name");
        robotList.sort(nameComparator);
        print(robotList);
        System.out.println();
        System.out.println("====== Sorted by speed");
        robotList.sort(speedComparator);
        print(robotList);
    }

    // ============================================================ Style 4
    /**
     * Same as style 3 but creating the lambda inline in the method call.
     */
    private static void style4(List<MyRobot> robotList) {

        System.out.println("====== Sorted by name");
        robotList.sort((robot1, robot2) -> robot1.getName().compareTo(robot2.getName()));
        print(robotList);
        System.out.println();
        System.out.println("====== Sorted by speed");
        robotList.sort((robot1, robot2) -> robot1.getSpeed() - robot2.getSpeed());
        print(robotList);
    }
}
