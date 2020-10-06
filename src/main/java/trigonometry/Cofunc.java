package trigonometry;

import utils.Calculator;

public class Cofunc implements Calculator {
    private Calculator cos;//if is null then func == cosec
    private Calculator sin;//if is null then func == sec
    private FuncType calculatedFunc;
    public Cofunc(Calculator cos, Calculator sin, FuncType f) {
        this.cos = cos;
        this.sin = sin;
        calculatedFunc = f;
    }

    public void setCalculatedFunc(FuncType f) {
        calculatedFunc = f;
    }

    @Override
    public double calcValue(double x, double p) throws IllegalArgumentException {
        switch (calculatedFunc) {
            case TAN:
                return sin.calcValue(x, p) / cos.calcValue(x, p);
            case CTG:
                return cos.calcValue(x, p) / sin.calcValue(x, p);
            case SEC:
                return 1 / cos.calcValue(x, p);
            case CSC:
                return 1 / sin.calcValue(x, p);
        }
        return -1;
    }

    @Override
    public String getName() {
        return calculatedFunc.getName();
    }

    public enum FuncType {
        CTG("ctg(x)"),
        SEC("sec(x)"),
        CSC("csc(x)"),
        TAN("tan(x)");


        String name;

        FuncType(String name) {
            this.name = name;
        }

        String getName() {
            return name;
        }
    }
}
