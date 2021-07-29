package com.example.button_clicks;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    final String pathSave = Environment.getExternalStorageDirectory().getAbsolutePath() + "/myrecording.3gp";
    MediaRecorder recorder;
    boolean recording = false;
    MediaPlayer mediaPlayer = new MediaPlayer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.button);
        final TextView textView = findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(recording && recorder != null){
                    button.setBackgroundColor(getResources().getColor(R.color.Gray));
                    recorder.stop();
                    recorder.release();
                    recorder = null;

                    recording = false;
                }

                if(mediaPlayer.isPlaying() && mediaPlayer != null){
                    mediaPlayer.stop();
                }

                mediaPlayer = new MediaPlayer();

                try{
                    mediaPlayer.setDataSource(pathSave);
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });

        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                button.setBackgroundColor(getResources().getColor(R.color.Red));

                try{
                    recorder = getMediaRecorder(pathSave);
                    recorder.prepare();
                }catch (IOException e){
                    e.printStackTrace();
                }

                recorder.start();
                recording = true;

                return false;
            }
        });
    }

    public MediaRecorder getMediaRecorder(String pathSave){
        MediaRecorder mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        mediaRecorder.setOutputFile(pathSave);

        return mediaRecorder;
    }

}
