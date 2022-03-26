package kaya.sengul.grocery;

public abstract class Fruit {
	protected int stock;
	protected double pricePerKg;

	public abstract double value();
	public abstract void updateStock(int val);
}
