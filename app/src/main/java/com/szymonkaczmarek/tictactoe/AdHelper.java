package com.szymonkaczmarek.tictactoe;

import android.content.Context;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class AdHelper {
    static String tylda = "ca-app-pub-1878000431593424~2210687768";

    public void setupAds(Context context, AdView mAdView){
        MobileAds.initialize(context,tylda);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}
