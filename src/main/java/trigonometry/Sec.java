package trigonometry;

import utils.Calculator;

public class Sec implements Calculator {
    private Cos cos;

    public Sec(Cos cos) {
        this.cos = cos;
    }

    @Override
    public double calcValue(double x, double p) throws IllegalArgumentException {
        return 1 / cos.calcValue(x, p*p);
    }

    @Override
    public String getName() {
        return "sec(x)";
    }
}
