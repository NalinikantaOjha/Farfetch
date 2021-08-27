package Model;

import java.util.List;

public class HomeModel {
    public static final int TEXT_TYPE = 0;
    public static final int TEXT_TYPE_TWO = 1;
    public static final int TEXT_TYPE_THREE = 2;
    public  static  final int TEXT_TYPE_FOUR=3;
    private final int Type;
    private final String ParentItemTitle;
    private final String  ParentItemDetails;
    private final List<ChildHomeModel> ChildItemList;
    private final List<ChildHomeModelTwo>ChildItemListTwo;

    public HomeModel(int Type, String parentItemTitle, String parentItemDetails, List<ChildHomeModel> childItemList, List<ChildHomeModelTwo> childItemListTwo) {
        ParentItemTitle = parentItemTitle;
        ParentItemDetails = parentItemDetails;
        ChildItemList = childItemList;
        this.Type=Type;
        ChildItemListTwo = childItemListTwo;
    }



    public int getType() {
        return Type;
    }

    public String getParentItemTitle() {
        return ParentItemTitle;
    }

    public String getParentItemDetails() {
        return ParentItemDetails;
    }

    public List<ChildHomeModel> getChildItemList() {
        return ChildItemList;
    }

    public List<ChildHomeModelTwo> getChildItemListTwo() {
        return ChildItemListTwo;
    }
}
