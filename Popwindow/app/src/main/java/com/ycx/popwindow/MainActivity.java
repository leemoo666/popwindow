package com.ycx.popwindow;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {


    private ListView listView;
    private CollectAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lvMainActivity);

        adapter = new CollectAdapter(this);
        listView.setAdapter(adapter);

        initData();
    }

    private void initData() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("这是标题 =" + i);
        }
        adapter.setList(list);

    }
}
