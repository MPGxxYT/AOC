package Y2023.D1;

import java.io.*;
import java.util.*;

public class P1 {

    // Take first and last digit in string
    // Put them together, don't add them.
    // Then get the sum of all the data.
    // ex.
    // 1abc2 : 12
    // pqr3stu8vwx : 38
    // a1b2c3d4e5f : 15
    // treb7uchet : 77
    // ++ 142

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/cali.txt"));
            String line = reader.readLine();
            int total = 0;


            // eightwothree : 8 2 3 : 83
            //                0 4 7
            // 4nineeightseven2 : 4 9 8 7 2 : 42
            //                    0 1 5 10 15
            // xtwone3four : 2 1 3 4
            //               1 3 6 7

            // LinkedHashMap<index, number>
            //
            while (line != null){
                System.out.println(line);
                for (Map.Entry<String, String> entry : getMap().entrySet()){
                    line = line.replace(entry.getKey(), entry.getValue());
                }
                System.out.println(line);
                line = line.replaceAll("[A-z]","");
                System.out.println(line);
                char first = line.charAt(0);
                char last = line.charAt(line.length() - 1);
                System.out.println(first + "" + last);
                total = total + Integer.parseInt(first + "" + last);
                line = reader.readLine();
            }

            System.out.println("TOTAL: " + total);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    static HashMap<String, String> getMap(){
        HashMap<String, String> map = new HashMap<>();
        map.put("one", "o1e");
        map.put("two", "t2o");
        map.put("three", "t3e");
        map.put("four", "f4r");
        map.put("five", "f5e");
        map.put("six", "s6x");
        map.put("seven", "s7n");
        map.put("eight", "e8t");
        map.put("nine", "n9e");
        return map;
    }
//    static HashMap<String, String> getMap(){
//        HashMap<String, String> map = new HashMap<>();
//        map.put("one", "1");
//        map.put("two", "2");
//        map.put("three", "3");
//        map.put("four", "4");
//        map.put("five", "5");
//        map.put("six", "6");
//        map.put("seven", "7");
//        map.put("eight", "8");
//        map.put("nine", "9");
//        return map;
//    }
}