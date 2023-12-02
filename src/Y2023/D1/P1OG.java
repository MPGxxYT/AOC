package Y2023.D1;

import java.io.*;
import java.util.*;

public class P1OG {

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
            //                    0
            // xtwone3four : 2 1 3 4
            //               1 3 6 7
            // 43eightnvdrthree1eightoneggrdmnp : 4 3 8 3 1 8 1

            // LinkedHashMap<index, number>
            // 57325
            while (line != null){
                HashMap<Integer, String> hashMap = new HashMap<>();

                String og = line;
                // Takes the string, finds the index of each value
                for (Map.Entry<String, String> entry : getMap().entrySet()){
                    String key = entry.getKey();
                    String value = entry.getValue();
                    line = og;
                    System.out.println(" * " + line + " : " + key + " " + value);
                    if (line.contains(key)){
                        int last_index = -1;
                        String sub = line;
                        while (sub.contains(key)) {
                            int index = line.indexOf(key, last_index + 1);
                            if (index == -1){
                                break;
                            }
                            hashMap.put(index, value);
                            last_index = index;
                            sub = line.substring(index);
                            System.out.println(last_index + " KEY:"+key + " " + line);
                        }
                    }
                    line = og;
                    if (line.contains(value)){
                        int last_index = -1;
                        String sub = line;
                        while (sub.contains(value)){
                            int index = line.indexOf(value, last_index + 1);
                            if (index == -1){
                                break;
                            }
                            hashMap.put(index, value);
                            last_index = index;
                            sub = line.substring(index);
                            System.out.println(last_index + " VALUE:"+value +" "+ line);
                        }
                    }
                }

                System.out.println(" " + line);
                System.out.println(hashMap);
                LinkedList<Integer> list = new LinkedList<>(hashMap.keySet().stream().toList());
                Collections.sort(list);
                System.out.println(list);
                String first = hashMap.get(list.get(0));
                String last = hashMap.get(list.get(list.size() - 1));
                System.out.println(first + last);
                System.out.println(total);
                total = total + Integer.parseInt(first + last);
                System.out.println(total);
                System.out.println(" ");
                line = reader.readLine();
            }

            System.out.println("TOTAL: " + total);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    static HashMap<String, String> getMap(){
        HashMap<String, String> map = new HashMap<>();
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");
        return map;
    }

}
