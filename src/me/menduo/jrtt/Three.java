package me.menduo.jrtt;

import java.util.Scanner;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-16 11:23
 **/
public class Three {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int  n  = scanner.nextInt();
        for (int i = 0; i < n ; i++) {
            int p = scanner.nextInt();
            int array[] = new int[p];
            for (int j = 0; j < p ; j++) {
                array[j] = scanner.nextInt();
            }
            System.out.println(candy(array));
        }
    }

    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        for (int i = 0; i < n; i++) {
            candies[i] = 1; //每人至少发一颗糖
        }
        for(int i = 1; i < n; i++){ //从前往后遍历ratings数组
            if(ratings[i] > ratings[i - 1]){
                candies[i] = candies[i - 1] + 1;
            }
            if(i==n-1 && ratings[i]>ratings[0]){
                candies[i] = Math.min(ratings[i-1],ratings[0])+1;
            }
        }
        for(int i = n - 2; i >= 0; i--){    //从后往前遍历ratings数组
            if(ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]){
                candies[i] = candies[i + 1] + 1;
            }
            if(i==0 && ratings[i]>ratings[n-1] && candies[i] <= candies[i + 1]){
                candies[i] = Math.min(ratings[n-1],ratings[i+1]) +1;
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += candies[i];
        }
        return sum;
    }
}
