package me.menduo.top100;

public class NO88MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int back = m+n-1;
        m--;
        n--;
        while(back>=0){
            if(m>=0&&n>=0){
                if(nums1[m]<nums2[n]){
                    nums1[back--]=nums2[n--];
                }else{
                    nums1[back--]=nums1[m--];
                }
            }else if(m>=0) {
                nums1[back--] = nums1[m--];
            }else if(n>=0) {
                nums1[back--] = nums2[n--];
            }
        }

    }
    public static void main(String[] args) {
        NO88MergeSortedArray no88MergeSortedArray = new NO88MergeSortedArray();
        int[] nums1 = new int[]{1,0,0,0,0,0};
        no88MergeSortedArray.merge(nums1,1,new int[]{2,5,6},3);
        for (int i: nums1) {
            System.out.println(i);
        }
    }
}
