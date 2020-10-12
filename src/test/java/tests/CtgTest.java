package tests;

import org.junit.Before;
import org.junit.Test;
import stubs.CosStub;
import stubs.Driver;
import stubs.SinStub;
import trigonometry.Ctg;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CtgTest {
    private double p;
    private Ctg ctg;

    @Before
    public void prepare() {
        p = 0.00001d;
        ctg = new Ctg(new SinStub(), new CosStub(null));
    }

    @Test
    public void test() {
        List<Double> values = new Driver().supply("ctgSource.csv");
        values.forEach(x ->
                assertEquals(1/Math.tan(x), ctg.calcValue(x, p), p));
    }
}
