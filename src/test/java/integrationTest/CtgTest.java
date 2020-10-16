package integrationTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import stubs.CosStub;
import stubs.Driver;
import stubs.SinStub;
import trigonometry.Cos;
import trigonometry.Ctg;
import trigonometry.Sin;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CtgTest {
    private final double p;
    private final Ctg ctg;
    private final double x;

    public CtgTest(double x) {
        p = 0.000001d;
        ctg = new Ctg(new Sin(), new Cos(new Sin()));
        this.x = x;
    }

    @Parameterized.Parameters
    public static List<Double> data() {
        return new Driver().supply("ctgSource.csv");
    }

    @Test
    public void test() {
        assertEquals(1 / Math.tan(x), ctg.calcValue(x, p), p);
    }
}
