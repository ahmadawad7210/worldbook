package ahmad.awad.fekry.worldbook;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.design.widget.BottomNavigationView;
//import android.support.design.widget.FloatingActionButton;
//import android.support.v4.view.ViewPager;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
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
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import android.os.PowerManager;

//import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

import com.google.ads.consent.ConsentForm;
import com.google.ads.consent.ConsentFormListener;
import com.google.ads.consent.ConsentInfoUpdateListener;
import com.google.ads.consent.ConsentInformation;
import com.google.ads.consent.ConsentStatus;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
//import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

//import com.my.target.common.MyTargetPrivacy;

import java.net.MalformedURLException;
import java.net.URL;
//import com.facebook.FacebookSdk;
public class MainActivity  extends Shard implements View.OnClickListener {
    protected PowerManager.WakeLock wakeLock;
   Button button1;
    Button button2;
    static Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8 ;
    LinearLayout linearLayout ;
    RelativeLayout linearLayout1  ;
    TextView exit;

    FloatingActionButton Switcher;
    boolean Dark = false;

    RelativeLayout relativeLayout;
int s ;
   // Shard shard;
    int x ;
    int c ;
    int v ;
     int y;
     int z;
     Context context;
    private static String packageName = "";
   // public int startPage ;
    private int pg = 0, current = 0, state = 0, savedPage = 0;
    private ahmad.awad.fekry.worldbook.Database myDB;
    public int save = 0;
    Activity currentActivity;
    float BackLightValue = 0.5f; //dummy default value
    private ViewFlipper flipper;
     ViewPager slider;
    private Bundle bundle;
    private int sp ;
     int p = 277 ;
    private ViewPagerAdapter pagerAdapter;
    private Integer[] images = {ahmad.awad.fekry.worldbook.R.drawable.q0, ahmad.awad.fekry.worldbook.R.drawable.q1, ahmad.awad.fekry.worldbook.R.drawable.q2, ahmad.awad.fekry.worldbook.R.drawable.q3, ahmad.awad.fekry.worldbook.R.drawable.q4, ahmad.awad.fekry.worldbook.R.drawable.q5, ahmad.awad.fekry.worldbook.R.drawable.q6, ahmad.awad.fekry.worldbook.R.drawable.q7, ahmad.awad.fekry.worldbook.R.drawable.q8, ahmad.awad.fekry.worldbook.R.drawable.q9, ahmad.awad.fekry.worldbook.R.drawable.q10, ahmad.awad.fekry.worldbook.R.drawable.q11, ahmad.awad.fekry.worldbook.R.drawable.q12, ahmad.awad.fekry.worldbook.R.drawable.q13, ahmad.awad.fekry.worldbook.R.drawable.q14, ahmad.awad.fekry.worldbook.R.drawable.q15, ahmad.awad.fekry.worldbook.R.drawable.q16, ahmad.awad.fekry.worldbook.R.drawable.q17, ahmad.awad.fekry.worldbook.R.drawable.q18, ahmad.awad.fekry.worldbook.R.drawable.q19, ahmad.awad.fekry.worldbook.R.drawable.q20, ahmad.awad.fekry.worldbook.R.drawable.q21, ahmad.awad.fekry.worldbook.R.drawable.q22, ahmad.awad.fekry.worldbook.R.drawable.q23, ahmad.awad.fekry.worldbook.R.drawable.q24, ahmad.awad.fekry.worldbook.R.drawable.q25, ahmad.awad.fekry.worldbook.R.drawable.q26, ahmad.awad.fekry.worldbook.R.drawable.q27, ahmad.awad.fekry.worldbook.R.drawable.q28, ahmad.awad.fekry.worldbook.R.drawable.q29, ahmad.awad.fekry.worldbook.R.drawable.q30, ahmad.awad.fekry.worldbook.R.drawable.q31, ahmad.awad.fekry.worldbook.R.drawable.q32, ahmad.awad.fekry.worldbook.R.drawable.q33, ahmad.awad.fekry.worldbook.R.drawable.q34, ahmad.awad.fekry.worldbook.R.drawable.q35, ahmad.awad.fekry.worldbook.R.drawable.q36, ahmad.awad.fekry.worldbook.R.drawable.q37, ahmad.awad.fekry.worldbook.R.drawable.q38, ahmad.awad.fekry.worldbook.R.drawable.q39, ahmad.awad.fekry.worldbook.R.drawable.q40, ahmad.awad.fekry.worldbook.R.drawable.q41, ahmad.awad.fekry.worldbook.R.drawable.q42, ahmad.awad.fekry.worldbook.R.drawable.q43, ahmad.awad.fekry.worldbook.R.drawable.q44, ahmad.awad.fekry.worldbook.R.drawable.q45, ahmad.awad.fekry.worldbook.R.drawable.q46, ahmad.awad.fekry.worldbook.R.drawable.q47, ahmad.awad.fekry.worldbook.R.drawable.q48, ahmad.awad.fekry.worldbook.R.drawable.q49, ahmad.awad.fekry.worldbook.R.drawable.q50, ahmad.awad.fekry.worldbook.R.drawable.q51, ahmad.awad.fekry.worldbook.R.drawable.q52, ahmad.awad.fekry.worldbook.R.drawable.q53, ahmad.awad.fekry.worldbook.R.drawable.q54, ahmad.awad.fekry.worldbook.R.drawable.q55, ahmad.awad.fekry.worldbook.R.drawable.q56, ahmad.awad.fekry.worldbook.R.drawable.q57, ahmad.awad.fekry.worldbook.R.drawable.q58, ahmad.awad.fekry.worldbook.R.drawable.q59, ahmad.awad.fekry.worldbook.R.drawable.q60, ahmad.awad.fekry.worldbook.R.drawable.q61, ahmad.awad.fekry.worldbook.R.drawable.q62, ahmad.awad.fekry.worldbook.R.drawable.q63, ahmad.awad.fekry.worldbook.R.drawable.q64, ahmad.awad.fekry.worldbook.R.drawable.q65, ahmad.awad.fekry.worldbook.R.drawable.q66, ahmad.awad.fekry.worldbook.R.drawable.q67, ahmad.awad.fekry.worldbook.R.drawable.q68, ahmad.awad.fekry.worldbook.R.drawable.q69, ahmad.awad.fekry.worldbook.R.drawable.q70, ahmad.awad.fekry.worldbook.R.drawable.q71, ahmad.awad.fekry.worldbook.R.drawable.q72, ahmad.awad.fekry.worldbook.R.drawable.q73, ahmad.awad.fekry.worldbook.R.drawable.q74, ahmad.awad.fekry.worldbook.R.drawable.q75, ahmad.awad.fekry.worldbook.R.drawable.q76, ahmad.awad.fekry.worldbook.R.drawable.q77, ahmad.awad.fekry.worldbook.R.drawable.q78, ahmad.awad.fekry.worldbook.R.drawable.q79, ahmad.awad.fekry.worldbook.R.drawable.q80, ahmad.awad.fekry.worldbook.R.drawable.q81, ahmad.awad.fekry.worldbook.R.drawable.q82, ahmad.awad.fekry.worldbook.R.drawable.q83, ahmad.awad.fekry.worldbook.R.drawable.q84, ahmad.awad.fekry.worldbook.R.drawable.q85, ahmad.awad.fekry.worldbook.R.drawable.q86, ahmad.awad.fekry.worldbook.R.drawable.q87, ahmad.awad.fekry.worldbook.R.drawable.q88, ahmad.awad.fekry.worldbook.R.drawable.q89, ahmad.awad.fekry.worldbook.R.drawable.q90, ahmad.awad.fekry.worldbook.R.drawable.q91, ahmad.awad.fekry.worldbook.R.drawable.q92, ahmad.awad.fekry.worldbook.R.drawable.q93, ahmad.awad.fekry.worldbook.R.drawable.q94, ahmad.awad.fekry.worldbook.R.drawable.q95, ahmad.awad.fekry.worldbook.R.drawable.q96, ahmad.awad.fekry.worldbook.R.drawable.q97, ahmad.awad.fekry.worldbook.R.drawable.q98, ahmad.awad.fekry.worldbook.R.drawable.q99, ahmad.awad.fekry.worldbook.R.drawable.q100, ahmad.awad.fekry.worldbook.R.drawable.q101, ahmad.awad.fekry.worldbook.R.drawable.q102, ahmad.awad.fekry.worldbook.R.drawable.q103, ahmad.awad.fekry.worldbook.R.drawable.q104, ahmad.awad.fekry.worldbook.R.drawable.q105, ahmad.awad.fekry.worldbook.R.drawable.q106, ahmad.awad.fekry.worldbook.R.drawable.q107, ahmad.awad.fekry.worldbook.R.drawable.q108, ahmad.awad.fekry.worldbook.R.drawable.q109, ahmad.awad.fekry.worldbook.R.drawable.q110, ahmad.awad.fekry.worldbook.R.drawable.q111, ahmad.awad.fekry.worldbook.R.drawable.q112, ahmad.awad.fekry.worldbook.R.drawable.q113, ahmad.awad.fekry.worldbook.R.drawable.q114, ahmad.awad.fekry.worldbook.R.drawable.q115, ahmad.awad.fekry.worldbook.R.drawable.q116, ahmad.awad.fekry.worldbook.R.drawable.q117, ahmad.awad.fekry.worldbook.R.drawable.q118, ahmad.awad.fekry.worldbook.R.drawable.q119, ahmad.awad.fekry.worldbook.R.drawable.q120, ahmad.awad.fekry.worldbook.R.drawable.q121, ahmad.awad.fekry.worldbook.R.drawable.q122, ahmad.awad.fekry.worldbook.R.drawable.q123, ahmad.awad.fekry.worldbook.R.drawable.q124, ahmad.awad.fekry.worldbook.R.drawable.q125, ahmad.awad.fekry.worldbook.R.drawable.q126, ahmad.awad.fekry.worldbook.R.drawable.q127, ahmad.awad.fekry.worldbook.R.drawable.q128, ahmad.awad.fekry.worldbook.R.drawable.q129, ahmad.awad.fekry.worldbook.R.drawable.q130, ahmad.awad.fekry.worldbook.R.drawable.q131, ahmad.awad.fekry.worldbook.R.drawable.q132, ahmad.awad.fekry.worldbook.R.drawable.q133, ahmad.awad.fekry.worldbook.R.drawable.q134, ahmad.awad.fekry.worldbook.R.drawable.q135, ahmad.awad.fekry.worldbook.R.drawable.q136, ahmad.awad.fekry.worldbook.R.drawable.q137, ahmad.awad.fekry.worldbook.R.drawable.q138, ahmad.awad.fekry.worldbook.R.drawable.q139, ahmad.awad.fekry.worldbook.R.drawable.q140, ahmad.awad.fekry.worldbook.R.drawable.q141, ahmad.awad.fekry.worldbook.R.drawable.q142, ahmad.awad.fekry.worldbook.R.drawable.q143, ahmad.awad.fekry.worldbook.R.drawable.q144, ahmad.awad.fekry.worldbook.R.drawable.q145, ahmad.awad.fekry.worldbook.R.drawable.q146, ahmad.awad.fekry.worldbook.R.drawable.q147, ahmad.awad.fekry.worldbook.R.drawable.q148, ahmad.awad.fekry.worldbook.R.drawable.q149, ahmad.awad.fekry.worldbook.R.drawable.q150, ahmad.awad.fekry.worldbook.R.drawable.q151, ahmad.awad.fekry.worldbook.R.drawable.q152, ahmad.awad.fekry.worldbook.R.drawable.q153, ahmad.awad.fekry.worldbook.R.drawable.q154, ahmad.awad.fekry.worldbook.R.drawable.q155, ahmad.awad.fekry.worldbook.R.drawable.q156, ahmad.awad.fekry.worldbook.R.drawable.q157, ahmad.awad.fekry.worldbook.R.drawable.q158, ahmad.awad.fekry.worldbook.R.drawable.q159, ahmad.awad.fekry.worldbook.R.drawable.q160, ahmad.awad.fekry.worldbook.R.drawable.q161, ahmad.awad.fekry.worldbook.R.drawable.q162, ahmad.awad.fekry.worldbook.R.drawable.q163, ahmad.awad.fekry.worldbook.R.drawable.q164, ahmad.awad.fekry.worldbook.R.drawable.q165, ahmad.awad.fekry.worldbook.R.drawable.q166, ahmad.awad.fekry.worldbook.R.drawable.q167, ahmad.awad.fekry.worldbook.R.drawable.q168, ahmad.awad.fekry.worldbook.R.drawable.q169, ahmad.awad.fekry.worldbook.R.drawable.q170, ahmad.awad.fekry.worldbook.R.drawable.q171, ahmad.awad.fekry.worldbook.R.drawable.q172, ahmad.awad.fekry.worldbook.R.drawable.q173, ahmad.awad.fekry.worldbook.R.drawable.q174, ahmad.awad.fekry.worldbook.R.drawable.q175, ahmad.awad.fekry.worldbook.R.drawable.q176, ahmad.awad.fekry.worldbook.R.drawable.q177, ahmad.awad.fekry.worldbook.R.drawable.q178, ahmad.awad.fekry.worldbook.R.drawable.q179, ahmad.awad.fekry.worldbook.R.drawable.q180, ahmad.awad.fekry.worldbook.R.drawable.q181, ahmad.awad.fekry.worldbook.R.drawable.q182, ahmad.awad.fekry.worldbook.R.drawable.q183, ahmad.awad.fekry.worldbook.R.drawable.q184, ahmad.awad.fekry.worldbook.R.drawable.q185, ahmad.awad.fekry.worldbook.R.drawable.q186, ahmad.awad.fekry.worldbook.R.drawable.q187, ahmad.awad.fekry.worldbook.R.drawable.q188, ahmad.awad.fekry.worldbook.R.drawable.q189, ahmad.awad.fekry.worldbook.R.drawable.q190, ahmad.awad.fekry.worldbook.R.drawable.q191, ahmad.awad.fekry.worldbook.R.drawable.q192, ahmad.awad.fekry.worldbook.R.drawable.q193, ahmad.awad.fekry.worldbook.R.drawable.q194, ahmad.awad.fekry.worldbook.R.drawable.q195, ahmad.awad.fekry.worldbook.R.drawable.q196, ahmad.awad.fekry.worldbook.R.drawable.q197, ahmad.awad.fekry.worldbook.R.drawable.q198, ahmad.awad.fekry.worldbook.R.drawable.q199, ahmad.awad.fekry.worldbook.R.drawable.q200, ahmad.awad.fekry.worldbook.R.drawable.q201, ahmad.awad.fekry.worldbook.R.drawable.q202, ahmad.awad.fekry.worldbook.R.drawable.q203, ahmad.awad.fekry.worldbook.R.drawable.q204, ahmad.awad.fekry.worldbook.R.drawable.q205, ahmad.awad.fekry.worldbook.R.drawable.q206, ahmad.awad.fekry.worldbook.R.drawable.q207, ahmad.awad.fekry.worldbook.R.drawable.q208, ahmad.awad.fekry.worldbook.R.drawable.q209, ahmad.awad.fekry.worldbook.R.drawable.q210, ahmad.awad.fekry.worldbook.R.drawable.q211, ahmad.awad.fekry.worldbook.R.drawable.q212, ahmad.awad.fekry.worldbook.R.drawable.q213, ahmad.awad.fekry.worldbook.R.drawable.q214, ahmad.awad.fekry.worldbook.R.drawable.q215, ahmad.awad.fekry.worldbook.R.drawable.q216, ahmad.awad.fekry.worldbook.R.drawable.q217, ahmad.awad.fekry.worldbook.R.drawable.q218, ahmad.awad.fekry.worldbook.R.drawable.q219, ahmad.awad.fekry.worldbook.R.drawable.q220, ahmad.awad.fekry.worldbook.R.drawable.q221, ahmad.awad.fekry.worldbook.R.drawable.q222, ahmad.awad.fekry.worldbook.R.drawable.q223, ahmad.awad.fekry.worldbook.R.drawable.q224, ahmad.awad.fekry.worldbook.R.drawable.q225, ahmad.awad.fekry.worldbook.R.drawable.q226, ahmad.awad.fekry.worldbook.R.drawable.q227, ahmad.awad.fekry.worldbook.R.drawable.q228, ahmad.awad.fekry.worldbook.R.drawable.q229, ahmad.awad.fekry.worldbook.R.drawable.q230, ahmad.awad.fekry.worldbook.R.drawable.q231, ahmad.awad.fekry.worldbook.R.drawable.q232, ahmad.awad.fekry.worldbook.R.drawable.q233, ahmad.awad.fekry.worldbook.R.drawable.q234, ahmad.awad.fekry.worldbook.R.drawable.q235, ahmad.awad.fekry.worldbook.R.drawable.q236, ahmad.awad.fekry.worldbook.R.drawable.q237, ahmad.awad.fekry.worldbook.R.drawable.q238, ahmad.awad.fekry.worldbook.R.drawable.q239, ahmad.awad.fekry.worldbook.R.drawable.q240, ahmad.awad.fekry.worldbook.R.drawable.q241, ahmad.awad.fekry.worldbook.R.drawable.q242, ahmad.awad.fekry.worldbook.R.drawable.q243, ahmad.awad.fekry.worldbook.R.drawable.q244, ahmad.awad.fekry.worldbook.R.drawable.q245, ahmad.awad.fekry.worldbook.R.drawable.q246, ahmad.awad.fekry.worldbook.R.drawable.q247, ahmad.awad.fekry.worldbook.R.drawable.q248, ahmad.awad.fekry.worldbook.R.drawable.q249, ahmad.awad.fekry.worldbook.R.drawable.q250, ahmad.awad.fekry.worldbook.R.drawable.q251, ahmad.awad.fekry.worldbook.R.drawable.q252, ahmad.awad.fekry.worldbook.R.drawable.q253, ahmad.awad.fekry.worldbook.R.drawable.q254, ahmad.awad.fekry.worldbook.R.drawable.q255, ahmad.awad.fekry.worldbook.R.drawable.q256, ahmad.awad.fekry.worldbook.R.drawable.q257, ahmad.awad.fekry.worldbook.R.drawable.q258, ahmad.awad.fekry.worldbook.R.drawable.q259, ahmad.awad.fekry.worldbook.R.drawable.q260, ahmad.awad.fekry.worldbook.R.drawable.q261, ahmad.awad.fekry.worldbook.R.drawable.q262, ahmad.awad.fekry.worldbook.R.drawable.q263, ahmad.awad.fekry.worldbook.R.drawable.q264, ahmad.awad.fekry.worldbook.R.drawable.q265, ahmad.awad.fekry.worldbook.R.drawable.q266, ahmad.awad.fekry.worldbook.R.drawable.q267, ahmad.awad.fekry.worldbook.R.drawable.q268, ahmad.awad.fekry.worldbook.R.drawable.q269, ahmad.awad.fekry.worldbook.R.drawable.q270, ahmad.awad.fekry.worldbook.R.drawable.q271, ahmad.awad.fekry.worldbook.R.drawable.q272, ahmad.awad.fekry.worldbook.R.drawable.q273, ahmad.awad.fekry.worldbook.R.drawable.q274, ahmad.awad.fekry.worldbook.R.drawable.q275, ahmad.awad.fekry.worldbook.R.drawable.q276,R.drawable.q277};
     ListView list;
     ahmad.awad.fekry.worldbook.ImageAdapter imageAdapter;
    private int status = 0;
    private InterstitialAd mInterstitialAd;

