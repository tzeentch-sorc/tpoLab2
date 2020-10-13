package integration;

import func.Func;
import logarithmic.Ln;
import logarithmic.Log2;
import logarithmic.Log5;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import stubs.CosStub;
import stubs.Driver;
import stubs.LnStub;
import stubs.SinStub;
import trigonometry.*;

import java.util.List;

@RunWith(Parameterized.class)
public class FuncTest {
    private final double p;
    private final Ln ln;
    private final Log2 log2;
    private final Log5 log5;
    private final Sin sin;
    private final Cos cos;
    private final Sec sec;
    private final Csc csc;
    private final Ctg ctg;
    private final Func func;
    private final double x;

    public FuncTest(double x) {
        p = 0.0001d;
        ln = new Ln();
        sin = new Sin();
        cos = new Cos(sin);
        log2 = new Log2(ln);
        log5 = new Log5(ln);
        sec = new Sec(cos);
        csc = new Csc(sin);
        ctg = new Ctg(sin, cos);
        func = new Func(log2, log5, sin, ctg, sec, csc);
        this.x = x;
    }

    @Parameterized.Parameters
    public static List<Double> data() {
        return new Driver().supply("funcSource.csv");
    }

    @Test
    public void test() {
        if (x > 0) {
            Assert.assertEquals(
                    Math.pow(Math.log(x) / Math.log(2) + Math.log(x) / Math.log(5), 16),
                    func.calcValue(x, p), Math.pow(p, -1));
        } else {
            Assert.assertEquals(
                    ((Math.pow((1 / Math.tan(x)), 2) - ((1 / Math.tan(x)) * (1 / Math.tan(x))) + (1 / Math.tan(x)))
                            - ((1 / Math.cos(x)) + Math.sin(x)))
                            / (1 / Math.sin(x)),
                    func.calcValue(x, p), p);
        }
    }
}
