package com.company;

import java.io.File;


/*
данный класс считает вес файла или вес каталога с файлами
*/

public class Reader {

    private String way;
    int length = 0;

    public Reader (String way){
        this.way = way;
    }

    public void setWay(String way) {
        this.way = way;
        length = 0;
    }

    public int getLength(){
        if (length == 0){
            File directory = new File(way);
            if (directory.isDirectory()){
                length = findCapacity(directory);
            }else{
                length = (int) directory.length();
            }
        }
        return length;
    }

    private int findCapacity(File directory){
        int localLength = 0;
        File[] files = directory.listFiles();
        for (File file : files){
            if (file.isDirectory()){
                localLength += findCapacity(file);
            }else{
                localLength += file.length();
            }
        }
        return localLength;
    }

    public void sckan(int i){
        String fin = "";
        if (i> 1000000000){
            fin = Integer.toString(i/1000000000) + "гб. ";
            i = i % 1000000000;
        }
        if (i> 1000000){
            fin += Integer.toString(i/1000000) + "мб. ";
            i = i % 1000000;
        }
        if (i> 1000){
            fin += Integer.toString(i/1000) + "кб. ";
            i = i % 1000;
        }
        fin += Integer.toString(i) + "байт ";
        System.out.println(fin);
    }

}
