package com.miguello.apppets;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.miguello.apppets.adapter.MascotasAdaptador;
import com.miguello.apppets.adapter.PageAdapter;
import com.miguello.apppets.fragments.fragment_recyclerview;
import com.miguello.apppets.fragments.perfil_mascota;
import com.miguello.apppets.pojo.Mascotas;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    private Toolbar miActionBar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miActionBar     = (Toolbar) findViewById(R.id.miActionBar);
        tabLayout       = (TabLayout) findViewById(R.id.tabLayout);
        viewPager       = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();

        if (miActionBar != null){
            setSupportActionBar(miActionBar);
        }


    }


    private ArrayList<Fragment> agregarFragments(){  //aquí estamos trayendo el Adaptador de Fragments del PageAdapter para agregra fragments
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new fragment_recyclerview());
        fragments.add(new perfil_mascota());

        return fragments;
    }


    private void setUpViewPager(){ // aquí estoy setteando el viewPager para agregarlo a cada fragment
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);


        tabLayout.getTabAt(0).setIcon(R.drawable.seal);
        tabLayout.getTabAt(1).setIcon(R.drawable.paw);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.action_estrella:
                Intent intent = new Intent(this, MascotasLike.class);
                startActivity(intent);
                break;

            case R.id.action_contacto:
                Intent intent1 = new Intent(this, activity_contacto.class);
                startActivity(intent1);
                break;

            case R.id.action_settings:
                Intent intent2 = new Intent(this, activity_aboutme.class);
                startActivity(intent2);
                break;

            default:
                break;
        }

        return true;
    }

}
