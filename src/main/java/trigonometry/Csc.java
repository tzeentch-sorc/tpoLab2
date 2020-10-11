package trigonometry;

import utils.Calculator;

public class Csc implements Calculator {
    private Sin sin;

    public Csc(Sin sin) {
        this.sin = sin;
    }

    @Override
    public double calcValue(double x, double p) throws IllegalArgumentException {
        return 1 / sin.calcValue(x, p);
    }

    @Override
    public String getName() {
        return "csc(x)";
    }
}
