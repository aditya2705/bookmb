package com.app.bookmybarber.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.alexvasilkov.foldablelayout.UnfoldableView;
import com.app.bookmybarber.activities.MainActivity;
import com.app.bookmybarber.adapters.ServicesRecyclerAdapter;
import com.app.bookmybarber.interfaces.RecyclerItemClickListener;
import com.app.bookmybarber.objects.ServiceItemObject;
import com.app.bookmybarber.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInBottomAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInLeftAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInRightAnimationAdapter;
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;

/**
 * A simple {@link Fragment} subclass.
 */
public class ServicesFragment extends Fragment {

    @Bind(R.id.recyclerView) RecyclerView recyclerView;
    @Bind(R.id.touch_interceptor_view) View  mListTouchInterceptor;
    @Bind(R.id.details_layout) View detailsLayout;
    @Bind(R.id.unfoldable_view) public UnfoldableView mUnfoldableView;
    @Bind(R.id.cross_icon) ImageView crossIconView;

    private MainActivity mainActivity;

    private ServicesRecyclerAdapter servicesRecyclerAdapter;
    private ArrayList<ServiceItemObject> serviceItemObjectArrayList;

    private View rootView;


    public ServicesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_services, container, false);

        ButterKnife.bind(this,rootView);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mListTouchInterceptor.setClickable(false);
        detailsLayout.setVisibility(View.INVISIBLE);

        serviceItemObjectArrayList = new ArrayList<>();

        serviceItemObjectArrayList.add(new ServiceItemObject("Service 1"));
        serviceItemObjectArrayList.add(new ServiceItemObject("Service 2"));
        serviceItemObjectArrayList.add(new ServiceItemObject("Service 3"));
        serviceItemObjectArrayList.add(new ServiceItemObject("Service 4"));
        serviceItemObjectArrayList.add(new ServiceItemObject("Service 5"));
        serviceItemObjectArrayList.add(new ServiceItemObject("Service 6"));
        serviceItemObjectArrayList.add(new ServiceItemObject("Service 7"));
        serviceItemObjectArrayList.add(new ServiceItemObject("Service 8"));
        serviceItemObjectArrayList.add(new ServiceItemObject("Service 9"));
        serviceItemObjectArrayList.add(new ServiceItemObject("Service 10"));
        serviceItemObjectArrayList.add(new ServiceItemObject("Service 11"));
        serviceItemObjectArrayList.add(new ServiceItemObject("Service 12"));

        servicesRecyclerAdapter = new ServicesRecyclerAdapter(getActivity(),serviceItemObjectArrayList);
        SlideInRightAnimationAdapter adapter = new SlideInRightAnimationAdapter(servicesRecyclerAdapter);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                mUnfoldableView.unfold(view.findViewById(R.id.item_card_view), detailsLayout);
            }
        }));


        mUnfoldableView.setOnFoldingListener(new UnfoldableView.SimpleFoldingListener() {
            @Override
            public void onUnfolding(UnfoldableView unfoldableView) {
                mListTouchInterceptor.setClickable(true);
                detailsLayout.setVisibility(View.VISIBLE);
                mainActivity.menu.getItem(0).setVisible(false);
                mainActivity.menu.getItem(1).setVisible(false);
            }

            @Override
            public void onUnfolded(UnfoldableView unfoldableView) {
                mListTouchInterceptor.setClickable(false);
            }

            @Override
            public void onFoldingBack(UnfoldableView unfoldableView) {
                mListTouchInterceptor.setClickable(true);
            }

            @Override
            public void onFoldedBack(UnfoldableView unfoldableView) {
                mListTouchInterceptor.setClickable(false);
                detailsLayout.findViewById(R.id.scrollView).scrollTo(0,0);
                detailsLayout.setVisibility(View.INVISIBLE);
                mainActivity.menu.getItem(0).setVisible(true);
                mainActivity.menu.getItem(1).setVisible(true);
            }
        });

        crossIconView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mUnfoldableView.isUnfolded()){
                    mUnfoldableView.foldBack();
                }
            }
        });

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mainActivity = (MainActivity)activity;
    }
}
