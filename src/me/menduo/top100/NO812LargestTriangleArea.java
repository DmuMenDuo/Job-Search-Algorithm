package me.menduo.top100;

public class NO812LargestTriangleArea {

    public double largestTriangleArea(int[][] points) {
        double max_value = 0;
        for(int i = 0;i<points.length;i++)
            for(int j = i;j<points.length;j++)
                for (int k = j;k<points.length;k++)
                    max_value = Math.max(max_value,cal(points[i],points[j],points[k]));
        return  max_value;
    }

    public double cal(int[] i,int[] j,int[] k){
        double a = Math.sqrt((i[0]-j[0])*(i[0]-j[0])+(i[1]-j[1])*(i[1]-j[1]));
        double b = Math.sqrt((i[0]-k[0])*(i[0]-k[0])+(i[1]-k[1])*(i[1]-k[1]));
        double c = Math.sqrt((j[0]-k[0])*(j[0]-k[0])+(j[1]-k[1])*(j[1]-k[1]));

        double p = (a+b+c)/2;

        return Math.sqrt(p*Math.abs(p-a)*Math.abs(p-b)*Math.abs(p-c));

    }

    public static void main(String[] args) {
        NO812LargestTriangleArea no812LargestTriangleArea = new NO812LargestTriangleArea();
        System.out.println(no812LargestTriangleArea.largestTriangleArea(new int[][]{{0,0},{0,1},{1,0},{0,2},{2,0}}));
    }
}
