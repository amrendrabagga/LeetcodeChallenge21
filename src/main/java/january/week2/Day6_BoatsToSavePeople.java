package january.week2;

import java.util.Arrays;

public class Day6_BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        if (limit == 0) {
            return 0;
        }
        Arrays.sort(people);
        int res = 0;
        int i = 0;
        int j = people.length - 1;
        // we try to fit lightest with heaviest person(as max 2 person can fit in boat)
        // if not then seperate boat for heavy person
        while (i <= j) {
            res++;
            if (people[i] + people[j] <= limit) {
                i++;
            }
            j--;
        }
        return res;
    }
}
