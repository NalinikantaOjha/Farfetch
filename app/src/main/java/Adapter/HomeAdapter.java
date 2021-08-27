package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farfetch.R;

import java.util.List;

import Interface.OnClicked;
import Model.HomeModel;
import ViewHolder.BuyNowViewHolder;
import ViewHolder.HomeOneViewHolder;
import ViewHolder.HomeThreeViewHolder;
import ViewHolder.HomeTwoViewHolder;

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
     List<HomeModel> homeModelList;
     OnClicked onClicked;
     OnClicked onItemClicked;



    public HomeAdapter(List<HomeModel> homeModelList,OnClicked onClicked,OnClicked onItemClicked) {
        this.homeModelList = homeModelList;
        this.onClicked=onClicked;
        this.onItemClicked=onItemClicked;


    }

    @NonNull

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        switch (viewType) {
            case HomeModel.TEXT_TYPE_FOUR:
                View view1=LayoutInflater.from(parent.getContext()).inflate(R.layout.button_layout,
                        parent,false);
                return new BuyNowViewHolder(view1,onClicked);

            case HomeModel.TEXT_TYPE:
                View imageViewType = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item, parent, false);
                return new HomeOneViewHolder(imageViewType,onClicked);
            case HomeModel.TEXT_TYPE_TWO:
                View textViewType = LayoutInflater.from(parent.getContext()).
                        inflate(R.layout.home_item_two, parent, false);
                return new HomeTwoViewHolder(textViewType);
            case HomeModel.TEXT_TYPE_THREE:
                View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item_three,
                        parent,false);
                return new HomeThreeViewHolder(view,onClicked);
        }
       return null;
    }

    @Override
    public void onBindViewHolder(@NonNull  RecyclerView.ViewHolder holder, int position) {
        int viewType = homeModelList.get(position).getType();
        HomeModel homeModel = homeModelList.get(position);

        switch (viewType) {

            case HomeModel.TEXT_TYPE:
                if (holder instanceof HomeOneViewHolder) {
                    ((HomeOneViewHolder) holder).SetDataHomeViewHolderOne(homeModel);
                }
                break;
            case HomeModel.TEXT_TYPE_TWO:
                if (holder instanceof HomeTwoViewHolder) {
                    ((HomeTwoViewHolder) holder).SetDataHomeViewHolderTwo(homeModel);
                }
                case HomeModel.TEXT_TYPE_THREE:
                    if (holder instanceof HomeThreeViewHolder){
                        ((HomeThreeViewHolder)holder).setDataHomeThreeViewHolder(homeModel);
                    }
            case HomeModel.TEXT_TYPE_FOUR:
                if (holder instanceof BuyNowViewHolder){
                    ((BuyNowViewHolder)holder).setDataButtoViewHolder(homeModel);
                }

        }

    }

    @Override
    public int getItemCount() {
        return homeModelList.size();
    }

    @Override
    public int getItemViewType(int position) {
        int itemType = homeModelList.get(position).getType();
        switch (itemType) {
            case HomeModel.TEXT_TYPE:
                return HomeModel.TEXT_TYPE;
            case HomeModel.TEXT_TYPE_TWO:
                return HomeModel.TEXT_TYPE_TWO;
                case HomeModel.TEXT_TYPE_THREE:
                    return HomeModel.TEXT_TYPE_THREE;
                    case HomeModel.TEXT_TYPE_FOUR:
                        return HomeModel.TEXT_TYPE_FOUR;

        }
        return -1;
    }
    }

