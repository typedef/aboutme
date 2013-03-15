package com.izouying.aboutme.client.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created with IntelliJ IDEA.
 * User: zouying
 * Date: 13-3-14
 * Time: 下午3:11
 * To change this template use File | Settings | File Templates.
 */
public class AboutmeMain extends Activity {

    private  static String TAG = Package.class.getSimpleName();
    private  Button mScanButton;
    private  Button mMakeQRCodeButton;
    private  Button mShowMyInfoButton;
    private View.OnClickListener mOnClickListener;

    @Override
    public void  onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.aboutmemain);
        mScanButton = (Button)findViewById(R.id.scan_button);
        mMakeQRCodeButton = (Button)findViewById(R.id.make_qrcode_button);
        mShowMyInfoButton = (Button)findViewById(R.id.show_my_info_button);

        mOnClickListener = createOnClickListner();
        mScanButton.setOnClickListener(mOnClickListener);
        mMakeQRCodeButton.setOnClickListener(mOnClickListener);
        mShowMyInfoButton.setOnClickListener(mOnClickListener);
    }

    private View.OnClickListener createOnClickListner() {
        return  new View.OnClickListener(){
            public void onClick(View view){
                switch (view.getId()){
                    case R.id.show_my_info_button:
                        openShowMyInfo();
                        break;
                    case R.id.make_qrcode_button:
                        Log.v(TAG, "button on make qrcode -------------");
                        makeQRCode();
                        break;
                    case R.id.scan_button:
                        openScanQRCode();
                        break;
                    default:
                        Log.v(TAG, "No Button match for id:"+(int)view.getId());
                }
            }
        };
    }

    private void openShowMyInfo(){

        Intent intent = getIntent();
        //intent.setClass(AboutmeMain.this, )
        startActivity(intent);
    }

    private void openScanQRCode(){
        Intent intent = getIntent();
        intent.setClass(AboutmeMain.this, CaptureActivity.class);
        startActivity(intent);
    }

    private void makeQRCode(){
        Intent intent = getIntent();
        intent.setClass(AboutmeMain.this, MakeQRCodeActivity.class);
        startActivity(intent);
        Log.v(TAG, "Start makeQRCode activity!!!!!!!") ;
    }
}
