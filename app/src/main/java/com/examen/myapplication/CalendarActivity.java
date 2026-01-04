package com.examen.myapplication;

import android.os.Bundle;

public class CalendarActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        setupBottomNavigation();
    }

    @Override
    protected int getNavigationMenuItemId() {
        return R.id.navigation_calendar;
    }
}
