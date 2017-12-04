package com.potatolist;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class PotatoActivity extends AppCompatActivity {

    private ArrayList<Potato> mypotatoes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_potato);

        JSONObject jsonObject;

        try {
            jsonObject = new JSONObject(loadJSONFromAsset());

            JSONArray jsonpotatoes = jsonObject.getJSONArray("potatoes");
            for (int i = 0;i<jsonpotatoes.length();i++) {
                JSONObject indi = (JSONObject) jsonpotatoes.get(i);
                String name = indi.getString("name");
                String icon = indi.getString("icon");
                String descr = indi.getString("description");
                Potato c = new Potato(name,icon,descr);
                mypotatoes.add(c);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        PotatoAdapter myAdapter = new PotatoAdapter(this);
        myAdapter.setPotatoInfo(mypotatoes);
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(myAdapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),PotatoDetailActivity.class);
                intent.putExtra("POTATOE",mypotatoes.get(i));
                startActivity(intent);
            }
        });

    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("potato.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
