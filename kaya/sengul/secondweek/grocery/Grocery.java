package kaya.sengul.secondweek.grocery;

import java.util.HashMap;
import java.util.Locale;

public class Grocery {
	private final HashMap<String, Fruit> fruits;
	public Grocery(Apple apple, Pear pear, Cherry cherry)
	{
		fruits = new HashMap<>();
		fruits.put("Apple", apple);
		fruits.put("Pear", pear);
		fruits.put("Cherry", cherry);
	}
	public void availability()
	{
		appleAvailability();
		pearAvailability();
		cherryAvailability();
	}
	public void appleAvailability()
	{
		var apple = fruits.get("Apple");
		System.out.println(apple.stock > 0 ? apple.toString() : "There is no apple");
	}
	public void pearAvailability()
	{
		var pear = fruits.get("Pear");
		System.out.println(pear.stock > 0 ? pear.toString() : "There is no apple");
	}
	public void cherryAvailability()
	{
		var cherry = fruits.get("Cherry");
		System.out.println(cherry.stock > 0 ? cherry.toString() : "There is no apple");
	}
	public void orderApple(int val)
	{
		fruits.get("Apple").updateStock(val);
		System.out.println("Apple sipariþin baþarýyla alýndý!");
	}
	public void orderPear(int val)
	{
		fruits.get("Pear").updateStock(val);
		System.out.println("Pear sipariþin baþarýyla alýndý!");
	}
	public void orderCherry(int val)
	{
		fruits.get("Cherry").updateStock(val);
		System.out.println("Cherry sipariþin baþarýyla alýndý!");
	}
	public void order()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);

		for (;;) {
			System.out.println("Please type quit if you have do not like to order anything!");
			System.out.println("What would you like to order?");
			String order = kb.nextLine();

			if (order.equals("quit"))
				break;

			if (!order.equals("Apple") && !order.equals("Pear") && !order.equals("Cherry")) {
				System.out.println("Please type your order correctly!");
				continue;
			}

			System.out.printf("How many %s would you like to order?", order);
			int val = Integer.parseInt(kb.nextLine());


			var fruit = fruits.get(order);
			fruit.updateStock(val);
			availability();
		}


	}

}
