package me.menduo.pinduoduo;

import java.util.Scanner;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-04-03 19:58
 **/
public class Two {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int[] array = new int[10];
            for (int i = 0; i < 10; i++) {
                array[i] = scanner.nextInt();
            }
            int first = scanner.nextInt();
            int second = scanner.nextInt();
            int[] a = new int[first];
            int[] b = new int[second];


            int start = 0;
            int left = 0;
            while (start < first && array[0] > 0) {
                a[start++] = 0;
                array[0]--;
            }
            while (left < second && array[0] > 0) {
                b[left++] = 0;
                array[0]--;
            }
            boolean flag = true;
            int i=0;
            for (; i < array.length ; i++) {
                while (array[i]>0) {
                    if (start == first) break;
                    if (left == second) break;
                    if (flag) {
                        a[start++] = i;
                        array[i]--;
                    }else {
                        b[left++] = i;
                        array[i]--;
                    }
                    flag = !flag;
                }
                if (start == first) break;
                if (left == second) break;
            }
            while (i<array.length && start<first) {

                while (array[i]>0) {
                    a[start++] = i;
                    array[i]--;
                }
                i++;
            }
            while (i<array.length && left<second) {
                while (array[i]>0) {
                    b[left++] = i;
                    array[i]--;
                }
                i++;
            }
            StringBuilder sba = new StringBuilder();
            int sentinel=0;
            while (sentinel<a.length && a[sentinel] == 0) {
                    sentinel++;
            }
            while (sentinel < a.length) {
                sba.append(a[sentinel++]);
            }

            StringBuilder sbb = new StringBuilder();
            sentinel=0;
            while (sentinel<b.length && b[sentinel]==0) {
                    sentinel++;
            }
            while (sentinel < b.length) {
                sbb.append(b[sentinel++]);
            }
            String nums1 = sba.toString().equals("") ? "0":sba.toString();

            String nums2 = sbb.toString().equals("") ? "0":sbb.toString();
            System.out.println(multiply(nums1,nums2));
        }
    }


    public static String multiply(String num1, String num2) {
        if(num1.length()==0 || num2.length()==0) return "";
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int m = chars1.length-1;
        int n = chars2.length-1;
        int[] result = new int[m+n+2];
        for (int i = m; i >= 0 ; i-- ) {
            for (int j = n; j >= 0; j--) {
                int mult = (chars1[i] - '0') * (chars2[j] - '0');
                mult += result[i+j+1];
                result[i+j] += mult / 10;
                result[i+j+1] = mult % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < result.length ; i++) {
            if(result[i]!=0) flag = true;
            if(flag) sb.append(result[i]);
        }
        if(!flag) return "0";
        return sb.toString();
    }
}
