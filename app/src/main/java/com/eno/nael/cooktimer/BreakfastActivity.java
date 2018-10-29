package com.eno.nael.cooktimer;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class BreakfastActivity extends AppCompatActivity {
    WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast);

        webview = findViewById(R.id.web);
        try {
            webView("https://www.foodinaminute.co.nz/Recipe-Categories/Breakfast-Ideas-Recipes");
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this, "PROBLEM WITH CONNECTION!\n TRY AGAIN", Toast.LENGTH_SHORT).show();
        }


    }

    @SuppressLint("SetJavaScriptEnabled")
    private void webView(String url) {

        webview.getSettings().setJavaScriptEnabled(true);

        webview.setWebViewClient(new MyWebViewClient());

        webview.loadUrl(url);
    }


    @Override
    public void onBackPressed() {
        if (webview.canGoBack()) {
            webview.goBack();
        } else {
            super.onBackPressed();
        }
    }


    private class MyWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return false;
        }
    }

}
