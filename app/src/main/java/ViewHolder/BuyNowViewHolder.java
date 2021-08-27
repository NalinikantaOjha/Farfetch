package ViewHolder;

import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farfetch.R;

import Interface.OnClicked;
import Model.HomeModel;

public class BuyNowViewHolder extends RecyclerView.ViewHolder {

        Button BuyNow;
        OnClicked onItemClicked;


    public BuyNowViewHolder(@NonNull  View itemView,OnClicked onClicked) {
        super(itemView);
        initView(itemView);
        this.onItemClicked=onClicked;
    }

    private void initView(View itemView) {
            BuyNow=itemView.findViewById(R.id.mBtnBuyNow);

        }
        public void setDataButtoViewHolder(HomeModel homeModel){
        BuyNow.setOnClickListener(v -> onItemClicked.onItemClicked(homeModel,getAdapterPosition()));

        }

    }

