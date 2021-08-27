package ViewHolder;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farfetch.R;

import Model.ChildHomeModel;

public class ChildHomeViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    CardView cardView;

    public ChildHomeViewHolder(@NonNull  View itemView) {
        super(itemView);

        initView(itemView);
    }

    private void initView(View itemView) {
        imageView=itemView.findViewById(R.id.img_child_item);
        cardView=itemView.findViewById(R.id.cardHomeChild);


    }
    public void setDataChildHome(ChildHomeModel childHomeModel){
        imageView.setImageResource(childHomeModel.getChildHomeImage());


    }
}
