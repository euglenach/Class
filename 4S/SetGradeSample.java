package com.company;
import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.*;
import java.lang.*;
import java.io.*;

public class SetGradeSample {
    public static void main(String[] args) {
        CitStudent koudai = new CitStudent();
        koudai.no = 1732999;
        koudai.name = "kodai";
        koudai.year = 2;
        koudai.grade = 79;
        koudai.department = 1;
        showGrade(koudai);
    }
    public  static void showGrade(CitStudent data){
        List<Integer> point = Arrays.asList(59,69,79,89,100);
        List<String> rank = Arrays.asList("D","C","B","A","S");
        int u = 0 ;

        System.out.print("No:" + data.no +" " + data.name + " " + data.grade);
        System.out.print(data.department == 1 ? "情報工学科" : "情報ネットワーク学科");
        for (var i: point) {
            if(data.grade <= i){
                System.out.print(rank.get(u));
                break;
            }
            u++;
        }

    }
}

class CitStudent{
    public int no;
    public String name;
    public int year;
    public int grade;
    public int department;
    public void setNo(int p_no){
        no = p_no;
    }
}
