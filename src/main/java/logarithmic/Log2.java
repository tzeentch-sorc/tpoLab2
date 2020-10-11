package logarithmic;

import utils.Calculator;

public class Log2 implements Calculator {

    private Ln ln;

    public Log2(Ln ln) {
        this.ln = ln;
    }

    @Override
    public double calcValue(double x, double p) throws IllegalArgumentException {
        if (x <= 0) throw new IllegalArgumentException();
        return ln.calcValue(x, p) / ln.calcValue(2, p);
    }

    @Override
    public String getName() {
        return "log2(x)";
    }

}
