/*
Напишите метод, читающий входной поток и вычисляющий контрольную сумму прочитанных данных.

Контрольная сумма данных вычисляется по следующему алгоритму:

    Контрольная сумма представляет собой число типа int. Контрольная сумма пустого набора данных равна нулю.
    Контрольная сумма непустого набора данных вычисляется по следующей рекуррентной формуле: 
    Cn+1=rotateLeft(Cn) xor bn+1 C_{n+1}=\mathrm{rotateLeft}(C_n)\ \mathrm{xor}\ b_{n+1} Cn+1​=rotateLeft(Cn​) xor bn+1​ , 
    где Cn C_n Cn​ — контрольная сумма первых n байт данных, rotateLeft — циклический сдвиг бит числа на один бит влево 
    (чтобы не изобретать велосипед, используйте Integer.rotateLeft), bn b_n bn​ — n-ный байт данных.

Поскольку метод не открывал данный InputStream, то и закрывать его он не должен. Выброшенное из методов InputStream исключение должно выбрасываться из метода.

Пример
На вход подан InputStream, последовательно возвращающий три байта: 0x33 0x45 0x01. В качестве контрольной суммы должно быть возвращено число 71.
 */
package stepikjavabase;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Test52_1 {
    public static void main(String[] args) {
        byte[] array1 = new byte[]{0x33, 0x45, 0x01};
        InputStream bis1 = new ByteArrayInputStream(array1);
        try {
            System.out.println("CheckSum: " + checkSumOfStream(bis1));
        } catch (IOException ex) {
            System.out.println("Exception: " + ex);
        }
    }
    
    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int controlSum = 0;
        int b;
        
        while((b = inputStream.read()) != -1){
            controlSum = Integer.rotateLeft(controlSum, 1) ^ b;
        }
        return controlSum;
    }    
}
