package Y2022.D1;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;

public class P2 {
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
            int total = list.get(list.size() - 1) + list.get(list.size() - 2) + list.get(list.size() - 3);
            System.out.println("TOTAL " + total);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}