    private static final String TAG = "MainActivity";
    ConsentForm form;
    private int tempFirstVisibleItem = -1;
    @SuppressLint("InvalidWakeLockTag")
    SeekBar brightness_seekBar;
    @SuppressLint("InvalidWakeLockTag")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Context context = getApplicationContext();
        AppSetIdClient client = AppSet.getClient(context);
        Task<AppSetIdInfo> task = client.getAppSetIdInfo();

        task.addOnSuccessListener(new OnSuccessListener<AppSetIdInfo>() {
            @Override
            public void onSuccess(AppSetIdInfo info) {
                // Determine current scope of app set ID.
                int scope = info.getScope();

                // Read app set ID value, which uses version 4 of the
                // universally unique identifier (UUID) format.
                String id = info.getId();
            }
        });

       // MobileAds.initialize(this, getString(R.string.YOUR_ADMOB_APP_ID));
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
        AdRequest adRequest = new AdRequest.Builder().build();
        getWindow().addFlags(128);
      /*  WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.screenBrightness = getIntPreference();
        getWindow().setAttributes(layoutParams);*/
        setContentView(ahmad.awad.fekry.worldbook.R.layout.activity_main);

        final PowerManager powerManager=(PowerManager)getSystemService(Context.POWER_SERVICE);
        this.wakeLock=powerManager.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK,TAG);
        this.wakeLock.acquire();


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
       // mInterstitialAd = new InterstitialAd(this);
      //  mInterstitialAd.setAdUnitId(getString(ahmad.awad.fekry.worldbook.R.string.admob_mInterstitialAd));
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
        /*mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
            @Override
            public void onAdClicked() {
                // Called when a click is recorded for an ad.
                Log.d(TAG, "Ad was clicked.");
            }

            @Override
            public void onAdDismissedFullScreenContent() {
                // Called when ad is dismissed.
                // Set the ad reference to null so you don't show the ad a second time.
                mInterstitialAd=null;
                Log.d(TAG, "Ad dismissed fullscreen content.");
               // mInterstitialAd = null;

            }

            @Override
            public void onAdFailedToShowFullScreenContent(AdError adError) {
                // Called when ad fails to show.
                mInterstitialAd=null;
                Log.e(TAG, "Ad failed to show fullscreen content.");
              //  mInterstitialAd = null;
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
        });
*/


        ConsentInformation consentInformation =
                ConsentInformation.getInstance(MainActivity.this);
