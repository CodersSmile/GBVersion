package com.kessi.wawbstatussaver.waweb;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.DownloadListener;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.kessi.wawbstatussaver.R;
import com.kessi.wawbstatussaver.util.SharedPrefs;
import com.kessi.wawbstatussaver.util.Utils;

import java.util.Arrays;
import java.util.Locale;

public class WAWebActivity extends AppCompatActivity {
    private static final String AUDIO_PERMISSION = "android.permission.RECORD_AUDIO";
    private static final int AUDIO_PERMISSION_RESULTCODE = 202;
    private static final String CAMERA_PERMISSION = "android.permission.CAMERA";
    private static final int CAMERA_PERMISSION_RESULTCODE = 201;
    private static final String CHROME_FULL = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36";
    public static final String DEBUG_TAG = "KESSI";
    private static final int FILECHOOSER_RESULTCODE = 200;
    private static final String STORAGE_PERMISSION = "android.permission.WRITE_EXTERNAL_STORAGE";
    private static final int STORAGE_PERMISSION_RESULTCODE = 204;
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36";
    /* access modifiers changed from: private */
    public static final String[] VIDEO_PERMISSION = {CAMERA_PERMISSION, AUDIO_PERMISSION};
    private static final int VIDEO_PERMISSION_RESULTCODE = 203;
    private static final String WHATSAPP_HOMEPAGE_URL = "https://www.whatsapp.com/";
    private static final String WHATSAPP_WEB_BASE_URL = "web.whatsapp.com";
    private static final String WHATSAPP_WEB_URL = ("https://web.whatsapp.com/🌐/" + Locale.getDefault().getLanguage());
    private static final String WORLD_ICON = "🌐";
    /* access modifiers changed from: private */
    public final Activity activity = this;
    ImageView back;
    LinearLayout container;
    /* access modifiers changed from: private */
    public String mCurrentDownloadRequest = null;
    /* access modifiers changed from: private */
    public PermissionRequest mCurrentPermissionRequest;
    private long mLastBackClick = 0;
    /* access modifiers changed from: private */
    public ValueCallback<Uri[]> mUploadMessage;
    /* access modifiers changed from: private */
    public WebView mWebView;
    ImageView refresh;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_waweb);
        Utils.setLanguage(this, SharedPrefs.getLang(this));
        getWindow().setSoftInputMode(16);
        ImageView imageView = (ImageView) findViewById(R.id.back);
        this.back = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WAWebActivity.this.onBackPressed();
            }
        });
        this.container = (LinearLayout) findViewById(R.id.banner_container);
        WebView webView = (WebView) findViewById(R.id.webview);
        this.mWebView = webView;
        webView.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                String unused = WAWebActivity.this.mCurrentDownloadRequest = str;
                if (WAWebActivity.this.checkPermission(WAWebActivity.STORAGE_PERMISSION)) {
                    WAWebActivity.this.mWebView.loadUrl(BlobDownloader.getBase64StringFromBlobUrl(str));
                    WAWebActivity.this.triggerDownload();
                    return;
                }
                WAWebActivity.this.requestPermission(WAWebActivity.STORAGE_PERMISSION);
            }
        });
        this.mWebView.addJavascriptInterface(new BlobDownloader(getApplicationContext()), BlobDownloader.JsInstance);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.getSettings().setAllowContentAccess(true);
        this.mWebView.getSettings().setAllowFileAccess(true);
        this.mWebView.getSettings().setAllowFileAccessFromFileURLs(true);
        this.mWebView.getSettings().setAllowUniversalAccessFromFileURLs(true);
        this.mWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        this.mWebView.getSettings().setDomStorageEnabled(true);
        this.mWebView.getSettings().setDatabaseEnabled(true);
