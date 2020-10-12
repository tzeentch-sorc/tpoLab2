package trigonometry;

import utils.Calculator;

public class Ctg implements Calculator {
    private Sin sin;
    private Cos cos;

    public Ctg(Sin sin, Cos cos) {
        this.sin = sin;
        this.cos = cos;
    }

    @Override
    public double calcValue(double x, double p) throws IllegalArgumentException {
        return cos.calcValue(x, p/100) / sin.calcValue(x, p*p);
    }

    @Override
    public String getName() {
        return "ctg(x)";
    }
}
