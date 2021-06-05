/*17.	Создайте приложение для поиска абонента телефонной сети.
Список абонентов (5 записей) создается в программе и является
объектом класса TreeMap. Ключом записи является номер телефона
(типа String), а значением – объект Abonent, содержащий четыре
 значения типа String:  фамилию, имя, отчество и адрес.
Предусмотреть возможность сортировки элементов коллекции по 2-3 полям,
 для чего использовать класс ArrayList.*/
import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class Task17 {
    public static void main(String[] args){
        TreeMap<String, Abonent> list_of_abonents = new TreeMap<>();
        list_of_abonents.put("0507892367", new Abonent("Петров","Иван","Васильевич", "г.Киев,ул.Павлова,д.6,кв.45"));
        list_of_abonents.put("0956783010", new Abonent("Иванов","Роман","Валерьевич", "г.Суммы,ул.Кирова,д.89,кв.2"));
        list_of_abonents.put("0669870917", new Abonent("Карпенко","Евгений","Дмитриевич", "г.Донецк,ул.Шевченко,д.78,кв.9"));
        list_of_abonents.put("0996051267", new Abonent("Амелина","Анна","Александровна", "г.Львов,ул.Главная,д.54,кв.85"));
        list_of_abonents.put("0449470376", new Abonent("Амелина","Виктория","Олеговна", "г.Харьков,ул.Чапаева,д.78,кв.25"));
        /*for(Map.Entry<String, Abonent> item: list_of_abonents.entrySet()){
            System.out.printf("Key: %s Value: %s %s %s %s \n", item.getKey(), item.getValue().getSurname(), item.getValue().getName(),item.getValue().getPatronymic(), item.getValue().getAddress());
        }
        System.out.println();*/
        Abonent obj = search_for_abonent(list_of_abonents,"0956783010");
        if(obj==null){
            System.out.println("There is no matches.");
        }
        else {
            System.out.print("Found information: " + obj.getSurname() + " " + obj.getName() + " " + obj.getPatronymic() + " " + obj.getAddress());
        }
        System.out.println();
        ArrayList<Abonent> list_for_sorting = sort_list(list_of_abonents);
        System.out.println("Sorted: ");
        for(int i=0; i<list_for_sorting.size(); i++){
            System.out.println(list_for_sorting.get(i).getSurname()+" "+list_for_sorting.get(i).getName()+" "+list_for_sorting.get(i).getPatronymic()+" "+list_for_sorting.get(i).getAddress() );
        }
    }


    static Abonent search_for_abonent(TreeMap list_of_abonents, String key){
        return (Abonent) list_of_abonents.get(key);
    }
    static ArrayList<Abonent> sort_list(TreeMap<String,Abonent> list_of_abonents){
        ArrayList<Abonent> list_for_sorting = new ArrayList<>(list_of_abonents.values());
        Collections.sort(list_for_sorting, new Comparator<Abonent>() {
            @Override
            public int compare(Abonent o1, Abonent o2) {
                int valueSurname = o1.getSurname().compareTo(o2.getSurname());
                if(valueSurname!=0){
                    return valueSurname;
                }
                int valueName = o1.getName().compareTo(o2.getName());
                if(valueName!=0){
                    return valueName;
                }
                int valuePatronymic = o1.getPatronymic().compareTo(o2.getPatronymic());
                if(valuePatronymic!=0){
                    return valuePatronymic;
                }
                return o1.getAddress().compareTo(o2.getAddress());
            }
        });
        return list_for_sorting;
    }


    static class Abonent{
        private String surname;
        private String name;
        private String patronymic;
        private String address;
        public Abonent(String s, String n,String p, String a){
            this.surname=s;
            this.name=n;
            this.patronymic=p;
            this.address=a;
        }
        public String getSurname(){
            return surname;
        }
        public String getName(){
            return name;
        }
        public String getPatronymic(){
            return patronymic;
        }
        public String getAddress(){
            return address;
        }

    }
}
