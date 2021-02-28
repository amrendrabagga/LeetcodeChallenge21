package february.week4;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Day7_MaximumFrequencyStack {
    Map<Integer, Integer> frequencyMap;
    Map<Integer, Stack<Integer>> sameFrequencyMap;
    int maxFrequency = 0;
    public Day7_MaximumFrequencyStack() {
        frequencyMap = new HashMap();
        sameFrequencyMap = new HashMap();
    }

    public void push(int x) {
        Integer freq = frequencyMap.getOrDefault(x, 0) + 1;
        frequencyMap.put(x, freq);
        if (frequencyMap.get(x) > maxFrequency) {
            maxFrequency = frequencyMap.get(x);
        }
        sameFrequencyMap.putIfAbsent(freq, new Stack<>());
        sameFrequencyMap.get(freq).push(x);
    }

    public int pop() {
        int top = sameFrequencyMap.get(maxFrequency).pop();
        frequencyMap.compute(top, (k,v) -> v == 1 ? null : v - 1);

        if (sameFrequencyMap.get(maxFrequency).size() == 0) {
            maxFrequency--;
        }

        return top;
    }

    public static void main(String[] args) {
        Day7_MaximumFrequencyStack obj = new Day7_MaximumFrequencyStack();
        obj.push(5);
        obj.push(7);
        obj.push(5);
        obj.push(7);
        obj.push(4);
        obj.push(5);

        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
    }
}
