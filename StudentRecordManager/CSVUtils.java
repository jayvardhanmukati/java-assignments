import java.io.*;
import java.util.*;

public class CSVUtils {

    public static List<String> readFile(String fileName) throws IOException {
        List<String> lines = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;

        while ((line = br.readLine()) != null) {
            lines.add(line);
        }
        br.close();
        return lines;
    }

    public static void writeFile(String fileName, List<String> lines) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        for (String line : lines) {
            bw.write(line);
            bw.newLine();
        }
        bw.close();
    }

    public static void appendLine(String fileName, String line) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
        bw.write(line);
        bw.newLine();
        bw.close();
    }
}
