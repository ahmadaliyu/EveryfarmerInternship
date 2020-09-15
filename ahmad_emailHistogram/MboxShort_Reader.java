package reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MboxShort_Reader {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Ahmadee\\IdeaProjects\\Amad_StudentRecord\\mbox-short.txt");
        FileReader fr = new FileReader(file);
        BufferedReader bfr = new BufferedReader(fr);
        StringBuffer sb = new StringBuffer();

        Map<String, Integer> mapContent = new HashMap<>();
        String line;
        List<String> list = new ArrayList<>();

        while ((line = bfr.readLine()) != null){
//            bfr.skip(3);
            if (line.contains("by") || line.contains("by".toUpperCase())) {
                list.add(line);
//                sb.append(line);
            }
            sb.append("\n");
        }

        System.out.println(mapContent.get(line));

        // putting them in a list and then putting them in a map to count repeated keys
        for (String ls: list){
            if(mapContent.containsKey(ls)){
                mapContent.put(ls, mapContent.get(ls) + 1);
            }else{
                mapContent.put(ls, 1);
            }
//            System.out.println(ls);
        }
        // iterating the map
        Set<Map.Entry<String,Integer>> entries = mapContent.entrySet();
        for (Map.Entry entr: entries){
            System.out.println(entr.getKey() + " " + entr.getValue());
        }
        fr.close();
        System.out.println(sb.toString());

    }
}
