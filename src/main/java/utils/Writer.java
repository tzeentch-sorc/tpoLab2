package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {

    public static void writeCSV(double startX, double step, int col, double p, Calculator calculator) throws IOException {
        String filename = "moduleOut.csv";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename, false));
        bufferedWriter.write(String.format("x, %s\n", calculator.getName()));
        double val;
        for (int i = 0; i < col; i++) {
            val = startX + i * step;
            bufferedWriter.write(val + ", " + calculator.calcValue(val, p) + "\n");
        }
        bufferedWriter.close();
    }
}
