package com.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private BarChart barChart;
    private List<BarEntry> lists;
    private PieChart pieChart;
    private List<PieEntry> listPies;
    private RadarChart radarChart;
    private List<RadarEntry> listRadar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ImageView menuView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        drawerLayout = findViewById(R.id.drawer_layout);

        barChart = findViewById(R.id.barChart);
        lists = new ArrayList<>();
        lists.add(new BarEntry(2014, 420));
        lists.add(new BarEntry(2015, 421));
        lists.add(new BarEntry(2016, 422));
        lists.add(new BarEntry(2017, 423));
        lists.add(new BarEntry(2018, 424));
        lists.add(new BarEntry(2019, 425));

        BarDataSet barDataSet = new BarDataSet(lists, "Lists");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);

        BarData barData = new BarData(barDataSet);

        barChart.setFitBars(true);
        barChart.setData(barData);
        barChart.getDescription().setText("Bar Chart");
        barChart.animateY(2000);

        pieChart = findViewById(R.id.pieChart);
        listPies = new ArrayList<>();
        listPies.add(new PieEntry(508, "2016"));
        listPies.add(new PieEntry(518, "2017"));
        listPies.add(new PieEntry(528, "2018"));
        listPies.add(new PieEntry(538, "2019"));
        listPies.add(new PieEntry(558, "2020"));

        PieDataSet pieDataSet = new PieDataSet(listPies, "List Pie");
        pieDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(16f);

        PieData pieData = new PieData(pieDataSet);

        pieChart.setData(pieData);
        pieChart.getDescription().setEnabled(false);
        pieChart.setCenterText("Pie");
        pieChart.animate();

        radarChart = findViewById(R.id.radarChart);
        listRadar = new ArrayList<>();
        listRadar.add(new RadarEntry(420));
        listRadar.add(new RadarEntry(500));
        listRadar.add(new RadarEntry(720));
        listRadar.add(new RadarEntry(320));
        listRadar.add(new RadarEntry(450));
        listRadar.add(new RadarEntry(470));
        listRadar.add(new RadarEntry(480));
        listRadar.add(new RadarEntry(490));

        RadarDataSet radarDataSet = new RadarDataSet(listRadar, "radar");
        radarDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        radarDataSet.setValueTextColor(Color.BLACK);
        radarDataSet.setValueTextSize(16f);

        RadarData radarData = new RadarData();
        radarData.addDataSet(radarDataSet);
        String[] listsStr = {"2011", "2012", "2013", "2014", "2015", "2016", "2017"};

        XAxis xAxis = radarChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(listsStr));
        radarChart.setData(radarData);

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