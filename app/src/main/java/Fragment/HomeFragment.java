package Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farfetch.R;

import java.util.ArrayList;
import java.util.List;

import Activity.SignUpActivity;
import Adapter.HomeAdapter;
import Interface.OnClicked;
import Model.ChildHomeModel;
import Model.ChildHomeModelTwo;
import Model.HomeModel;


public class HomeFragment extends Fragment implements OnClicked {

    RecyclerView homeRecycleView;
    HomeAdapter homeAdapter;
    List<HomeModel> homeModelList=new ArrayList<>();
    ImageView IvBag;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        homeRecycleView=view.findViewById(R.id.recycleView_home);
        IvBag=view.findViewById(R.id.IvBag);
        HomeBuildData();
        setLayout();

return view;
    }


    private void HomeBuildData(){

        HomeModel item3 =new HomeModel(HomeModel.TEXT_TYPE_THREE,null,
                null,null, null);
        homeModelList.add(item3);
        for(int i =0;i<10;i++) {
            HomeModel item = new HomeModel(HomeModel.TEXT_TYPE, "First look: fall layers",
                    null, ChildBuildData(), null);
            homeModelList.add(item);
            HomeModel item5 = new HomeModel(HomeModel.TEXT_TYPE_FOUR, null,
                    null, null, null);
            homeModelList.add(item5);


            HomeModel item1 = new HomeModel(HomeModel.TEXT_TYPE_TWO, "New in",
                    "Hand-picked daily from the world's best brands and boutiques"
                    , null,ChildBuildDataTwo());
            homeModelList.add(item1);

        }
    }private void setLayout(){
        homeAdapter=new HomeAdapter(homeModelList,this,this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        homeRecycleView.setLayoutManager(layoutManager);
        homeRecycleView.setAdapter(homeAdapter);
    }
    private List<ChildHomeModel> ChildBuildData() {
        List<ChildHomeModel> ChildItemList = new ArrayList<>();
        ChildItemList.add(new ChildHomeModel(R.drawable.firstlookone));
        ChildItemList.add(new ChildHomeModel(R.drawable.firstlooktwo));
        ChildItemList.add(new ChildHomeModel(R.drawable.firstlookthree));
        return ChildItemList;
    }
    private List<ChildHomeModelTwo> ChildBuildDataTwo() {
        List<ChildHomeModelTwo> ChildItemListTwo = new ArrayList<>();
        for (int i =0;i<10;i++) {
            ChildItemListTwo.add(new ChildHomeModelTwo(R.drawable.recomandedfive,
                    2827, "Palm Angels",
                    " Fun Mix tweed jumper"));
            ChildItemListTwo.add(new ChildHomeModelTwo(R.drawable.recomandedforu,
                    2827, "Palm Angels",
                    " Fun Mix tweed jumper"));
            ChildItemListTwo.add(new ChildHomeModelTwo(R.drawable.recomandedthree,
                    2827, "Palm Angels",
                    " Fun Mix tweed jumper"));
            ChildItemListTwo.add(new ChildHomeModelTwo(R.drawable.recomandedtwo,
                    2827, "Palm Angels",
                    " Fun Mix tweed jumper"));
        }
        return ChildItemListTwo;
    }

    @Override
    public void onButtonClicked(HomeModel model, int position) {

        Intent intent =new Intent(this.getContext(), SignUpActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemClicked(HomeModel model, int position) {



    }

}