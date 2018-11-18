package me.menduo.leetcode;

public class Top4MedianofTwoSortedArrays {


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m>n){
            // propose j = (m+n+1)/2 -i  must greater than 0;
            int[] tmp =nums1; nums1 = nums2; nums2 = tmp;
            m = m^n; n = n^m; m = m^n;
        }
        int imin = 0, imax = m, halfLen = (m+n+1)/2;
        while(imin <= imax){
            int i = (imin + imax)/2;
            int j = halfLen - i;
            if(i > imin && nums1[i-1] > nums2[j]){
                imax = i - 1;
            }else if(i < imax && nums2[j-1] > nums1[i]){
                imin = i + 1;
            }else{
                int max_l,min_r;
                if(i == 0){
                    max_l = nums2[j-1];
                }else if(j == 0){
                    max_l = nums1[i-1];
                }else{
                    max_l = Math.max(nums1[i-1],nums2[j-1]);
                }
                if((m+n)%2==1) return max_l;
                if(i == m){
                    min_r = nums2[j];
                }else if(j == n){
                    min_r = nums1[i];
                }else{
                    min_r = Math.min(nums1[i],nums2[j]);
                }
                return (min_r+max_l)/2.0;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
//        Example 1:
//        nums1 = [1, 3]
//        nums2 = [2]
//
//        The median is 2.0
        Top4MedianofTwoSortedArrays top4MedianofTwoSortedArrays = new Top4MedianofTwoSortedArrays();
        System.out.println(top4MedianofTwoSortedArrays.findMedianSortedArrays(new int[]{1,3},new int[]{2}));

//        Example 2:
//        nums1 = [1, 2]
//        nums2 = [3, 4]
//
//        The median is (2 + 3)/2 = 2.5
        System.out.println(top4MedianofTwoSortedArrays.findMedianSortedArrays(new int[]{1,2},new int[]{3,4}));

    }
}
