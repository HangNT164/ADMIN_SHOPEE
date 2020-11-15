package com.admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Random;

import ir.androidexception.datatable.DataTable;
import ir.androidexception.datatable.model.DataTableHeader;
import ir.androidexception.datatable.model.DataTableRow;

public class CategoryActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DataTable dataTable;
    private DataTableRow row;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ImageView menuView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        dataTable = findViewById(R.id.data_table_category);

        DataTableHeader header = new DataTableHeader.Builder()
                .item("field name 1", 3)
                .item("field name 2", 4)
                .item("field name 3", 5)
                .item("field name 4", 6)
                .build();

        ArrayList<DataTableRow> rows = new ArrayList<>();

        // define 200 fake rows for table
        for (int i = 0; i < 10; i++) {
            Random r = new Random();
            int random = r.nextInt(i + 1);
            int randomDiscount = r.nextInt(20);
            row = new DataTableRow.Builder()
                    .value("Product #" + i)
                    .value(String.valueOf(random))
                    .value(String.valueOf(random * 1000).concat("$"))
                    .value(String.valueOf(randomDiscount).concat("%"))
                    .build();
            rows.add(row);
        }

        dataTable.setHeader(header);
        dataTable.setRows(rows);
        dataTable.inflate(getApplicationContext());

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        drawerLayout = findViewById(R.id.drawer_layout);
        menuView = findViewById(R.id.iconMenu);

        menuView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_product) {
            Intent intent = new Intent(this, ProductActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_category) {
            Intent intent = new Intent(this, CategoryActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_message) {
            Intent intent = new Intent(this, MessageActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_profile) {
            Intent intent = new Intent(this, SettingActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_account) {
            Intent intent = new Intent(this, AccountActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_order) {
            Intent intent = new Intent(this, OrderActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}