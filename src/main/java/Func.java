import logarithmic.LogN;
import trigonometry.Cofunc;
import trigonometry.Cos;
import trigonometry.Sin;
import utils.Calculator;

public class Func implements Calculator {
    private Calculator log2 = new LogN(2);
    private Calculator log5 = new LogN(5);

    private Calculator sin = new Sin();
    private Calculator cos = new Cos();

    private Cofunc cofunc = new Cofunc(sin, cos, Cofunc.FuncType.CTG);

    @Override
    public double calcValue(double x, double p) throws IllegalArgumentException {
        if (x > 0) {
            return Math.pow(log2.calcValue(x, p) + log5.calcValue(x, p), 16);
        } else {
            double[] cofuncVal = new double[3]; //0 = ctg, 1 = sec, 2 = csc
            for (int i = 0; i < cofuncVal.length; i++) {
                cofunc.setCalculatedFunc(Cofunc.FuncType.values()[i]);
                cofuncVal[i] = cofunc.calcValue(x, p);
            }

            return (Math.pow(cofuncVal[0], 2) - cofuncVal[0] * cofuncVal[0] + cofuncVal[0] - (cofuncVal[1] + sin.calcValue(x, p)))
                    / cofuncVal[2];
        }
    }

    @Override
    public String getName() {
        return "Func(x)";
    }
}
