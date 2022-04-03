package kaya.sengul.secondweek.grocery;

public class Apple extends Fruit {
	@Override
	public double value()
	{
		return super.stock * super.pricePerKg;
	}
	public Apple(double pricePerKg, int stock)
	{
		super.pricePerKg = pricePerKg;
		super.stock = stock;
	}
	@Override
	public void updateStock(int val)
	{
		if (val < 0) {
			System.out.println("Negatif sayý girdiniz. Sipariþ alýnamadý!%n");
			return;
		}

		if (super.stock - val < 0) {
			System.out.printf("You can only order %d many apples%n", super.stock);
			System.out.println("Sipariþ alýnamadý!");
			return;
		}
		super.stock -= val;

	}
	@Override
	public String toString()
	{
		return String.format("%d many apple at price %.2f$ and it is worth " +
				"%.2f$", super.stock, super.pricePerKg, value());
	}
}
