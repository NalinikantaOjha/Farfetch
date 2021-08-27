package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farfetch.R;

import java.util.List;

import Model.ChildHomeModel;
import ViewHolder.ChildHomeViewHolder;

public class ChildHomeAdapter extends RecyclerView.Adapter<ChildHomeViewHolder> {
    List<ChildHomeModel>childHomeModelList;


    public ChildHomeAdapter(List<ChildHomeModel> childHomeModelList) {
        this.childHomeModelList = childHomeModelList;

    }

    @NonNull

    @Override
    public ChildHomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.home_child_item,parent,false);
        return new ChildHomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  ChildHomeViewHolder holder, int position) {
        ChildHomeModel childHomeModel=childHomeModelList.get(position);
        holder.setDataChildHome(childHomeModel);

    }

    @Override
    public int getItemCount() {
        return childHomeModelList.size();
    }
}
