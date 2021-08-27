package Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.farfetch.R;

import Activity.SignUpActivity;


public class MyAccountBlankFragment extends Fragment {

   Button Signup;
   Button SignIn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_my_account_blank, container, false);
        Signup=view.findViewById(R.id.mBtnCreateAccountM);
        SignIn=view.findViewById(R.id.mBtnSignInM);
        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MyAccountBlankFragment.this.getContext(), SignUpActivity.class);
                startActivity(intent);
            }
        });
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MyAccountBlankFragment.this.getContext(), SignUpActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}