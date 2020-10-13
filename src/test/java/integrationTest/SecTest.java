package integrationTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import stubs.CosStub;
import stubs.Driver;
import trigonometry.Sec;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SecTest {
    private final double p;
    private final Sec sec;
    private final double x;

    public SecTest(double x) {
        p = 0.000001d;
        sec = new Sec(new CosStub(null));
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
