package logarithmic;

import utils.Calculator;

public class LogN implements Calculator {

    private double base;

    public LogN(double base){
        this.base = base;
    }

    @Override
    public double calcValue(double x, double p) throws IllegalArgumentException {
        if(x <= 0) throw new IllegalArgumentException();
        Calculator calculator = new Ln();
        return calculator.calcValue(x, p)/calculator.calcValue(base, p);
    }
}
