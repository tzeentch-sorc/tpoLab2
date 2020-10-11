package stubs;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import trigonometry.Cos;
import trigonometry.Sin;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import static java.lang.Double.parseDouble;

public class CosStub extends Cos {

    public CosStub(Sin sin) {
        super(sin);
    }

    @Override
    public double calcValue(double x, double p) throws IllegalArgumentException {
        String filename = getClass().getClassLoader().getResource("cosResults.csv").getFile();
        try {
            CSVParser parser = CSVParser.parse(new File(filename), Charset.forName("UTF-8"), CSVFormat.RFC4180.withFirstRecordAsHeader().withSkipHeaderRecord());
            List<CSVRecord> records = parser.getRecords();

            for (CSVRecord record : records) {
                if (parseDouble(record.get(0)) == x) {
                    return parseDouble(record.get(1));
                }
            }
            throw new IllegalArgumentException("desired x not found");
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }
}
