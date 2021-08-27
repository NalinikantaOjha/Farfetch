package Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farfetch.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Activity.PaymentActivity;
import Adapter.ProductAdapter;
import Interface.onProductClicked;
import Model.Payment;
import Model.ProductModel;
import Model.User;


public class ProductFragment extends Fragment implements onProductClicked {
    private final FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
    private final FirebaseDatabase firebaseDatabase =FirebaseDatabase.getInstance();
    private final DatabaseReference databaseReference=firebaseDatabase.
            getReference("parent").child("payment");

    RecyclerView homeRecycleView;
    ProductAdapter productAdapter;
    CardView cardView;
    TextView low;

    TextView New;

    List<ProductModel> ChildItemListTwo=new ArrayList<>();

    TextView sort;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_product, container, false);
        sort=view.findViewById(R.id.sort);
        low=view.findViewById(R.id.sortLow);
        New=view.findViewById(R.id.sortNew);
        cardView=view.findViewById(R.id.cardViewRefine);

        homeRecycleView=view.findViewById(R.id.recycleView_home);
        buildData();
        setLayout();
        sort.setOnClickListener(v -> cardView.setVisibility(View.VISIBLE));
        low.setOnClickListener(v -> {
            cardView.setVisibility(View.GONE);
            Collections.sort(ChildItemListTwo);
            productAdapter.notifyDataSetChanged();

        });
        New.setOnClickListener(v -> {
            cardView.setVisibility(View.GONE);
            Collections.sort(ChildItemListTwo,ProductModel.myName);
            productAdapter.notifyDataSetChanged();
        });
        return view;
    }
    private void setLayout() {
        productAdapter=new ProductAdapter(ChildItemListTwo,this);
        LinearLayoutManager layoutManager = new GridLayoutManager(this.getContext(),2);
        homeRecycleView.setLayoutManager(layoutManager);
        homeRecycleView.setAdapter(productAdapter);
    }

    private void buildData() {

        ChildItemListTwo.add(new ProductModel(R.drawable.recomandedfive,
                2000, "Palm Angels",
                " Fun Mix tweed jumper"));
        ChildItemListTwo.add(new ProductModel(R.drawable.recomandedforu,
                2827, "Palm Angels",
                " Fun Mix tweed jumper"));
        ChildItemListTwo.add(new ProductModel(R.drawable.recomandedthree,
                300, "Palm Angels",
                " Fun Mix tweed jumper"));
        ChildItemListTwo.add(new ProductModel(R.drawable.recomandedtwo,
                4000, "Palm Angels",
                " Fun Mix tweed jumper"));
        ChildItemListTwo.add(new ProductModel(R.drawable.recomandedfive,
                5000, "Palm Angels",
                " Fun Mix tweed jumper"));
        ChildItemListTwo.add(new ProductModel(R.drawable.recomandedforu,
                1000, "Palm Angels",
                " Fun Mix tweed jumper"));
        ChildItemListTwo.add(new ProductModel(R.drawable.recomandedthree,
                100, "Palm Angels",
                " Fun Mix tweed jumper"));
        ChildItemListTwo.add(new ProductModel(R.drawable.recomandedtwo,
                2827, "Palm Angels",
                " Fun Mix tweed jumper"));
    }




    @Override
    public void onProductClicked(ProductModel model, int position) {
        Payment payment=new Payment(model.getTwoTextPrice());
        databaseReference.setValue(payment);
        Intent intent =new Intent(this.getContext(), PaymentActivity.class);
        startActivity(intent);
        Toast.makeText(this.getContext(),"rtyuirtyuio",Toast.LENGTH_LONG).show();


    }
}