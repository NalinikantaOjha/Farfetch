package ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farfetch.R;

import Adapter.ChildHomeAdapter;
import Interface.OnClicked;
import Model.HomeModel;

public class HomeOneViewHolder extends RecyclerView.ViewHolder {
    private TextView Title;
    private RecyclerView recyclerView;
    OnClicked onItemClicked;


    public HomeOneViewHolder(@NonNull  View itemView ,OnClicked onItemClicked) {
        super(itemView);

        initView(itemView);
        this.onItemClicked=onItemClicked;

    }

    private void initView(View itemView) {
        Title=itemView.findViewById(R.id.tvHomeItemOneTitle);
        recyclerView=itemView.findViewById(R.id.home_item_one_recyclerview);

    }public void SetDataHomeViewHolderOne(HomeModel homeModel){
        Title.setText(homeModel.getParentItemTitle());
        LinearLayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext(),
                LinearLayoutManager.HORIZONTAL, false);
        layoutManager.setInitialPrefetchItemCount(homeModel.getChildItemList().size());
        ChildHomeAdapter childItemAdapter = new ChildHomeAdapter(homeModel.getChildItemList());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(childItemAdapter);


Title.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        onItemClicked.onItemClicked(homeModel,getAdapterPosition());
    }
});

            }





}
