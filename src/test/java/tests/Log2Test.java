package tests;

import logarithmic.Log2;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.junit.Assert;
import org.junit.Test;
import stubs.LnStub;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public class Log2Test {
    private double p = 0.00001d;

    @Test
    public void test() {
        Log2 log2 = new Log2(new LnStub());
        String filename = String.format("%sModuleOutput.csv", log2.getName());
        try {
            utils.Writer.writeCSV(0.01, 0.01, 1000, p, log2);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }


        try {
            CSVParser parser = CSVParser.parse(new File(filename), Charset.forName("UTF-8"), CSVFormat.RFC4180.withFirstRecordAsHeader().withSkipHeaderRecord());
            List<CSVRecord> records = parser.getRecords();

            for (CSVRecord record : records) {
                Assert.assertEquals(
                        Math.log(Double.parseDouble(record.get(0))) / Math.log(2),
                        Double.parseDouble(record.get(1)), p);
            }
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
