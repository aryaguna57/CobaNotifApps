package com.cobacoba.cobacoba;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.provider.DocumentsContract;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;
    Toolbar toolbar;
    NavigationView navigationView;
    FragmentManager fragmentManager;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private ArrayList<ItemRecyclerView> mItemRecyclerView;
    public int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        RelativeLayout layout = (RelativeLayout) findViewById(R.id.list_item_data);
//        layout.setVisibility(View.INVISIBLE);
//        LinearLayout layoutNoData = (LinearLayout) findViewById(R.id.no_list);
//        layoutNoData.setVisibility(View.VISIBLE);

//        if(count == 0){
//        } else if(count == 1){
//            createItem();
//            buildRecyclerView();
//        } else if(count > 1){
//            createNewItem();
//        }

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button btnAdd = findViewById(R.id.button_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent add = new Intent(MainActivity.this, AddActivity.class);
                startActivity(add);
            }
        });

        drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void createItem(){
        mItemRecyclerView = new ArrayList<>();
        mItemRecyclerView.add(new ItemRecyclerView(R.drawable.ic_circle_red,R.drawable.ic_circle_green,R.drawable.ic_monetization_yellow, R.drawable.ic_delete_red,"Title","SubTitle"));
        redStatus();
    }

    public void createNewItem(){
        mItemRecyclerView.add(new ItemRecyclerView(R.drawable.ic_circle_red,R.drawable.ic_circle_green,R.drawable.ic_monetization_yellow, R.drawable.ic_delete_red,"Title","SubTitle"));
        redStatus();
    }

    public void itemHasOpen(){
        greenStatus();
    }

    public void buildRecyclerView(){
        mRecyclerView = findViewById(R.id.rv_main);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new MyAdapter(mItemRecyclerView);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onBackPressed() {
        drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_settings){
            Intent add = new Intent(this, AddActivity.class);
            startActivity(add);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.nav_feedback){
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_EMAIL, "emailaddress@emailaddress.com");
            intent.putExtra(Intent.EXTRA_TEXT, "Please write the feedback for this apps.");
            startActivity(Intent.createChooser(intent, "Send Email"));

        }else if(id == R.id.nav_about){
            final Dialog dialog = new Dialog(MainActivity.this);
            dialog.setContentView(R.layout.activity_popup);
            Button dialogButton = dialog.findViewById(R.id.button_close_about);
            dialogButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
            dialog.show();
        }

        drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

//    public void adaData(){
//        RelativeLayout layout = findViewById(R.id.list_item_data);
//        layout.setVisibility(View.VISIBLE);
//        LinearLayout layoutNoData = findViewById(R.id.no_list);
//        layoutNoData.setVisibility(View.GONE);
//        redStatus();
//        Intent data = getIntent();
//        String text = data.getStringExtra(AddActivity.EXTRA_TEXT);
//    }

    public void redStatus(){
        ImageView stGreen = findViewById(R.id.status_green);
        ImageView stRed = findViewById(R.id.status_red);

        stRed.setVisibility(View.VISIBLE);
        stGreen.setVisibility(View.GONE);
    }

    public void greenStatus(){
        ImageView stGreen = findViewById(R.id.status_green);
        ImageView stRed = findViewById(R.id.status_red);

        stRed.setVisibility(View.GONE);
        stGreen.setVisibility(View.VISIBLE);
    }

    /*private void callFragment(Fragment fragment) {
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frame_container, fragment)
                .commit();
    }*/

}
