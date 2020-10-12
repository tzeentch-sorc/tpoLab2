package stubs;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.stream.Collectors;

public class Driver {

    public List<Double> supply(String filename) {
        String resource = getClass().getClassLoader().getResource(filename).getFile();
        try {
            CSVParser parser = CSVParser.parse(new File(resource), Charset.forName("UTF-8"), CSVFormat.RFC4180.withFirstRecordAsHeader().withSkipHeaderRecord());
            List<CSVRecord> records = parser.getRecords();
            return records.stream().map(e -> Double.parseDouble(e.get(0))).collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }
}