package com.opustechinc.navigationdrawer;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.util.Log;

import java.io.File;

public class MainActivity extends AppCompatActivity  {

    private WebView mywebview;
    private ProgressBar progressBar;
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    private RelativeLayout pl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Connecting to the website
        mywebview = (WebView) findViewById(R.id.webView);
        WebSettings websettings = mywebview.getSettings();
        websettings.setJavaScriptEnabled(true);
        mywebview.loadUrl("https://laikipia.go.ke/");
        mywebview.setWebViewClient(new WebViewClient());

        dl = (DrawerLayout)findViewById(R.id.activity_main);
        t = new ActionBarDrawerToggle(this, dl,R.string.Open, R.string.Close);
        dl.addDrawerListener(t);
        t.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        nv = (NavigationView)findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                int id = item.getItemId();
                switch(id)
                {
                    case R.id.home:
                        //Toast.makeText(MainActivity.this, "My Account",Toast.LENGTH_SHORT).show();
//                        if(item.isChecked())
//                            item.setChecked(false);
//                        else
                            mywebview = (WebView) findViewById(R.id.webView);
                            WebSettings homepage = mywebview.getSettings();
                            homepage.setJavaScriptEnabled(true);
                            mywebview.loadUrl("https://laikipia.go.ke/home/");
                            mywebview.setWebViewClient(new WebViewClient());

                            dl.closeDrawers();

                        return true;
                    case R.id.govt:
                        //Toast.makeText(MainActivity.this, "Settings",Toast.LENGTH_SHORT).show();
//
                            mywebview = (WebView) findViewById(R.id.webView);
                        WebSettings govt = mywebview.getSettings();
                        govt.setJavaScriptEnabled(true);
                        mywebview.loadUrl("https://laikipia.go.ke/government/");
                        mywebview.setWebViewClient(new WebViewClient());

                        dl.closeDrawers();

                        return true;

                    case R.id.ecitizen:
                        //Toast.makeText(MainActivity.this, "My Cart",Toast.LENGTH_SHORT).show();
//
                            mywebview = (WebView) findViewById(R.id.webView);
                        WebSettings e_citizen = mywebview.getSettings();
                        e_citizen.setJavaScriptEnabled(true);
                        mywebview.loadUrl("https://laikipia.go.ke/e-citizen-services/");
                        mywebview.setWebViewClient(new WebViewClient());

                        dl.closeDrawers();

                        return true;

                    case R.id.mediacenter:
                        //Toast.makeText(MainActivity.this, "My Cart",Toast.LENGTH_SHORT).show();
                            mywebview = (WebView) findViewById(R.id.webView);
                        WebSettings mediacenter = mywebview.getSettings();
                        mediacenter.setJavaScriptEnabled(true);
                        mywebview.loadUrl("https://laikipia.go.ke/gallery/");
                        mywebview.setWebViewClient(new WebViewClient());

                        dl.closeDrawers();

                        return true;

                    case R.id.invest:
                        //Toast.makeText(MainActivity.this, "My Cart",Toast.LENGTH_SHORT).show();
                            mywebview = (WebView) findViewById(R.id.webView);
                        WebSettings invest = mywebview.getSettings();
                        invest.setJavaScriptEnabled(true);
                        mywebview.loadUrl("https://laikipia.go.ke/invest-in-laikipia/");
                        mywebview.setWebViewClient(new WebViewClient());

                        dl.closeDrawers();

                        return true;

                    case R.id.resourcecenter:
                        //Toast.makeText(MainActivity.this, "My Cart",Toast.LENGTH_SHORT).show();
//
                        mywebview = (WebView) findViewById(R.id.webView);
                        WebSettings resourcecenter = mywebview.getSettings();
                        resourcecenter.setJavaScriptEnabled(true);
                        mywebview.loadUrl("https://laikipia.go.ke/resources/");
                        mywebview.setWebViewClient(new WebViewClient());

                        dl.closeDrawers();

                        return true;

                    case R.id.regards:
                        //Toast.makeText(MainActivity.this, "My Cart",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(MainActivity.this, Developer.class));

                        dl.closeDrawers();

                        return true;

//                    case R.id.share:
//                        //Toast.makeText(MainActivity.this, "My Cart",Toast.LENGTH_SHORT).show();
//                            ApplicationInfo api = getApplicationContext().getApplicationInfo();
//                            String apkPath = api.sourceDir;
////
////                            Intent i = new Intent(Intent.ACTION_SEND);
////                            i.setType("application/vnd.android.package-archive");
////
////                            i.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(apkPath)));
////                            startActivity(Intent.createChooser(i, "Share app using"));
////
////                            dl.closeDrawers();
////                        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
////                        sharingIntent.setType("application/vnd.android.package-archive");
////
////                        startActivity(Intent.createChooser(sharingIntent, "Share app via..."));
////
////
////
////                    dl.closeDrawers();
////
//
//                        return true;

                    case R.id.feedback:
                        //Toast.makeText(MainActivity.this, "My Cart",Toast.LENGTH_SHORT).show();
                        Log.i("Send email", "");
                        String[] TO = {""};
                        String[] CC = {""};
                        Intent emailIntent = new Intent(Intent.ACTION_SEND);

                        emailIntent.setData(Uri.parse("mailto:"));
                        emailIntent.setType("text/plain");
                        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                        emailIntent.putExtra(Intent.EXTRA_CC, CC);
                        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
                        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

                        try {
                            startActivity(Intent.createChooser(emailIntent, "Send mail..."));

                            Log.i("Sending mail finished.", "");
                        } catch (android.content.ActivityNotFoundException ex) {
                            Toast.makeText(MainActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
                        }

                            dl.closeDrawers();

                        return true;

                    case R.id.about:
                        //Toast.makeText(MainActivity.this, "My Cart",Toast.LENGTH_SHORT).show();
//                        if(item.isChecked())
//                            item.setChecked(false);
//                        else
                        startActivity(new Intent(MainActivity.this, Info.class));

                        dl.closeDrawers();

                        return true;

                    default:
                        return true;
                }
            }
        });

        mywebview.setDownloadListener(new DownloadListener() {

            @Override
            public void onDownloadStart(String url, String userAgent,String contentDisposition, String mimetype,long contentLength) {
                DownloadManager.Request request = new DownloadManager.Request(
                        Uri.parse(url));

                request.allowScanningByMediaScanner();

                //Notifying the client once download is completed!
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "Name of your downloadable file goes here, example: Mathematics II ");
                DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                dm.enqueue(request);

                //Notifying the Client that the file is being downloaded
                Toast.makeText(getApplicationContext(), "Downloading File", Toast.LENGTH_LONG).show();

            }
        });

        mywebview.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                progressBar = (ProgressBar) findViewById(R.id.progressBar);
                progressBar.setIndeterminate(true);
                progressBar.setVisibility(View.VISIBLE);
            }
        });

        mywebview.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                progressBar = (ProgressBar) findViewById(R.id.progressBar);
                progressBar.setVisibility(View.GONE);
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(t.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if(mywebview.canGoBack()){
            mywebview.goBack();
        }else {
            super.onBackPressed();
        }
    }

}
