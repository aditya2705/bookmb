package com.app.bookmybarber.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.bookmybarber.activities.ServiceListActivity;
import com.app.bookmybarber.R;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidviewhover.BlurLayout;
import com.rey.material.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private View rootView;
    private BlurLayout leftLayout, rightLayout;
    private View lefthover,righthover;
    private TextView leftHoverTextView, rightHoverTextView;
    private ImageView leftHoverIcon, rightHoverIcon;
    private Button leftHoverButton, rightHoverButton;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_home, container, false);

        leftLayout = (BlurLayout)rootView.findViewById(R.id.left_view);
        lefthover = LayoutInflater.from(getActivity()).inflate(R.layout.hover_home_layout, null);
        leftHoverTextView = (TextView) lefthover.findViewById(R.id.hover_text);
        leftHoverIcon = (ImageView) lefthover.findViewById(R.id.hover_icon);
        leftHoverButton = (Button) lefthover.findViewById(R.id.hover_button);
        leftLayout.addChildAppearAnimator(lefthover, R.id.hover_icon, Techniques.FlipInX);
        leftLayout.addChildDisappearAnimator(lefthover, R.id.hover_icon, Techniques.FlipOutX);
        leftLayout.addChildAppearAnimator(lefthover, R.id.hover_text, Techniques.FlipInX);
        leftLayout.addChildDisappearAnimator(lefthover, R.id.hover_text, Techniques.FlipOutX);
        leftLayout.addChildAppearAnimator(lefthover, R.id.hover_button, Techniques.FlipInX);
        leftLayout.addChildDisappearAnimator(lefthover, R.id.hover_button, Techniques.FlipOutX);
        leftLayout.setHoverView(lefthover);


        rightLayout = (BlurLayout)rootView.findViewById(R.id.right_view);
        righthover = LayoutInflater.from(getActivity()).inflate(R.layout.hover_home_layout, null);
        rightHoverTextView = (TextView) righthover.findViewById(R.id.hover_text);
        rightHoverIcon = (ImageView) righthover.findViewById(R.id.hover_icon);
        rightHoverButton = (Button) righthover.findViewById(R.id.hover_button);
        rightLayout.addChildAppearAnimator(righthover, R.id.hover_icon, Techniques.FlipInX);
        rightLayout.addChildDisappearAnimator(righthover, R.id.hover_icon, Techniques.FlipOutX);
        rightLayout.addChildAppearAnimator(righthover, R.id.hover_text, Techniques.FlipInX);
        rightLayout.addChildDisappearAnimator(righthover, R.id.hover_text, Techniques.FlipOutX);
        rightLayout.addChildAppearAnimator(righthover, R.id.hover_button, Techniques.FlipInX);
        rightLayout.addChildDisappearAnimator(righthover, R.id.hover_button, Techniques.FlipOutX);
        rightLayout.setHoverView(righthover);

        leftHoverTextView.setText("Sample Text 1 - Any content here");
        rightHoverTextView.setText("Sample Text 2 - Any content here");
        leftHoverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ServiceListActivity.class);
                startActivity(intent);
            }
        });
        rightHoverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ServiceListActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }

}
