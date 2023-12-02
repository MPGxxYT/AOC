package Templates;

import java.io.*;

public class Class {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/Y2022/D1/data.txt"))) {
            String line = reader.readLine();

            while (line != null){

                line = reader.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
