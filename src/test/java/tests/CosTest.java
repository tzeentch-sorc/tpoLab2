package tests;

import org.junit.Test;
import stubs.Driver;
import stubs.SinStub;
import trigonometry.Cos;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CosTest {
    private double p = 0.00001d;

    @Test
    public void test() {
        Cos cos = new Cos(new SinStub());
        List<Double> values = new Driver().supply("cosSource.csv");
        values.forEach(x ->
                assertEquals(Math.cos(x), cos.calcValue(x, p), p));
    }
}
