package seminar2Task;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Program {
    
    public static void minWindow(String firstText, String secondText){
        Pattern pattern = Pattern.compile(secondText);
        Matcher matcher = pattern.matcher(firstText);
        while (matcher.find()) {
        System.out.println(firstText.substring(matcher.start(), matcher.end()));
        }    
    }
//Напишите программу, чтобы проверить, являются ли две данные строки вращением 
//друг друга (вхождение в обратном порядке).
    public static boolean searchPalindrom(String firstStr, String secondStr) {
        return firstStr.equals(new StringBuilder(secondStr).reverse().toString());
    }
        // переворачиваем с помощю рекурсии
        public static String reverseStr(String str) {
        if (str.length() <= 1) {
            return str;
        }
        return reverseStr(str.substring(1)) + str.charAt(0);
    }
        
    /* Дано два числа, например 3 и 56, 
    необходимо составить следующие строки: 
    3 + 56 = 59 
    3 – 56 = -53 
    3 * 56 = 168 
    Используем метод StringBuilder.append(). */
        public static String compilerMathToStr (int num1, int num2, char sign) {
            StringBuilder mathTask = new StringBuilder();
            mathTask.append(num1).append(" ").append(sign).append(" ").append(num2).append(" = ");
            switch (sign) {
                case '+':
                    mathTask.append(num1 + num2);
                    break;
                case '-':
                    mathTask.append(num1 - num2);
                    break;
                case '*':
                    mathTask.append(num1 * num2);
                    break;
            }
            return mathTask.toString();
        }
       
         public static String replacEqual(String mathTask) {
                StringBuilder task = new StringBuilder(mathTask);
                int index = task.indexOf("=");
                return task.deleteCharAt(index).insert(index, "равно").toString();
            }
    // 6 *Замените символ “=” на слово “равно”. Используйте методы
    // StringBuilder.replace().
    public static String nextReplacEquel(String mathTask) {
        StringBuilder task = new StringBuilder(mathTask);
        int index = task.indexOf("=");
        return task.replace(index, index + 1, "равно").toString();
    }

    public static void main(String[] args) {
    Scanner iScanner = new Scanner(System.in);
    System.out.printf("Ввод первой строки: ");
    String str1 = iScanner.nextLine();
    System.out.printf("Ввод второй строки: ");
    String str2 = iScanner.nextLine();
    iScanner.close();

    System.out.println("Все наименьшие окна первой строки, содержащие все символы второй строки если они есть: ");
    minWindow(str1, str2);
    // ответ второго задания
    System.out.println();
    if (searchPalindrom(str1, str2)) {
        System.out.println("Введеные строки являются вращением друг друга");
        } else
             System.out.println("Введеные строки неявляются вращением друг друга");
    // ответ на 3 задачу
    System.out.println();
    System.out.printf("перевернем первую строку: %s\n", reverseStr(str1));
    System.out.printf("перевернем вторую строку: %s\n", reverseStr(str2));
 // 4
 System.out.println();
 System.out.println("вывод  в виде строк:");
 int a = 3, b = 56;
 System.out.println(compilerMathToStr(a, b, '+'));
 System.out.println(compilerMathToStr(a, b, '-'));
 System.out.println(compilerMathToStr(a, b, '*'));
// 5 решение 
System.out.println();
System.out.println("Пример с заменой знака '=' на слово");
System.out.println(replacEqual(compilerMathToStr(a, b, '+')));

// 6 решение  ответ
System.out.println(nextReplacEquel(compilerMathToStr(a, b, '*')));
System.out.println();
}
     
     
}
