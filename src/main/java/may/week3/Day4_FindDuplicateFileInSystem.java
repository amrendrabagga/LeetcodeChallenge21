package may.week3;

import java.util.*;
import java.util.stream.Collectors;

public class Day4_FindDuplicateFileInSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap();
        for (String path : paths) {
            String files[] = path.split("\\s");
            for (int i=1; i<files.length; i++) {
                // int m = files[i].indexOf("(");
                // String fileName = files[i].substring(0, m);
                // String content = files[i].substring(m + 1, files[i].length() - 1);
                String names[] = files[i].split("\\(");
                String content = names[1];
                List<String> fileNames = map.getOrDefault(content, new ArrayList());
                fileNames.add(files[0] + "/" + names[0]);
                map.put(content, fileNames);
            }
        }
        return map.values().stream().filter(l -> l.size() > 1).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Day4_FindDuplicateFileInSystem obj = new Day4_FindDuplicateFileInSystem();
        obj.findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)"});
    }
}
