package com.examen.myapplication;

import android.os.Bundle;

public class NotesActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        setupBottomNavigation();
    }

    @Override
    protected int getNavigationMenuItemId() {
        return R.id.navigation_notes;
    }
}
