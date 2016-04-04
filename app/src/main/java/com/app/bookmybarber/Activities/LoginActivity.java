package com.app.bookmybarber.activities;

import android.content.pm.ActivityInfo;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.app.bookmybarber.fragments.SignInFragment;
import com.app.bookmybarber.fragments.SignUpFragment;
import com.app.bookmybarber.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

public class LoginActivity extends AppCompatActivity {

    private SmartTabLayout tabs;
    private ViewPager pager;
    private LoginPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        tabs = (SmartTabLayout) findViewById(R.id.tabs);

        pager = (ViewPager) findViewById(R.id.pager);
        pager.setOffscreenPageLimit(10);

        adapter = new LoginPagerAdapter(getSupportFragmentManager());

        pager.setAdapter(adapter);
        tabs.setViewPager(pager);

    }

    public class LoginPagerAdapter extends FragmentPagerAdapter {
        private final String[] tab_names = {"SIGN IN", "SIGN UP"};

        private LoginPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tab_names[position];
        }

        @Override
        public int getCount() {
            return tab_names.length;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {

                case 0:
                    return new SignInFragment();

                case 1:
                    return new SignUpFragment();
            }

            return null;
        }
    }
}
