package unitTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import stubs.Driver;
import stubs.SinStub;
import trigonometry.Cos;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CosTest {
    private final double p;
    private final Cos cos;
    private final double x;

    public CosTest(double x) {
        p = 0.0000001d;
        cos = new Cos(new SinStub());
        this.x = x;
    }

    @Parameterized.Parameters
    public static List<Double> data() {
        return new Driver().supply("cosSource.csv");
    }

    @Test
    public void test() {
        assertEquals(Math.cos(x), cos.calcValue(x, p), p*10);
    }
}
