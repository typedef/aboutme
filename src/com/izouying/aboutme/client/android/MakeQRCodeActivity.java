package com.izouying.aboutme.client.android;


import android.app.Activity;
import android.app.ActionBar;
import android.support.v4.app.*;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import android.app.ActionBar.OnNavigationListener;
import com.izouying.aboutme.client.android.makeqrcode.ContentInfo;



/**
 * Created with IntelliJ IDEA.
 * User: zouying
 * Date: 13-3-14
 * Time: 下午4:55
 * To change this template use File | Settings | File Templates.
 */
public class MakeQRCodeActivity extends Activity {

    private static String TAG = Package.class.getSimpleName();
    SpinnerAdapter mSpinnerAdapter;
    ActionBar mActionBar ;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.makeqrcode);
        mSpinnerAdapter = new ArrayAdapter<CharSequence>(this, R.array.info_format,
                        android.R.layout.simple_spinner_item);

        mActionBar = getActionBar();
        if (mActionBar == null)
        {
            Log.v(TAG, "getActionBar is null!!!!!!!!!!");
        }else {
            mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
            mActionBar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);
            mActionBar.setListNavigationCallbacks(mSpinnerAdapter, new DropDownListenser());
        }

    }

    private class DropDownListenser   extends FragmentActivity implements OnNavigationListener
    {
        String[] listNames = getResources().getStringArray(R.array.info_format);

        public boolean onNavigationItemSelected(int itemPostion, long itemId){
            ContentInfo contentInfo = new ContentInfo();
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            // 将Activity中的内容替换成对应选择的Fragment
            transaction.replace(R.id.context, contentInfo, listNames[itemPostion]);
            transaction.commit();
            return true;
        }
    }



}
