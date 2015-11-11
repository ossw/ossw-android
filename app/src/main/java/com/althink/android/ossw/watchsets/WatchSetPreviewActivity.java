package com.althink.android.ossw.watchsets;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.althink.android.ossw.R;

public class WatchSetPreviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_set_preview);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_set_preview);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        mToolbar.setClickable(true);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        WatchSetImportFragment importFragment = new WatchSetImportFragment();
        Uri uri;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String uriString = extras.getString("uri");
            uri = Uri.parse(uriString);
            importFragment.setUri(uri);
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, importFragment)
                .commit();
    }

}
