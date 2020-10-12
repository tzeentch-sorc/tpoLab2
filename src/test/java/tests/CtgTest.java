package tests;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.junit.Assert;
import org.junit.Test;
import stubs.CosStub;
import stubs.SinStub;
import trigonometry.Ctg;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public class CtgTest {
    private double p = 0.00001d;

    @Test
    public void test() {
        Ctg ctg = new Ctg(new SinStub(), new CosStub(new SinStub()));
        String filename = String.format("%sModuleOutput.csv", ctg.getName());
        try {
            utils.Writer.writeCSV(-3.24, 0.01, 628, p, ctg);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }


        try {
            CSVParser parser = CSVParser.parse(new File(filename), Charset.forName("UTF-8"), CSVFormat.RFC4180.withFirstRecordAsHeader().withSkipHeaderRecord());
            List<CSVRecord> records = parser.getRecords();

            for (CSVRecord record : records) {
                Assert.assertEquals(1 / Math.tan(Double.parseDouble(record.get(0))),
                        Double.parseDouble(record.get(1)), p);
            }
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
