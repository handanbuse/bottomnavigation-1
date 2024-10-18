package com.example.bottomnavigation_1;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mBottombar;
    private HomeFragment homeFragment;
    private ProfileFragment profileFragment;
    private SearchFragment searchFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBottombar=findViewById(R.id.mainActivity_bottomnav);
        homeFragment= new HomeFragment();
        profileFragment= new ProfileFragment();
        searchFragment= new SearchFragment();

        setFragment(homeFragment); // başlangıçta seçili gelsin
        //tıklanınca olayın tetiklenmesi için
        mBottombar.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.bottombar_menuhome) {
                    setFragment(homeFragment); // homefragmenti içine gönder tıklayınca
                    return true;
                } else if (item.getItemId() == R.id.bottombar_menuprofile) {
                    setFragment(profileFragment);
                    return true;
                } else if (item.getItemId() == R.id.bottombar_menusearch) {
                 setFragment(searchFragment);
                    return true;
                }
                else return false;
            }
        });

    }

    // fragmnet burada tanımlandı
    private  void setFragment(Fragment fragment){
        FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.mainActivity_frame,fragment);
        transaction.commit();

    }
}