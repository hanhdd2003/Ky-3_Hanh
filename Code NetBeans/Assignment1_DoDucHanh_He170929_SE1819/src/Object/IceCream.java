package object;


public class IceCream {
    private String iceID;
    private String name;
    private String type;
    private double price;

    public IceCream(String iceID, String name, String type, double price) {
        this.iceID = iceID;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getIceID() {
        return iceID;
    }

    public void setIceID(String iceID) {
        this.iceID = iceID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
}
