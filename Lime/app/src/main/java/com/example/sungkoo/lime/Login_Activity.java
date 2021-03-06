package com.example.sungkoo.lime;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.Toast;

import com.parse.ParseObject;

import java.io.FileNotFoundException;
import java.io.IOException;


public class Login_Activity extends ActionBarActivity {

    TabWidget tabs;
    ImageView Pro_Image;
    protected static final int REQ_CODE_PICK_PICTURE=0;
    ListView listView1;
    IconTextListAdapter adapter;
    EditText nameEntrEdit;
    EditText ageEntryEdit;
    EditText CareerEntryEdit;
    EditText SexEntryEdit;
    String nameEntryString;
    String  ageEntryEditString;
    String CareerEntryEditString;
    String SexEntryEditString;
    Intent image;
    ParseObject Profile = new ParseObject("Profile");


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
        tabwidget03.setImageResource(R.drawable.tab_03);
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
        // 리스트뷰 객체 참조
        listView1 = (ListView) findViewById(R.id.listView1);
        // 어댑터 객체 생성
        adapter = new IconTextListAdapter(this);
        // 아이템 데이터 만들기
        Resources res = getResources();
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05), "Hwang Youji", "student", "age: 22"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon06), "lee seongkoo", "student", "age: 25"));
        // 리스트뷰에 어댑터 설정
        listView1.setAdapter(adapter);
        // 새로 정의한 리스너로 객체를 만들어 설정
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                IconTextItem curItem = (IconTextItem) adapter.getItem(position);
                String[] curData = curItem.getData();
                Toast.makeText(getApplicationContext(), "Selected : " + curData[0], Toast.LENGTH_LONG).show();
            }
        });

        Pro_Image = (ImageView) findViewById(R.id.Pro_Image);

        Pro_Image.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                image = new Intent(Intent.ACTION_PICK);
                image.setType(android.provider.MediaStore.Images.Media.CONTENT_TYPE);
                image.setData(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(image, REQ_CODE_PICK_PICTURE);
            }
        });
    }

    public void onSaveClicked() {
        nameEntrEdit = (EditText) findViewById(R.id.nameEntry);
        nameEntryString = nameEntrEdit.getText().toString();
        ageEntryEdit = (EditText) findViewById(R.id. ageEntry);
        ageEntryEditString = ageEntryEdit.getText().toString();
        CareerEntryEdit = (EditText) findViewById(R.id.CareerEntry);
        CareerEntryEditString = CareerEntryEdit.getText().toString();
        SexEntryEdit = (EditText) findViewById(R.id.SexEntry);
        SexEntryEditString = SexEntryEdit.getText().toString();

        Profile.put("Name", nameEntryString);
        Profile.put("Career", CareerEntryEditString);
        Profile.put("Sex", SexEntryEditString);
        Profile.put("Age",ageEntryEditString);
        Profile.put("Image", image);
        Profile.saveInBackground();
    }


        protected void onActivityResult(int requestCode, int resultCode, Intent data){
           if(requestCode==REQ_CODE_PICK_PICTURE) {
               if (resultCode == Activity.RESULT_OK) {
                   BitmapFactory.Options options = new BitmapFactory.Options();
                   options.inSampleSize = 2;

                   try {
                       Bitmap image = BitmapFactory.decodeStream(
                               getContentResolver()
                                       .openInputStream(data.getData()), null,
                               options);

                       Pro_Image.setImageBitmap(image);
                   } catch (FileNotFoundException e) {
                       // TODO Auto-generated catch block
                       e.printStackTrace();
                   } catch (IOException e) {
                       // TODO Auto-generated catch block
                       e.printStackTrace();
                   }
               }
           }


    }

}


