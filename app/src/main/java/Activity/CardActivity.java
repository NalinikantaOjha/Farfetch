package Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.farfetch.R;

import Fragment.FragmentActivity2;

public class CardActivity extends AppCompatActivity {
    private EditText CardNumber;
    private EditText Month;
    private EditText Ccv;
    private Button PayNow;
    private EditText Year;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        initView();
        PayNow.setOnClickListener(v -> {
            boolean cardNumber = cardNumber();
            boolean month = year();
            boolean year = month();
            boolean ccv=ccv();
            if(cardNumber&&month&&year&&ccv){
                Toast.makeText(CardActivity.this,"Payment Success",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(CardActivity.this, FragmentActivity2.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        CardNumber = findViewById(R.id.etCardNumber);
        Month = findViewById(R.id.etMonth);
        Year = findViewById(R.id.etYear);
        Ccv = findViewById(R.id.etCcv);
        PayNow = findViewById(R.id.mBtnPayNow);
    }

    private boolean cardNumber() {
        if (CardNumber.getText().toString().length() == 16) {
            return true;
        } else {
            CardNumber.setError("Invalid card number");
            return false;
        }
    }

    private boolean ccv() {
        if (Ccv.getText().toString().length() >= 3) {
            return true;
        } else {
            Ccv.setError("Invalid ccv");
            return false;
        }
    }

    private boolean month() {
        if (Month.getText().toString().trim().length() >= 2) {
            return true;
        } else {
            Month.setError("Invalid month");
            return false;
        }
    }
    private boolean year() {
        if (Year.getText().toString().trim().length() >= 2) {
            return true;
        } else {
            Year.setError("Invalid year");
            return false;
        }
    }
}