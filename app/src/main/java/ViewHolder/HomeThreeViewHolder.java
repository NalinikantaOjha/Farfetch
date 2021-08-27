package ViewHolder;

import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farfetch.R;

import Interface.OnClicked;
import Model.HomeModel;

public class HomeThreeViewHolder extends RecyclerView.ViewHolder {
    Button button;
    Button SignIn;
    OnClicked onButtonClicked;
    public HomeThreeViewHolder(@NonNull  View itemView, OnClicked onClicked) {
        super(itemView);
        initView(itemView);
        this.onButtonClicked=onClicked;
    }

    private void initView(View itemView) {
        SignIn=itemView.findViewById(R.id.mBtnSignIn);
        button =itemView.findViewById(R.id.mBtnCreateAccount);
    }
    public void setDataHomeThreeViewHolder(HomeModel homeModel){
     button.setOnClickListener(v -> onButtonClicked.
             onButtonClicked(homeModel,getAdapterPosition()));
SignIn.setOnClickListener(v -> onButtonClicked.onButtonClicked(homeModel,getAdapterPosition()));
    }

}
