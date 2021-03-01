package march.week1;

import java.util.HashSet;
import java.util.Set;

public class Day1_DistributeCandies {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        int max = candyType.length / 2;
        for (int candy : candyType) {
            set.add(candy);
        }
        return set.size() >= max ? max : set.size();
    }
}
