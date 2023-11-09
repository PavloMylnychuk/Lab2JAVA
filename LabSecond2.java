public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int numberOfRoots() {
        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            return 2;
        } else if (discriminant == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public double[] calculateRoots() {
        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            return new double[]{root1, root2};
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            return new double[]{root};
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        QuadraticEquation equation1 = new QuadraticEquation(1, -3, 2);
        QuadraticEquation equation2 = new QuadraticEquation(1, 2, 1);
        QuadraticEquation equation3 = new QuadraticEquation(1, -5, 10);

        System.out.println("Рівняння 1 має " + equation1.numberOfRoots() + " коренів.");
        double[] roots1 = equation1.calculateRoots();
        if (roots1 != null) {
            System.out.println("Корені рівняння 1: " + roots1[0] + ", " + roots1[1]);
        }

        System.out.println("Рівняння 2 має " + equation2.numberOfRoots() + " корінь.");
        double[] roots2 = equation2.calculateRoots();
        if (roots2 != null) {
            System.out.println("Корінь рівняння 2: " + roots2[0]);
        }

        System.out.println("Рівняння 3 має " + equation3.numberOfRoots() + " коренів.");
        double[] roots3 = equation3.calculateRoots();
        if (roots3 != null) {
            System.out.println("Корені рівняння 3: " + roots3[0] + ", " + roots3[1]);
        }
    }
}
