import logarithmic.Ln;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.junit.Assert;
import org.junit.Test;
import trigonometry.Sin;
import utils.Writer;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public class LnTest {

    private double p = 0.00001d;

    @Test
    public void calcDefinedLn() {

        try {
            utils.Writer.writeCSV(0.1, 10, 1000, p, new Ln());
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }


        try {
            CSVParser parser = CSVParser.parse(new File("moduleOut.csv"), Charset.forName("UTF-8"), CSVFormat.RFC4180.withFirstRecordAsHeader().withSkipHeaderRecord());
            List<CSVRecord> records = parser.getRecords();

            for (CSVRecord record : records) {
                Assert.assertEquals(Double.parseDouble(record.get(1)), Math.log(Double.parseDouble(record.get(0))), p);
            }
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void calcDefinedSin() {

        try {
            Writer.writeCSV(-20, 0.1, 400, p, new Sin());
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }


        try {
            CSVParser parser = CSVParser.parse(new File("moduleOut.csv"), Charset.forName("UTF-8"), CSVFormat.RFC4180.withFirstRecordAsHeader().withSkipHeaderRecord());
            List<CSVRecord> records = parser.getRecords();

            for (CSVRecord record : records) {
                Assert.assertEquals(Double.parseDouble(record.get(1)), Math.sin(Double.parseDouble(record.get(0))), p);
            }
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
