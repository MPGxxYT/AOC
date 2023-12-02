package Y2022.D2;

import java.io.*;
import java.util.HashMap;

public class P2 {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/Y2022/D2/data.txt"))) {
            String line = reader.readLine();
            HashMap<String, String> winMap = new HashMap<>();
            winMap.put("A", "Y");
            winMap.put("B", "Z");
            winMap.put("C", "X");
            HashMap<String, String> lossMap = new HashMap<>();
            lossMap.put("A", "Z");
            lossMap.put("B", "X");
            lossMap.put("C", "Y");
            HashMap<String, String> drawMap = new HashMap<>();
            drawMap.put("A", "X");
            drawMap.put("B", "Y");
            drawMap.put("C", "Z");
            int total = 0;
            while (line != null){
                String[] game = line.split(" ");
                String op = game[0];
                String me = game[1];
                System.out.println(" ");
                System.out.println(op + " " + me);
                int score = 0;
                switch (me) {
                    case "X" -> // LOSE
                            me = lossMap.get(op);
                    case "Y" -> {  // DRAW
                        me = drawMap.get(op);
                        score = score + 3;
                    }
                    case "Z" -> {  // WIN
                        me = winMap.get(op);
                        score = score + 6;
                    }
                }
                switch (me) {
                    case "X" -> score = score + 1;
                    case "Y" -> score = score + 2;
                    case "Z" -> score = score + 3;
                }
                line = reader.readLine();
                total = total + score;
            }
            System.out.println(total);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
