package ahmad.awad.fekry.worldbook;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
//import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;


public class Shard extends AppCompatActivity {
      String MY_PREFS_NAME = "savefil";
      String PUZZEL_COUNT = "currentPag";
    String MY_PREFS_NAME2 = "setting2";
    String PUZZEL_COUNT2 = "puzzel_count2";
    String r = "brightness";
    String mypref = "myPref";
    String isdark = "isDark";
    // Context context;
    /*public Shard(Context context) {
        super(context);
        this.context=context;
    }




    @Override
    public Adapter getAdapter() {
        return null;
    }

    @Override
    public void setAdapter(Adapter adapter) {

    }

    @Override
    public View getSelectedView() {
        return null;
    }

    @Override
    public void setSelection(int position) {

    }*/
     void savePuzzelCount(int i) {
        SharedPreferences share=getSharedPreferences(MY_PREFS_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE).edit();
         editor.putInt(PUZZEL_COUNT, i);
         editor.apply();
        return;
    }
    int getSavedPuzzelCount() {
        SharedPreferences share= getSharedPreferences(MY_PREFS_NAME,Context.MODE_PRIVATE);
        return  share.getInt(PUZZEL_COUNT, 0);
    }

    void setBrightness(int alpha) {
        SharedPreferences share=getSharedPreferences(MY_PREFS_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE).edit();
        editor.putInt(r, alpha);
        editor.apply();
        return;
    }
    int getIntPreference() {
        SharedPreferences share= getSharedPreferences(MY_PREFS_NAME,Context.MODE_PRIVATE);
        return  share.getInt(r, 0);
    }

    void savePuzzelCount2(int i) {
        SharedPreferences sharedPreferences2=getSharedPreferences(MY_PREFS_NAME2,Context.MODE_PRIVATE);
        SharedPreferences.Editor pen2 = getSharedPreferences(MY_PREFS_NAME2, Context.MODE_PRIVATE).edit();
        pen2.putInt(PUZZEL_COUNT2, i);
        pen2.apply();
        return;
    }
    int getSavedPuzzelCount2() {
        SharedPreferences sharedPreferences2= getSharedPreferences(MY_PREFS_NAME2,Context.MODE_PRIVATE);
        return  sharedPreferences2.getInt(PUZZEL_COUNT2, 0);
    }


    void saveThemeStatePref(boolean isDark) {

        SharedPreferences pref = getSharedPreferences(mypref,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(isdark,isDark);
        editor.apply();
    }

    boolean getThemeStatePref () {

        SharedPreferences pref = getApplicationContext().getSharedPreferences(mypref,MODE_PRIVATE);
        boolean isDark = pref.getBoolean(isdark,false) ;
        return isDark;

    }
}
