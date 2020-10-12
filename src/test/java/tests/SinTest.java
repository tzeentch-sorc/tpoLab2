package tests;

import org.junit.Before;
import org.junit.Test;
import stubs.Driver;
import stubs.SinStub;
import trigonometry.Csc;
import trigonometry.Sin;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SinTest {
    private double p;
    private Sin sin;

    @Before
    public void prepare() {
        p = 0.00001d;
        sin = new Sin();
    }

    @Test
    public void test() {
        List<Double> values = new Driver().supply("sinSource.csv");
        values.forEach(x ->
                assertEquals(Math.sin(x), sin.calcValue(x, p), p));
    }
}
