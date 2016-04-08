package com.app.bookmybarber.activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.alexvasilkov.foldablelayout.UnfoldableView;
import com.app.bookmybarber.fragments.ServicesFragment;
import com.app.bookmybarber.R;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar) Toolbar mToolbar;

    private Drawer drawer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ButterKnife.bind(this);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        //Create the drawer
        drawer = new DrawerBuilder(this)
                .withToolbar(mToolbar)
                .withActionBarDrawerToggle(false)
                .withFullscreen(false)
                .withHeader(View.inflate(this,R.layout.drawer_account_header,null))
                .withDisplayBelowStatusBar(true)
                .withDrawerWidthRes(R.dimen._240sdp)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("Home").withIcon(FontAwesome.Icon.faw_home),
                        new PrimaryDrawerItem().withName("Favorites").withIcon(FontAwesome.Icon.faw_heart)

                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int i, IDrawerItem drawerItem) {

                        if (drawerItem != null && drawerItem instanceof Nameable) {
                            String name = ((Nameable) drawerItem).getName().getText(MainActivity.this);
                            getSupportActionBar().setTitle(name);
                            Fragment fragment = null;

                            switch (i) {
                                default:
                                    fragment = new ServicesFragment();
                                    break;
                            }

                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                        }

                        return false;
                    }
                })
                .withDrawerGravity(Gravity.RIGHT)
                .withFireOnInitialOnClick(false)
                .withSavedInstance(savedInstanceState)
                .build();

        drawer.setSelectionAtPosition(1, true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Intent intent;
        //noinspection SimplifiableIfStatement
        if(id == R.id.search){
            SearchView mSearchView = (SearchView) MenuItemCompat.getActionView(item);
            mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }
            });

            mSearchView.setQueryHint("Search Saloons");
            SearchView.SearchAutoComplete searchAutoComplete = (SearchView.SearchAutoComplete) mSearchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
            searchAutoComplete.setHintTextColor(getResources().getColor(R.color.md_white_400));
            searchAutoComplete.setTextColor(getResources().getColor(R.color.md_white_1000));

        }else if(id == R.id.action_drawer_toggle){
            if(drawer.isDrawerOpen())drawer.closeDrawer();
            else drawer.openDrawer();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().findFragmentById(R.id.fragment_container) instanceof ServicesFragment){
            UnfoldableView mUnfoldableView = ((ServicesFragment)getSupportFragmentManager().findFragmentById(R.id.fragment_container)).mUnfoldableView;
            if (mUnfoldableView != null && (mUnfoldableView.isUnfolded() || mUnfoldableView.isUnfolding())) {
                mUnfoldableView.foldBack();
            } else {
                super.onBackPressed();
            }
        }

    }
}
