/*
Реализуйте метод, вычисляющий симметрическую разность двух множеств.
Метод должен возвращать результат в виде нового множества. Изменять переданные в него множества не допускается.
Пример
Симметрическая разность множеств {1, 2, 3} и {0, 1, 2} равна {0, 3}.
 */
package stepikjavabase;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test62 {
    public static void main(String[] args) {
        Set s1 = new HashSet();
        s1.add(1);
        s1.add(2);
        s1.add(3);

        Set s2 = new HashSet();
        s2.add(0);
        s2.add(1);
        s2.add(2);
        
        Set sResult = new HashSet();
        sResult = symmetricDifference(s1, s2);
        
        if(!sResult.isEmpty()){
            for(Object n: sResult){
                System.out.println(n);
            }
        }
        
    }
    
    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set setResult = new HashSet(set1);
        setResult.addAll(set2);


        Iterator i = setResult.iterator();
        while (i.hasNext()) {
           Object s = i.next(); // must be called before you can call i.remove()
           if(set1.contains(s) && set2.contains(s)) i.remove();
        }

        return setResult;
    } 
    
    //или так :)
    public static <T> Set<T> symmetricDifference2(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T>s3 = new HashSet<>(set1);
        Set<T>s4 = new HashSet<>(set2);
        s3.removeAll(set2);
        s4.removeAll(set1);
        s3.addAll(s4);
        return s3;
    }    
    
}
