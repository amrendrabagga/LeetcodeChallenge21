package january.week1;

public class Day6_KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        int low = 0;
        int high = arr.length;
        // when value of mid(arr[mid]) and integers till mid(mid+1) ie arr[mid] - (mid+1)< k
        // means missing integers lie from[mid+1, n]
        // else lie from [1,mid]
        // [1,5,7] k=2
        // means no lies between [1,5]

        while (low < high) {
            int mid = low + (high - low)/2;
            if (arr[mid] - (mid + 1) < k) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        return low + k;
    }

    public static void main(String[] args) {
        Day6_KthMissingPositiveNumber obj = new Day6_KthMissingPositiveNumber();
        System.out.println(obj.findKthPositive(new int[]{3,7},4));
    }
}
