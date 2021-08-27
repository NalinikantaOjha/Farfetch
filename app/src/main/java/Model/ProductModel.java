package Model;

import java.util.Comparator;

public class ProductModel implements Comparable<ProductModel> {
    int TwoImage;
    int TwoTextPrice;
    String TwoTextName;
    String TwoTextDetails;

    public ProductModel(int twoImage, int twoTextPrice, String twoTextName, String twoTextDetails) {
        TwoImage = twoImage;
        TwoTextPrice = twoTextPrice;
        TwoTextName = twoTextName;
        TwoTextDetails = twoTextDetails;

    }

    public int getTwoImage() {
        return TwoImage;
    }

    public int getTwoTextPrice() {
        return TwoTextPrice;
    }

    public String getTwoTextName() {
        return TwoTextName;
    }

    public String getTwoTextDetails() {
        return TwoTextDetails;
    }
public static Comparator<ProductModel>myName= (o1, o2) -> o1.getTwoTextName().compareTo(o2.getTwoTextName());


    @Override
    public int compareTo(ProductModel o) {
        return this.TwoTextPrice - o.getTwoTextPrice();
    }
}