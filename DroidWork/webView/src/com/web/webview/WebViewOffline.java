package com.web.webview;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebViewOffline extends Activity {
	private WebView webView;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.offline);
        
      //Set Id layout
        webView = (WebView) findViewById(R.id.webView1);
        //Setting and Go
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/myResume.html");
    }
}