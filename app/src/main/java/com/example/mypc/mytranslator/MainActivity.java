package com.example.mypc.mytranslator;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
    EditText translated;
    Button btnEnRu, btnRuEn, btnPlRu, btnRuPl, btnFrRu, btnRuFr, btnDeRu, btnRuDe, btnZhRu, btnRuZh;

    final private String URL = "https://translate.yandex.net";
    final private String KEY = "trnsl.1.1.20160719T224220Z.24f42814f637f644.dc9cbf9b0dec16722dd04d18cbbac6d6d1974d74";
    private Gson gson = new GsonBuilder()
            .create();
    private Retrofit retrofit = new Retrofit.Builder()//Retrofit - класс для обработки результатов. Ему нужно указать базовый адрес в методе baseUrl()
            .addConverterFactory(GsonConverterFactory.create(gson))//
            .baseUrl(URL)//базовый url
            .build();
    private Link intf = retrofit.create(Link.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();//Что это?
        StrictMode.setThreadPolicy(policy);
        initialize();
    }

    private void initialize() {
        btnEnRu = (Button) findViewById(R.id.btn_en_ru);
        btnEnRu.setOnClickListener(this);
        btnPlRu = (Button) findViewById(R.id.btn_pl_ru);
        btnPlRu.setOnClickListener(this);
        btnFrRu = (Button) findViewById(R.id.btn_fr_ru);
        btnFrRu.setOnClickListener(this);
        btnDeRu = (Button) findViewById(R.id.btn_de_ru);
        btnDeRu.setOnClickListener(this);
        btnZhRu = (Button) findViewById(R.id.btn_zh_ru);
        btnZhRu.setOnClickListener(this);

        btnRuEn = (Button) findViewById(R.id.btn_ru_en);
        btnRuEn.setOnClickListener(this);
        btnRuPl = (Button) findViewById(R.id.btn_ru_pl);
        btnRuPl.setOnClickListener(this);
        btnRuFr = (Button) findViewById(R.id.btn_ru_fr);
        btnRuFr.setOnClickListener(this);
        btnRuDe = (Button) findViewById(R.id.btn_ru_de);
        btnRuDe.setOnClickListener(this);
        btnRuZh = (Button) findViewById(R.id.btn_ru_zh);
        btnRuZh.setOnClickListener(this);
        translated = (EditText) findViewById(R.id.translated);
        text = (EditText) findViewById(R.id.text);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_en_ru:
                Map<String, String> mapjson = new HashMap<String, String>();
                mapjson.put("key", KEY);
                mapjson.put("text", text.getText().toString());
                mapjson.put("lang", "en-ru");

                Call<Object> call = intf.translate(mapjson);
                try {
                    Response<Object> res = call.execute();//Для синхронного запроса используйте метод Call.execute(), для асинхронного - метод Call.enqueue().
                    //В Response - получаем json обьект
                    Map<String, String> map = gson.fromJson(res.body().toString(), Map.class);//res.body() - все что пришло с сервера

                    for (Map.Entry e : map.entrySet()) {
                        if (e.getKey().equals("text")) {
                            String str = e.getValue().toString();
                            translated.setText(str.substring(1, str.length()-1));
                        }
//                        System.out.println(e.getKey()+" "+e.getValue());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_pl_ru:
                Map<String, String> mapjsonPlRu = new HashMap<String, String>();
                mapjsonPlRu.put("key", KEY);
                mapjsonPlRu.put("text", text.getText().toString());
                mapjsonPlRu.put("lang", "pl-ru");

                Call<Object> callPlRu = intf.translate(mapjsonPlRu);
                try {
                    Response<Object> res = callPlRu.execute();//Для синхронного запроса используйте метод Call.execute(), для асинхронного - метод Call.enqueue().
                    //В Response - получаем json обьект
                    Map<String, String> map = gson.fromJson(res.body().toString(), Map.class);//res.body() - все что пришло с сервера

                    for (Map.Entry e : map.entrySet()) {
                        if (e.getKey().equals("text")) {
                            String str = e.getValue().toString();
                            translated.setText(str.substring(1, str.length()-1));
                        }
//                        System.out.println(e.getKey()+" "+e.getValue());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_fr_ru:
                Map<String, String> mapjsonFrRu = new HashMap<String, String>();
                mapjsonFrRu.put("key", KEY);
                mapjsonFrRu.put("text", text.getText().toString());
                mapjsonFrRu.put("lang", "fr-ru");

                Call<Object> callFrRu = intf.translate(mapjsonFrRu);
                try {
                    Response<Object> res = callFrRu.execute();//Для синхронного запроса используйте метод Call.execute(), для асинхронного - метод Call.enqueue().
                    //В Response - получаем json обьект
                    Map<String, String> map = gson.fromJson(res.body().toString(), Map.class);//res.body() - все что пришло с сервера

                    for (Map.Entry e : map.entrySet()) {
                        if (e.getKey().equals("text")) {
                            String str = e.getValue().toString();
                            translated.setText(str.substring(1, str.length()-1));
                        }
//                        System.out.println(e.getKey()+" "+e.getValue());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_de_ru:
                Map<String, String> mapjsonDeRu = new HashMap<String, String>();
                mapjsonDeRu.put("key", KEY);
                mapjsonDeRu.put("text", text.getText().toString());
                mapjsonDeRu.put("lang", "de-ru");

                Call<Object> callDeRu = intf.translate(mapjsonDeRu);
                try {
                    Response<Object> res = callDeRu.execute();//Для синхронного запроса используйте метод Call.execute(), для асинхронного - метод Call.enqueue().
                    //В Response - получаем json обьект
                    Map<String, String> map = gson.fromJson(res.body().toString(), Map.class);//res.body() - все что пришло с сервера

                    for (Map.Entry e : map.entrySet()) {
                        if (e.getKey().equals("text")) {
                            String str = e.getValue().toString();
                            translated.setText(str.substring(1, str.length()-1));
                        }
//                        System.out.println(e.getKey()+" "+e.getValue());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_zh_ru:
                Map<String, String> mapjsonZhRu = new HashMap<String, String>();
                mapjsonZhRu.put("key", KEY);
                mapjsonZhRu.put("text", text.getText().toString());
                mapjsonZhRu.put("lang", "zh-ru");

                Call<Object> callZhRu = intf.translate(mapjsonZhRu);
                try {
                    Response<Object> res = callZhRu.execute();//Для синхронного запроса используйте метод Call.execute(), для асинхронного - метод Call.enqueue().
                    //В Response - получаем json обьект
                    Map<String, String> map = gson.fromJson(res.body().toString(), Map.class);//res.body() - все что пришло с сервера

                    for (Map.Entry e : map.entrySet()) {
                        if (e.getKey().equals("text")) {
                            String str = e.getValue().toString();
                            translated.setText(str.substring(1, str.length()-1));
                        }
//                        System.out.println(e.getKey()+" "+e.getValue());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;



            case R.id.btn_ru_en:
                Map<String, String> mapjsonRuEn = new HashMap<String, String>();
                mapjsonRuEn.put("key", KEY);
                mapjsonRuEn.put("text", translated.getText().toString());
                mapjsonRuEn.put("lang", "ru-en");

                Call<Object> callRuEn = intf.translate(mapjsonRuEn);
                try {
                    Response<Object> res = callRuEn.execute();//Для синхронного запроса используйте метод Call.execute(), для асинхронного - метод Call.enqueue().
                    //В Response - получаем json обьект
                    Map<String, String> map = gson.fromJson(res.body().toString(), Map.class);//res.body() - все что пришло с сервера

                    for (Map.Entry e : map.entrySet()) {
                        if (e.getKey().equals("text")) {
                            String str = e.getValue().toString();
                            text.setText(str.substring(1, str.length()-1));
                        }
//                        System.out.println(e.getKey()+" "+e.getValue());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_ru_pl:
                Map<String, String> mapjsonRuPl = new HashMap<String, String>();
                mapjsonRuPl.put("key", KEY);
                mapjsonRuPl.put("text", translated.getText().toString());
                mapjsonRuPl.put("lang", "ru-pl");

                Call<Object> callRuPl = intf.translate(mapjsonRuPl);
                try {
                    Response<Object> res = callRuPl.execute();//Для синхронного запроса используйте метод Call.execute(), для асинхронного - метод Call.enqueue().
                    //В Response - получаем json обьект
                    Map<String, String> map = gson.fromJson(res.body().toString(), Map.class);//res.body() - все что пришло с сервера

                    for (Map.Entry e : map.entrySet()) {
                        if (e.getKey().equals("text")) {
                            String str = e.getValue().toString();
                            text.setText(str.substring(1, str.length()-1));
                        }
//                        System.out.println(e.getKey()+" "+e.getValue());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_ru_fr:
                Map<String, String> mapjsonRuFr = new HashMap<String, String>();
                mapjsonRuFr.put("key", KEY);
                mapjsonRuFr.put("text", translated.getText().toString());
                mapjsonRuFr.put("lang", "ru-fr");

                Call<Object> callRuFr = intf.translate(mapjsonRuFr);
                try {
                    Response<Object> res = callRuFr.execute();//Для синхронного запроса используйте метод Call.execute(), для асинхронного - метод Call.enqueue().
                    //В Response - получаем json обьект
                    Map<String, String> map = gson.fromJson(res.body().toString(), Map.class);//res.body() - все что пришло с сервера

                    for (Map.Entry e : map.entrySet()) {
                        if (e.getKey().equals("text")) {
                            String str = e.getValue().toString();
                            text.setText(str.substring(1, str.length()-1));
                        }
//                        System.out.println(e.getKey()+" "+e.getValue());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_ru_de:
                Map<String, String> mapjsonRuDe = new HashMap<String, String>();
                mapjsonRuDe.put("key", KEY);
                mapjsonRuDe.put("text", translated.getText().toString());
                mapjsonRuDe.put("lang", "ru-de");

                Call<Object> callRuDe = intf.translate(mapjsonRuDe);
                try {
                    Response<Object> res = callRuDe.execute();//Для синхронного запроса используйте метод Call.execute(), для асинхронного - метод Call.enqueue().
                    //В Response - получаем json обьект
                    Map<String, String> map = gson.fromJson(res.body().toString(), Map.class);//res.body() - все что пришло с сервера

                    for (Map.Entry e : map.entrySet()) {
                        if (e.getKey().equals("text")) {
                            String str = e.getValue().toString();
                            text.setText(str.substring(1, str.length()-1));
                        }
//                        System.out.println(e.getKey()+" "+e.getValue());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_ru_zh:
                Map<String, String> mapjsonRuZh = new HashMap<String, String>();
                mapjsonRuZh.put("key", KEY);
                mapjsonRuZh.put("text", translated.getText().toString());
                mapjsonRuZh.put("lang", "ru-zh");

                Call<Object> callRuZh = intf.translate(mapjsonRuZh);
                try {
                    Response<Object> res = callRuZh.execute();//Для синхронного запроса используйте метод Call.execute(), для асинхронного - метод Call.enqueue().
                    //В Response - получаем json обьект
                    Map<String, String> map = gson.fromJson(res.body().toString(), Map.class);//res.body() - все что пришло с сервера

                    for (Map.Entry e : map.entrySet()) {
                        if (e.getKey().equals("text")) {
                            String str = e.getValue().toString();
                            text.setText(str.substring(1, str.length()-1));
                        }
//                        System.out.println(e.getKey()+" "+e.getValue());
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
