package kaya.sengul.grocery;
/*
 * Manav dükkaný açmak isteyen bir adam hal'den bir miktar elma, bir miktar armut, bir miktar kiraz alacaktýr.
 * Mallar dükkana gelmiþtir.
 * Kullanýcý bu mallarý ayrý odalarda saklayacaktýr.
 * Her bir odadaki elma, armut ve kirazýn kg cinsinden deðerini bulalým.
 */
/*
 * Manav'dan online alýþveriþ yapýlýyor. Müþteri Ve 1 kg elma, 2 kg armut almak istedi.
 * Mallarý alsýn. depo guncellensin.
/*
 * Online satýþta müþteri depoda kalan maldan fazla bir miktarda mal almak istedi.
 * Bunu kullanýcýya bildir.
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
