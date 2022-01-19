package com.hit.digitalwallethitapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MenuScreen extends AppCompatActivity implements MenuAdapterClass.ListViewHolder.RecycleViewClickListener {
    MenuAdapterClass menuAdapterClass;
    ArrayList<MenuModelClass> menu_items;
    RecyclerView recyclerView;

    ImageView arr;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_screen);

        recyclerView = findViewById(R.id.recyclerView);
        getData();
        setAdapter();

        arr = findViewById(R.id.arrow);

        arr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuScreen.this, BalanceScreen.class);
                startActivity(intent);
            }
        });
    }

    private void setAdapter() {
        menuAdapterClass = new MenuAdapterClass(MenuScreen.this, menu_items,this::onClicklistener);
        recyclerView.setAdapter(menuAdapterClass);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    private void getData() {
        menu_items = new ArrayList<>();
        menu_items.add(new MenuModelClass(1,R.drawable.shapes, R.drawable.ic_baseline_arrow_forward_24,"Send Money"));
        menu_items.add(new MenuModelClass(2,R.drawable.shapes1, R.drawable.ic_baseline_archive_24,"Top up wallet"));
        menu_items.add(new MenuModelClass(3,R.drawable.shapes2, R.drawable.ic_baseline_payments_24,"Bill Payment"));
        menu_items.add(new MenuModelClass(4,R.drawable.shapes3, R.drawable.ic_baseline_sim_card_download_24,"Withdraw"));
        menu_items.add(new MenuModelClass(5,R.drawable.shapes4, R.drawable.ic_baseline_compare_arrows_24,"History Transaction"));
        menu_items.add(new MenuModelClass(6,R.drawable.shapes5, R.drawable.ic_baseline_group_24,"Request Payment"));
        menu_items.add(new MenuModelClass(7,R.drawable.shapes6, R.drawable.ic_baseline_settings_24,"Settings"));
        menu_items.add(new MenuModelClass(8,R.drawable.shapes7, R.drawable.ic_baseline_text_snippet_24,"Help"));
    }


    @Override
    public void onClicklistener(int position) {

        int index = 0;
        int id = menu_items.get(position).getId();

        switch (id) {

            case 1:
                Intent intent = new Intent(MenuScreen.this, SendMoneyScreen.class);
                startActivity(intent);
                break;

            case 2:
                Intent intent1 = new Intent(MenuScreen.this, TopUpScreen.class);
                startActivity(intent1);
                break;

            case 3:
                Intent intent2 = new Intent(MenuScreen.this, ElectricityBillScreen.class);
                startActivity(intent2);
                break;

            case 4:
                Intent intent3 = new Intent(MenuScreen.this, WithdrawScreen.class);
                startActivity(intent3);
                break;
        }

        }
//        String name = menu_items.get(position).getItem_name();
//        Intent intent = new Intent(MenuScreen.this, BalanceScreen.class);
//        startActivity(intent);
    }
