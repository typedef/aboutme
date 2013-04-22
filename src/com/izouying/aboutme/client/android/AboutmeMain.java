package com.izouying.aboutme.client.android;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.*;
import android.widget.*;
import com.izouying.aboutme.client.android.addInfotools.ScanTabFragment;
import com.izouying.aboutme.client.android.makeqrcode.MakeQRCodeFragment;
import com.izouying.aboutme.client.android.showmyinfo.MyInfoFragment;

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
    private  View.OnClickListener mOnClickListener;
    private  boolean mShowOrHidden=true;
    private  ActionBar mActionBar;

    @Override
    public void  onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.aboutmemain);
        //initActionBar();
    }

    @Override
    protected void onStart() {
        super.onStart();    //To change body of overridden methods use File | Settings | File Templates.
        initActionBar();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);    //To change body of overridden methods use File | Settings | File Templates.

        if (data == null){
            Log.v(TAG, "data is null ----");
        }
        Log.v(TAG,requestCode + "---" + resultCode +"----------");
    }

    void initActionBar(){
        mActionBar = getActionBar();
        mActionBar.removeAllTabs();
        mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        mActionBar.setDisplayOptions(0);
       // mActionBar.setDisplayUseLogoEnabled(false);
       // mActionBar.setDisplayShowTitleEnabled(false);


        ScanTabFragment scanTabFragment = new ScanTabFragment(this);

        mActionBar.addTab(mActionBar.newTab().setText(R.string.scan).setTabListener(new myTabListener(scanTabFragment)));

        MyInfoFragment aboutmeFragment = new MyInfoFragment(this);
        mActionBar.addTab(mActionBar.newTab().setText(R.string.show_my_info).setTabListener(new myTabListener(aboutmeFragment)));

        MakeQRCodeFragment makeQRCodeFragment = new MakeQRCodeFragment(this);
        mActionBar.addTab(mActionBar.newTab().setText(R.string.make_qrcode).setTabListener(new myTabListener(makeQRCodeFragment)));

    }

    private class myTabListener implements ActionBar.TabListener{
        private Fragment mTabContentFragment;
        public myTabListener(Fragment tabContentFragment){
            mTabContentFragment = tabContentFragment;
        }

        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
            //To change body of implemented methods use File | Settings | File Templates.
            fragmentTransaction.add(R.id.fragment_content, mTabContentFragment, null);
        }

        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
            //To change body of implemented methods use File | Settings | File Templates.
            fragmentTransaction.remove(mTabContentFragment);
        }

        @Override
        public void onTabReselected(ActionBar.Tab tab, android.app.FragmentTransaction fragmentTransaction) {
            //To change body of implemented methods use File | Settings | File Templates.
        }
    }

}
