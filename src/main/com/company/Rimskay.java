package main.com.company;

import java.util.Scanner;

public class Rimskay {
    Rimskay(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число: ");
        int start = in.nextInt();
        String result = "";
        if(start>1000) {
            int tis = start % 1000;
            tis = (start - tis) / 1000;
            result = result + rim(tis, 1000);
            start-=(tis*1000);
        }
        if(start>100){
            int sot = start % 100;
            sot = (start - sot) / 100;
            result = result + rim(sot, 100);
            start-=(sot*100);
        }
        if(start>10){
            int des = start % 10;
            des = (start - des) / 10;
            result = result + rim(des, 10);
            start-=(des*10);
        }
        result = result + rim(start, 1);
        System.out.print(result);
    }

    public String rim (int chis, int ras){
        String res;
        String ed;
        String fi;
        String de;
        if(ras==1) {
            ed = "I";
            fi = "V";
            de = "X";
        }else if(ras==10){
            ed = "X";
            fi = "L";
            de = "C";
        }else if (ras ==100){
            ed = "C";
            fi = "D";
            de = "M";
        }else{
            ed = "M";
            fi = "V";
            de = "X";
        }
        if(chis==1){
            res = ed;
        }else if(chis==2){
            res = ed + ed;
        }else if(chis==3){
            res = ed + ed + ed;
        }else if(chis==4){
            res = ed + fi;
        }else if(chis==5){
            res = fi;
        }else if(chis==6){
            res = fi + ed;
        }else if(chis==7){
            res = fi + ed + ed;
        }else if(chis==8){
            res = fi + ed + ed + ed;
        }else{
            res = ed+de;
        }
        return res;
    }


}
