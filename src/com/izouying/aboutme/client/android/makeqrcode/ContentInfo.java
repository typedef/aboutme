package com.izouying.aboutme.client.android.makeqrcode;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v4.app.Fragment;


/**
 * Created with IntelliJ IDEA.
 * User: zouying
 * Date: 13-3-14
 * Time: 下午9:51
 * To change this template use File | Settings | File Templates.
 */
public class ContentInfo extends Fragment {

    private String tag;
    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        tag = getTag();
    }
    public View OnCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedBundle){
        TextView textView = new TextView(getActivity());
        textView.setText(tag);
        return textView;
    }
}
