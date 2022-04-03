package kaya.sengul.thirdweek.sat.flying.plane;

public class PegasusAirlines extends Plane implements IFoodService {
    public PegasusAirlines(int capacity, String brand) {
        super(capacity, brand);
    }
    @Override
    public void serveFood(boolean international)
    {
        if (!international) {
            System.out.println("Pegasus Airlines food service for domestic flights");
            return;
        }
        System.out.println("Pegasus Airlines food service for international flights");
    }
}
