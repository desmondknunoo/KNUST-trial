package com.example.knusttrial;

import android.app.Activity; 
import android.content.Intent; 
import android.os.Bundle; 
import android.view.Menu; 
import android.view.View; 
import android.webkit.WebSettings; 
import android.webkit.WebView; 
import android.widget.ShareActionProvider; 
 
 
 
 
public class MainActivity extends Activity { 
 
     private WebView mWebView; 
 
 
     @Override 
     protected void onCreate(Bundle savedInstanceState) { 
         super.onCreate(savedInstanceState); 
         setContentView(R.layout.activity_main); 
 
 
         mWebView = (WebView) findViewById(R.id.activity_main_webview); 
         WebSettings webSettings = mWebView.getSettings(); 
         webSettings.setJavaScriptEnabled(true); 
         mWebView.loadUrl("https://knust.edu.gh/"); 
         mWebView.setWebViewClient(new com.example.knusttrial.MyAppWebViewClient(){ 
             @Override 
             public void onPageFinished(WebView view, String url) { 
                 //hide loading image 
                 findViewById(R.id.progressBar1).setVisibility(View.GONE); 
                 //show webview 
                 findViewById(R.id.activity_main_webview).setVisibility(View.VISIBLE); 
             }}); 
  
 
     } 
 
      @Override 
     public void onBackPressed() { 
         if(mWebView.canGoBack()) { 
             mWebView.goBack(); 
         } else { 
             super.onBackPressed(); 
         } 
     } 
 
  
 
    private ShareActionProvider mShareActionProvider; 
     @Override 
     public boolean onCreateOptionsMenu(Menu menu) { 
 
          /** Inflating the current activity's menu with res/menu/items.xml */ 
         getMenuInflater().inflate(R.menu.main, menu); 
 
 
         /** Getting the actionprovider associated with the menu item whose id is share */ 
         mShareActionProvider = (ShareActionProvider) menu.findItem(R.id.share).getActionProvider(); 
 
 
         /** Setting a share intent */ 
         mShareActionProvider.setShareIntent(getDefaultShareIntent()); 
 
 
         return super.onCreateOptionsMenu(menu); 
 
      } 

     /** Returns a share intent */ 
     private Intent getDefaultShareIntent(){ 
         Intent intent = new Intent(Intent.ACTION_SEND); 
         intent.setType("text/plain"); 
         intent.putExtra(Intent.EXTRA_SUBJECT, "KNUST(trial) app."); 
         intent.putExtra(Intent.EXTRA_TEXT,"This is a trial version"); 
         return intent; 
     } 
 
 
 
 } 
