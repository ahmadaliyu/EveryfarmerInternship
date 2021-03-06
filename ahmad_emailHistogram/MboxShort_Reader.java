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

        Map<String, Integer> mapContent = new HashMap<>();
        String line;
        List<String> list = new ArrayList<>();

        while ((line = bfr.readLine()) != null){
            line = line.trim().toLowerCase();

            if (line.contains("by") && !(line.contains("this")) && !(line.contains("component"))) {
                line = line.replaceAll("by\\s", "");
               String[] arr =  line.split("\\s+");
                if (mapContent.containsKey(arr[0])){
                    mapContent.put(arr[0], mapContent.get(arr[0]) + 1);
                }else{
                mapContent.put(arr[0], 1);
            }

            }
        }

        // iterating the map
        Set<Map.Entry<String,Integer>> entries = mapContent.entrySet();
        for (Map.Entry entr: entries){
            System.out.println(entr.getKey() + " " + entr.getValue());
        }
        fr.close();
    }
}
