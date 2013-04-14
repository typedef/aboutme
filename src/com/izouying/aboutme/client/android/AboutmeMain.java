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

        initActionBar();
       /* mScanButton = (Button)findViewById(R.id.scan_button);
        mMakeQRCodeButton = (Button)findViewById(R.id.make_qrcode_button);
        mShowMyInfoButton = (Button)findViewById(R.id.show_my_info_button);

        mOnClickListener = createOnClickListner();
        mScanButton.setOnClickListener(mOnClickListener);
        mMakeQRCodeButton.setOnClickListener(mOnClickListener);
        mShowMyInfoButton.setOnClickListener(mOnClickListener);
        */


    }

   void initActionBar(){
        mActionBar = getActionBar();
        mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        mActionBar.setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP, ActionBar.DISPLAY_HOME_AS_UP);
        mActionBar.setTitle("");

        ScanTabFragment scanTabFragment = new ScanTabFragment(this);

        mActionBar.addTab(mActionBar.newTab().setText(R.string.scan).setTabListener(new myTabListener(scanTabFragment)));

        MyInfoFragment aboutmeFragment = new MyInfoFragment(getResources().getString(R.string.show_my_info));
        mActionBar.addTab(mActionBar.newTab().setText(R.string.show_my_info).setTabListener(new myTabListener(aboutmeFragment)));

        TabContentFragment makeQRCodeFragment = new TabContentFragment(getResources().getString(R.string.make_qrcode));
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

    private class TabContentFragment extends Fragment {
        private String mText;
        public TabContentFragment(String text) {
            mText = text;
        }
        @Override
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState) {
            View fragView = layoutInflater.inflate(R.layout.actionbar_tab_content,container,false);
            TextView textView = (TextView)fragView.findViewById(R.id.text);
            textView.setText(mText);
            return fragView;
        }
    }

    private void makeQRCode(){
        Intent intent = getIntent();
        intent.setClass(AboutmeMain.this, MakeQRCodeActivity.class);
        startActivity(intent);
        Log.v(TAG, "Start makeQRCode activity!!!!!!!") ;
    }
}
