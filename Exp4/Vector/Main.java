import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Enter dimension (2 or 3 only): ");
            int dimension = sc.nextInt();

            double[] values1 = new double[dimension];
            double[] values2 = new double[dimension];

            System.out.println("Enter elements of Vector 1:");
            for (int i = 0; i < dimension; i++) {
                values1[i] = sc.nextDouble();
            }

            System.out.println("Enter elements of Vector 2:");
            for (int i = 0; i < dimension; i++) {
                values2[i] = sc.nextDouble();
            }

            Vector v1 = new Vector(values1);
            Vector v2 = new Vector(values2);

            System.out.println("\nChoose Operation:");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Dot Product");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    Vector sum = v1.add(v2);
                    System.out.print("Result: ");
                    sum.printVector();
                    break;

                case 2:
                    Vector diff = v1.subtract(v2);
                    System.out.print("Result: ");
                    diff.printVector();
                    break;

                case 3:
                    double dot = v1.dotProduct(v2);
                    System.out.println("Dot Product: " + dot);
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } catch (VectorException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}