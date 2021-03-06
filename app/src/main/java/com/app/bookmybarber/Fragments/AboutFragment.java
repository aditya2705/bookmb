package com.app.bookmybarber.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.bookmybarber.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment {


    private static final int CONTACT_TAB = 1;
    private static final int HOURS_TAB = 2;
    private View rootView;
    private SmartTabLayout tabs;
    private ViewPager pager;
    private FragmentPagerAdapter adapter;

    public AboutFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_about, container, false);

        tabs = (SmartTabLayout) rootView.findViewById(R.id.tabs);
        tabs.setCustomTabView(R.layout.custom_about_tab, R.id.tab_text);
        pager = (ViewPager) rootView.findViewById(R.id.pager);
        pager.setOffscreenPageLimit(15);
        adapter = new AboutPagerAdapter(getChildFragmentManager());
        pager.setAdapter(adapter);
        tabs.setViewPager(pager);


        return rootView;
    }

    public class AboutPagerAdapter extends FragmentPagerAdapter {
        private final String[] tab_names = {"Info", "Contact", "Hours"};

        private AboutPagerAdapter(FragmentManager fm) {
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

                case CONTACT_TAB:
                    return new ContactFragment();
                case HOURS_TAB:
                    return new HoursFragment();

                default:
                    return new ServicesFragment();
            }
        }
    }

}
