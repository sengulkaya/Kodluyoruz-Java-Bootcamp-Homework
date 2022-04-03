package kaya.sengul.thirdweek.sat.flying.plane;

public class TurkishAirlines extends Plane implements IFoodService {
    public TurkishAirlines(int capacity, String brand) {
        super(capacity, brand);
    }

    @Override
    public void serveFood(boolean international)
    {
        if (!international) {
            System.out.println("Turkish Airlines food service for domestic flights");
            return;
        }
        System.out.println("Turkish Airlines food service for international flights");
    }
}
