package Y2022.D2;

import java.io.*;
import java.util.HashMap;
import java.util.Objects;

public class P1 {

    // A beats Z : L
    // B beats X : L
    // C beats Y : L
    //

    // A = ROCK : A = 1
    // B = PAPER : B = 2
    // C = SCISSORS : C = 3

    // X = ROCK : X = 1
    // Y = PAPER : Y = 2
    // Z = SCISSORS : Z = 3

    // ROCK = 1
    // PAPER = 2
    // SCISSORS = 3

    // LOSE = 0
    // DRAW = 3
    // WIN = 6

    // if num == num : draw
    // check

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/Y2022/D2/data.txt"))) {
            String line = reader.readLine();
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
                if (Objects.equals(drawMap.get(op), me)){ // DRAW
                    score = score + 3;
                    System.out.println("DRAW");
                } else if (!Objects.equals(lossMap.get(op), me)){
                    score = score + 6;
                    System.out.println("WIN");
                } else {
                    System.out.println("LOSS");
                }
                if (me.equals("X")){
                    score = score + 1;
                }
                if (me.equals("Y")){
                    score = score + 2;
                }
                if (me.equals("Z")){
                    score = score + 3;
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
