package january.week5;

public class Day3_NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // first check location where nums is not descending
        while (i >=0 && nums[i] >= nums[i+1]) {
            i--;
        }
        // look for location where nums[i] < nums[j]
        // j starting from right
        int j = nums.length - 1;
        if (i >= 0) {
            while (j >=0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        swapArray(nums, i + 1, nums.length - 1);
    }
    private void swapArray(int nums[], int i, int j) {
        while (i < j) {
            int tmp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = tmp;
        }
    }
    private void swap(int nums[], int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
