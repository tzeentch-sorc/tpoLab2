package tests;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.junit.Assert;
import org.junit.Test;
import stubs.SinStub;
import trigonometry.Csc;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public class CscTest {
    private double p = 0.00001d;

    @Test
    public void test() {
        Csc csc = new Csc(new SinStub());
        String filename = String.format("%sModuleOutput.csv", csc.getName());
        try {
            utils.Writer.writeCSV(0.1, 10, 1000, p, csc);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }


        try {
            CSVParser parser = CSVParser.parse(new File(filename), Charset.forName("UTF-8"), CSVFormat.RFC4180.withFirstRecordAsHeader().withSkipHeaderRecord());
            List<CSVRecord> records = parser.getRecords();

            for (CSVRecord record : records) {
                Assert.assertEquals(
                        1 / Math.cos(Double.parseDouble(record.get(0))),
                        Double.parseDouble(record.get(1)), p);
            }
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}