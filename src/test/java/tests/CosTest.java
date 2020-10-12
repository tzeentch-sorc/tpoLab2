package tests;

import org.junit.Before;
import org.junit.Test;
import stubs.Driver;
import stubs.SinStub;
import trigonometry.Cos;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CosTest {
    private double p;
    private Cos cos;

    @Before
    public void prepare() {
        p = 0.00001d;
        cos = new Cos(new SinStub());
    }

    @Test
    public void test() {
        List<Double> values = new Driver().supply("cosSource.csv");
        values.forEach(x ->
                assertEquals(Math.cos(x), cos.calcValue(x, p), p));
    }
}
