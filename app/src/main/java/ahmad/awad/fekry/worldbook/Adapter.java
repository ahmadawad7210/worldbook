package ahmad.awad.fekry.worldbook;

import android.content.Context;
import android.graphics.Typeface;
/*import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;*/
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import ahmad.awad.fekry.worldbook.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahmed on 10/18/2017.
 */

public class Adapter extends ArrayAdapter {
    Typeface tp ;
    private Context context;
    private String [] data;
    public Adapter(@NonNull Context context, String [] data) {
        super(context, R.layout.raw, data);

        Log.v("a7a", data[0]);

        this.context = context;
        this.data = data;
        tp = Typeface.createFromAsset(this.context.getAssets(),"fonts/DTNASKH4.TTF");

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.raw, parent, false);

        TextView text = (TextView) row.findViewById(R.id.item);
        text.setTypeface(tp);
        text.setText(data[position]);

        return row;
    }
}
