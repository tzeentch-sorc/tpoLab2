package tests;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.junit.Assert;
import org.junit.Test;
import trigonometry.Sin;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public class SinTest {
    private double p = 0.00001d;

    @Test
    public void test() {
        Sin sin = new Sin();
        String filename = String.format("%sModuleOutput.csv", sin.getName());
        try {
            utils.Writer.writeCSV(0.1, 10, 1000, p, sin);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }


        try {
            CSVParser parser = CSVParser.parse(new File(filename), Charset.forName("UTF-8"), CSVFormat.RFC4180.withFirstRecordAsHeader().withSkipHeaderRecord());
            List<CSVRecord> records = parser.getRecords();

            for (CSVRecord record : records) {
                Assert.assertEquals(
                        Math.sin(Double.parseDouble(record.get(0))),
                        Double.parseDouble(record.get(1)), p);
            }
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
