package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {

    public static void writeCSV(double startX, double step, int col, double p, Calculator calculator) throws IOException {
        String filename = String.format("%sModuleOutput.csv", calculator.getName());
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename, false));
        bufferedWriter.write(String.format("x,      %s\n", calculator.getName()));
        double val;
        for (int i = 0; i < col; i++) {
            val = startX + i * step;
            bufferedWriter.write(String.format("%s,     %s\n", val, calculator.calcValue(val, p)));
        }
        bufferedWriter.close();
    }
}
