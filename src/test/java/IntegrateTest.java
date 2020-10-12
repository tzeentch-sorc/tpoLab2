import logarithmic.Ln;
import logarithmic.Log2;
import logarithmic.Log5;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import trigonometry.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public class IntegrateTest {
    private double p = 0.00001d;
    private Ln ln;
    private Log2 log2;
    private Log5 log5;
    private Sin sin;
    private Cos cos;
    private Sec sec;
    private Csc csc;
    private Ctg ctg;
    private Func func;

    @BeforeClass
    public void init() {
        ln = new Ln();
        log2 = new Log2(ln);
        log5 = new Log5(ln);
        sin = new Sin();
        cos = new Cos(sin);
        sec = new Sec(cos);
        csc = new Csc(sin);
        ctg = new Ctg(sin, cos);
        func = new Func(log2, log5, sin, cos, ctg, sec, csc);
    }

    @Test
    public void log2Test() {
        String filename = String.format("%sModuleOutput.csv", log2.getName());
        try {
            utils.Writer.writeCSV(0.1, 10, 1000, p, log2);
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

    @Test
    public void log5Test() {
        String filename = String.format("%sModuleOutput.csv", log5.getName());
        try {
            utils.Writer.writeCSV(0.1, 10, 1000, p, log5);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }


        try {
            CSVParser parser = CSVParser.parse(new File(filename), Charset.forName("UTF-8"), CSVFormat.RFC4180.withFirstRecordAsHeader().withSkipHeaderRecord());
            List<CSVRecord> records = parser.getRecords();

            for (CSVRecord record : records) {
                Assert.assertEquals(
                        Math.log(Double.parseDouble(record.get(0))) / Math.log(5),
                        Double.parseDouble(record.get(1)), p);
            }
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void cosTest() {
        String filename = String.format("%sModuleOutput.csv", cos.getName());
        try {
            utils.Writer.writeCSV(0.1, 10, 1000, p, cos);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }


        try {
            CSVParser parser = CSVParser.parse(new File(filename), Charset.forName("UTF-8"), CSVFormat.RFC4180.withFirstRecordAsHeader().withSkipHeaderRecord());
            List<CSVRecord> records = parser.getRecords();

            for (CSVRecord record : records) {
                Assert.assertEquals(
                        Math.cos(Double.parseDouble(record.get(0))),
                        Double.parseDouble(record.get(1)), p);
            }
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void cscTest() {
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

    @Test
    public void secTest() {
        String filename = String.format("%sModuleOutput.csv", sec.getName());
        try {
            utils.Writer.writeCSV(0.1, 10, 1000, p, sec);
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

    @Test
    public void ctgTest() {
        String filename = String.format("%sModuleOutput.csv", ctg.getName());
        try {
            utils.Writer.writeCSV(0.1, 10, 1000, p, ctg);
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

    @Test
    public void funcTest() {
        String filename = String.format("%sModuleOutput.csv", func.getName());
        try {
            utils.Writer.writeCSV(0.1, 10, 1000, p, func);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }


        try {
            CSVParser parser = CSVParser.parse(new File(filename), Charset.forName("UTF-8"), CSVFormat.RFC4180.withFirstRecordAsHeader().withSkipHeaderRecord());
            List<CSVRecord> records = parser.getRecords();

            for (CSVRecord record : records) {
                double x = Double.parseDouble(record.get(0));
                if (x <= 0) {
                    Assert.assertEquals(
                            Math.pow(Math.log(x) / Math.log(2) + Math.log(x) / Math.log(5), 16),
                            Double.parseDouble(record.get(1)), p);
                } else {
                    Assert.assertEquals(
                            ((Math.pow((1 / Math.tan(x)), 2) - ((1 / Math.tan(x)) * (1 / Math.tan(x))) + (1 / Math.tan(x)))
                                    - ((1 / Math.cos(x)) + Math.sin(x)))
                                    / (1 / Math.sin(x)),
                            Double.parseDouble(record.get(1)), p);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
