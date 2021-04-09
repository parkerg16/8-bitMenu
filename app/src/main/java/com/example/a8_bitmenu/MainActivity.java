package com.example.a8_bitmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.example.a8_bitmenu.adapter.MyDrinkAdapter;
import com.example.a8_bitmenu.listener.ICartLoadListener;
import com.example.a8_bitmenu.listener.IDrinkLoadListener;
import com.example.a8_bitmenu.model.CartModel;
import com.example.a8_bitmenu.model.DrinkModel;
import com.example.a8_bitmenu.utils.SpaceItemDecoration;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nex3z.notificationbadge.NotificationBadge;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    @BindView(R.id.drawer_layout)
    RelativeLayout drawer_layout;

//    @BindView(R.id.recycler_drink)
//    RecyclerView recyclerDrink;
//
//
//    @BindView(R.id.badge)
//    NotificationBadge badge;
//
//    @BindView(R.id.btnCart)
//    FrameLayout btnCart;
//
//    IDrinkLoadListener drinkLoadListener;
//    ICartLoadListener cartLoadListener;


    private DrawerLayout drawer;
    private Object drinkModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        init();
//        loadDrinkFromFireBase();


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new TacosFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_Tacos);
        }


    }

//    private void loadDrinkFromFireBase() {
//        List<DrinkModel> drinkModels = new ArrayList<>();
//        FirebaseDatabase.getInstance()
//                .getReference("Drink")
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                        if (dataSnapshot.exists()) {
//                            for (DataSnapshot drinkSnapshot : dataSnapshot.getChildren()) {
//                                DrinkModel drinkModel = drinkSnapshot.getValue(DrinkModel.class);
//                                drinkModel.setKey(drinkSnapshot.getKey());
//                                drinkModels.add(drinkModel);
//                            }
//                            drinkLoadListener.onDrinkLoadSuccess(drinkModels);
//                        } else
//                            drinkLoadListener.onDrinkLoadFailed("Can't Find Drink");
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError databaseError) {
//                        drinkLoadListener.onDrinkLoadFailed(databaseError.getMessage());
//                    }
//                });
//
//
//    }
//
//    private void init() {
//        ButterKnife.bind(this);
//        drinkLoadListener = this;
//        cartLoadListener = this;
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
//        recyclerDrink.setLayoutManager(gridLayoutManager);
//        recyclerDrink.addItemDecoration(new SpaceItemDecoration());
//
//    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_Tacos:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new TacosFragment()).commit();
                break;
            case R.id.nav_Hamburger:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HamburgerFragment()).commit();
                break;
            case R.id.nav_HotDog:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HotDogFragment()).commit();
                break;
            case R.id.nav_Drinks:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new DrinksFragment()).commit();
                break;
            case R.id.nav_Salad:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SaladsFragment()).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

//    @Override
//    public void onDrinkLoadSuccess(List<DrinkModel> drinkModelList) {
//
//        MyDrinkAdapter adapter = new MyDrinkAdapter(this, drinkModelList);
//        recyclerDrink.setAdapter(adapter);
//
//    }
//
//    @Override
//    public void onDrinkLoadFailed(String message) {
//        Snackbar.make(drawer_layout, message, Snackbar.LENGTH_LONG).show();
//    }
//
//    @Override
//    public void onCartLoadSuccess(List<CartModel> cartModelList) {
//
//    }
//
//    @Override
//    public void onCartLoadFailed(String message) {

}
