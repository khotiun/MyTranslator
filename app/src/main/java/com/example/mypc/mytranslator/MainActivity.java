package com.example.mypc.mytranslator;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText text;
    TextView translated;
    Button translateBtn;

    final private String URL = "https://translate.yandex.net";
    final private String KEY = "trnsl.1.1.20160719T224220Z.24f42814f637f644.dc9cbf9b0dec16722dd04d18cbbac6d6d1974d74";
    private Gson gson = new GsonBuilder()
            .create();
    private Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))//
            .baseUrl(URL)
            .build();
    private Link intf = retrofit.create(Link.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        initialize();
    }

    private void initialize() {
        translateBtn = (Button) findViewById(R.id.translate_btn);
        translateBtn.setOnClickListener(this);
        translated = (TextView) findViewById(R.id.translated);
        text = (EditText) findViewById(R.id.text);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.translate_btn:
                Map<String, String> mapjson = new HashMap<String, String>();
                mapjson.put("key", KEY);
                mapjson.put("text", text.getText().toString());
                mapjson.put("lang", "en-ru");

                Call<Object> call = intf.translate(mapjson);
                try {
                    Response<Object> res = call.execute();

                    Map<String, String> map = gson.fromJson(res.body().toString(), Map.class);

                    for (Map.Entry e : map.entrySet()) {
                        if (e.getKey().equals("text")) {
                            translated.setText(e.getValue().toString());
                        }
                        //System.out.println(e.getKey()+" "+e.getValue());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
    }
}
