package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farfetch.R;

import java.util.List;

import Model.ChildHomeModelTwo;
import ViewHolder.ChildHomeTwoViewHolder;

public class ChildHomeTwoAdapter extends RecyclerView.Adapter<ChildHomeTwoViewHolder> {
    List<ChildHomeModelTwo> childHomeModelTwoList;

    public ChildHomeTwoAdapter(List<ChildHomeModelTwo> childHomeModelTwoList) {
       this.childHomeModelTwoList=childHomeModelTwoList;
    }




    @NonNull

    @Override
    public ChildHomeTwoViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.home_child_two,parent,false);
        return new ChildHomeTwoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  ChildHomeTwoViewHolder holder, int position) {
        ChildHomeModelTwo childHomeModelTwo=childHomeModelTwoList.get(position);
        holder.setDataChildHomeTwo(childHomeModelTwo);


    }

    @Override
    public int getItemCount() {
        return childHomeModelTwoList.size();
    }
}
