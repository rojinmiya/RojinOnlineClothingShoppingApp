package com.rojinonlineclothingshoppingapp;



import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import Fragments.LoginFragment;
import Fragments.RegistrationFragment;
import adapter.ViewPageAdapter;


public class MainActivity extends AppCompatActivity {

private ViewPager viewPager;
private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout=findViewById(R.id.tabId);
        viewPager=findViewById(R.id.viewPager);

        ViewPageAdapter adapter=new ViewPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new LoginFragment(),"Login");
        adapter.addFragment(new RegistrationFragment(),"Registration");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);












    }


}

