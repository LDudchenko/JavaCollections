/*Задание№15(Создайте программу, которая осуществляет шифрование /
расшифровка модифицированным методом Цезаря. В нем
ключом является лозунг, который многократно повторяется до
тех пор, чтобы достичь длины открытого текста, а
шифрование / расшифровка заключается в суммировании /
вычитании кодов символов открытого текста / криптотексте с
соответствующими кодами символов лозунга.
)*/
import java.util.ArrayList;

public class Task15 {
    public static void main(String[] args){
       String t="I learn Java programming";
       String k ="kpi";
       ArrayList<Character> text = new ArrayList<>();
        for(int i = 0; i<t.toCharArray().length; i++){
            text.add(t.toCharArray()[i]);
        }
        ArrayList<Character> key = new ArrayList<>();
        for(int j = 0; j<k.toCharArray().length; j++) {
            key.add(k.toCharArray()[j]);
        }
        System.out.print("Crypted text: ");
        ArrayList<Character> res_text = cezar_code(text,key);
        for(int i=0; i<res_text.size(); i++){
            System.out.print(res_text.get(i));
        }
        System.out.print("\nEncrypted text: ");
        res_text = cezar_decode(res_text,key);
        for(int i=0; i<res_text.size(); i++){
            System.out.print(res_text.get(i));
        }


    }

    public static ArrayList<Character> cezar_code(ArrayList<Character> text, ArrayList<Character> key){
        ArrayList<Character> ret_text = new ArrayList<>();
        ArrayList<Character> key2 = new ArrayList<>();
        int i=0;
        int j=0;
        while(i<text.size()){
            key2.add(key.get(j));
            j++;
            if(j==key.size()){
                j=0;
            }
            i++;
        }
        for(int k=0; k<text.size(); k++){
            ret_text.add((char)(text.get(k)+key2.get(k)));
        }
        return ret_text;
    }

    public static ArrayList<Character> cezar_decode(ArrayList<Character> text, ArrayList<Character> key){
        ArrayList<Character> ret_text = new ArrayList<>();
        ArrayList<Character> key2 = new ArrayList<>();
        int i=0;
        int j=0;
        while(i<text.size()){
            key2.add(key.get(j));
            j++;
            if(j==key.size()){
                j=0;
            }
            i++;
        }
        for(int k=0; k<text.size(); k++){
            ret_text.add((char)(text.get(k)-key2.get(k)));
        }
        return ret_text;
    }

}



