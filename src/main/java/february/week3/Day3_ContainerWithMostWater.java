package february.week3;

public class Day3_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int res = 0;
        while (i < j) {
            int area = (j - i) * Math.min(height[i], height[j]);
            res = Math.max(res, area);
            if (height[i] > height[j]) {
                j--;
            }
            else {
                i++;
            }
        }
        return res;
    }
}
