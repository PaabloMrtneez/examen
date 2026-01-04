package com.examen.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public abstract class BaseActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    protected BottomNavigationView bottomNavigationView;

    protected abstract int getNavigationMenuItemId();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        // When an activity is brought to the front of the stack (e.g., via FLAG_ACTIVITY_CLEAR_TOP),
        // we need to make sure its bottom navigation item is selected.
        if (bottomNavigationView != null) {
            bottomNavigationView.setSelectedItemId(getNavigationMenuItemId());
        }
    }

    protected void setupBottomNavigation() {
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(getNavigationMenuItemId());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        final int itemId = item.getItemId();

        if (itemId == getNavigationMenuItemId()) {
            return true; // Already on this page, do nothing.
        }

        Class<?> activityClass = null;
        if (itemId == R.id.navigation_home) {
            activityClass = HomePrincipal.class;
        } else if (itemId == R.id.navigation_notes) {
            activityClass = NotesActivity.class;
        } else if (itemId == R.id.navigation_calendar) {
            activityClass = CalendarActivity.class;
        } else if (itemId == R.id.navigation_account) {
            activityClass = AccountActivity.class;
        }

        if (activityClass != null) {
            Intent intent = new Intent(this, activityClass);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); // Force no animation
            return true;
        }

        return false;
    }
}
