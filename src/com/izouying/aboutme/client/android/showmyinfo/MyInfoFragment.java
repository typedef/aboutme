package com.izouying.aboutme.client.android.showmyinfo;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.izouying.aboutme.client.android.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: zouying
 * Date: 13-4-14
 * Time: 下午4:56
 * To change this template use File | Settings | File Templates.
 */
public class MyInfoFragment extends Fragment {

    private Activity mActivity;
    public MyInfoFragment(){}

    public MyInfoFragment(Activity activity){

        mActivity = activity;
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState){
        View frageView = layoutInflater.inflate(R.layout.myinfolist,container,false);
        ListView listView = (ListView)frageView.findViewById(R.id.myinfolists);
        SimpleAdapter simpleAdapter = new SimpleAdapter(mActivity,getData(),
                    R.layout.myinfolist_item,
                    new String[]{"title", "info", "img"},
                    new int[]{R.id.title, R.id.info,R.id.img});

        //listView.setAdapter(new ArrayAdapter<String>(mActivity, android.R.layout.simple_list_item_1,getData()));

        listView.setAdapter(simpleAdapter);
        //mActivity.setContentView(listView);


        return  frageView;
    }

    private List<Map<String,Object>> getData(){
        List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", "G1");
        map.put("info", "google 1");
        map.put("img", R.drawable.shopper_icon);
        data.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "G2");
        map.put("info", "google 2");
        map.put("img", R.drawable.shopper_icon);
        data.add(map);

        return data;
    }


}
