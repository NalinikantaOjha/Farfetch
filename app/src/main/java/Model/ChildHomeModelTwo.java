package Model;

public class ChildHomeModelTwo {
    private final int childHomeTwoImage;
    private final int childHomeTwoTextPrice;
    private final String childHomeTwoTextName;
    private final String childHomeTwoTextDetails;

    public ChildHomeModelTwo(int childHomeTwoImage, int childHomeTwoTextPrice,
                             String childHomeTwoTextName, String childHomeTwoTextDetails) {
        this.childHomeTwoImage = childHomeTwoImage;
        this.childHomeTwoTextPrice = childHomeTwoTextPrice;
        this.childHomeTwoTextName = childHomeTwoTextName;
        this.childHomeTwoTextDetails = childHomeTwoTextDetails;
    }

    public int getChildHomeTwoImage() {
        return childHomeTwoImage;
    }

    public int getChildHomeTwoTextPrice() {
        return childHomeTwoTextPrice;
    }

    public String getChildHomeTwoTextName() {
        return childHomeTwoTextName;
    }

    public String getChildHomeTwoTextDetails() {
        return childHomeTwoTextDetails;
    }
}