//// test
        // ConsentInformation.getInstance(this).addTestDevice("62577C087ADC5497524E2FAF2B0E67AE");
/////
        String[] publisherIds = {getString(ahmad.awad.fekry.worldbook.R.string.admob_pub)};
        consentInformation.requestConsentInfoUpdate(publisherIds, new ConsentInfoUpdateListener() {
            @Override
            public void onConsentInfoUpdated(ConsentStatus consentStatus) {
                // User's consent status successfully updated.
                Log.d(TAG, "onConsentInfoUpdated");
                switch (consentStatus) {
                    case PERSONALIZED:
                        Log.d(TAG, "PERSONALIZED");
                        ConsentInformation.getInstance(MainActivity.this)
                                .setConsentStatus(ConsentStatus.PERSONALIZED);
                        break;
                    case NON_PERSONALIZED:
                        Log.d(TAG, "NON_PERSONALIZED");
                        ConsentInformation.getInstance(MainActivity.this)
                                .setConsentStatus(ConsentStatus.NON_PERSONALIZED);
                        break;
                    // User's consent status successfully updated.
                    case UNKNOWN:
                        Log.d(TAG, "UNKNOWN");
                        if
                                (ConsentInformation.getInstance(MainActivity.this).isRequestLocationInEeaOrUnknown
                                ()) {
                            URL privacyUrl = null;
                            try {
// TODO: Replace with your app's privacy policy URL.
                                privacyUrl = new URL("https://sites.google.com/view/ahmad-awad/home");
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
// Handle error.
                            }
                            form = new ConsentForm.Builder(MainActivity.this,
                                    privacyUrl)
                                    .withListener(new ConsentFormListener() {
                                        @Override
                                        public void onConsentFormLoaded() {
// Consent form loaded successfully.
                                            Log.d(TAG, "onConsentFormLoaded");
                                            showform();
                                        }

                                        @Override
                                        public void onConsentFormOpened() {
// Consent form was displayed.
                                            Log.d(TAG, "onConsentFormOpened");
                                        }

                                        @Override
                                        public void onConsentFormClosed(
                                                ConsentStatus consentStatus, Boolean
                                                userPrefersAdFree) {
// Consent form was closed.
                                            Log.d(TAG, "onConsentFormClosed");
                                        }

                                        @Override
                                        public void onConsentFormError(String
                                                                               errorDescription) {
// Consent form error.
                                            Log.d(TAG, "onConsentFormError");
                                            Log.d(TAG, errorDescription);
                                        }
                                    })
                                    .withPersonalizedAdsOption()
                                    .withNonPersonalizedAdsOption()
                                    .build();
                            form.load();
                        } else {
                            Log.d(TAG, "PERSONALIZED else");
                            ConsentInformation.getInstance(MainActivity.this)
                                    .setConsentStatus(ConsentStatus.PERSONALIZED);
                        }
                        break;
                    default:
                        break;
                }

            }

            @Override
            public void onFailedToUpdateConsentInfo(String errorDescription) {
                // User's consent status failed to update.
                Log.d(TAG, "onFailedToUpdateConsentInfo");
                Log.d(TAG, errorDescription);
            }
        });
        Log.v("501", "start");







       // bundle = getIntent().getExtras() ;
      /*  SharedPreferences share = getSharedPreferences("savefil" , Context.MODE_PRIVATE);

        sp = share.getInt("currentPag", 0) ;

*/
        /*if(bundle != null) {
            y = bundle.getInt("index");
        }else {*/

        //}

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.buttonprivecy);
        exit=(TextView)findViewById(R.id.exit);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        exit.setOnClickListener(this);

        Switcher = findViewById(R.id.switcher);
        Dark = getThemeStatePref();
        if(Dark) {
            // dark theme is on

          /*  searchInput.setBackgroundResource(R.drawable.search_input_dark_style);
            rootLayout.setBackgroundColor(getResources().getColor(R.color.black));
*/
        }
        else
        {
        /*    // light theme is on
            searchInput.setBackgroundResource(R.drawable.search_input_style);
            rootLayout.setBackgroundColor(getResources().getColor(R.color.white));
*/
        }
