package trigonometry;

import utils.Calculator;

import java.math.BigDecimal;


public class Sin implements Calculator {
    private static BigDecimal calcFactorial(int a) throws IllegalArgumentException {
        if (a >= 0) {
            BigDecimal res = BigDecimal.ONE;
            for (int i = 2; i <= a; i++)
                res = res.multiply(BigDecimal.valueOf(i));
            return res;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private static double calcX(double x) {

        Double k = 1d;
        if (Math.abs(x) > 2 * Math.PI)
            k = x / (2 * Math.PI);
        return x - 2 * k.intValue() * Math.PI;
    }

    static BigDecimal calcNthMember(double x, int n) {
        return BigDecimal.valueOf(Math.pow(-1, n)).multiply(BigDecimal.valueOf(Math.pow(x, 2 * n + 1)))
                .divide(calcFactorial(2 * n + 1), 20, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    public double calcValue(double x, double p) throws IllegalArgumentException {
        BigDecimal res = BigDecimal.ZERO;
        BigDecimal nth;
        int step = 0;
        double x2 = calcX(x);
        while (true) {
            nth = calcNthMember(x2, step);
            if (nth.abs().compareTo(BigDecimal.valueOf(Math.pow(p, 2))) < 0) break;
            step++;
            res = res.add(nth);
        }
        return res.doubleValue();
    }
}
