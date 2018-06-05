package kr.csh.magazine;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ContentActivity extends AppCompatActivity {
    WebView contentWebView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contentWebView=(WebView)findViewById(R.id.webView);
        WebSettings webSettings = contentWebView.getSettings();
        // 폼 입력값 저장
        webSettings.setSaveFormData(true);
        // 줌 사용 : HTML Meta 태그에 적어놓은 설정 우선
        webSettings.setSupportZoom(false);
        webSettings.setDisplayZoomControls(false);
        //javascript 사용
        webSettings.setJavaScriptEnabled(true);
        //localStorage 사용
        webSettings.setDomStorageEnabled(true);
        //위치 정보 사용
        webSettings.setGeolocationEnabled(true);
        //JS의 window.open() 사용
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        // HTTPS와 HTTP 연동
        if(Build.VERSION.SDK_INT >= 16){
            webSettings.setAllowFileAccessFromFileURLs(true);
            webSettings.setAllowUniversalAccessFromFileURLs(true);
        }
        if(Build.VERSION.SDK_INT >= 21){
            webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        contentWebView.setWebViewClient(new WebViewClient());

        contentWebView.setVerticalScrollBarEnabled(false);
        contentWebView.setHorizontalScrollBarEnabled(false);

        webSettings.setLoadWithOverviewMode(true);


    }
}
