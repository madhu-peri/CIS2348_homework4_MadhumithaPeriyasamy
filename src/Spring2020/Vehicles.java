package Spring2020;

public class Vehicles {
    private double price = 100000;
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
    public Porsche()
    {
        System.out.println("The Porsche's price is: " + this.getPrice());
    }
}

class Prius extends Vehicles
{
    public Prius(double price, double mlg)
    {
        this.setPrice(price);
        this.setMileage(mlg);
    }
}
