package com.izouying.aboutme.client.android.makeqrcode;


import android.app.*;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import com.izouying.aboutme.client.android.R;


/**
 * Created with IntelliJ IDEA.
 * User: zouying
 * Date: 13-3-14
 * Time: 下午4:55
 * To change this template use File | Settings | File Templates.
 */
public class MakeQRCodeActivity extends Activity

    @Override
    public void OnCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.makeqrcode);
        SpinnerAdapter mSpinnerAdapter = new ArrayAdapter<CharSequence>(this, R.array.info_format, android.R.layout.simple_spinner_item);

        final ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        actionBar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);
        actionBar.setListNavigationCallbacks(mSpinnerAdapter, new DropDownListenser());

    }


}
