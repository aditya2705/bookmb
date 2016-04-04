package com.app.bookmybarber.fragments;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.bookmybarber.adapters.ServiceItemAdapter;
import com.app.bookmybarber.interfaces.AnimatedListAdapter.appearance.AnimationAdapter;
import com.app.bookmybarber.interfaces.AnimatedListAdapter.appearance.simple.ScaleInAnimationAdapter;
import com.app.bookmybarber.objects.ServiceItemObject;
import com.app.bookmybarber.R;
import com.nirhart.parallaxscroll.views.ParallaxListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ServicesFragment extends Fragment {

    String myJSON;

    private static final String RESULTS_FETCH_URL = "http://alpha95.net63.net/something";

    private static final String TAG_RESULTS="result";
    private static final String TAG_ID = "id";
    private static final String TAG_SHOE_ID = "shoe_id";
    private static final String TAG_NAME = "name";
    private static final String TAG_CATEGORY ="category";
    private static final String TAG_PRICE ="price";
    private static final String TAG_RATING ="rating";
    private static final String TAG_REVIEWS ="reviews";
    private static final String TAG_SIZES ="sizes";
    private static final String TAG_DEFAULT_IMAGE ="default_image_url";

    JSONArray servicesJSONArray = null;

    private ServiceItemAdapter serviceItemAdapter;
    private ArrayList<ServiceItemObject> serviceItemObjectArrayList;

    private ParallaxListView parallaxListView;

    private View rootView;


    public ServicesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_services, container, false);

        parallaxListView = (ParallaxListView)rootView.findViewById(R.id.listView);

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

        serviceItemAdapter = new ServiceItemAdapter(getActivity(),R.layout.services_item_layout, serviceItemObjectArrayList);

        AnimationAdapter animAdapter;
        animAdapter = new ScaleInAnimationAdapter(serviceItemAdapter);
        animAdapter.setAbsListView(parallaxListView);

        parallaxListView.setAdapter(animAdapter);

        //getData();

        return rootView;
    }

    public void getData(){
        class GetDataJSON extends AsyncTask<String, Void, String> {

            @Override
            protected String doInBackground(String... params) {

                URL obj = null;
                String result = null;
                InputStream inputStream = null;
                try {
                    obj = new URL(RESULTS_FETCH_URL);
                    HttpURLConnection con = (HttpURLConnection) obj.openConnection();

                    //add request header
                    con.setRequestProperty("Content-Type","application/json");
                    inputStream = con.getInputStream();
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(inputStream, "UTF-8"), 8);

                    StringBuilder sb = new StringBuilder();

                    String line = null;
                    while ((line = reader.readLine()) != null)
                    {
                        sb.append(line + "\n");
                    }
                    result = sb.toString();
                    Log.d("RESULT",result);

                } catch (Exception e) {}
                finally {
                    try{if(inputStream != null)inputStream.close();}catch(Exception squish){}
                }
                return result;
            }

            @Override
            protected void onPostExecute(String result){
                myJSON=result;
                try {
                    showList();
                } catch (Exception e) {}
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }
        }
        GetDataJSON g = new GetDataJSON();
        g.execute();
    }

    protected void showList() throws JSONException {
        try {
            JSONObject jsonObj = new JSONObject(myJSON);
            servicesJSONArray = jsonObj.getJSONArray(TAG_RESULTS);

            for(int i = 0; i< servicesJSONArray.length(); i++){
                JSONObject c = servicesJSONArray.getJSONObject(i);
                String id,shoe_id,name,category,price,rating,reviews,sizes,default_image_url;

                id = c.getString(TAG_ID);
                shoe_id = c.getString(TAG_SHOE_ID);
                name = c.getString(TAG_NAME);
                category = c.getString(TAG_CATEGORY);
                price = c.getString(TAG_PRICE);
                rating = c.getString(TAG_RATING);
                reviews = c.getString(TAG_REVIEWS);
                sizes = c.getString(TAG_SIZES);
                default_image_url = c.getString(TAG_DEFAULT_IMAGE);

                ServiceItemObject serviceItemObject = new ServiceItemObject(name);

                serviceItemObjectArrayList.add(serviceItemObject);
            }

            serviceItemAdapter = new ServiceItemAdapter(getActivity(),R.layout.services_item_layout, serviceItemObjectArrayList);
            parallaxListView.setAdapter(serviceItemAdapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }



}
