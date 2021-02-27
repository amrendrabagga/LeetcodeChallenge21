package february.week4;

public class Day5_ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int pushId = -1, popId = 0;

        for (int i=0; i<pushed.length; i++) {
            pushed[++pushId] = pushed[i];
            while (pushId >= 0 && pushed[pushId] == popped[popId]) {
                pushId--;
                popId++;
            }
        }
        return pushId == -1;
    }

    public static void main(String[] args) {
        Day5_ValidateStackSequences obj = new Day5_ValidateStackSequences();
        System.out.println(obj.validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,3,5,1,2}));
    }
}
