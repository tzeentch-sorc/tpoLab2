package trigonometry;

import utils.Calculator;

public class Cos implements Calculator {
    private Sin sin;

    public Cos(Sin sin) {
        this.sin = sin;
    }

    @Override
    public double calcValue(double x, double p) throws IllegalArgumentException {
        double realX = calcX(x);
        int sign = Math.abs(realX) < Math.PI/2 ? 1: -1;
        return Math.sqrt(1 - Math.pow(sin.calcValue(x, p*p), 2)) * sign;
    }

    private static double calcX(double x) {
        Double k = 0d;
        if (Math.abs(x) > 2 * Math.PI)
            k = x / (2 * Math.PI);
        return x - 2 * k.intValue() * Math.PI;
    }

    @Override
    public String getName() {
        return "cos(x)";
    }
}
