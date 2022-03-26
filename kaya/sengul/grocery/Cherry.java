package kaya.sengul.grocery;

public class Cherry extends Fruit {
	
	@Override
	public double value()
	{
		return stock * pricePerKg;
	}
	public Cherry(double pricePerKg, int stock)
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

		if (stock - val < 0) {
			System.out.printf("You can only order %d many cherries%n", stock);
			System.out.println("Sipariþ alýnamadý!");
			return;
		}

		super.stock -= val;

	}
	@Override
	public String toString()
	{
		return String.format("%d many cherry at price %.2f$ and it is worth " +
				"%.2f$", stock, pricePerKg, value());
	}

}
