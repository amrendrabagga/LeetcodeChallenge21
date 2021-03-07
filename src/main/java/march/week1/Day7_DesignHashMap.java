package march.week1;

public class Day7_DesignHashMap {
    int[] map;
    /** Initialize your data structure here. */
    public Day7_DesignHashMap() {
        map = new int[1000000];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        map[key] = value + 1;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return map[key] - 1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        map[key] = 0;
    }
}
