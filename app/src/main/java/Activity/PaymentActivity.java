package Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.farfetch.R;

public class PaymentActivity extends AppCompatActivity {
    private ImageView ivDebitCard;
    private ImageView ivCreditCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        initView();
        Toast.makeText(this,"We will add a feature so that you will be able to pay all the payment mode",Toast.LENGTH_LONG).show();
        ivDebitCard.setOnClickListener(v -> {
            Intent intent=new Intent(PaymentActivity.this, CardActivity.class);
            startActivity(intent);
        });
        ivCreditCard.setOnClickListener(v -> {
            Intent intent=new Intent(PaymentActivity.this,CardActivity.class);
            startActivity(intent);
        });


    }

    private void initView() {
        ivDebitCard=findViewById(R.id.debitcard);
        ivCreditCard=findViewById(R.id.creditcard);

    }
}