/*Задание №7(Создайте программу для определения кода введенного
символа в 16-ном представлены в формате '\ uXXXX ".
Обеспечьте цикличность выполнения программы до ввода
символа пробел. Проверьте правильность работы программы,
воспользовавшись ею для получения кодов символов в любом
слове (например, "cat") и выведя на экран слово из
полученных кодов.)*/
import java.util.ArrayList;
import java.util.Iterator;

public class Task7 {
        public static void main(String[] arg){
            String t ="cat ";
            ArrayList<Character> text = new ArrayList<>();
            for(int i = 0; i<t.toCharArray().length; i++){
                text.add(t.toCharArray()[i]);
            }
            Iterator<Character> i =text.iterator();
            int k=0;
            while(i.hasNext()&&text.get(k)!=' '){
                System.out.print(convert_to_Hex(i.next())+' ');
                k++;
            }

        }
        public static String convert_to_Hex(char symbol) {
            String ret= null;
            String ch = Integer.toHexString(symbol).toUpperCase();
           if(ch.length()==1) {
                ret="\\u000"+ ch;
            }
            else if(ch.length()==2) {
                ret="\\u00"+ch;
            }
            else if(ch.length()==3) {
                ret="\\u0"+ch;
            }
            else if(ch.length()==4) {
                ret="\\u"+ch;
            }
            return ret;
        }
    }


