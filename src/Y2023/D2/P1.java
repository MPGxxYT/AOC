package Y2023.D2;

import java.io.*;

public class P1 {

    //Game 1: 1 blue; 4 green, 5 blue; 11 red, 3 blue, 11 green; 1 red, 10 green, 4 blue; 17 red, 12 green, 7 blue; 3 blue, 19 green, 15 red

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/Y2023/D2/data.txt"));
            String line = reader.readLine();
            int total = 0;
            while (line != null){
                int red = 0;
                int green = 0;
                int blue = 0;
                System.out.println(line);
                for (int i = 0; i < 25; i++) {
                    if (line.contains(i + " red")){
                        red = i;
                    }
                    if (line.contains(i + " green")){
                        green = i;
                    }
                    if (line.contains(i + " blue")){
                        blue = i;
                    }
                }
                int power = red * blue * green;
                total = total + power;
                line = reader.readLine();
            }
            System.out.println(total);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
