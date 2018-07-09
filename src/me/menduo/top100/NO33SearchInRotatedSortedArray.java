package me.menduo.top100;

/**
 * User: menduo email:demon9607@163.com
 * Date: 2018-07-08
 * Time: 17:23
 */
public class NO33SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1 && nums[0] == target) return 0;
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (left < 0 || right > nums.length - 1) return -1;
            if (nums[mid] == target) return mid;
            if (nums[left] == target) return left;
            if (nums[right] == target) return right;
            else if (nums[left] < target && target < nums[mid]) {
                right = mid - 1;
            } else if (nums[mid] < target && target < nums[right]) {
                left = mid + 1;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[left]) {
                right = mid - 1;
            } else {
                return -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        NO33SearchInRotatedSortedArray no33SearchInRotatedSortedArray = new NO33SearchInRotatedSortedArray();
        System.out.println(no33SearchInRotatedSortedArray.search(new int[]{1, 3}, 3));
    }
}
