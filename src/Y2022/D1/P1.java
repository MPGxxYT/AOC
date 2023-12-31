package Y2022.D1;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;

public class P1 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/Y2022/D1/data.txt"))) {
            String line = reader.readLine();
            LinkedList<Integer> list = new LinkedList<>();
            int elfTotal = 0;
            while (line != null){
                System.out.println(line);
                if (line.isEmpty()){
                    list.add(elfTotal);
                    elfTotal = 0;
                } else {
                    elfTotal = elfTotal + Integer.parseInt(line);
                }
                line = reader.readLine();
            }
            Collections.sort(list);
            System.out.println("TOTAL " + list.get(list.size() - 1));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}