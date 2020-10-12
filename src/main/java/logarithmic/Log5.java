package logarithmic;

import utils.Calculator;

public class Log5 implements Calculator {

    private Ln ln;

    public Log5(Ln ln) {
        this.ln = ln;
    }

    @Override
    public double calcValue(double x, double p) throws IllegalArgumentException {
        if (x <= 0) throw new IllegalArgumentException();
        return ln.calcValue(x, p) / ln.calcValue(5, p*p);
    }

    @Override
    public String getName() {
        return "log5(x)";
    }

}
