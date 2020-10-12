package tests;

import org.junit.Before;
import org.junit.Test;
import stubs.CosStub;
import stubs.Driver;
import stubs.SinStub;
import trigonometry.Csc;
import trigonometry.Sec;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SecTest {
    private double p;
    private Sec sec;

    @Before
    public void prepare() {
        p = 0.00001d;
        sec = new Sec(new CosStub(new SinStub()));
    }

    @Test
    public void test() {
        List<Double> values = new Driver().supply("secSource.csv");
        values.forEach(x ->
                assertEquals(1/Math.cos(x), sec.calcValue(x, p), p));
    }
}
