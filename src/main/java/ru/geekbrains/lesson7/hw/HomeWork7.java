package ru.geekbrains.lesson7.hw;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import ru.geekbrains.lesson7.hw.dto.DailyForecast;
import ru.geekbrains.lesson7.hw.dto.WeatherResponse;

import java.io.IOException;
import java.util.Objects;

public class HomeWork7 {
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
//        System.out.println(response.body().string());
        ObjectMapper objectMapper = new ObjectMapper();
        WeatherResponse weatherResponse = objectMapper.readValue(response.body().byteStream(), WeatherResponse.class);

//        System.out.println(weatherResponse);

        for (DailyForecast forecast : weatherResponse.getDailyForecasts()) {
            System.out.printf("Погода в Санкт-Петербурге на %s\n" +
                            "%s, " + "температура от %.1f %s\n\n",
                    forecast.getDate(),
                    forecast.getDay().getIconPhrase(),
                    forecast.getTemperature().getMinimum().getValue(),
                    forecast.getTemperature().getMaximum().getValue(),
                    forecast.getTemperature().getMinimum().getUnit());
        }

//        System.out.println(Objects.requireNonNull(response.body()).string());
    }
}


