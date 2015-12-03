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

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            WatchSetType t = (WatchSetType) extras.getSerializable("type");
            importFragment.setWatchsetType(t);
            String param = extras.getString("uri");
            if (param != null && !param.isEmpty()) {
                Uri uri = Uri.parse(param);
                importFragment.setUri(uri);
            }
            if (extras.containsKey("id"))
                importFragment.setId(extras.getInt("id"));
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, importFragment)
                .commit();
    }

}
