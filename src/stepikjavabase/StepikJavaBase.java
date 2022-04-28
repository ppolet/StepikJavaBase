/*
Stepik. Java. Базовый курс
 */
package stepikjavabase;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class StepikJavaBase {

    public static void main(String[] args) throws Exception {
        String s = "Ы";
        byte[] b = s.getBytes(StandardCharsets.UTF_8);
        
        for(int i = 0; i < b.length; i++)
        System.out.print(b[i]+256 + " ");
        
        System.out.println("");
                
        
/*
Реализуйте метод, который зачитает данные из InputStream и преобразует их в строку, используя заданную кодировку.
Пример
InputStream последовательно возвращает четыре байта: 48 49 50 51.
Метод, вызванный для такого InputStream и кодировки ASCII, должен вернуть строку "0123".        
*/
        InputStream inByte = new ByteArrayInputStream(new byte[]{48, 49, 50, 51});
        System.out.println(readAsString(inByte, StandardCharsets.US_ASCII));
   
    } 
    
    public static String readAsString(InputStream inputStream, Charset charset) throws Exception {
        StringBuilder sb = new StringBuilder();
        Reader in = new InputStreamReader(inputStream, charset);

        int s;
        while((s = in.read()) != -1){
            sb.append((char)s);
        }
        return sb.toString();
    }
    
}
