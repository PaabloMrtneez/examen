package com.examen.myapplication;

import android.os.Bundle;

public class AccountActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        setupBottomNavigation();
    }

    @Override
    protected int getNavigationMenuItemId() {
        return R.id.navigation_account;
    }
}
