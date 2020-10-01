import java.io.*;

abstract class Calculator {
    private static String filename = "moduleOut.csv";

    private static double calcValue(double x, double p) throws IllegalArgumentException{
        return 0;
    }

    static void writeCSV(double startX, double step, int col, double p) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename, false));
        bufferedWriter.write("x, func(x)\n");
        for (int i = 0; i < col; i++) {
            bufferedWriter.write(startX + ", " + calcValue(startX + i * step, p)+"\n");
        }
        bufferedWriter.close();
    }
}
