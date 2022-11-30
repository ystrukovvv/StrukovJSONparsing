package com.example.strukov;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    TextView txt;
    private List<Player> mPlayerList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.textView);

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new getData().execute();
            }
        });
    }
    public class getData extends AsyncTask<Void,Void,String>
    {

        @Override
        protected String doInBackground(Void... voids) {
            try {
                String result = SyncManager.GetInstance().getData("users");
                return result;
            } catch (Exception e) {
                return null;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (!s.isEmpty()) {

                try {
                    JSONArray tempArray = new JSONArray(s);
                    for (int i = 0; i < tempArray.length(); i++) {
                        JSONObject tempO = tempArray.getJSONObject(i);
                        Player tempPlayer = new Player(tempO.getString("login"),
                                tempO.getInt("id"),
                                tempO.getString("node_id"),
                                tempO.getString("type"),
                                tempO.getBoolean("site_admin"));
                        mPlayerList.add(tempPlayer);
                    }

                    StringBuilder res = new StringBuilder();
                    for (Player tempPlayer : mPlayerList) {
                        res.append("\n" + "\n \t Пользователь с логином: " + tempPlayer.getLogin() + " \n {-- \n" + " \t Id: " +tempPlayer.getId() + "\n \t node_id: "+tempPlayer.getNode_id() + "\n \t Тип пользователя: " + tempPlayer.getType() + "\n \t Является ли админом: " + tempPlayer.getSite_admin() +"\n --} \n" );

                    }
                    txt.setText(res);
                } catch (Exception e) {

                }
            }
        }

        @Override
        protected void onPreExecute() {
            txt.setText("Загрузка...");
        }
    }
}
