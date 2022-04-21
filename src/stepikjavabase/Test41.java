/*
Реализуйте метод, позволяющий другим методам узнать, откуда их вызвали.

Метод getCallerClassAndMethodName() должен возвращать имя класса и метода, 
откуда вызван метод, вызвавший данный утилитный метод. Или null (нулевую ссылку, а не строку "null"), 
если метод, вызвавший getCallerClassAndMethodName() является точкой входа в программу, т.е. его никто не вызывал.

Это актуально, например, в библиотеках логирования, где для каждого сообщения в логе надо выводить класс и метод, откуда сообщение было залогировано.

При запуске эта программа должна вывести:

null
org.stepic.java.example.Test#main

P.S. При тестировании этой программы в среде разработки вы можете получить другой результат: 
вместо null в первой строчке будет напечатан какой-то посторонний класс и метод. 
Это связано с тем, что среда разработки обычно запускает не ваш класс, а свой собственный, 
который затем уже вызывает ваш. Чтобы этого избежать, запускайте программу командой "java" в командной строке.
 */
package stepikjavabase;

public class Test41 {
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName()); //null
        anotherMethod();
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName()); //anotherMethod
    }

    public static String getCallerClassAndMethodName() {
        StackTraceElement[] stackTraceElements = new Exception().getStackTrace();
//        System.out.println(stackTraceElements.length-1);
        
//        for (StackTraceElement stackTraceElement : stackTraceElements) {
//            System.out.println(stackTraceElement.getClassName() + "#" + stackTraceElement.getMethodName());
//        }
        
        if(stackTraceElements.length < 3) return null;
        
        return stackTraceElements[2].getClassName() + "#" + stackTraceElements[2].getMethodName();
    }
    
}
