package me.menduo.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-04-05 17:52
 **/
public class CampareUser {
    static class Value {
        int start;
        int end;
        public Value(int start,int end) {
            this.start = start;
            this.end = end;
        }
        public static int compare(Value o1,Value o2) {
            if(o1.start <= o2.start) return -1;
            else {
                if(o1.end <= o2.end) return -1;
                else return 1;
            }
        }

        @Override
        public String toString() {
            return "Value{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Value> values = new ArrayList<>();
        values.add(new Value(1,3));
        values.add(new Value(7,8));
        values.add(new Value(2,6));

        values.sort((o1,o2) -> o1.start > o2.start ? 1:-1);
        System.out.println(Arrays.toString(values.toArray()));
    }
}
