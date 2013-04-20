/*
 * Copyright (C) 2012 HTC Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.htc.sample.idlescreen;

import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;

import com.htc.lockscreen.fusion.open.SimpleEngine;
import com.htc.lockscreen.fusion.open.SimpleIdleScreenService;
import com.htc.sample.idlescreen.widget.AlarmAnime;

/**
 * Creates a lockscreen that is displayed when the user turns on their phone's screen,
 * before they pull the lockscreen ring to unlock the phone.
 *
 */
public class SampleService extends SimpleIdleScreenService {

	@Override
	public SimpleEngine onCreateEngine() {
		return new IdleScreenRemoteEngine();
	}
	
	public class IdleScreenRemoteEngine extends SimpleEngine implements OnClickListener, OnTouchListener{

		private Button mButton;
		
		private AlarmAnime mClock;

		private boolean mStart = false;

		public IdleScreenRemoteEngine() {
		}
		
		public void onCreate(SurfaceHolder holder) {
			this.setContent(R.layout.lockscreen);
			this.setShowLiveWallpaper(false);
			this.setBackground(R.drawable.background);
			
			mClock = (AlarmAnime)this.findViewById(R.id.clock);
			mButton = (Button)this.findViewById(R.id.button1);
			mButton.setOnClickListener(this);
			mButton.setOnTouchListener(this);
		}
		
		public void onStart() {			
		}
		
		public void onResume() {
		}
		
		public void onPause() {
		}
		
		public void onStop() {
		}
		
		public void onDestroy() {
		}
		
		@Override
		public void onClick(View view) {
			if (!mStart) {
				mClock.startAnime();
				mButton.setText(R.string.button2);
				mStart = true;
			}
			else {
				mClock.stopAnime();
				mButton.setText(R.string.button1);
				mStart = false;
			}
		}

		@Override
		public boolean onTouch(View arg0, MotionEvent event) {
			if (event.getAction() == MotionEvent.ACTION_DOWN) {
				skipShowHint();
			}
			return false;
		}
	}
}

