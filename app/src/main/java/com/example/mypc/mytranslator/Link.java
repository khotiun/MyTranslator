package com.example.mypc.mytranslator;

import java.util.Map;

import retrofit.Call;
import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by MyPc on 21.04.2017.
 */

public interface Link {
    //content://authority/path
//   https://translate.yandex.net/api/v1.5/tr.json/translate
// api/v1.5/tr.json/translate
    @FormUrlEncoded
    @POST("/api/v1.5/tr.json/translate")
    Call<Object> translate(@FieldMap Map<String, String > map);
}
