package april.week4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day1_LeastBricks {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap();
        int maxEdges = 0;
        for (List<Integer> w : wall) {
            int l = 0;
            for (int i=0; i<w.size()-1; i++) {
                l += w.get(i);
                map.put(l, map.getOrDefault(l, 0) + 1);
                maxEdges = Math.max(maxEdges, map.get(l));
            }
        }
        return wall.size() - maxEdges;
    }
}
