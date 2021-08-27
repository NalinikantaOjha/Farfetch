package Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.farfetch.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

import Fragment.FragmentActivity2;
import Model.User;

public class SignUpActivity extends AppCompatActivity {
    LinearLayout Signup;
    LinearLayout SignIn;
    EditText etName,etEmail,etPass;
    EditText etCEmail;
    EditText etCPass;
    Button mBtnRegister,mBtnSignIn;
TextView tvSignIn;
TextView tvRegisterAsNew;
    private final FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
    private final FirebaseDatabase firebaseDatabase =FirebaseDatabase.getInstance();
    private final DatabaseReference databaseReference=firebaseDatabase.
            getReference("parent");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initView();
        
mBtnSignIn.setOnClickListener(v -> firebaseAuth.signInWithEmailAndPassword(etEmail.getText().toString(),etPass.getText().toString()).addOnCompleteListener(task -> {
    if (task.isSuccessful()) {
        Intent intent = new Intent(getBaseContext(), FragmentActivity2.class);
        startActivity(intent);
    }
}).addOnFailureListener(e -> {
    Toast.makeText(getBaseContext(),"Invalid username or Password",Toast.LENGTH_LONG).show();
e.printStackTrace();
}));



        tvSignIn.setOnClickListener(v -> {
            Signup.setVisibility(View.GONE);
            SignIn.setVisibility(View.VISIBLE);

            });

tvRegisterAsNew.setOnClickListener(v -> {
    SignIn.setVisibility(View.GONE);
    Signup.setVisibility(View.VISIBLE);
});



        mBtnRegister.setOnClickListener(v -> {

            if(VALIDATE()){
                firebaseAuth.createUserWithEmailAndPassword(etCEmail.getText().toString(),etCPass.getText().toString())
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()){
                                User user=new User(
                                        etName.getText().toString(),
                                        etCEmail.getText().toString()
                                );
                                databaseReference.child(Objects.requireNonNull(firebaseAuth.getCurrentUser()).getUid())
                                        .setValue(user)
                                        .addOnCompleteListener(task1 -> {
                                            Intent intent=new Intent(getBaseContext(), FragmentActivity2.class);
                                            startActivity(intent);


                                        });

                            }
                        });


            }
        });

    }

    private void initView() {
        tvSignIn=findViewById(R.id.textSignIn);
        tvRegisterAsNew=findViewById(R.id.textRegisterAsNew);
        SignIn=findViewById(R.id.SignInLayout);
        Signup=findViewById(R.id.SignUpLayout);
        etName=findViewById(R.id.etName);
       etCEmail=findViewById(R.id.etCEmail);
       etCPass=findViewById(R.id.etCPass);
       mBtnRegister=findViewById(R.id.mBtnRegister);
       etEmail=findViewById(R.id.etEmail);
       etPass=findViewById(R.id.etPass);
       mBtnSignIn=findViewById(R.id.mBtnSignIn);

    }

    private boolean VALIDATE() {
        boolean isVlid = true;
        if (!Patterns.EMAIL_ADDRESS.matcher(etCEmail.getText().toString()).matches()) {
            etCEmail.setError("Invalid Email");
            isVlid=false;

        }if (etCPass.getText().toString().length()<4){
            etCPass.setError("pass is too short");
            isVlid =false;
        }
        return isVlid;
    }
}