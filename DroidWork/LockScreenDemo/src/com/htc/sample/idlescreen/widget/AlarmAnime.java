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

package com.htc.sample.idlescreen.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;

import com.htc.sample.idlescreen.R;

/**
 * Displays an alarm clock with moving hands that can also animate itself bouncing around.
 *
 */
public class AlarmAnime extends View {

	private static final int s_frame_size = 40;
	
	private static final int[] s_rotations = {
		0, 4, 6, 8, 10,
		12, 12, 10, 8, 6,
		2, 0, -2, -3, -5,
		-7, -9, -9, -7, -5, 
		-3, 0, 4, 8, 10, 
		10, 8, 5, 3, 1,
		0, -2, -4, -8, -10,
		-10, -8, -6, -2, 0};
	
	private static final int[] s_moves = {
		-32 , -40, -10, 0, 0,
		5, 5, -5, -10, -20,
		-40, -25, -5 , -5 , 5,
		-10, -20, -32 , -10 , -8, 
		-5, 5, 5, -10, 5,
		0, -5, -10, -20, -32,
		-5, 5, 5, -10, 5,
		0, -5, -10, -20, -32};
	
	private static final int s_frameDelay = 70;

	private Drawable mAlarmBody;
	
	private int mAlarmDif = 0;
	
	private int mFrame = 0;

	int mOld = -100;
	
	Handler mUIHandler = new Handler() {
		public void handleMessage(Message msg) {
			mFrame = mFrame + 1;
			if (mFrame >= s_frame_size) {
				mFrame = 0;
			}
			invalidate();
			mUIHandler.removeMessages(1);
			this.sendEmptyMessageDelayed(1, s_frameDelay);
		}
	};
	
	public AlarmAnime(Context context) {
		super(context);
		initView();
	}
	
	public AlarmAnime(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView();
	}
	
	public AlarmAnime(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initView();
	}
	
	public void initView() {
		Resources res = getContext().getResources();
		mAlarmDif = (int)res.getDimension(R.dimen.alarm_body_dif);
		initBitmap();
	}
	
	public void startAnime() {
		mUIHandler.removeMessages(1);
		mUIHandler.sendEmptyMessageDelayed(1, s_frameDelay);
	}
	
	public void stopAnime() {
		mUIHandler.removeMessages(1);
		if (mOld != -100) {
			mOld = -100;
		}
	}
	
	public void initBitmap() {
		Resources res = getContext().getResources();
		if (mAlarmBody == null) {
			ClockBitmap clockBitmap = new ClockBitmap(getContext());
			mAlarmBody = new BitmapDrawable(res, clockBitmap.getClockBitmap(true));
	    }
	}
	
	@Override
	public void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		//draw body
		int rotation = s_rotations[mFrame];
		int move = s_moves[mFrame];
		
		int availableWidth = this.getWidth();

        final Drawable body = mAlarmBody;
        int bodyH = body.getIntrinsicHeight();
        
        int x = availableWidth / 2;
        int y = bodyH - move - mAlarmDif;
        
		canvas.save();
        canvas.rotate(rotation, x, y);
        
        int w = body.getIntrinsicWidth();
        
        body.setBounds(x - (w / 2), y - (bodyH - mAlarmDif)  , x + (w / 2), y + mAlarmDif);
        body.draw(canvas);
        canvas.restore();
	}
}
