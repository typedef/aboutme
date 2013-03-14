package com.izouying.aboutme.client.android.makeqrcode;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import com.izouying.aboutme.client.android.R;

/**
* Created with IntelliJ IDEA.
* User: zouying
* Date: 13-3-14
* Time: 下午5:54
* To change this template use File | Settings | File Templates.
*/
class DropDownListenser implements ActionBar.OnNavigationListener{

    String[] listNames = getResources().getStringArray(R.array.info_format);

    public boolean onNavigationItemSelected(int itemPostion, long itemId){
        ContentInfo contentInfo = new ContentInfo();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.contents_text_view, contentInfo, listNames[itemPostion]);
        transaction.commit();
        return true;
    }
}
