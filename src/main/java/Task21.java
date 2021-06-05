/*Создайте приложение для добавления книг и просмотра списка книг
в  библиотечном каталоге. Список книг (5 записей) создается в программе
и является объектом класса HashMap. Ключом записи является индекс ISBN
книги (типа Integer), а значением – объект Book, содержащий наименование
книги, фамилию, имя и отчество (ФИО) автора, издательство (все записи
типа String), год издания (типа int) и цену книги (типа float). Предусмотреть
 возможность получения списка авторов книг, где авторы не повторяются для
 чего использовать TreeSet.*/


import java.util.HashMap;
import java.util.TreeSet;
import java.util.Map;

public class Task21 {
        static public void main(String[] args) {
            HashMap<Integer, Book> library_catalog = new HashMap<>();
            library_catalog.put(1500, new Book("Анна Каренина", "Толстой Лев Николаевич", "МИФ", 2000, 160f));
            library_catalog.put(1501, new Book("Палата номер 6", "Чехов Антон Павлович", "Ранок", 1995, 99f));
            library_catalog.put(1502, new Book("Война и мир", "Толстой Лев Николаевич", "МИФ ", 2002, 180.5f));
            library_catalog.put(1503, new Book("Шинель", "Гоголь Николай Васильевич", "Пегас", 1990, 87.9f));
            library_catalog.put(1504, new Book("Человек в футляре", "Чехов Антон Павлович", "Пегас", 2001, 115.5f));
            Book ob = new Book("Евгений Онегин","Пушкин Александр Сергеевич","Росмэн",2007,110f);
            int ISBN =1510;
            library_catalog=add_element_to_list(library_catalog,ISBN, ob);
            watch_library_catalog(library_catalog);
            TreeSet<Book> list_of_authors = get_only_list_of_authors(library_catalog);
            for(Book book:list_of_authors){
                System.out.println(book.getFull_name_of_author());
            }

        }
        static class Book implements Comparable<Book> {
            private String name;
            private String full_name_of_author;
            private String publishing_house;
            private int year;
            private float price;
            Book(String n, String f, String ph, int y, float p){
                this.name=n;
                this.full_name_of_author=f;
                this.publishing_house=ph;
                this.year=y;
                this.price=p;
            }
            public String getName(){
                return name;
            }
            public String getFull_name_of_author(){
                return full_name_of_author;
            }
            public String getPublishing_house(){
                return publishing_house;
            }
            public int getYear(){
                return year;
            }
            public float getPrice(){
                return price;
            }

            @Override
            public int compareTo(Book o) {
                return this.full_name_of_author.compareTo(o.getFull_name_of_author());
            }
        }

        public static HashMap<Integer, Book> add_element_to_list(HashMap<Integer,Book> list, int ISBN, Book ob){
            list.put(ISBN,ob);
            return list;
        }
        public static void watch_library_catalog (HashMap<Integer,Book> catalog){
            for (Map.Entry<Integer,Book> item : catalog.entrySet()) {
                System.out.printf("Key: %d; Value: \"%s\" %s %s %d %.2f \n",item.getKey(), item.getValue().getName(),item.getValue().getFull_name_of_author(),item.getValue().getPublishing_house(),item.getValue().getYear(),item.getValue().getPrice());
            }
        }
        public static TreeSet<Book> get_only_list_of_authors(HashMap<Integer,Book> library_catalog){
            TreeSet<Book> list_of_authors = new TreeSet<>(library_catalog.values());
            return list_of_authors;
        }
    }

