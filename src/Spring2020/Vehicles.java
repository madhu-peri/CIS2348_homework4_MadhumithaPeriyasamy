package Spring2020;

import static java.lang.String.format;

public class Vehicles {
    private double price;
    private double mileage;

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}

class Porsche extends Vehicles
{
    public Porsche(double price)

    {
        this.setPrice(price);
        System.out.println("The Porsche's price is: $" + format("%.2f",this.getPrice()));
    }
}

class Prius extends Vehicles
{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Prius(double price, double mlg)
    {
        this.setPrice(price);
        this.setMileage(mlg);
    }

}
