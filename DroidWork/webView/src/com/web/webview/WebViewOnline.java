package com.web.webview;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebViewOnline extends Activity {  
  //Create Local Variable
    private WebView webView;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.online);
        
        //Set Id layout
        webView = (WebView) findViewById(R.id.webView1);
        //Setting and Go
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://www.google.co.th");
    }
}