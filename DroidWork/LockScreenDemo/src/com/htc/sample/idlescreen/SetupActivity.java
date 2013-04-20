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

import android.app.Activity;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

/**
 * Checks for the presence of the lockscreen customization API,
 * enables the services for it if found, and prompts the user.
 *
 */
public class SetupActivity extends Activity {
	
	private static final String LOG_TAG = "LockScreenDemo SetupActivity";

	private static final String NEW_LOCKSCREEN_API_CLASS_NAME = "com.htc.lockscreen.fusion.open.SimpleEngine";

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setup);
		final TextView text = (TextView) findViewById(R.id.text);

		// Check for lockscreen API.
		final boolean isNewLockscreenApiSupported = isNewLockscreenApiSupported();
		Log.i(LOG_TAG, "isNewLockscreenApi: " + isNewLockscreenApiSupported);

		// If not supported, let the user know and finish executing.
		if ( !isNewLockscreenApiSupported ) {
			text.setText(R.string.setup_prompt_not_supported);
			return;
		}
		
		// Otherwise enable lockscreen service and let user know how to enable.
		text.setText(R.string.setup_prompt_supported);
		final ComponentName name = new ComponentName(this, SampleService.class);
		Log.i(LOG_TAG, "enabling service: " + name);	
		final PackageManager pm = (PackageManager) getPackageManager();		
		pm.setComponentEnabledSetting(name, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
	}

	/**
	 * @return true if the lockscreen API is supported
	 */
    public static final boolean isNewLockscreenApiSupported() {
        try {
            Class.forName(NEW_LOCKSCREEN_API_CLASS_NAME);
            return true;
        } catch (final ClassNotFoundException e) {
        }
        return false;
    }

}
