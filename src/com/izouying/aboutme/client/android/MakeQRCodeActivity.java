package com.izouying.aboutme.client.android;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.*;
import com.google.zxing.WriterException;
import com.izouying.aboutme.client.android.encode.QRCodeEncoder;


/**
 * Created with IntelliJ IDEA.
 * User: zouying
 * Date: 13-3-14
 * Time: 下午4:55
 * To change this template use File | Settings | File Templates.
 */
public class MakeQRCodeActivity extends Activity {

    private static String TAG = Package.class.getSimpleName();
    Button mMakeQRButton ;
    ImageView mQRCodeImage;
    EditText mName;
    EditText mPhone;
    private QRCodeEncoder mQRCodeEncoder;


    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.make_qrcode);
        mMakeQRButton = (Button)findViewById(R.id.makeQRcodeButton);
        mQRCodeImage = (ImageView)findViewById(R.id.imageView);
        mName = (EditText)findViewById(R.id.myName);
        mPhone = (EditText)findViewById(R.id.myPhone);

        mMakeQRButton.setOnClickListener(mMakeQRCodeButtonListener);

    }

    View.OnClickListener mMakeQRCodeButtonListener = new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                            String myName = mName.getText().toString();
                    String myPhone = mPhone.getText().toString();

                    String mTextInfo = myName + " tel:"+myPhone;
                    Log.v(TAG, mTextInfo+"===");

                    WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
                    Display display = manager.getDefaultDisplay();
                    int width = display.getWidth();
                    int height = display.getHeight();
                    int smallerDimension = width < height ? width : height;
                    smallerDimension = smallerDimension * 7 / 8;
                    try{
                        Intent intent = getIntent();
                        intent.setAction(Intents.Encode.ACTION);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra(Intents.Encode.DATA, myPhone.toString());
                        intent.putExtra(Intents.Encode.TYPE,Contents.Type.PHONE);
                        //intent.setClass(MakeQRCodeActivity.this, EncodeActivity.class);
                        // startActivity(intent);
                        mQRCodeEncoder = new QRCodeEncoder(MakeQRCodeActivity.this, intent, smallerDimension, false);
                        Bitmap bitmap = mQRCodeEncoder.encodeAsBitmap();
                        mQRCodeImage.setImageBitmap(bitmap);
                    } catch (WriterException e) {
                        Log.w(TAG, "Could not encode barcode", e);
                        //showErrorMessage(R.string.msg_encode_contents_failed);
                        mQRCodeEncoder = null;

                    }

                 }
    };


}
