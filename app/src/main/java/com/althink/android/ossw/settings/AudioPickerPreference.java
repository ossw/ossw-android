package com.althink.android.ossw.settings;

import android.content.Context;
import android.database.Cursor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceViewHolder;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;


import com.althink.android.ossw.R;

import java.io.IOException;

/**
 * Created by Pavel Vasilyev on 24/12/2015.
 */
public class AudioPickerPreference extends Preference {
    private static MediaPlayer mediaPlayer;
    private String uriValue;
    private String title;

    public void setUriValue(String uriValue) {
        this.uriValue = uriValue;
        persistString(uriValue);
        Cursor musicCursor = getContext().getContentResolver().query(Uri.parse(uriValue), null, null, null, null);
        if (musicCursor != null && musicCursor.moveToFirst()) {
            title = musicCursor.getString(musicCursor.getColumnIndex
                    (android.provider.MediaStore.Audio.Media.TITLE));
        }
        if (musicCursor != null)
            musicCursor.close();
    }

    @Override
    public CharSequence getSummary() {
        if (title != null && !title.isEmpty())
            return title;
        else
            return super.getSummary();
    }

    public AudioPickerPreference(Context context, AttributeSet attrs) {
        super(context, attrs, android.support.v7.preference.R.attr.preferenceScreenStyle);
    }

    @Override
    public void onBindViewHolder(PreferenceViewHolder holder) {
        setUriValue(getPersistedString(getContext().getString(R.string.pref_phone_discovery_file_uri)));
        super.onBindViewHolder(holder);

        LinearLayout ll = (LinearLayout) holder.itemView.findViewById(android.R.id.widget_frame);
        final ImageView imageView = (ImageView) holder.itemView.findViewById(R.id.play_button);
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer == null) {
                    mediaPlayer = new MediaPlayer();
                }

                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    imageView.setImageResource(R.drawable.ic_play);
                } else {
                    Uri uri = Uri.parse(uriValue);
                    mediaPlayer.reset();
                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    try {
                        mediaPlayer.setDataSource(getContext(), uri);
                        mediaPlayer.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    mediaPlayer.start();
                    imageView.setImageResource(R.drawable.ic_stop);
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            imageView.setImageResource(R.drawable.ic_play);
                        }
                    });
                }
            }
        });
    }

}
