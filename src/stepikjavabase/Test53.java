/*
https://stepik.org/lesson/12784/step/13?unit=3131

Напишите программу, читающую текст из System.in и выводящую в System.out 
сумму всех встреченных в тексте вещественных чисел с точностью до шестого знака после запятой. 
Числом считается последовательность символов, отделенная от окружающего текста пробелами или переводами строк и успешно разбираемая методом Double.parseDouble.

На этот раз вам надо написать программу полностью, т.е. объявить класс (с именем Main — таково ограничение проверяющей системы), метод main, прописать все import'ы.

Sample Input 1:
1 2 3

Sample Output 1:
6.000000

Sample Input 2:
a1 b2 c3

Sample Output 2:
0.000000

Sample Input 3:
-1e3
18 .111 11bbb

Sample Output 3:
-981.889000
 */
package stepikjavabase;

import java.io.IOException;
import java.util.Scanner;

public class Test53 {
    public static void main(String[] args) throws IOException {
        Double sum = 0.0;
        Double n;

        try(Scanner sc = new Scanner(System.in)){
            while(sc.hasNext()){
                if(sc.hasNextDouble()){
                    n = sc.nextDouble();
                    sum += n;
                } else {
                    sc.next();
                }
            }
            System.out.printf("%.6f", sum);
        } catch (Exception ex){
            System.out.printf("%.6f", 0.0);
        }

        
        

    }
}
