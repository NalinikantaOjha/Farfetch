package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farfetch.R;

import java.util.List;


import Interface.onProductClicked;
import Model.ProductModel;
import ViewHolder.ProductViewHolder;

public class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder>{
    onProductClicked onProductClicked;
    List<ProductModel> productModelList;

    public ProductAdapter(List<ProductModel> productModelList,onProductClicked onProductClicked) {
        this.productModelList=productModelList;
        this.onProductClicked=onProductClicked;
    }

    @NonNull

    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item_layout,parent,false);
        return new ProductViewHolder(view,onProductClicked);
    }

    @Override
    public void onBindViewHolder(@NonNull  ProductViewHolder holder, int position) {
      ProductModel productModel=productModelList.get(position);
      holder.setDataProduct(productModel);

    }

    @Override
    public int getItemCount() {
        return productModelList.size();
    }
}


