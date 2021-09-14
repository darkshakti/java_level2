package ru.geekbrains.lesson6.hw;

// С помощью http запроса получить в виде json строки погоду в Санкт-Петербурге на период
// времени, пересекающийся со следующим занятием (например, выборка погода на следующие
// 5 дней - подойдет)
// 2. Подобрать источник самостоятельно. Можно использовать api accuweather, порядок
// следующий: зарегистрироваться, зарегистрировать тестовое приложение для получения api
// ключа, найдите нужный endpoint и изучите документацию. Бесплатный тарифный план
// предполагает получение погоды не более чем на 5 дней вперед (этого достаточно для
// выполнения д/з).

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;

public class HomeWork6 {
    public static final String HOST = "dataservice.accuweather.com";
    public static final String FORECAST_URL = "forecasts";
    public static final String DAILY_URL = "daily";
    public static final String FIVE_DAYS_URL = "5day";
    public static final String API_VERSION = "v1";
    public static final String CITY_ID = "295212";
    public static final String API_KEY = "15N8f128OE5AGJaOGr4YdbtCSlfImRq1";
    public static final String LANGUAGE = "ru-RU";
    public static final String METRIC = "true";

    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();
        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host(HOST)
                .addPathSegment(FORECAST_URL)
                .addPathSegment(API_VERSION)
                .addPathSegment(DAILY_URL)
                .addPathSegment(FIVE_DAYS_URL)
                .addPathSegment(CITY_ID)
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("language", LANGUAGE)
                .addQueryParameter("metric", METRIC)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();

        System.out.println(Objects.requireNonNull(response.body()).string());
    }
}