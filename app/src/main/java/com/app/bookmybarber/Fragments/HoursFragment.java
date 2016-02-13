package com.app.bookmybarber.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.bookmybarber.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HoursFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HoursFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private int[] day_id = {R.id.monday, R.id.tuesday, R.id.wednesday,
            R.id.thursday, R.id.friday, R.id.saturday,
            R.id.sunday};

    private String[] day_name = {"Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday",
            "Sunday"};

    private String[] day_time = {"Non Stop", "10:00 AM - 05:00 PM", "10:00 AM - 05:00 PM",
            "10:00 AM - 05:00 PM", "10:00 AM - 05:00 PM",
            "10:00 AM - 05:00 PM", "10:00 AM - 05:00 PM"};


    public HoursFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HoursFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HoursFragment newInstance(String param1, String param2) {
        HoursFragment fragment = new HoursFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hours, container, false);
        for (int i = 0; i < day_id.length; i++) {
            View dayView = view.findViewById(day_id[i]);
            ((TextView) dayView.findViewById(R.id.day_text)).setText(day_name[i]);
            ((TextView) dayView.findViewById(R.id.time_text)).setText(day_time[i]);
        }
        return view;
    }

}


