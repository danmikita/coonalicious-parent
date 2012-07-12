package com.linkmongrel.games.coonalicious;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.scoreloop.client.android.ui.EntryScreenActivity;
import com.scoreloop.client.android.ui.OnScoreSubmitObserver;
import com.scoreloop.client.android.ui.PostScoreOverlayActivity;
import com.scoreloop.client.android.ui.ScoreloopManagerSingleton;
import com.scoreloop.client.android.ui.ShowResultOverlayActivity;

public class MainActivity extends AndroidApplication implements
		OnScoreSubmitObserver, ScoreloopInterface {

	private static final int SHOW_RESULT = 0;
	private static final int POST_SCORE = 1;
	private int _submitStatus;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
		cfg.useGL20 = false;

		ScoreloopManagerSingleton.init(this, "mJifVdeKX/oFwYGBvrAdfGRb8Z/RQhlSDp+0JajpFLUO2OOBXsluJw==");

		ScoreloopManagerSingleton.get().setOnScoreSubmitObserver(this);

		initialize(new Coonalicious(this), cfg);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		ScoreloopManagerSingleton.destroy();
	}

	public void onScoreSubmit(int status, Exception error) {
		_submitStatus = status;
		startActivityForResult(
				new Intent(this, ShowResultOverlayActivity.class), SHOW_RESULT);
	}

	void SubmitScore(double score) {
		ScoreloopManagerSingleton.get().onGamePlayEnded((double) score, null);
		// score is the score you want to update in scoreloop
		// second argument is for modes and for a basic scoreboard like the one
		// in the game we did not have any so we pass null
	}

	public void OnActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
		case SHOW_RESULT:
			// if (_submitStatus != ScoreloopManager.STATUS_ERROR_NETWORK) {
			// Show the post-score activity unless there has been a network
			// error.
			startActivityForResult(new Intent(this,
					PostScoreOverlayActivity.class), POST_SCORE);
			// } else {

			finish();
			// }

			break;

		case POST_SCORE:

			// Here we get notified that the PostScoreOverlay has finished.
			// in this example this simply means that we're ready to return to
			// the main activity
			finish();
			break;
		default:
			break;
		}
	}

	public void OpenScoreloop() {
		startActivity(new Intent(this, EntryScreenActivity.class));
	}
	
	public void DestroyScoreLoop(){
		   ScoreloopManagerSingleton.destroy();
		}

}