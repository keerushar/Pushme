package com.keerushar.pushme;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class webview_you extends AppCompatActivity {

    WebView webview ;
    ProgressBar progressBar;
    ProgressBar progress;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        webview = findViewById(R.id.webview);

        url = getIntent().getStringExtra("url");
        webview.loadUrl(url);
        //   webView.loadUrl("file:///android_asset/himalaya.html");
        webview.getSettings().setJavaScriptEnabled(true);


        progress = findViewById(R.id.progress);
        progressBar = findViewById(R.id.progressbar);


        webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progress.setVisibility(View.GONE);
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progress.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.VISIBLE);
            }
        });

        webview.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                progressBar.setProgress(newProgress);
            }
        });
    }
}




