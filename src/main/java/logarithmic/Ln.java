package logarithmic;

import utils.Calculator;

public class Ln implements Calculator {

    //Gregory series (ln(x) = ln (z + 1)/(z - 1)). All further calculations inside with z
    private static double calcZ(double x) {
        return (x - 1) / (x + 1);
    }

    static double calcNthMember(double arg, int n) throws IllegalArgumentException {
        if (n <= 0) throw new IllegalArgumentException(); //n must be natural
        return 2d * Math.pow(arg, n) / n;
    }

    @Override
    public double calcValue(double x, double p) throws IllegalArgumentException{
        if(x < 0) throw new IllegalArgumentException(); //ln(x) defined only for x > 0
        double z = calcZ(x);
        double res = 0;
        double nth;
        int step = 1;
        while (true) {
            nth = calcNthMember(z, step);
            if (Math.abs(nth) <= Math.pow(p, 2)) break;
            step += 2;
            res += nth;

        }
        return res;
    }
}