/*
        Switcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dark = !Dark ;
                if (Dark) {

                    rootLayout.setBackgroundColor(getResources().getColor(R.color.black));
                    searchInput.setBackgroundResource(R.drawable.search_input_dark_style);

                }
                else {
                    rootLayout.setBackgroundColor(getResources().getColor(R.color.white));
                    searchInput.setBackgroundResource(R.drawable.search_input_style);
                }

                newsAdapter = new NewsAdapter(getApplicationContext(),mData,isDark);
                if (!search.toString().isEmpty()){

                    newsAdapter.getFilter().filter(search);

                }
                NewsRecyclerview.setAdapter(newsAdapter);
                saveThemeStatePref(isDark);




            }
        });
*/


        relativeLayout =(RelativeLayout)findViewById(R.id.brightness);
        linearLayout1 = (RelativeLayout) findViewById(R.id.menu_linearLayout_brightness);
        linearLayout1.setOnClickListener(this);


        linearLayout = (LinearLayout) findViewById(R.id.linerlayout);
        linearLayout.setVisibility(View.GONE);

        brightness_seekBar = (SeekBar) findViewById(R.id.brightness_seekBar);
        brightness_seekBar.setProgress(255-getIntPreference());
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.screenBrightness = brightness_seekBar.getProgress();
        getWindow().setAttributes(layoutParams);
        brightness_seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                setBrightness(255-progress);
                WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
                layoutParams.screenBrightness = progress;
                getWindow().setAttributes(layoutParams);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        flipper = (ViewFlipper) findViewById(ahmad.awad.fekry.worldbook.R.id.content);
        slider = (ViewPager) findViewById(ahmad.awad.fekry.worldbook.R.id.slider);
        list = (ListView) findViewById(ahmad.awad.fekry.worldbook.R.id.imageList);


        myDB = new Database(this);

        if(0 == myDB.getAllData().getCount()){
            if(button3.getVisibility()==View.VISIBLE){
                button3.setVisibility(View.GONE);
            }
        }

        final AdView mAdView = (AdView) findViewById(ahmad.awad.fekry.worldbook.R.id.adView);

        mAdView.loadAd(adRequest);

        mAdView.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {
                mAdView.setVisibility(View.VISIBLE);
                Log.i("Ads", "onAdLoaded");
            }
        });
        pager();
        listView();


        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            flipper.setDisplayedChild(0);

            listView();
            status = 0;

        }else {

            flipper.setDisplayedChild(1);

            pager();
            status = 1;
        }


    }

    private void listView(){

        imageAdapter = new ImageAdapter(this, images);
        list = (ListView) findViewById(R.id.imageList);
        list.setAdapter(imageAdapter);


        z=getSavedPuzzelCount();

        list.setSelection(z);

        list.setOnScrollListener(new ListView.OnScrollListener() {
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

s = firstVisibleItem+0;

               slider.setCurrentItem(p-s);



            }

            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }


        });


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                save = position;
                if (relativeLayout.getVisibility() == View.VISIBLE) {
                    relativeLayout.setVisibility(View.GONE);
                  /*  WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
                    layoutParams.screenBrightness = getIntPreference();
                    getWindow().setAttributes(layoutParams);*/
                } else {
                    if (linearLayout.getVisibility() == View.VISIBLE) {
                        linearLayout.setVisibility(View.GONE);

                    } else {
                        linearLayout.setVisibility(View.VISIBLE);
                    }


                }

            }

        });

    }
    private void pager(){
        pagerAdapter = new ViewPagerAdapter(this);
        slider = (ViewPager) findViewById(R.id.slider);
        slider.setAdapter(pagerAdapter);

        y=getSavedPuzzelCount();

        slider.setCurrentItem(p-y);


        slider.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageSelected(int position) {

s = position+0;
if (list.getFirstVisiblePosition()!= p-s) {
    list.setSelection(p - s);
}



            }

            public void onPageScrollStateChanged(int state) {
            }

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

        });

    }


    private void showform() {
        if (form != null) {
            Log.d(TAG, "show ok");
            form.show();
        }
    }



    @Override
    protected void onStop() {

        savePuzzelCount(p-slider.getCurrentItem());
       //setCurrentPage2(getCurrentPage());
        super.onStop();



    }

    @Override
    public void onDestroy(){
        this.wakeLock.release();

        super.onDestroy();
    }
    @Override
    protected void onRestart() {
        super.onRestart();

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            flipper.setDisplayedChild(0);

            listView();
            status = 0;

        } else {

            flipper.setDisplayedChild(1);

            pager();
            status = 1;

        }
    }
    void displayInterstitialAd() {
      /*  mInterstitialAd.loadAd(new AdRequest.Builder().build());
        if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }*/
        if (mInterstitialAd != null) {
            mInterstitialAd.show(this);
        } else {
            Log.d("TAG", "The interstitial ad wasn't ready yet.");
        }

    }
    public Activity getCurrentActivity() {
        return currentActivity;
    }
    public void setCurrentActivity(Activity activity) {
        currentActivity = activity;
    }


    @Override
    public void onClick(View v) {
        if (v == button1) {
            Intent intent = new Intent(MainActivity.this, ahmad.awad.fekry.worldbook.Index.class);
            startActivity(intent);
          //  displayInterstitialAd();
        } else if (v == button2) {

            save = p - slider.getCurrentItem();
            boolean isInserted = myDB.insertData(save);
            Log.v("save", save + "");

            if (isInserted == true) {
                Toast.makeText(MainActivity.this, "تم حفظ الصفحة", Toast.LENGTH_LONG).show();
                if(button3.getVisibility()==View.GONE){
                    button3.setVisibility(View.VISIBLE);
                }
            }else {
                Toast.makeText(MainActivity.this, "تم حفظ الصفحة سابقاً", Toast.LENGTH_LONG).show();
            }

        //    displayInterstitialAd();
        } else if (v == button3) {
            Intent intent1 = new Intent(MainActivity.this, ahmad.awad.fekry.worldbook.Favorit.class);
            startActivity(intent1);
    //        displayInterstitialAd();
        } else if (v == button4) {
            Intent intent2 = new Intent(MainActivity.this, ahmad.awad.fekry.worldbook.About.class);
            startActivity(intent2);
//            displayInterstitialAd();
        }else if (v == button5) {
          //  StartAppAd.showAd(this);
            Intent intent3 = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://play.google.com/store/apps/developer?id=%D8%A3%D8%AD%D9%85%D8%AF%20%D8%B9%D9%88%D8%B6%20%D9%81%D9%83%D8%B1%D9%89"));

            startActivity(intent3);

        }else if (v == button6) {
            Intent intent4=new Intent(Intent.ACTION_SEND)
                    .setType("text/plain")
                    .putExtra(Intent.EXTRA_TEXT,"SharingConnection"+"\n"+"https://play.google.com/store/apps/details?id="+getPackageName());
            Intent.createChooser(intent4,"مشاركة التطبيق");
            startActivity(intent4);

         //   displayInterstitialAd();
        }else if (v == button7) {


            Intent intent5=new Intent(Intent.ACTION_VIEW)
                    .setData(Uri.parse("market://details?id="+getPackageName()));
            startActivity(intent5);

            displayInterstitialAd();
        }else if (v==linearLayout1){
            linearLayout.setVisibility(View.GONE);
            relativeLayout.setVisibility(View.VISIBLE);
            //Intent intent6 = new Intent(getCurrentActivity(),Brightnes.class);
          //  intent6.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
          //  startActivity(intent6);


        }else if (v==exit){
            relativeLayout.setVisibility(View.GONE);

        //    displayInterstitialAd();
        }else if (v==button8){
            Intent intent = new Intent(MainActivity.this, ahmad.awad.fekry.worldbook.PrivacyPolicy.class);
            startActivity(intent);
        }
       //  displayInterstitialAd();
        //startAppAd.showAd(); // show the ad
    }


}
