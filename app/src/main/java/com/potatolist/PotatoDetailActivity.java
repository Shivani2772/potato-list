package com.potatolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PotatoDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_potato_detail);

        Potato potato = (Potato) getIntent().getSerializableExtra("POTATOE");

        ImageView icon = (ImageView)findViewById(R.id.image);
        TextView name = (TextView)findViewById(R.id.potato_name);
        TextView description = (TextView)findViewById(R.id.potato_description);

        icon.setBackgroundResource(potato.getIcon());
        name.setText(potato.getName());
        description.setText(potato.getDescription());
    }
}
