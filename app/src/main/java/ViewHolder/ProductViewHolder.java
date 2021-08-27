package ViewHolder;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farfetch.R;

import Interface.onProductClicked;
import Model.ProductModel;

public class ProductViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView textView;
    TextView textViewPrice;
    TextView textViewDetails;
    onProductClicked onProductClicked;

    public ProductViewHolder(@NonNull View itemView,onProductClicked onProductClicked) {
        super(itemView);
        initView(itemView);
        this.onProductClicked=onProductClicked;

    }
    private void initView(View itemView) {
        imageView=itemView.findViewById(R.id.IvChild_two_image);
        textView=itemView.findViewById(R.id.tvNameChildTwo);
        textViewDetails=itemView.findViewById(R.id.tvDetailsChildTwo);
        textViewPrice=itemView.findViewById(R.id.tvPriceChildTwo);

    }
    @SuppressLint("SetTextI18n")
    public void setDataProduct(ProductModel childHomeModel){
        imageView.setImageResource(childHomeModel.getTwoImage());
        textView.setText(childHomeModel.getTwoTextName());
        textViewDetails.setText(childHomeModel.getTwoTextDetails());
        textViewPrice.setText(childHomeModel.getTwoTextPrice()+"");
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onProductClicked.onProductClicked(childHomeModel,getAdapterPosition());
            }
        });

    }
}



