package com.lz233.onetext.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lz233.onetext.BuildConfig;
import com.lz233.onetext.R;
import com.lz233.onetext.tools.utils.AppUtil;

import io.noties.markwon.Markwon;

public class AboutActivity extends BaseActivity {
    private ImageView green_android_imageview;
    private ImageView storage_isolation_imageview;
    private ImageView coolapk_imageview;
    private ImageView msappcenter_imageview;
    private ImageView github_imageview;
    private ImageView telegram_imageview;
    private ImageView mstodo_imageview;
    private TextView ver_textview;
    private TextView about_textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        //曲 线 救 国
        fuckNav(findViewById(R.id.about_textview));
        //fb
        green_android_imageview = findViewById(R.id.green_android_imageview);
        storage_isolation_imageview = findViewById(R.id.storage_isolation_imageview);
        coolapk_imageview = findViewById(R.id.coolapk_imageview);
        msappcenter_imageview = findViewById(R.id.msappcenter_imageview);
        github_imageview = findViewById(R.id.github_imageview);
        telegram_imageview = findViewById(R.id.telegram_imageview);
        mstodo_imageview = findViewById(R.id.mstodo_imageview);
        ver_textview = findViewById(R.id.ver_textview);
        about_textview = findViewById(R.id.about_textview);
        //初始化
        if (BuildConfig.BUILD_TYPE.equals("GooglePlay")){
            coolapk_imageview.setVisibility(View.GONE);
            msappcenter_imageview.setVisibility(View.GONE);
        }
        green_android_imageview.setOnClickListener(v -> startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://green-android.org"))));
        storage_isolation_imageview.setOnClickListener(v -> startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/RikkaApps/StorageRedirect-assets/blob/master/app_rule/apps/com.lz233.onetext.json"))));
        coolapk_imageview.setOnClickListener(view -> startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://coolapk.com/apk/com.lz233.onetext"))));
        msappcenter_imageview.setOnClickListener(view -> startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://install.appcenter.ms/users/lz233/apps/onetext/distribution_groups/onetext%20testgroup"))));
        github_imageview.setOnClickListener(view -> startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/lz233/OneText_For_Android"))));
        telegram_imageview.setOnClickListener(view -> startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/OneTextProject"))));
        mstodo_imageview.setOnClickListener(view -> startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://to-do.microsoft.com/sharing?InvitationToken=WI9tpCxeg9ktR5mg-AI-qwPXapdT_kGucjpSBCP6fwLE9bN5Uz2vS61gY9X8RTaC0"))));
        //ver_textview.setText(AppUtil.getAppVersionName(AboutActivity.this) + " (" + String.valueOf(AppUtil.getAppVersionCode(AboutActivity.this) + ")"));
        ver_textview.setText(BuildConfig.VERSION_NAME+" "+BuildConfig.VERSION_CODE+"\n"+BuildConfig.BUILD_TYPE);
        final Markwon markwon = Markwon.create(getApplicationContext());
        markwon.setMarkdown(about_textview, getString(R.string.about_page_introduction));

    }
}
