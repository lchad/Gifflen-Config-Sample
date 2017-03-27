package com.lchad.gifflen;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

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
                        .listener(new Gifflen.OnEncodeFinishListener() {
                            @Override
                            public void onEncodeFinish(String path) {
                                Toast.makeText(MainActivity.this, "已保存gif到" + path, Toast.LENGTH_LONG).show();
                            }
                        })
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
