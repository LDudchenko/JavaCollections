import org.junit.jupiter.api.Test;



import java.lang.reflect.Array;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class Tests {
    char ch1 = 'a';
    char ch2 = '-';
    char ch3 = 'Z';

    @Test
    void convert_to_Hex1() {
        String expected = Task7.convert_to_Hex(ch1);
        String actual = "\\u0061";
        assertEquals(expected, actual);
    }

    @Test
    void convert_to_Hex2() {
        String expected = Task7.convert_to_Hex(ch2);
        String actual = "\\u002D";
        assertEquals(expected, actual);
    }

    @Test
    void convert_to_Hex3() {
        String expected = Task7.convert_to_Hex(ch3);
        String actual = "\\u005A";
        assertEquals(expected, actual);
    }

    ArrayList<Character> text1 = new ArrayList<>(Arrays.asList('P', 'r', 'o', 'g', 'r', 'a', 'm', 'm', 'i', 'n', 'g'));
    ArrayList<Character> key1 = new ArrayList<>(Arrays.asList('J', 'a', 'v', 'a'));
    ArrayList<Character> text2 = new ArrayList<>(Arrays.asList('\u009A', 'Ó', 'å', 'È', '¼', 'Â', 'ã', 'Î', '³', 'Ï', 'Ý'));

    @Test
    void cezar_code1() {
        ArrayList<Character> expected = Task15.cezar_code(text1, key1);
        ArrayList<Character> actual = new ArrayList<>(Arrays.asList('\u009A', 'Ó', 'å', 'È', '¼', 'Â', 'ã', 'Î', '³', 'Ï', 'Ý'));
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }

    @Test
    void cezar_decode1() {
        ArrayList<Character> expected = Task15.cezar_decode(text2, key1);
        ArrayList<Character> actual = new ArrayList<>(Arrays.asList('P', 'r', 'o', 'g', 'r', 'a', 'm', 'm', 'i', 'n', 'g'));
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }

    TreeMap<String, Task17.Abonent> list_of_abonents = new TreeMap<String, Task17.Abonent>() {{
        put("0507892367", new Task17.Abonent("Петров", "Иван", "Васильевич", "г.Киев,ул.Павлова,д.6,кв.45"));
        put("0956783010", new Task17.Abonent("Иванов", "Роман", "Валерьевич", "г.Суммы,ул.Кирова,д.89,кв.2"));
        put("0669870917", new Task17.Abonent("Карпенко", "Евгений", "Дмитриевич", "г.Донецк,ул.Шевченко,д.78,кв.9"));
        put("0996051267", new Task17.Abonent("Амелина", "Анна", "Александровна", "г.Львов,ул.Главная,д.54,кв.85"));
        put("0449470376", new Task17.Abonent("Амелина", "Виктория", "Олеговна", "г.Харьков,ул.Чапаева,д.78,кв.25"));
    }};

    @Test
    void search_for_abonent1() {
        Task17.Abonent expected = Task17.search_for_abonent(list_of_abonents, "0956783010");
        Task17.Abonent actual = new Task17.Abonent("Иванов", "Роман", "Валерьевич", "г.Суммы,ул.Кирова,д.89,кв.2");
        assertTrue(equal(expected, actual));
    }

    @Test
    void sort_list() {
        ArrayList<Task17.Abonent> expected = Task17.sort_list(list_of_abonents);
        ArrayList<Task17.Abonent> actual = new ArrayList<Task17.Abonent>(){{
            add(new Task17.Abonent("Амелина","Анна","Александровна", "г.Львов,ул.Главная,д.54,кв.85"));
            add(new Task17.Abonent("Амелина","Виктория","Олеговна", "г.Харьков,ул.Чапаева,д.78,кв.25"));
            add(new Task17.Abonent("Иванов","Роман","Валерьевич", "г.Суммы,ул.Кирова,д.89,кв.2"));
            add(new Task17.Abonent("Карпенко","Евгений","Дмитриевич", "г.Донецк,ул.Шевченко,д.78,кв.9"));
            add(new Task17.Abonent("Петров","Иван","Васильевич", "г.Киев,ул.Павлова,д.6,кв.45"));
        }};
        for(int i=0; i<expected.size();i++) {
                assertTrue(equal(expected.get(i), actual.get(i)));
        }
    }


    public boolean equal(Task17.Abonent o1, Task17.Abonent o2) {
        if (o1.getName().equals(o2.getName()) && o1.getSurname().equals(o2.getSurname()) && o1.getPatronymic().equals(o2.getPatronymic())
                && o1.getAddress().equals(o2.getAddress())) {
            return true;
        }
        return false;
    }

    HashMap<Integer, Task21.Book> library_catalog = new HashMap<Integer, Task21.Book>() {{
        put(1500, new Task21.Book("Анна Каренина", "Толстой Лев Николаевич", "МИФ", 2000, 160f));
        put(1501, new Task21.Book("Палата номер 6", "Чехов Антон Павлович", "Ранок", 1995, 99f));
        put(1502, new Task21.Book("Война и мир", "Толстой Лев Николаевич", "МИФ ", 2002, 180.5f));
        put(1503, new Task21.Book("Шинель", "Гоголь Николай Васильевич", "Пегас", 1990, 87.9f));
        put(1504, new Task21.Book("Человек в футляре", "Чехов Антон Павлович", "Пегас", 2001, 115.5f));
    }};
         Task21.Book obj = new Task21.Book("Евгений Онегин", "Пушкин Александр Сергеевич", "Росмэн", 2007, 110f);

    @Test
    void add_element_to_list1() {
        HashMap<Integer, Task21.Book> expected = Task21.add_element_to_list(library_catalog, 1510, obj);
        HashMap<Integer, Task21.Book> actual = new HashMap<Integer, Task21.Book>() {
            {
                put(1504, new Task21.Book("Человек в футляре", "Чехов Антон Павлович", "Пегас", 2001, 115.5f));
                put(1510,new Task21.Book("Евгений Онегин", "Пушкин Александр Сергеевич", "Росмэн", 2007, 110f));
                put(1500, new Task21.Book("Анна Каренина", "Толстой Лев Николаевич", "МИФ", 2000, 160f));
                put(1501, new Task21.Book("Палата номер 6", "Чехов Антон Павлович", "Ранок", 1995, 99f));
                put(1502, new Task21.Book("Война и мир", "Толстой Лев Николаевич", "МИФ ", 2002, 180.5f));
                put(1503, new Task21.Book("Шинель", "Гоголь Николай Васильевич", "Пегас", 1990, 87.9f));
            }
        };
        ArrayList<Integer> keys1 = new ArrayList<>(expected.keySet());
        ArrayList<Integer> keys2 = new ArrayList<>(actual.keySet());
        for(int i=0; i<keys1.size();i++){
            assertEquals(keys1.get(i),keys2.get(i));
            assertTrue(equal2(expected.get(keys1.get(i)),actual.get(keys2.get(i))));
        }
    }
    @Test
    void get_only_list_of_authors1() {
        TreeSet<Task21.Book> expected = Task21.get_only_list_of_authors(library_catalog);
        TreeSet<Task21.Book> actual = new TreeSet<Task21.Book>() {
            {
                add(new Task21.Book("Шинель", "Гоголь Николай Васильевич", "Пегас", 1990, 87.9f));
                add(new Task21.Book("Анна Каренина", "Толстой Лев Николаевич", "МИФ", 2000, 160f));
                add(new Task21.Book("Человек в футляре", "Чехов Антон Павлович", "Пегас", 2001, 115.5f));
            }
        };
        Iterator<Task21.Book> i1 = expected.iterator();
        Iterator<Task21.Book> i2 = actual.iterator();
        while(i1.hasNext()||i2.hasNext()){
            assertTrue(equal2(i1.next(),i2.next()));
        }
    }

    public boolean equal2(Task21.Book o1, Task21.Book o2) {
        if (o1.getName().equals(o2.getName()) && o1.getFull_name_of_author().equals(o2.getFull_name_of_author()) && o1.getPublishing_house().equals(o2.getPublishing_house())
                && (o1.getYear()==o2.getYear())&&(o1.getPrice()==o2.getPrice())) {
            return true;
        }
        return false;
    }

}