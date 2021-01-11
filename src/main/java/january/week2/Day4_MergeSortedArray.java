package january.week2;

import java.util.Arrays;

public class Day4_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                i++;
                continue;
            }
            else {
                int tmp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = tmp;
                int k = j+1;
                tmp = nums2[j];
                while (k < n && nums2[k] < tmp) {
                    nums2[k-1] = nums2[k];
                    k++;
                }
                if (k == n) {
                    nums2[n-1] = tmp;
                }
                else {
                    nums2[k-1] = tmp;
                }
            }
        }
        while (i < m + n && j < n) {
            nums1[i] = nums2[j];
            i++;
            j++;
        }
        System.out.println(Arrays.toString(nums2));
        System.out.println(Arrays.toString(nums1));
    }

    public void mergeEfficient(int[] nums1, int m, int[] nums2, int n) {
        int p = m - 1, q = n - 1, i = m + n -1;
        while (q >= 0) {
            if (p < 0 || nums2[q] >= nums1[p]) {
                nums1[i--] = nums2[q--];
            }
            else {
                nums1[i--] = nums1[p--];
            }
        }
    }

        public static void main(String[] args) {
        Day4_MergeSortedArray obj = new Day4_MergeSortedArray();
//        obj.merge(new int[]{1,2,4,5,6,0}, 5, new int[]{3}, 1);
            obj.mergeEfficient(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
    }
}
