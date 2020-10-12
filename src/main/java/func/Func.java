package func;

import logarithmic.Log2;
import logarithmic.Log5;
import trigonometry.*;
import utils.Calculator;

public class Func implements Calculator {
    private Log2 log2;
    private Log5 log5;

    private Sin sin;

    private Ctg ctg;
    private Sec sec;
    private Csc csc;

    public Func(Log2 log2,
                Log5 log5,
                Sin sin,
                Ctg ctg,
                Sec sec,
                Csc csc) {
        this.log2 = log2;
        this.log5 = log5;
        this.sin = sin;
        this.ctg = ctg;
        this.sec = sec;
        this.csc = csc;
    }


    @Override
    public double calcValue(double x, double p) throws IllegalArgumentException {
        if (x > 0) {
            return Math.pow(log2.calcValue(x, p) + log5.calcValue(x, p), 16);
        } else {
            return (((Math.pow(ctg.calcValue(x, p), 2) - (ctg.calcValue(x, p) * ctg.calcValue(x, p))) + ctg.calcValue(x, p)) - (sec.calcValue(x, p) + sin.calcValue(x, p)))
                    / csc.calcValue(x, p);
        }
    }

    @Override
    public String getName() {
        return "func(x)";
    }
}
