package com.example.ballcontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    protected Sensor s;
    private float[] gravity = new float[]{0, 0};
    private BallControlView ballView;
    private float sensorX, sensorY;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorManager sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        s = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        if(s != null){
            //roda a aplicação
            ballView = new BallControlView(this);
            setContentView(ballView);

        }

    }

    @Override
    protected void onResume(){
        super.onResume();
        ballView.resume();
    }

    @Override
    protected  void onPause() {
        super.onResume();
        ballView.pause();
        super.onPause();
    }


    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    public class BallControlView extends SurfaceView implements Runnable{
        Thread thread = null;

        Bitmap ball;
        SurfaceHolder surface;
        float speedX = 0, speedY = 0;
        float positionX = 0, positionY = 0;
        final float maxSpeed = 40f;
        final double maxSpeedXY = Math.sqrt(2) * maxSpeed;
        float volume;
        float mass;
        boolean enableSoundFX;

        MediaPlayer mp;

        boolean isRunning;


        public BallControlView(Context context) {
            super(context);

            setKeepScreenOn(true);

            ball = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background);
            surface = getHolder();
            mp= (MediaPlayer) MediaPlayer.create(context, R.raw.water_drop_sound_effect);

        }

        @Override
        public void run() {
            while(isRunning){
                if(surface.getSurface().isValid()){

                    Canvas canvas = surface.lockCanvas();

                    if(canvas != null){
                        float validWidth = getWidth() - ball.getWidth();
                        float validHeight = getHeight() - ball.getHeight();

                        enableSoundFX = true;
                        mass = 30;

                        boolean collided = false;

                        speedX += sensorX/mass;
                        speedX = constrain(-maxSpeed,speedX,maxSpeed);
                        positionX = positionX + speedX;

                        if(positionX < 0 || positionX > validWidth){
                            speedX = -.8f + speedX;
                            collided = true;
                        }

                        positionX = constrain(0, positionX, validWidth);

                        speedY += sensorY/mass;
                        speedY = constrain(-maxSpeed,speedY,maxSpeed);
                        positionY = positionY + speedY;

                        if(positionY < 0 || positionY > validHeight){
                            speedY = -.8f + speedY;
                            collided = true;
                        }

                        positionY = constrain(0, positionY, validWidth);

                        canvas.drawColor(Color.BLACK);
                        canvas.drawBitmap(ball, (int) positionX, (int) positionY, null);
                        surface.unlockCanvasAndPost(canvas);

                        if(enableSoundFX && collided){
                            volume = (float) (Math.pow(Math.hypot((double) speedX,(double) speedY)/maxSpeedXY,2));
                            mp.setVolume(volume, volume);

                            if(mp.isPlaying()) mp.seekTo(0);
                            else mp.start();
                        }

                    }
                }
            }
        }

        private float constrain (float min, float value, float max){
            return Math.max(Math.min(value,max),min);
        }

        public void resume(){
            isRunning = true;
            thread = new Thread(this);
            thread.start();
        }

        public void pause(){
            isRunning = false;

            try{
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                thread = null;
            }
        }
    }
}
