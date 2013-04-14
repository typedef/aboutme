package com.izouying.aboutme.client.android.showmyinfo;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.izouying.aboutme.client.android.R;

/**
 * Created with IntelliJ IDEA.
 * User: zouying
 * Date: 13-4-14
 * Time: 下午4:56
 * To change this template use File | Settings | File Templates.
 */
public class MyInfoFragment extends Fragment {

    private String mText;
    public MyInfoFragment(String text){
        mText=text;
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState){
        View frageView = layoutInflater.inflate(R.layout.myinfolist,container,false);
        ListView listView = (ListView)frageView.findViewById(R.id.myinfolists);

        return  frageView;
    }


}