//        this.mWebView.getSettings().setAppCacheEnabled(false);
        this.mWebView.getSettings().setCacheMode(-1);
        this.mWebView.getSettings().setLoadWithOverviewMode(true);
        this.mWebView.getSettings().setUseWideViewPort(true);
        this.mWebView.getSettings().setSupportZoom(true);
        this.mWebView.getSettings().setBuiltInZoomControls(true);
        this.mWebView.getSettings().setDisplayZoomControls(false);
        this.mWebView.getSettings().setSaveFormData(true);
        this.mWebView.getSettings().setLoadsImagesAutomatically(true);
        this.mWebView.getSettings().setBlockNetworkImage(false);
        this.mWebView.getSettings().setBlockNetworkLoads(false);
        this.mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.mWebView.getSettings().setNeedInitialFocus(false);
        this.mWebView.getSettings().setGeolocationEnabled(true);
        this.mWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        this.mWebView.setScrollBarStyle(0);
        this.mWebView.setScrollbarFadingEnabled(true);
        this.mWebView.setWebChromeClient(new WebChromeClient() {
            public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
                Toast.makeText(WAWebActivity.this.getApplicationContext(), "OnCreateWindow", 1).show();
                return true;
            }

            public void onPermissionRequest(PermissionRequest permissionRequest) {
                if (permissionRequest.getResources()[0].equals("android.webkit.resource.VIDEO_CAPTURE")) {
                    if (ContextCompat.checkSelfPermission(WAWebActivity.this.activity, WAWebActivity.CAMERA_PERMISSION) == -1 && ContextCompat.checkSelfPermission(WAWebActivity.this.activity, WAWebActivity.AUDIO_PERMISSION) == -1) {
                        ActivityCompat.requestPermissions(WAWebActivity.this.activity, WAWebActivity.VIDEO_PERMISSION, WAWebActivity.VIDEO_PERMISSION_RESULTCODE);
                        PermissionRequest unused = WAWebActivity.this.mCurrentPermissionRequest = permissionRequest;
                    } else if (ContextCompat.checkSelfPermission(WAWebActivity.this.activity, WAWebActivity.CAMERA_PERMISSION) == -1) {
                        ActivityCompat.requestPermissions(WAWebActivity.this.activity, new String[]{WAWebActivity.CAMERA_PERMISSION}, WAWebActivity.CAMERA_PERMISSION_RESULTCODE);
                        PermissionRequest unused2 = WAWebActivity.this.mCurrentPermissionRequest = permissionRequest;
                    } else if (ContextCompat.checkSelfPermission(WAWebActivity.this.activity, WAWebActivity.AUDIO_PERMISSION) == -1) {
                        ActivityCompat.requestPermissions(WAWebActivity.this.activity, new String[]{WAWebActivity.AUDIO_PERMISSION}, WAWebActivity.AUDIO_PERMISSION_RESULTCODE);
                        PermissionRequest unused3 = WAWebActivity.this.mCurrentPermissionRequest = permissionRequest;
                    } else {
                        permissionRequest.grant(permissionRequest.getResources());
                    }
                } else if (!permissionRequest.getResources()[0].equals("android.webkit.resource.AUDIO_CAPTURE")) {
                    try {
                        permissionRequest.grant(permissionRequest.getResources());
                    } catch (RuntimeException e) {
                        Log.d(WAWebActivity.DEBUG_TAG, "Granting permissions failed", e);
                    }
                } else if (ContextCompat.checkSelfPermission(WAWebActivity.this.activity, WAWebActivity.AUDIO_PERMISSION) == 0) {
                    permissionRequest.grant(permissionRequest.getResources());
                } else {
                    ActivityCompat.requestPermissions(WAWebActivity.this.activity, new String[]{WAWebActivity.AUDIO_PERMISSION}, WAWebActivity.AUDIO_PERMISSION_RESULTCODE);
                    PermissionRequest unused4 = WAWebActivity.this.mCurrentPermissionRequest = permissionRequest;
                }
            }

            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                Log.d(WAWebActivity.DEBUG_TAG, "WebView console message: " + consoleMessage.message());
                return super.onConsoleMessage(consoleMessage);
            }

            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
                ValueCallback unused = WAWebActivity.this.mUploadMessage = valueCallback;
                WAWebActivity.this.startActivityForResult(fileChooserParams.createIntent(), 200);
                return true;
            }
        });
        this.mWebView.setWebViewClient(new WebViewClient() {
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            public void onPageCommitVisible(WebView webView, String str) {
                super.onPageCommitVisible(webView, str);
            }

            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                webView.scrollTo(0, 0);
            }

            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                Uri url = webResourceRequest.getUrl();
                Log.d(WAWebActivity.DEBUG_TAG, url.toString());
                if (url.toString().equals(WAWebActivity.WHATSAPP_HOMEPAGE_URL)) {
                    WAWebActivity.this.showToast("WA Web has to be reloaded to keep the app running");
                    WAWebActivity.this.loadWhatsapp();
                    return true;
                } else if (url.getHost().equals(WAWebActivity.WHATSAPP_WEB_BASE_URL)) {
                    return super.shouldOverrideUrlLoading(webView, webResourceRequest);
                } else {
                    WAWebActivity.this.startActivity(new Intent("android.intent.action.VIEW", url));
                    return true;
                }
            }

            @SuppressLint("NewApi")
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                Log.d(WAWebActivity.DEBUG_TAG, String.format("Error: %s - %s", new Object[]{Integer.valueOf(webResourceError.getErrorCode()), webResourceError.getDescription()}));
            }

            public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
                Log.d(WAWebActivity.DEBUG_TAG, "Unhandled key event: " + keyEvent.toString());
            }
        });
        if (bundle == null) {
            loadWhatsapp();
        } else {
            Log.d(DEBUG_TAG, "savedInstanceState is present");
        }
        this.mWebView.getSettings().setUserAgentString("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36");
        ImageView imageView2 = (ImageView) findViewById(R.id.refresh);
        this.refresh = imageView2;
        imageView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WAWebActivity.this.showToast("Reloading...");
                WAWebActivity.this.loadWhatsapp();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.mWebView.onResume();

    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.mWebView.onPause();

    }

    /* access modifiers changed from: private */
    public boolean checkPermission(String str) {
        return ContextCompat.checkSelfPermission(this.activity, str) == 0;
    }

    /* access modifiers changed from: private */
    public void requestPermission(String str) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this.activity, str)) {
            ActivityCompat.requestPermissions(this.activity, new String[]{str}, STORAGE_PERMISSION_RESULTCODE);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        switch (i) {
            case CAMERA_PERMISSION_RESULTCODE /*201*/:
            case AUDIO_PERMISSION_RESULTCODE /*202*/:
                if (iArr.length > 0 && iArr[0] == 0) {
                    try {
                        PermissionRequest permissionRequest = this.mCurrentPermissionRequest;
                        permissionRequest.grant(permissionRequest.getResources());
                        break;
                    } catch (RuntimeException e) {
                        Log.e(DEBUG_TAG, "Granting permissions failed", e);
                        break;
                    }
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Permission not granted, can't use ");
                    sb.append(i == CAMERA_PERMISSION_RESULTCODE ? "camera" : "microphone");
                    showToast(sb.toString());
                    this.mCurrentPermissionRequest.deny();
                    break;
                }
            case VIDEO_PERMISSION_RESULTCODE /*203*/:
                if (strArr.length != 2 || iArr[0] != 0 || iArr[1] != 0) {
                    showToast("Permission not granted, can't use video.");
                    this.mCurrentPermissionRequest.deny();
                    break;
                } else {
                    try {
                        PermissionRequest permissionRequest2 = this.mCurrentPermissionRequest;
                        permissionRequest2.grant(permissionRequest2.getResources());
                        break;
                    } catch (RuntimeException e2) {
                        Log.e(DEBUG_TAG, "Granting permissions failed", e2);
                        break;
                    }
                }
            case STORAGE_PERMISSION_RESULTCODE /*204*/:
                if (iArr.length > 0 && iArr[0] == 0) {
                    triggerDownload();
                    break;
                } else {
                    showToast("Permission not granted, can't download");
                    this.mCurrentDownloadRequest = null;
                    break;
                }
            default:
                Log.d(DEBUG_TAG, "Got permission result with unknown request code " + i + " - " + Arrays.asList(strArr).toString());
                break;
        }
        this.mCurrentPermissionRequest = null;
    }

    /* access modifiers changed from: private */
    public void loadWhatsapp() {
        this.mWebView.getSettings().setUserAgentString("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36");
        this.mWebView.loadUrl(WHATSAPP_WEB_URL);
    }

    /* access modifiers changed from: private */
    public void triggerDownload() {
        String str = this.mCurrentDownloadRequest;
        if (str != null) {
            this.mWebView.loadUrl(BlobDownloader.getBase64StringFromBlobUrl(str));
        }
        this.mCurrentDownloadRequest = null;
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.mWebView.saveState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.mWebView.restoreState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 200) {
            Log.d(DEBUG_TAG, "Got activity result with unknown request code " + i + " - " + intent.toString());
        } else if (i2 == 0 || intent.getData() == null) {
            this.mUploadMessage.onReceiveValue((Uri[]) null);
        } else {
            this.mUploadMessage.onReceiveValue(new Uri[]{intent.getData()});
        }
    }

    /* access modifiers changed from: private */
    public void showToast(final String str) {
        runOnUiThread(new Runnable() {
            public void run() {
                Toast.makeText(WAWebActivity.this, str, 0).show();
            }
        });
    }

    public void onBackPressed() {
        /*if (System.currentTimeMillis() - this.mLastBackClick < 1100) {
            super.onBackPressed();
            return;
        }
        showToast("Click back again to close");
*/
        super.onBackPressed();
    }
}
