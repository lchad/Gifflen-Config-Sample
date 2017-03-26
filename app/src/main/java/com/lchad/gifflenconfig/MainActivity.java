package com.lchad.gifflenconfig;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.lchad.gifflen.Gifflen;
import com.lchad.test.R;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.fire).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gifflen gifflen = new Gifflen.Builder()
                        .color(256)
                        .delay(500)
                        .quality(10)
                        .width(320)
                        .height(320)
                        .build();
                gifflen.encode(MainActivity.this, Environment.getExternalStorageDirectory().getAbsolutePath() +
                        File.separator + "gifflen-sample.gif", new int[]{
                        R.drawable.mengbi1,
                        R.drawable.mengbi2,
                        R.drawable.mengbi3,
                        R.drawable.mengbi4,
                        R.drawable.mengbi5
                });
            }
        });
    }
}
