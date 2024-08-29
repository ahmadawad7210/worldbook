package ahmad.awad.fekry.worldbook;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Typeface;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
//import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.FullScreenContentCallback;

//import com.ironsource.mediationsdk.IronSource;
//import com.startapp.android.publish.adsCommon.StartAppAd;
//import com.startapp.android.publish.adsCommon.StartAppSDK;

import java.util.ArrayList;

public class Favorit extends Shard {

    FavoritAdapt Fadapter;
    private ListView list;
    private ArrayList<Integer> pages;
    private Database myDB;
    private InterstitialAd mInterstitialAd;
    private static final String TAG = "Favorit";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  StartAppSDK.init(this, getString(R.string.startapp), false);
      //  StartAppAd.disableSplash();
        setContentView(R.layout.activity_favorit);
        //MobileAds.initialize(this, getString(R.string.YOUR_ADMOB_APP_ID));
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        RequestConfiguration requestConfiguration = MobileAds.getRequestConfiguration()
                .toBuilder()
                .setTagForChildDirectedTreatment(
                        RequestConfiguration.TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE)
                .setMaxAdContentRating(RequestConfiguration.MAX_AD_CONTENT_RATING_G)
                .build();
        MobileAds.setRequestConfiguration(requestConfiguration);

      //  MobileAds.initialize(this, getString(R.string.YOUR_ADMOB_APP_ID));
        AdRequest adRequest = new AdRequest.Builder().build();
       // mInterstitialAd = new InterstitialAd(this);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(128);
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.screenBrightness = 255-getIntPreference();
        getWindow().setAttributes(layoutParams);
/*
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                mInterstitialAd.loadAd(new AdRequest.Builder().build());

            }
        });*/
        mInterstitialAd.load(this,getString(R.string.admob_mInterstitialAd), adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        Log.i(TAG, "onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.d(TAG, loadAdError.toString());
                        mInterstitialAd = null;
                    }
                });
       /* mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
            @Override
            public void onAdClicked() {
                // Called when a click is recorded for an ad.
                Log.d(TAG, "Ad was clicked.");
            }

            @Override
            public void onAdDismissedFullScreenContent() {
                // Called when ad is dismissed.
                // Set the ad reference to null so you don't show the ad a second time.
                Log.d(TAG, "Ad dismissed fullscreen content.");
                mInterstitialAd = null;
            }

            @Override
            public void onAdFailedToShowFullScreenContent(AdError adError) {
                // Called when ad fails to show.
                Log.e(TAG, "Ad failed to show fullscreen content.");
                mInterstitialAd = null;
            }

            @Override
            public void onAdImpression() {
                // Called when an impression is recorded for an ad.
                Log.d(TAG, "Ad recorded an impression.");
            }

            @Override
            public void onAdShowedFullScreenContent() {
                // Called when ad is shown.
                Log.d(TAG, "Ad showed fullscreen content.");
            }
        });*/
        final AdView mAdView = (AdView) findViewById(R.id.adView);
        //AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mAdView.setAdListener(new AdListener(){

            @Override
            public void onAdLoaded() {
                mAdView.setVisibility(View.VISIBLE);
                Log.i("Ads", "onAdLoaded");
            }
        });
        pages = new ArrayList<>();
        myDB = new Database(this);

        viewAll();
        Fadapter = new FavoritAdapt(this, pages);

        list = (ListView) findViewById(R.id.favoritlist);

        list.setAdapter(Fadapter);

    }


    public void viewAll()
    {
        Cursor res = myDB.getAllData();
        if (0 ==res.getCount()) {
            return;
        }
        while (res.moveToNext()) {
            pages.add(res.getInt(0));
        }
    }


    public class FavoritAdapt extends ArrayAdapter {
        private Context context;
        private ArrayList<Integer> pages;
        private Database myDB;
        Typeface tp ;

        public FavoritAdapt(@NonNull Context context, ArrayList<Integer> pages) {
            super(context, R.layout.favorit_raw, pages);


            this.context = context;
            this.pages = pages;
            tp = Typeface.createFromAsset(this.context.getAssets(),"fonts/DTNASKH4.TTF");

        }


        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View row = inflater.inflate(R.layout.favorit_raw, parent, false);

            TextView text = (TextView) row.findViewById(R.id.favorititem);
            text.setTypeface(tp);
            ImageButton del = (ImageButton) row.findViewById(R.id.delete);
            myDB = new Database(context);


            if(pages.get(position) <3)
                text.setText("مقدمة " + (pages.get(position)+1));
            else
                text.setText("صفحة رقم " + (pages.get(position)-2) );

            del.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myDB.deleteData(pages.get(position).toString());
                    pages.remove(position);
                    notifyDataSetChanged();
                    if (0 == myDB.getAllData().getCount()){
                        if (MainActivity.button3.getVisibility()==View.VISIBLE){
                            MainActivity.button3.setVisibility(View.GONE);
                        }

                        Intent intent = new Intent(context, MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    }
                }

            });

            text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    //intent.putExtra("index", pages.get(position));
                    savePuzzelCount(pages.get(position));
                    savePuzzelCount2(pages.get(position));
                    context.startActivity(intent);
                    displayInterstitialAd();



                }
            });

            return row;
        }

    }
    void displayInterstitialAd() {
       /* mInterstitialAd.loadAd(new AdRequest.Builder().build());
        if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }*/
        if (mInterstitialAd != null) {
            mInterstitialAd.show(this);
        } else {
            Log.d("TAG", "The interstitial ad wasn't ready yet.");
        }
    }

}
