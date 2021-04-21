package com.example.giuaki;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

@SuppressLint("ViewConstructor")
public class MyRow extends TableRow {

//    LayoutPa
    
    public MyRow(Context context, long id, String infor) {
        super(context);
        this.addView(renderIdColumn(id));
        this.addView(renderInforColumn(infor));
    }

    @SuppressLint({"DefaultLocale", "UseCompatLoadingForDrawables"})
    public TextView renderIdColumn(long id){
        TableLayout.LayoutParams layoutParams = new TableLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
        );
        TextView id_view = new TextView(getContext());
        id_view.setLayoutParams(layoutParams);
        id_view.setText(String.format("%d",id));
        id_view.setPadding(5,0,5,0);
        id_view.setBackground(getResources().getDrawable(R.drawable.border_black_shape_rectangle_noradius));
        return id_view;
    }

    @SuppressLint({"DefaultLocale", "UseCompatLoadingForDrawables"})
    public TextView renderInforColumn(String infor){
        TableLayout.LayoutParams layoutParams = new TableLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT,
                1.0f
        );
        TextView id_view = new TextView(getContext());
        id_view.setLayoutParams(layoutParams);
        id_view.setText(infor);
        id_view.setPadding(5,0,5,0);
        id_view.setBackground(getResources().getDrawable(R.drawable.border_black_shape_rectangle_noradius));
        return id_view;
    }

}
