package unitTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import stubs.CosStub;
import stubs.Driver;
import stubs.SinStub;
import trigonometry.Ctg;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CtgTest {
    private final double p;
    private final Ctg ctg;
    private final double x;

    public CtgTest(double x) {
        p = 0.0000001d;
        ctg = new Ctg(new SinStub(), new CosStub(null));
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
