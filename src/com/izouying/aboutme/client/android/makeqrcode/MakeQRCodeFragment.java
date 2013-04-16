package com.izouying.aboutme.client.android.makeqrcode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.app.Fragment;

import com.izouying.aboutme.client.android.MakeQRCodeActivity;
import com.izouying.aboutme.client.android.R;


/**
 * Created with IntelliJ IDEA.
 * User: zouying
 * Date: 13-3-14
 * Time: 下午9:51
 * To change this template use File | Settings | File Templates.
 */
public class MakeQRCodeFragment extends Fragment {

    final static private String TAG = Package.getPackages().getClass().getSimpleName();
    private Activity mActivity;
    //private Button.OnClickListener  mButtonLister;

    public MakeQRCodeFragment(){

    }
    public   MakeQRCodeFragment(Activity activity){

        mActivity = activity;
    }
    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        //tag = getTag();
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedBundle){

        View fragmentView = layoutInflater.inflate(R.layout.make_qrcode,container,false);

        Button mMakeQRButton = (Button)fragmentView.findViewById(R.id.makeQRcodeButton);
        mMakeQRButton.setOnClickListener(mButtonLister);
        //TextView textView = new TextView(getActivity());
        //textView.setText(tag);
        return fragmentView;
    }


    Button.OnClickListener mButtonLister = new Button.OnClickListener(){
        @Override
        public void onClick(View view){
            Intent intent = mActivity.getIntent();
            intent.setClass(mActivity, MakeQRCodeActivity.class);
            startActivity(intent);
            Log.v(TAG, "Start makeQRCode activity!!!!!!!") ;
        }
    };

}
