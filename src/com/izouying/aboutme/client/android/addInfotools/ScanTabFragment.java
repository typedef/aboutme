package com.izouying.aboutme.client.android.addInfotools;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import com.izouying.aboutme.client.android.AboutmeMain;
import com.izouying.aboutme.client.android.CaptureActivity;
import com.izouying.aboutme.client.android.Contents;
import com.izouying.aboutme.client.android.R;

/**
 * Created with IntelliJ IDEA.
 * User: zouying
 * Date: 13-4-14
 * Time: 下午5:01
 * To change this template use File | Settings | File Templates.
 */
public class ScanTabFragment extends Fragment{
    private Contents mContents;
    private Activity mParents;
    final private  int REQUEST_ASK_SCAN_QRCODE_ID = 1;

    final private String TAG = "ScanTabFragment";
    public ScanTabFragment(Activity activity){
        mParents = activity;
    }



    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState){
        View fragView = layoutInflater.inflate(R.layout.scan_qrcode,container,false);
        ImageButton scanButton = (ImageButton)fragView.findViewById(R.id.scanQRCodeButton);
        scanButton.setOnClickListener(myListener);

        return  fragView;
    }
    ImageButton.OnClickListener  myListener= new ImageButton.OnClickListener(){

        public void onClick(View view){
            Intent intent = mParents.getIntent();
            intent.setClass(mParents, CaptureActivity.class);
            startActivityForResult(intent, REQUEST_ASK_SCAN_QRCODE_ID);
        }
    };

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);    //To change body of overridden methods use File | Settings | File Templates.

        Log.v(TAG,requestCode + "---" + resultCode +"----------");
    }

}


