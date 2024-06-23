package com.example.receptsapp;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class homePage extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.profile);
    }

    Profile profile = new Profile();
    Favorites favorites = new Favorites();

    FragmentPopular popular = new FragmentPopular();
    Categories categories = new Categories();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.profile) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment, profile).commit();
            return true;
        } else if (item.getItemId() == R.id.favorites) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment, favorites).commit();
            return true;
        }

        else if (item.getItemId() == R.id.popular) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment, popular).commit();
            return true;
        }
        else if (item.getItemId() == R.id.categories) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment, categories).commit();
            return true;
        }
        return false;
    }


}
