package Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.farfetch.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FragmentActivity2 extends AppCompatActivity {
    BottomNavigationView bnv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment2);
        fragmentscreens();
    }
    @SuppressLint("NonConstantResourceId")
    private void fragmentscreens() {
        getSupportFragmentManager().beginTransaction().replace(R.id.mainframe2, new DisplayFragment()).commit();
        initview();
        bnv.setOnNavigationItemSelectedListener(item -> {
            Fragment temp=null;
            switch (item.getItemId()) {


                case R.id.menu_wish:
                    temp=new DisplayFragment();
                    break;
                case R.id.menu_home:
                    temp=new DisplayFragment();
                    break;
                case R.id.menu_search:
                    temp=new DisplayFragment();
                    break;
                case R.id.account:
                    temp=new MyAccountFragment();
                    break;

            }

            getSupportFragmentManager().beginTransaction().replace(R.id.mainframe2, temp).commit();
            return true;
        });

    }


    private void initview() {
        bnv = findViewById(R.id.bottomNavigation2);

    }




}