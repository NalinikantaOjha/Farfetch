package ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farfetch.R;

import Model.ChildHomeModelTwo;

public class ChildHomeTwoViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView textView;
    TextView textViewPrice;
    TextView textViewDetails;

    public ChildHomeTwoViewHolder(@NonNull  View itemView) {
        super(itemView);
        initView(itemView);
    }

    private void initView(View itemView) {
        imageView=itemView.findViewById(R.id.IvChild_two_image);
        textView=itemView.findViewById(R.id.tvNameChildTwo);
        textViewDetails=itemView.findViewById(R.id.tvDetailsChildTwo);
        textViewPrice=itemView.findViewById(R.id.tvPriceChildTwo);

    }
    public void setDataChildHomeTwo(ChildHomeModelTwo childHomeModel){
        imageView.setImageResource(childHomeModel.getChildHomeTwoImage());
        textView.setText(childHomeModel.getChildHomeTwoTextName());
        textViewDetails.setText(childHomeModel.getChildHomeTwoTextDetails());
        textViewPrice.setText(childHomeModel.getChildHomeTwoTextPrice()+"");
    }
}
