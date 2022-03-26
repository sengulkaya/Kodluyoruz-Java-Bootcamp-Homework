package kaya.sengul.secondweek.sat;

import java.util.ArrayList;

class Test {
    /*
     * 1'den 10 a kadar olan say�lar i�erisinde
     * 2 ile tam b�l�nenleri ekrana yazd�r.
     */
    public static void testIsEven(int val) {
        for (int i = 1; i < 10; i++)
            if (Questions.isEven(val))
                System.out.printf("%d ", val);

    }

    /*
     * Bu listedeki isimleri ekrana �u �ekilde yazd�r.
     * 1. Murat
     * 2. Ahmet
     * 3. Mehmet
     */
    public static void testDisplayList() {
        java.util.ArrayList<String> list = new ArrayList<>();
        list.add("Murat");
        list.add("Ahmet");
        list.add("Mehmet");
        Questions.displayList(list);
    }

    /*
     * Sinema bileti sat���:
     * �cret hesaplama: 18 ya� alt� i�in %10 indirimli.
     * 18 ve 25 ya� aras� % 5 indirim.
     * Korku filmi se�ilmi�se ekstra % 10 indirim.
     */
    public static void testBuyTicket() {
        Questions.buyTicket();
    }

    /*
     * 10 ki�ilik bir s�n�f var.
     * S�n�ftaki ki�ilerin numaralar� ve cinsiyetlerini biliyorum.
     * bu s�n�ftaki k�zlar�n ve erkeklerin numalar�n� ayr� ayr� ekrana yazd�ran program.
     */
    public static void TestDisplayGroupedNumbersByGender() {
        ArrayList<Person> list = new ArrayList<>();
        int index = 1;
        list.add(new Person("Ali", Gender.MAN, index++));
        list.add(new Person("Leyla", Gender.WOMAN, index++));
        list.add(new Person("Fahriye", Gender.WOMAN, index++));
        list.add(new Person("Oguz", Gender.MAN, index++));
        list.add(new Person("Feride", Gender.WOMAN, index++));
        list.add(new Person("Feriha", Gender.WOMAN, index++));
        list.add(new Person("Ali", Gender.MAN, index++));
        list.add(new Person("Ali", Gender.MAN, index++));
        list.add(new Person("Ali", Gender.MAN, index++));
        list.add(new Person("Ali", Gender.MAN, index++));
        Questions.displayGroupedNumbersByGender(list);
    }


}
