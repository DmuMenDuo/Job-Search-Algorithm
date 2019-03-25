package me.menduo.leetcode;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-25 17:33
 **/
public class TimeStamp {

    private static long Seconds = 1000;
    private static long Minutes =  60;
    private static long Hours =  60;
    private static long DAYS = 24;
    private static long Four_Year = 365*3+366;
    private static long[] pingM = {31,28,31,30,31,30,31,31,30,31,30,31};
    private static long[] runM = {31,29,31,30,31,30,31,31,30,31,30,31};
    private static long c_seconds = 0;
    private static long c_minutes = 0;
    private static long c_hours = 0;
    private static long c_year = 0;
    private static long c_month = 0;
    private static long c_days = 0;
    public static void main(String[] args) {
        long test = 1961683200000l; //3-25 18:34:12;
        getTime(test);
        getDate(test);
        print();

    }

    private static void getTime(long timestamps) {
        c_seconds = timestamps/Seconds%Minutes;
        c_minutes = timestamps/(Seconds*Minutes)%Hours;
        c_hours = timestamps/(Seconds*Minutes*Hours)%DAYS + 8;
    }
    private static void print(){
        System.out.println(c_year + "-" +c_month + "-" + c_days + " " +c_hours + ":" + c_minutes + ":" + c_seconds);
    }
    private static void getDate(long timestamps) {
        long data = timestamps / (Seconds*Minutes*Hours*DAYS);
        //System.out.println(data);
        long year = 1970 + 4 * data/Four_Year;
        long mouths = data%Four_Year;
        boolean flag = false;
        if(mouths<365){

        }else if(mouths<365*2){
            //year++;
            mouths-=365;
        }else if(mouths<365*3){
            //year+=2;
            mouths-=365*2;
        }else {
            //year+=3;
            mouths-=365*3;
            flag=true;
        }
        c_year = year;
        //System.out.println(mouths);
        //if(year%400==0 ||(year%4==0 && year%100!=0)) flag = true;

        if(!flag){
            for (int i = 0; i < pingM.length ; i++) {
                if(mouths - pingM[i] > 0){
                    mouths -= pingM[i];
                }else {
                    c_month = i+1;
                    break;
                }
            }
        }else {
            for (int i = 0; i < runM.length; i++) {
                if (mouths - runM[i] > 0) {
                    mouths -= runM[i];
                } else {
                    c_month = i + 1;
                    break;

                }
            }
        }
        c_days = mouths+1;


    }
}
