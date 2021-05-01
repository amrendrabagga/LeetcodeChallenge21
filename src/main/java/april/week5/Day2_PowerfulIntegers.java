package april.week5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day2_PowerfulIntegers {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> xl = new ArrayList();
        List<Integer> yl = new ArrayList();
        xl.add(1);
        yl.add(1);
        if (x != 1) {
            int px = x;
            while (px <= bound) {
                xl.add(px);
                px *= x;
            }
        }
        if (y != 1) {
            int py = y;
            while (py <= bound) {
                yl.add(py);
                py *= y;
            }
        }
        Set<Integer> set = new HashSet();
        for (int i : xl) {
            for (int j : yl) {
                if (i + j <= bound) {
                    set.add(i + j);
                }
            }
        }
        return new ArrayList<>(set);
    }
}
