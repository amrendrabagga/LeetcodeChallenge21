package january.week4;

public class Day4_CheckIfAllOnesAreAtleastLengthKPlacesAway {
    public boolean kLengthApart(int[] nums, int k) {
        int prev = -1;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 1 && prev == -1) {
                prev = i;
            }
            else if (nums[i] == 1 && i - prev <= k) {
                return false;
            }
            else if(nums[i] == 1) {
                prev = i;
            }
        }
        return true;
    }
}
