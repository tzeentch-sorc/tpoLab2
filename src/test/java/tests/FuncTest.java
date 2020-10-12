package tests;

import func.Func;
import logarithmic.Ln;
import logarithmic.Log2;
import logarithmic.Log5;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import stubs.CosStub;
import stubs.Driver;
import stubs.LnStub;
import stubs.SinStub;
import trigonometry.*;

import java.util.List;

public class FuncTest {
    private static double p;
    private static Ln lnStub;
    private static Log2 log2;
    private static Log5 log5;
    private static Sin sin;
    private static Sin sinStub;
    private static Cos cosStub;
    private static Sec sec;
    private static Csc csc;
    private static Ctg ctg;
    private static Func func;

    @BeforeClass
    public static void prepare() {
        p = 0.00001d;
        lnStub = new LnStub();
        sinStub = new SinStub();
        cosStub = new CosStub(null);
        log2 = new Log2(lnStub);
        log5 = new Log5(lnStub);
        sin = new Sin();
        sec = new Sec(cosStub);
        csc = new Csc(sinStub);
        ctg = new Ctg(sinStub, cosStub);
        func = new Func(log2, log5, sin, ctg, sec, csc);
    }


    @Test
    public void test() {
        List<Double> values = new Driver().supply("funcSource.csv");
        values.forEach(x -> {
            if (x > 0) {
                Assert.assertEquals(
                        Math.pow(Math.log(x) / Math.log(2) + Math.log(x) / Math.log(5), 16),
                        func.calcValue(x, p), p);
            } else {
                Assert.assertEquals(
                        ((Math.pow((1 / Math.tan(x)), 2) - ((1 / Math.tan(x)) * (1 / Math.tan(x))) + (1 / Math.tan(x)))
                                - ((1 / Math.cos(x)) + Math.sin(x)))
                                / (1 / Math.sin(x)),
                        func.calcValue(x, p), p);
            }
        });
    }
}
