/*
Напишите класс AsciiCharSequence, реализующий компактное хранение последовательности ASCII-символов (их коды влезают в один байт) в массиве байт. 
По сравнению с классом String, хранящим каждый символ как char, AsciiCharSequence будет занимать в два раза меньше памяти.

Класс AsciiCharSequence должен:

    реализовывать интерфейс java.lang.CharSequence;
    иметь конструктор, принимающий массив байт;
    определять методы length(), charAt(), subSequence() и toString()

Сигнатуры методов и ожидания по их поведению смотрите в описании интерфейса java.lang.CharSequence (JavaDoc или исходники).

В данном задании методам charAt() и subSequence() всегда будут подаваться корректные входные параметры, 
поэтому их проверкой и обработкой ошибок заниматься не нужно. Тем более мы еще не проходили исключения.
 */
package stepikjavabase;

public class AsciiCharSequence implements CharSequence{
    byte[] data;

    public AsciiCharSequence(byte[] data) {
        this.data = data;
    }
    
    @Override
    public int length() {
        return data.length;
    }

    @Override
    public char charAt(int index) {
        return  (char) (data[index] & 0xff);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        int len = end - start;
        byte[] subData = new byte[len];
        for (int i = 0; i < len; i++){
            subData[i] = data[i + start];
        }
        return new AsciiCharSequence(subData);
    }
    
    @Override
    public String toString(){
        return new String(data);
    }
    
    
}
