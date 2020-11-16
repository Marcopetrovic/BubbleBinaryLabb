package com.company;

public class BubbleSort {

    public void sorting(int[] array){
        int x;
        do{
            x = 0;
            for(int i = 0; i < array.length-1; i++){
                if(array[i]>array[i+1]){
                    int tillf = array[i];
                    array[i] = array[i+1];
                    array[i+1] = tillf;
                    x++;
                }
            }
        }while(x != 0);
    }

    public void printSortedNumbers(int[] array){
        sorting(array);
        String printString = "";
        for(int e: array){
            printString += e + ", ";
        }
        printString = printString.substring(0, printString.length()-2);
        System.out.println(printString);
    }
}
