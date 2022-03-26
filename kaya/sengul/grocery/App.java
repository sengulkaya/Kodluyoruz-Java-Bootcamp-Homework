package kaya.sengul.grocery;
/*
 * Manav d�kkan� a�mak isteyen bir adam hal'den bir miktar elma, bir miktar armut, bir miktar kiraz alacakt�r.
 * Mallar d�kkana gelmi�tir.
 * Kullan�c� bu mallar� ayr� odalarda saklayacakt�r.
 * Her bir odadaki elma, armut ve kiraz�n kg cinsinden de�erini bulal�m.
 */
/*
 * Manav'dan online al��veri� yap�l�yor. M��teri Ve 1 kg elma, 2 kg armut almak istedi.
 * Mallar� als�n. depo guncellensin.
/*
 * Online sat��ta m��teri depoda kalan maldan fazla bir miktarda mal almak istedi.
 * Bunu kullan�c�ya bildir.
 */
public class App {

	public static void main(String[] args) {

		Grocery grocery = new Grocery(new Apple(3, 100),
				new Pear(4, 100), new Cherry(5, 100));

		grocery.availability();

		grocery.order();

		grocery.availability();
	}

}
