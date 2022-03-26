package kaya.sengul.secondweek.sat;

import java.util.ArrayList;

class Test {
    /*
     * 1'den 10 a kadar olan sayýlar içerisinde
     * 2 ile tam bölünenleri ekrana yazdýr.
     */
    public static void testIsEven(int val) {
        for (int i = 1; i < 10; i++)
            if (Questions.isEven(val))
                System.out.printf("%d ", val);

    }

    /*
     * Bu listedeki isimleri ekrana þu þekilde yazdýr.
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
     * Sinema bileti satýþý:
     * ücret hesaplama: 18 yaþ altý için %10 indirimli.
     * 18 ve 25 yaþ arasý % 5 indirim.
     * Korku filmi seçilmiþse ekstra % 10 indirim.
     */
    public static void testBuyTicket() {
        Questions.buyTicket();
    }

    /*
     * 10 kiþilik bir sýnýf var.
     * Sýnýftaki kiþilerin numaralarý ve cinsiyetlerini biliyorum.
     * bu sýnýftaki kýzlarýn ve erkeklerin numalarýný ayrý ayrý ekrana yazdýran program.
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
