public class Drib {
    private int numerator;
    private int denominator;

    public Drib(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменник не може дорівнювати нулю.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    private void simplify() {
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        if (gcd > 1) {
            numerator /= gcd;
            denominator /= gcd;
        }
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public Drib add(Drib other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Drib(newNumerator, newDenominator);
    }

    public Drib subtract(Drib other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Drib(newNumerator, newDenominator);
    }

    public Drib multiply(Drib other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Drib(newNumerator, newDenominator);
    }

    public Drib divide(Drib other) {
        if (other.numerator == 0) {
            throw new IllegalArgumentException("Ділення на нуль недопустиме.");
        }
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        return new Drib(newNumerator, newDenominator);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public static void main(String[] args) {
        Drib drib1 = new Drib(3, 4);
        Drib drib2 = new Drib(5, 6);

        Drib sum = drib1.add(drib2);
        Drib difference = drib1.subtract(drib2);
        Drib product = drib1.multiply(drib2);
        Drib quotient = drib1.divide(drib2);

        System.out.println("Додавання: " + sum);
        System.out.println("Віднімання: " + difference);
        System.out.println("Множення: " + product);
        System.out.println("Ділення: " + quotient);
    }
}
