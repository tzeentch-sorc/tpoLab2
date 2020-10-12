package tests;

import org.junit.Test;
import org.junit.runners.Parameterized;
import stubs.CosStub;
import stubs.Driver;
import stubs.SinStub;
import trigonometry.Sec;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SecTest {
    private final double p;
    private final Sec sec;
    private final double x;

    public SecTest(double x) {
        p = 0.00001d;
        sec = new Sec(new CosStub(new SinStub()));
        this.x = x;
    }

    @Parameterized.Parameters
    public static List<Double> data() {
        return new Driver().supply("secSource.csv");
    }

    @Test
    public void test() {
        assertEquals(1 / Math.cos(x), sec.calcValue(x, p), p);
    }
}
