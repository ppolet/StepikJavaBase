/*
Напишите программу, которая прочитает из System.in последовательность целых чисел, разделенных пробелами, 
затем удалит из них все числа, стоящие на четных позициях, и затем выведет получившуюся последовательность в обратном порядке в System.out.
Все числа влезают в int. Позиции чисел в последовательности нумеруются с нуля.
В этом задании надо написать программу целиком, включая import'ы, декларацию класса Main и метода main.

Sample Input:
1 2 3 4 5 6 7

Sample Output:
6 4 2
 */
package stepikjavabase;

import java.util.Deque;
import java.util.Scanner;

public class Test62_1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        if(reader.hasNextLine()){
            String[] strArr = reader.nextLine().split(" ");

            int n = (strArr.length % 2) == 0 ? strArr.length : strArr.length - 1;
            StringBuilder sb = new StringBuilder();
            String pref = "";
            for(int i = n - 1; i > 0; i-=2){
                sb.append(pref + strArr[i]);
                pref = " ";
            }
            System.out.println(sb);
        }
              
    }
    
}
