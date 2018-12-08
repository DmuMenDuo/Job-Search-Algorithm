package me.menduo.gjsf;

import java.io.IOException;
import java.util.*;



public class HanoTower2064 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int level = in.nextInt();
            long tmp = 0;
            long sum = 0;
            for (int i = 0; i < level; i++)
                tmp += (2 + 2*tmp);
            sum+=tmp;
            System.out.println(sum);
        }
    }
}

