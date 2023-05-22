public class Money {
    private double[] denominations = { 500, 200, 100, 50, 20, 10, 5, 2, 1, 0.5, 0.25, 0.1, 0.05, 0.02, 0.01 };
    private int[] counts = new int[15];

    public Money(int[] counts) {
        this.counts = counts;
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < denominations.length; i++) {
            total += denominations[i] * counts[i];
        }
        return total;
    }

    public Money add(Money other) {
        int[] newCounts = new int[15];
        for (int i = 0; i < 15; i++) {
            newCounts[i] = this.counts[i] + other.counts[i];
        }
        return new Money(newCounts);
    }

    public Money subtract(Money other) {
        int[] newCounts = new int[15];
        for (int i = 0; i < 15; i++) {
            newCounts[i] = this.counts[i] - other.counts[i];
        }
        return new Money(newCounts);
    }

    public Money divide(int divisor) {
        int[] newCounts = new int[15];
        for (int i = 0; i < 15; i++) {
            newCounts[i] = this.counts[i] / divisor;
        }
        return new Money(newCounts);
    }

    public double divide(double divisor) {
        return getTotal() / divisor;
    }

    public boolean equals(Money other) {
        for (int i = 0; i < 15; i++) {
            if (this.counts[i] != other.counts[i]) {
                return false;
            }
        }
        return true;
    }
}
import java.util.Scanner;

public class MoneyMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] counts1 = new int[15];
        int[] counts2 = new int[15];

        System.out.println("Enter the counts for money1:");
        for (int i = 0; i < counts1.length; i++) {
            counts1[i] = scanner.nextInt();
        }

        System.out.println("Enter the counts for money2:");
        for (int i = 0; i < counts2.length; i++) {
            counts2[i] = scanner.nextInt();
        }

        Money money1 = new Money(counts1);
        Money money2 = new Money(counts2);

        System.out.println("Total of money1: " + money1.getTotal());
        System.out.println("Total of money2: " + money2.getTotal());

        Money money3 = money1.add(money2);
        System.out.println("Total of money3 (money1 + money2): " + money3.getTotal());

        Money money4 = money1.subtract(money2);
        System.out.println("Total of money4 (money1 - money2): " + money4.getTotal());

        Money money5 = money1.divide(2);
        System.out.println("Total of money5 (money1 / 2): " + money5.getTotal());

        double money6 = money1.divide(2.5);
        System.out.println("Result of money1 / 2.5: " + money6);

        boolean isEqual = money1.equals(money2);
        System.out.println("Are money1 and money2 equal? " + isEqual);
    }
}
------------------------------------------------------------------------------
public class Parallelogram {
    private double side1;
    private double side2;
    private double angle;

    public Parallelogram(double s1, double s2, double a) {
        side1 = s1;
        side2 = s2;
        angle = a;
    }

    public double getPerimeter() {
        return 2 * (side1 + side2);
    }

    public double getArea() {
        return side1 * side2 * Math.sin(Math.toRadians(angle));
    }

    public boolean isEqual(Parallelogram other) {
        return this.side1 == other.side1 && this.side2 == other.side2 && this.angle == other.angle;
    }

    public boolean isSimilar(Parallelogram other) {
        double ratio1 = this.side1 / other.side1;
        double ratio2 = this.side2 / other.side2;
        double ratio3 = Math.sin(Math.toRadians(this.angle)) / Math.sin(Math.toRadians(other.angle));
        return ratio1 == ratio2 && ratio2 == ratio3;
    }
}
public class ParallelogramMain {
    public static void main(String[] args) {
        Parallelogram p = new Parallelogram(5, 8, 60);
        double perimeter = p.getPerimeter();
        double area = p.getArea();
        System.out.println("Parallelogram with sides 5 and 8 and angle between them 60 degrees:");
        System.out.println("Perimeter: " + perimeter);
        System.out.println("Area: " + area);
    }
}

