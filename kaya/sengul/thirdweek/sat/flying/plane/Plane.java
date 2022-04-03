package kaya.sengul.thirdweek.sat.flying.plane;

import kaya.sengul.thirdweek.sat.flying.plane.IFoodService;

import java.util.stream.Collector;

public abstract class Plane implements IFoodService {
    protected final int capacity;
    protected String brand;
    protected String code;

    private void setCodeForPlane()
    {
        this.code = brand.chars().
                filter(ch -> Character.isUpperCase((char)ch)).
                mapToObj(ch -> (char) ch).
                collect(Collector.of(StringBuilder :: new, StringBuilder::append, StringBuilder::append,
                        StringBuilder :: toString));
    }
    protected Plane(int capacity, String brand)
    {
        this.capacity = capacity;
        this.brand = brand;
        setCodeForPlane();
    }

    public int getCapacity() {
        return capacity;
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCode() {
        return code;
    }
}
