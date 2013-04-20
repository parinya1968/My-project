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
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.format.Time;

import com.htc.sample.idlescreen.R;

/**
 * Generates a bitmap image of a clock with the hands correctly positioned to match the time.
 *
 */
public class ClockBitmap {
	
	public static final String LOG_PREFIX = "ClockBitmap";
    
	private Drawable mHourHand;
    
	private Drawable mMinuteHand;
    
	private Drawable mDial;
    
	private Drawable mBackground;
        
    private Time mCalendar;
    
    private float mMinutes;
    
    private float mHour;
	
    public ClockBitmap(Context context) {
		Resources res = context.getResources();
		mBackground = res.getDrawable(R.drawable.alarm_body);
		mHourHand = res.getDrawable(R.drawable.alarm_hours);
		mMinuteHand = res.getDrawable(R.drawable.alarm_minutes);
		mDial = res.getDrawable(R.drawable.alarm_dot);
		
		mCalendar = new Time();
	}
	
	private void onTimeChanged() {
        mCalendar.setToNow();

        int hour = mCalendar.hour;
        int minute = mCalendar.minute;
        int second = mCalendar.second;

        mMinutes = minute + second / 60.0f;
        mHour = hour + mMinutes / 60.0f;
    }
	
	public Bitmap getClockBitmap(boolean updateTime) {
		if (updateTime)
			onTimeChanged();
		int width = mBackground.getIntrinsicWidth();
		int height = mBackground.getIntrinsicHeight();

		if(width <= 0 || height <= 0){
			android.util.Log.e(LOG_PREFIX, "buildCache error!!! width = " + width + ", height = " + height);
			return null;
		}
	    Bitmap cacheBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
	    Canvas cacheCanvas = new Canvas(cacheBitmap);
	    cacheCanvas.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
	    this.onDraw(cacheCanvas);
    	return cacheBitmap;
	}

    protected void onDraw(Canvas canvas) {

        int availableWidth = canvas.getWidth();
        int availableHeight = canvas.getHeight();
       
        int x = availableWidth / 2;
        int y = availableHeight / 2;

        boolean scaled = false;

        final Drawable background = mBackground;
        int w = background.getIntrinsicWidth();
        int h = background.getIntrinsicHeight();
        background.setBounds(x - (w / 2), y - (h / 2), x + (w / 2), y + (h / 2));
        background.draw(canvas);
       
        canvas.save();
        canvas.rotate(mHour / 12.0f * 360.0f, x, y);

        final Drawable hourHand = mHourHand;
        w = hourHand.getIntrinsicWidth();
        h = hourHand.getIntrinsicHeight();
        hourHand.setBounds(x - (w / 2), y - (h / 2), x + (w / 2), y + (h / 2));
        hourHand.draw(canvas);
        canvas.restore();

        canvas.save();
        canvas.rotate(mMinutes / 60.0f * 360.0f, x, y);

        final Drawable minuteHand = mMinuteHand;
        w = minuteHand.getIntrinsicWidth();
        h = minuteHand.getIntrinsicHeight();
        minuteHand.setBounds(x - (w / 2), y - (h / 2), x + (w / 2), y + (h / 2));
        minuteHand.draw(canvas);
        canvas.restore();

        final Drawable dial = mDial;
        w = dial.getIntrinsicWidth();
        h = dial.getIntrinsicHeight();
        dial.setBounds(x - (w / 2), y - (h / 2), x + (w / 2), y + (h / 2));
        dial.draw(canvas);
        
        if (scaled) {
            canvas.restore();
        }
    }
}
