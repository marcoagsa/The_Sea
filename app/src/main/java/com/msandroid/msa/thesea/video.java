package com.msandroid.msa.thesea;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class video extends AppCompatActivity  {

    private ProgressDialog pDialog;
    private VideoView Vid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Vid = (VideoView) findViewById(R.id.videoview);

        // Recebe informação de outras actividas
        Intent getVideo = getIntent();
        Bundle dataBundle = getVideo.getExtras();
        String dataString = dataBundle.getString("Data");

        pDialog = new ProgressDialog(video.this);
        pDialog.setTitle(R.string.Play_Video);
        pDialog.setMessage(getResources().getString(R.string.Loading));
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();


        try {
            MediaController mediaController = new MediaController(video.this);
            mediaController.setAnchorView(Vid);
            Vid.setMediaController(mediaController);
            Vid.setVideoURI(Uri.parse(String.valueOf(dataString)));
        }catch (Exception e) {
            Log.e("Erro", e.getMessage());
            e.printStackTrace();
        }

        Vid.requestFocus();
        Vid.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                pDialog.dismiss();
                Vid.start();
            }
        });

    }

}
