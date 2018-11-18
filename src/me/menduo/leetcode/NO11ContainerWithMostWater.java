package me.menduo.leetcode;

/**
 * User: menduo email:demon9607@163.com
 * Date: 2018-07-01
 * Time: 12:42
 */
public class NO11ContainerWithMostWater {
    /**
     * 暴力法 TLE
     *
     * @param height 容器纵坐标
     * @return 大小
     */
    public int maxArea(int[] height) {
        int maxarea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return maxarea;
    }

    public int maxArea2(int[] height) {
        int maxarea = 0;

        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[r], height[l]) * (r - l));
            if (height[r] > height[l]) l--;
            else r--;
        }
        return maxarea;
    }

    public static void main(String[] args) {

    }
}
