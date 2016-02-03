package com.app.bookmybarber.Fragments;


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
        tabs.setCustomTabView(R.layout.custom_smart_tab_view2, R.id.tab_text);
        pager = (ViewPager) rootView.findViewById(R.id.pager);
        pager.setOffscreenPageLimit(15);
        adapter = new PiePagerAdapter(getChildFragmentManager());
        pager.setAdapter(adapter);
        tabs.setViewPager(pager);


        return rootView;
    }

    public class PiePagerAdapter extends FragmentPagerAdapter {
        private final String[] tab_names = {"Info", "Contact", "Hours"};

        private PiePagerAdapter(FragmentManager fm) {
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

                default:
                    return new ServicesFragment();
            }
        }
    }

}
