package Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.farfetch.R;

import Fragment.FragmentActivity;

public class MainActivity extends AppCompatActivity {
int SPLASH_DISPLAY_LENGTH=2150;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(() -> {

            Intent mainIntent = new Intent(MainActivity.this, FragmentActivity.class);
            MainActivity.this.startActivity(mainIntent);
            finish();
        }, SPLASH_DISPLAY_LENGTH);
    }
}