package com.fatjoni.droid.t25guide;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends ActionBarActivity implements NavigationDrawerCallbacks {

    private Toolbar mToolbar;
    private NavigationDrawerFragment mNavigationDrawerFragment;
    private List<Workout> workoutList;

    private RecyclerView workoutRecyclerView;
    private RecyclerView.Adapter workoutAdapter;
    private RecyclerView.LayoutManager workoutLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_topdrawer);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager().findFragmentById(R.id.fragment_drawer);
        mNavigationDrawerFragment.setup(R.id.fragment_drawer, (DrawerLayout) findViewById(R.id.drawer), mToolbar);

        String[] workoutArray = getResources().getStringArray(R.array.workout_array);

        workoutList = new ArrayList<Workout>();

        for (int i=0; i<workoutArray.length; i++){
            Workout workout = new Workout(workoutArray[i]);
            workoutList.add(workout);
        }

        workoutRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        workoutRecyclerView.setHasFixedSize(true);
        workoutRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        workoutAdapter = new CardViewDataAdapter(workoutList);

        workoutRecyclerView.setAdapter(workoutAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        Toast.makeText(this, "Menu item selected -> " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        if (mNavigationDrawerFragment.isDrawerOpen())
            mNavigationDrawerFragment.closeDrawer();
        else
            super.onBackPressed();
    }
}
