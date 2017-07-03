package com.example.mypc.mytranslator;

import java.util.Map;

import retrofit.Call;
import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by MyPc on 21.04.2017.
 */

public interface Link {//интерфейс для управления адресом, используя команды GET, POST и т.д.
    //content://authority/path
//   https://translate.yandex.net/api/v1.5/tr.json/translate
// api/v1.5/tr.json/translate
    @FormUrlEncoded//При использовании пары "имя/значение" в POST-запросах применяется аннотации @FormUrlEncoded и @FieldMap:
    @POST("/api/v1.5/tr.json/translate")//ссылка куда отправляется запрос
    Call<Object> translate(@FieldMap Map<String, String > map);// Call<Object> - то что получаем назад.
    //Запросы размещаются в обобщённом классе Call с указанием желаемого типа.
}
