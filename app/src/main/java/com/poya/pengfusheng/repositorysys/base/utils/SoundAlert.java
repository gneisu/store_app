package com.poya.pengfusheng.repositorysys.base.utils;

import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.util.Log;

import com.poya.pengfusheng.repositorysys.R;
import com.poya.pengfusheng.repositorysys.base.MyApplication;

import java.io.IOException;

/**
 * Created by pengfusheng on 2016/3/20.
 */
public class SoundAlert {
    private String TAG = "SoundAlert";
    private static MediaPlayer mMediaPlayer = null;
    private static final SoundAlert INSTANCE = new SoundAlert();
    private SoundAlert() {
        mMediaPlayer = new MediaPlayer();
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.seekTo(0);
            }
        });
        AssetFileDescriptor file = MyApplication.getContext().getResources().openRawResourceFd(R.raw.fallbackring);
        try {
            mMediaPlayer.setDataSource(file.getFileDescriptor(), file.getStartOffset(), file.getLength());
            file.close();
//          mediaPlayer.setVolume();
            mMediaPlayer.prepare();
        } catch (IOException e) {
            Log.w(TAG, e);
            mMediaPlayer = null;
        }
    }

    public static SoundAlert getInstance() {
        return INSTANCE;
    }

    public void soundAlert() {
        mMediaPlayer.start();
    }

}
