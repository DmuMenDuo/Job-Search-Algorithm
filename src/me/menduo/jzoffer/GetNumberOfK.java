package me.menduo.jzoffer;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-08 16:20
 **/
public class GetNumberOfK {
    public int GetNumberOfK(int [] array , int k) {
        int start = getFirst(k,array,0,array.length-1);
        int end = getLast(k,array,0,array.length-1);
        if(start>-1 && end>-1)
            return end-start+1;
        else return 0;
    }

    private int getFirst(int k,int array[],int start,int end) {
        if(start>end) return -1;
        int mid = start + (end - start)/2;

        if (array[mid] == k) {
           if(mid>0 && array[mid-1] != k || mid==0)
               return mid;
           else
               end = mid - 1;
        }else if(array[mid]>k){
            end = mid-1;
        }else
            start = mid+1;

        return getFirst(k,array,start,end);
    }

    private int getLast(int k,int array[],int start,int end) {
        if(start>end) return -1;
        int mid = start + (end - start)/2;

        if (array[mid] == k) {
            if(mid<array.length-1 && array[mid+1] != k || mid==array.length-1)
                return mid;
            else
                start = mid + 1;
        }else if(array[mid]>k){
            end = mid-1;
        }else
            start = mid+1;

        return getLast(k,array,start,end);
    }

    public static void main(String[] args) {
        GetNumberOfK getNumberOfK =new GetNumberOfK();
        getNumberOfK.GetNumberOfK(new int[]{1},3);
    }
}
