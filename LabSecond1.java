import java.lang.Math;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void moveX(double deltaX) {
        x += deltaX;
    }

    public void moveY(double deltaY) {
        y += deltaY;
    }

    public double distanceToOrigin() {
        return Math.sqrt(x * x + y * y);
    }

    public double distanceToPoint(Point otherPoint) {
        double dx = x - otherPoint.x;
        double dy = y - otherPoint.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double[] toPolarCoordinates() {
        double r = Math.sqrt(x * x + y * y);
        double theta = Math.atan2(y, x);
        return new double[]{r, theta};
    }

    public boolean isEqual(Point otherPoint) {
        return x == otherPoint.x && y == otherPoint.y;
    }

    public boolean isNotEqual(Point otherPoint) {
        return !isEqual(otherPoint);
    }

    public static void main(String[] args) {
        Point point1 = new Point(3, 4);
        Point point2 = new Point(5, 6);

        point1.moveX(2);
        point2.moveY(-1);

        System.out.println("Відстань до початку координат для точки 1: " + point1.distanceToOrigin());
        System.out.println("Відстань до початку координат для точки 2: " + point2.distanceToOrigin());

        System.out.println("Відстань між точкою 1 та точкою 2: " + point1.distanceToPoint(point2));

        double[] polarCoordinates = point1.toPolarCoordinates();
        System.out.println("Полярні координати точки 1: r = " + polarCoordinates[0] + ", theta = " + polarCoordinates[1]);

        if (point1.isEqual(point2)) {
            System.out.println("Точки 1 і 2 співпадають.");
        } else {
            System.out.println("Точки 1 і 2 неспівпадають.");
        }
    }
}
