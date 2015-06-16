package com.example.sungkoo.lime;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;

import java.io.FileNotFoundException;
import java.io.IOException;


public class LoginActivity extends ActionBarActivity {

    TabWidget tabs;
    ImageView Pro_Image;
    protected static final int REQ_CODE_PICK_PICTURE=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        ImageView tabwidget01 = new ImageView(this);
        tabwidget01.setImageResource(R.drawable.tab_01);
        tabwidget01.setScaleType(ImageView.ScaleType.FIT_XY);
        ImageView tabwidget02 = new ImageView(this);
        tabwidget02.setImageResource(R.drawable.tab_02);
        tabwidget02.setScaleType(ImageView.ScaleType.FIT_XY);
        ImageView tabwidget03 = new ImageView(this);
        tabwidget03.setImageResource(R.drawable.tab_02);
        tabwidget03.setScaleType(ImageView.ScaleType.FIT_XY);
        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();
        TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("Tab1");
        tabSpec1.setIndicator(tabwidget01);
        tabSpec1.setContent(R.id.tab1);
        tabHost.addTab(tabSpec1);
        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("Tab2");
        tabSpec2.setIndicator(tabwidget02);
        tabSpec2.setContent(R.id.tab2);
        tabHost.addTab(tabSpec2);
        TabHost.TabSpec tabSpec3 = tabHost.newTabSpec("Tab3");
        tabSpec3.setIndicator(tabwidget03);
        tabSpec3.setContent(R.id.tab3);
        tabHost.addTab(tabSpec3);

        Pro_Image = (ImageView) findViewById(R.id.Pro_Image);

        Pro_Image.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK);
                i.setType(android.provider.MediaStore.Images.Media.CONTENT_TYPE);
                i.setData(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, REQ_CODE_PICK_PICTURE);
            }
        });
    }
        protected void onActivityResult(int requestCode, int resultCode, Intent data){
           if(requestCode==REQ_CODE_PICK_PICTURE){


                if(resultCode== Activity.RESULT_OK){
                    BitmapFactory.Options options= new BitmapFactory.Options();
                    options.inSampleSize=2;

                    try{
                        Bitmap image=BitmapFactory.decodeStream(
                                getContentResolver()
                                        .openInputStream(data.getData()),null,
                                options);

                      Pro_Image.setImageBitmap(image);
                    }catch(FileNotFoundException e){
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }catch(IOException e){
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }


    }

}


