package com.projectundikamobile.dilmusic;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class menu extends ArrayAdapter <String> {

    private Activity context;
    private String[] textmenu;
    private Integer[] icon;

    public menu(@NonNull Activity context, String[] textmenu, Integer[] icon) {
        super(context, R.layout.menu, textmenu);

        this.context = context;
        this.textmenu = textmenu;
        this.icon = icon;

    }

    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.menu, null, true);

        TextView txtmenu = rowView.findViewById(R.id.text);
        ImageView icons = rowView.findViewById(R.id.icon);

        txtmenu.setText(textmenu[position]);
        icons.setImageResource(icon[position]);

        return rowView ;

    }

}
