package march.week3;

public class Day4_WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int up = 1;
        int down = 1;
        // 1,17,5,10,13,15,10,5,16,8
        for(int i = 1; i < n; i++) {
            if(nums[i] > nums[i - 1]) {
                up = down + 1; // up = 1 2 4 6
            }
            else if(nums[i] < nums[i - 1]) {
                down = up + 1;// down = 3 5
            }
        }
        return Math.max(up, down);
    }
}
