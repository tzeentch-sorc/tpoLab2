package trigonometry;

import utils.Calculator;

public class Csc implements Calculator {
    private final Sin sin;

    public Csc(Sin sin) {
        this.sin = sin;
    }

    @Override
    public double calcValue(double x, double p) throws IllegalArgumentException {
        return 1 / sin.calcValue(x, p * p);
    }

    @Override
    public String getName() {
        return "csc(x)";
    }
}
