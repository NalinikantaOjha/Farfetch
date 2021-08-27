package ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farfetch.R;

import Adapter.ChildHomeTwoAdapter;
import Model.HomeModel;

public class HomeTwoViewHolder extends RecyclerView.ViewHolder {
    private TextView Title;
    private TextView Details;
    private RecyclerView recyclerView;
    public HomeTwoViewHolder(@NonNull  View itemView) {
        super(itemView);

        initView(itemView);
    }

        private void initView(View itemView) {
            Title=itemView.findViewById(R.id.tvHomeItemTwoTitle);
            Details=itemView.findViewById(R.id.tvHomeItemTwoDescription);
            recyclerView=itemView.findViewById(R.id.home_item_two_recyclerview);

        }public void SetDataHomeViewHolderTwo(HomeModel homeModel){
            Title.setText(homeModel.getParentItemTitle());
            Details.setText(homeModel.getParentItemDetails());
            LinearLayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext(),
                    LinearLayoutManager.HORIZONTAL, false);
        layoutManager.setInitialPrefetchItemCount(homeModel.getChildItemListTwo().size());
        ChildHomeTwoAdapter childItemAdapter = new ChildHomeTwoAdapter(homeModel.getChildItemListTwo());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(childItemAdapter);


        }

}
