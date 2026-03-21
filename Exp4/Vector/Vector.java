public class Vector {

    private double[] components;

    // Constructor (Only 2D or 3D allowed)
    public Vector(double[] values) throws VectorException {

        if (values.length != 2 && values.length != 3) {
            throw new VectorException("Vector must be strictly 2D or 3D.");
        }

        components = values;
    }

    public int getDimension() {
        return components.length;
    }

    public Vector add(Vector v1) throws VectorException {

        if (this.getDimension() != v1.getDimension()) {
            throw new VectorException("Dimensions must match for addition.");
        }

        double[] result = new double[components.length];

        for (int i = 0; i < components.length; i++) {
            result[i] = this.components[i] + v1.components[i];
        }

        return new Vector(result);
    }

    public Vector subtract(Vector v1) throws VectorException {

        if (this.getDimension() != v1.getDimension()) {
            throw new VectorException("Dimensions must match for subtraction.");
        }

        double[] result = new double[components.length];

        for (int i = 0; i < components.length; i++) {
            result[i] = this.components[i] - v1.components[i];
        }

        return new Vector(result);
    }

    public double dotProduct(Vector v1) throws VectorException {

        if (this.getDimension() != v1.getDimension()) {
            throw new VectorException("Dimensions must match for dot product.");
        }

        double sum = 0;

        for (int i = 0; i < components.length; i++) {
            sum += this.components[i] * v1.components[i];
        }

        return sum;
    }

    public void printVector() {

        System.out.print("(");

        for (int i = 0; i < components.length; i++) {
            System.out.print(components[i]);
            if (i < components.length - 1)
                System.out.print(", ");
        }

        System.out.println(")");
    }
}