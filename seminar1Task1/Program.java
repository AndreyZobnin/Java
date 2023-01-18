package seminar1Task1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Program {

    // 1 Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
    public static int randomNum(int min, int max) {
        int num = (int) (Math.random() * ((max - min) + 1)) + min;
        return num;
    }

    // 2 Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
    public static int seniorBit(int i) {
        int binLen = Integer.toBinaryString(i).length();
        return binLen;
    }
    
    //Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
    
    public static ArrayList<Integer> arrayMult(int i, int n, int max) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int j = i + 1; j <= max; j++) {
            if (j % n == 0) {
                list.add(j);
            }
        }
        return list;
    }

    // Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
    public static ArrayList<Integer> arrayNotMult(int i, int n, int min) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int j = i - 1; j >= min; j--) {
            if (j % n != 0) {
                list.add(j);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int min = 0, max = 20000;
        int i = randomNum(min, max);
        System.out.println("Случайное число от " + min + " и " + max + ": i = " + i);
        int n = seniorBit(i);
        System.out.println("Номер старшего бита в массиве i: n = " + n);
        ArrayList<Integer> m1 = arrayMult(i, n, max);
        System.out.print("array MAX_values  n > i: " + m1);
        ArrayList<Integer> m2 = arrayNotMult(i, n, min);
        System.out.print("array MIN_values  n < i: " + m2);
 
    }
}