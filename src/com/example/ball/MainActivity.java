package com.example.ball;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	private CBall mCBall = new CBall();
	private TextView mAnswerLabel;
	private Button mGetAnswerButton;
	private ImageView mCBallImage;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); 
   
    	//Assign the View from the layout files
        mAnswerLabel = (TextView) findViewById(R.id.textView1);
        mGetAnswerButton = (Button) findViewById(R.id.button1);
        mCBallImage= (ImageView) findViewById(R.id.imageView1);
        
        mGetAnswerButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String answer= mCBall.getAnAnswer();
				mAnswerLabel.setText(answer);
				
				animateCBall();
				animateAnswer();
				playSound();
			}
		});
        }
    
   private void animateCBall(){
	  
	   mCBallImage.setImageResource(R.animator.cball_animation);
	   AnimationDrawable ballAnimation = (AnimationDrawable) mCBallImage.getDrawable();
	   if(ballAnimation.isRunning()){
		   ballAnimation.stop();
	   }
	   ballAnimation.start();
   }
   
   private void animateAnswer(){
	  AlphaAnimation fadeInAnimation= new AlphaAnimation(0, 1);
	  fadeInAnimation.setDuration(1500);
	  fadeInAnimation.setFillAfter(true);
	  
	  mAnswerLabel.setAnimation(fadeInAnimation);
   }
   
   private void playSound() {
	   MediaPlayer player = MediaPlayer.create(this, R.raw.test_cbr);
	   player.start();
	   player.setOnCompletionListener(new OnCompletionListener() {
		
		@Override
		public void onCompletion(MediaPlayer mp) {
			// TODO Auto-generated method stub
			mp.release();
		}
	});
   }
   
}
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
