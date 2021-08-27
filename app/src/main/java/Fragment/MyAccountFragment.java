package Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.farfetch.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import Model.Payment;
import Model.User;


public class MyAccountFragment extends Fragment {
    private final FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
    Button button;
    private TextView mEmail,mName,payment;
    private final FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    private final DatabaseReference databaseReference =firebaseDatabase.
            getReference("parent");


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_my_account, container, false);
        button=view.findViewById(R.id.SignOut2);
        mEmail=view.findViewById(R.id.email2);
        mName=view.findViewById(R.id.name2);
        payment=view.findViewById(R.id.name3);
        button.setOnClickListener(v -> {
            firebaseAuth.signOut();
            Intent intent=new Intent(this.getContext(), FragmentActivity.class);
            startActivity(intent);
        });
        return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        databaseReference.child("payment").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                GenericTypeIndicator<Payment>genericTypeIndicator=new GenericTypeIndicator<Payment>() {
                };
                Payment student1=snapshot.getValue(genericTypeIndicator);
                payment.setText(student1.getPaymentNalini()+"");
            }

            @Override
            public void onCancelled(@NonNull  DatabaseError error) {

            }
        });
        if (firebaseAuth.getCurrentUser()!=null) {
            GenericTypeIndicator<User> genericTypeIndicator = new
                    GenericTypeIndicator<User>() {
                    };
            databaseReference.child(firebaseAuth.getCurrentUser().
                    getUid()).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    User user = snapshot.getValue(genericTypeIndicator);
                    mName.setText(user.getName());
                    mEmail.setText(user.getEmail());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        }


    }
}