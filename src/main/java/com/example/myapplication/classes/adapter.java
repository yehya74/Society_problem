package com.example.myapplication.classes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.activity.Main3Activity;

import java.util.ArrayList;

public class adapter extends ArrayAdapter<Main> {
    public adapter(Context context, int resourse, ArrayList<Main>objects ){
        super(context,resourse,objects);

    }

    @Override
    public View getView(final int position,  View convertView,  ViewGroup parent) {
        if (convertView==null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.main2, parent, false);
        }
        final TextView name=convertView.findViewById(R.id.name);
        TextView year=convertView.findViewById(R.id.year);
        ImageView image=convertView.findViewById(R.id.image);
        ConstraintLayout crow=convertView.findViewById(R.id.row_id);


            if (getItem(position)!=null){
            name.setText(getItem(position).getName());
            year.setText(""+getItem(position).getYear());
            image.setImageResource(getItem(position).getImage());
        }
        crow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go=new Intent(getContext(), Main3Activity.class);
                Bundle bund=new Bundle();
                bund.putString("name",getItem(position).getName());
                bund.putInt("year",getItem(position).getYear());
                 go.putExtras(bund);
                getContext().startActivity(go);
            }
        });
        return convertView;
    }

}
