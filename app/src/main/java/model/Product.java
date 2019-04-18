package model;

import java.io.Serializable;

public class Product implements Serializable {

    private String productimage;
    private String productName;
    private float cost;
    private int fees;

    public Product(String productimage, String productName, float cost, int fees) {
        this.productimage = productimage;
        this.productName = productName;
        this.cost = cost;
        this.fees = fees;
    }

    public String getProductimage() {
        return productimage;
    }

    public String getProductName() {
        return productName;
    }

    public float getCost() {
        return cost;
    }

    public int getFees() {
        return fees;
    }

    @Override
    public String toString() {
//        return " " +
//                "productimage= " + productimage + "\n" +
//                "productName= " + productName + "\n" +
//                "cost= " + cost + "\n" +
//                "fees= " + fees + "\n"
//                ;

        return productName;
    }
}
