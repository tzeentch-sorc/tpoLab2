package trigonometry;

import utils.Calculator;

public class Cos implements Calculator {
    private Calculator sin = new Sin();

    @Override
    public double calcValue(double x, double p) throws IllegalArgumentException {
        return Math.sqrt(1 - Math.pow(sin.calcValue(x, p), 2));
    }

    @Override
    public String getName() {
        return "cos(x)";
    }
}
