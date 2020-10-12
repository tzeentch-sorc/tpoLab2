package trigonometry;

import utils.Calculator;

public class Cos implements Calculator {
    private final Sin sin;

    public Cos(Sin sin) {
        this.sin = sin;
    }

    private static double calcSign(double x) {
        Double k;
        if (Math.abs(x) > Math.PI / 2) {
            k = x / (Math.PI / 2);
            return Math.abs(k.intValue()) % 4 == 0 || Math.abs(k.intValue()) % 4 == 3 ? 1 : -1;
        } else return 1;
    }

    @Override
    public double calcValue(double x, double p) throws IllegalArgumentException {
        double sign = calcSign(x);
        //if(x == 10.1) System.out.println(Math.sqrt(1 - Math.pow(sin.calcValue(x, p*p), 2)) * sign);
        return Math.sqrt(1 - Math.pow(sin.calcValue(x, p * p), 2)) * sign;
    }

    @Override
    public String getName() {
        return "cos(x)";
    }
}
