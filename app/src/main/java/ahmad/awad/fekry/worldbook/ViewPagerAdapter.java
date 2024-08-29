package ahmad.awad.fekry.worldbook;

import android.app.Activity;
import android.content.Context;
//import android.support.design.widget.BottomNavigationView;
//import android.support.v4.view.PagerAdapter;
//import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;


/**
 * Created by ahmed on 10/11/2017.
 */

public class ViewPagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {

    private Context context;
    private LayoutInflater inflater;
    float BackLightValue = 0.5f; //dummy default value

    LinearLayout linearLayout ;
    RelativeLayout relativeLayout;



    private Integer [] images = { R.drawable.q277 ,R.drawable.q276,R.drawable.q275,R.drawable.q274,R.drawable.q273,R.drawable.q272,R.drawable.q271,R.drawable.q270,R.drawable.q269,R.drawable.q268,R.drawable.q267,R.drawable.q266,R.drawable.q265,R.drawable.q264,R.drawable.q263,R.drawable.q262,R.drawable.q261,R.drawable.q260,R.drawable.q259,R.drawable.q258,R.drawable.q257,R.drawable.q256,R.drawable.q255,R.drawable.q254,R.drawable.q253,R.drawable.q252,R.drawable.q251,R.drawable.q250,R.drawable.q249,R.drawable.q248,R.drawable.q247,R.drawable.q246,R.drawable.q245,R.drawable.q244,R.drawable.q243,R.drawable.q242,R.drawable.q241,R.drawable.q240,R.drawable.q239,R.drawable.q238,R.drawable.q237,R.drawable.q236,R.drawable.q235,R.drawable.q234,R.drawable.q233,R.drawable.q232,R.drawable.q231,R.drawable.q230,R.drawable.q229,R.drawable.q228,R.drawable.q227,R.drawable.q226,R.drawable.q225,R.drawable.q224,R.drawable.q223,R.drawable.q222,R.drawable.q221,R.drawable.q220,R.drawable.q219,R.drawable.q218,R.drawable.q217,R.drawable.q216,R.drawable.q215,R.drawable.q214,R.drawable.q213,R.drawable.q212,R.drawable.q211,R.drawable.q210,R.drawable.q209,R.drawable.q208,R.drawable.q207,R.drawable.q206,R.drawable.q205,R.drawable.q204,R.drawable.q203,R.drawable.q202,R.drawable.q201,R.drawable.q200,R.drawable.q199,R.drawable.q198,R.drawable.q197,R.drawable.q196,R.drawable.q195,R.drawable.q194,R.drawable.q193,R.drawable.q192,R.drawable.q191,R.drawable.q190,R.drawable.q189,R.drawable.q188,R.drawable.q187,R.drawable.q186,R.drawable.q185,R.drawable.q184,R.drawable.q183,R.drawable.q182,R.drawable.q181,R.drawable.q180,R.drawable.q179,R.drawable.q178,R.drawable.q177,R.drawable.q176,R.drawable.q175,R.drawable.q174,R.drawable.q173,R.drawable.q172,R.drawable.q171,R.drawable.q170,R.drawable.q169,R.drawable.q168,R.drawable.q167,R.drawable.q166,R.drawable.q165,R.drawable.q164,R.drawable.q163,R.drawable.q162,R.drawable.q161,R.drawable.q160,R.drawable.q159,R.drawable.q158,R.drawable.q157,R.drawable.q156,R.drawable.q155,R.drawable.q154,R.drawable.q153,R.drawable.q152,R.drawable.q151,R.drawable.q150,R.drawable.q149,R.drawable.q148,R.drawable.q147,R.drawable.q146,R.drawable.q145,R.drawable.q144,R.drawable.q143,R.drawable.q142,R.drawable.q141,R.drawable.q140,R.drawable.q139,R.drawable.q138,R.drawable.q137,R.drawable.q136,R.drawable.q135,R.drawable.q134,R.drawable.q133,R.drawable.q132,R.drawable.q131,R.drawable.q130,R.drawable.q129,R.drawable.q128,R.drawable.q127,R.drawable.q126,R.drawable.q125,R.drawable.q124,R.drawable.q123,R.drawable.q122,R.drawable.q121,R.drawable.q120,R.drawable.q119,R.drawable.q118,R.drawable.q117,R.drawable.q116,R.drawable.q115,R.drawable.q114,R.drawable.q113,R.drawable.q112,R.drawable.q111,R.drawable.q110,R.drawable.q109,R.drawable.q108,R.drawable.q107,R.drawable.q106,R.drawable.q105,R.drawable.q104,R.drawable.q103,R.drawable.q102,R.drawable.q101,R.drawable.q100,R.drawable.q99,R.drawable.q98,R.drawable.q97,R.drawable.q96,R.drawable.q95,R.drawable.q94,R.drawable.q93,R.drawable.q92,R.drawable.q91,R.drawable.q90,R.drawable.q89,R.drawable.q88,R.drawable.q87,R.drawable.q86,R.drawable.q85,R.drawable.q84,R.drawable.q83,R.drawable.q82,R.drawable.q81,R.drawable.q80,R.drawable.q79,R.drawable.q78,R.drawable.q77,R.drawable.q76,R.drawable.q75,R.drawable.q74,R.drawable.q73,R.drawable.q72,R.drawable.q71,R.drawable.q70,R.drawable.q69,R.drawable.q68,R.drawable.q67,R.drawable.q66,R.drawable.q65,R.drawable.q64,R.drawable.q63,R.drawable.q62,R.drawable.q61,R.drawable.q60,R.drawable.q59,R.drawable.q58,R.drawable.q57,R.drawable.q56,R.drawable.q55,R.drawable.q54,R.drawable.q53,R.drawable.q52,R.drawable.q51,R.drawable.q50,R.drawable.q49,R.drawable.q48,R.drawable.q47,R.drawable.q46,R.drawable.q45,R.drawable.q44,R.drawable.q43,R.drawable.q42,R.drawable.q41,R.drawable.q40,R.drawable.q39,R.drawable.q38,R.drawable.q37,R.drawable.q36,R.drawable.q35,R.drawable.q34,R.drawable.q33,R.drawable.q32,R.drawable.q31,R.drawable.q30,R.drawable.q29,R.drawable.q28,R.drawable.q27,R.drawable.q26,R.drawable.q25,R.drawable.q24,R.drawable.q23,R.drawable.q22,R.drawable.q21,R.drawable.q20,R.drawable.q19,R.drawable.q18,R.drawable.q17,R.drawable.q16,R.drawable.q15,R.drawable.q14,R.drawable.q13,R.drawable.q12,R.drawable.q11,R.drawable.q10,R.drawable.q9,R.drawable.q8,R.drawable.q7,R.drawable.q6,R.drawable.q5,R.drawable.q4,R.drawable.q3,R.drawable.q2,R.drawable.q1,R.drawable.q0};
    public  ViewPagerAdapter(Context context)
    {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_image,container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        imageView.setImageResource(images[position]);
       // ViewPager pager = (ViewPager) container;
        //pager.addView(view, 0);
        linearLayout = (LinearLayout) ((Activity)context).findViewById(R.id.linerlayout);
        relativeLayout = (RelativeLayout)((Activity)context).findViewById(R.id.brightness);



        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (relativeLayout.getVisibility() == View.VISIBLE) {
                    relativeLayout.setVisibility(View.GONE);
                 /*   WindowManager.LayoutParams layoutParams = ((Activity)context).getWindow().getAttributes();
                    layoutParams.screenBrightness = p.getIntPreference();
                    ((Activity)context).getWindow().setAttributes(layoutParams);*/

                } else {
                    if (linearLayout.getVisibility() == View.VISIBLE) {
                        linearLayout.setVisibility(View.GONE);

                    } else {
                        linearLayout.setVisibility(View.VISIBLE);
                    }


                }

            }
        });
        container.addView(view);
        return  view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

       // ViewPager pager = (ViewPager) container;
        //View view = (View) object;
       // pager.removeView(view);

        container.removeView((View) object);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

}
