package com.codepath.android.themeswitcher.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;


public class ThemeActivity extends AppCompatActivity {

    Spinner spinner;

//    @LayoutRes
    int layoutResID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setTheme(R.style.Theme_RedLime_Light);
//        if (savedInstanceState != null)
//        layoutResID = savedInstanceState.getInt("layout");

        layoutResID = this.getIntent().getIntExtra("layout", 0);

        if (layoutResID == 0) {
            layoutResID = R.style.Theme_Material_Light;
        }
        setTheme(layoutResID);
        setContentView(R.layout.activity_theme);
        spinner = findViewById(R.id.spThemes);
    }

    public void onStart() {
        super.onStart();
        spinner.post(new Runnable() {
            public void run() {
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        Log.d("jenda", "position " + position );

                        Intent intent = getIntent();
                        if (position == 0) {
                            intent.putExtra("layout", R.style.Theme_Material_Light);
//                            setTheme(R.style.Theme_Material_Light);
                        } else {
                            intent.putExtra("layout", R.style.Theme_RedLime_Light);
//                            setTheme(R.style.Theme_RedLime_Light);
                        }
                        Log.d("jenda", "R.style.Theme_RedLime_Light " + R.style.Theme_RedLime_Light);
                        finish();
                        startActivity(intent);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        });
    }


        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_theme, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
