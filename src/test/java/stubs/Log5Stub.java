package stubs;

import logarithmic.Ln;
import logarithmic.Log5;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static java.lang.Double.parseDouble;

public class Log5Stub extends Log5 {

    public Log5Stub(Ln ln) {
        super(ln);
    }

    @Override
    public double calcValue(double x, double p) throws IllegalArgumentException {
        String filename = getClass().getClassLoader().getResource("log5Results.csv").getFile();
        try {
            CSVParser parser = CSVParser.parse(new File(filename), StandardCharsets.UTF_8, CSVFormat.RFC4180.withFirstRecordAsHeader().withSkipHeaderRecord());
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
