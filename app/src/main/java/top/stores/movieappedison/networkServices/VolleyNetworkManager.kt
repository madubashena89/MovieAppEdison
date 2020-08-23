package top.stores.movieappedison.networkServices

import android.content.Context
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import org.json.JSONException
import org.json.JSONObject
import java.util.*

object VolleyNetworkManager {


    fun downloadData(context: Context){
        fun paerseResponseToWeatherEntityByCityID(cityID: String) {
            val url: String = "https://api.themoviedb.org/4/list/1?page=1&api_key=d956f280a7d5133bcf5ca8233b99febf"
            val weatherReportEntities: MutableList<WeatherReportEntity> =
                ArrayList<WeatherReportEntity>()

// get the json object
            val objectRequest = JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                Response.Listener { response ->
                    try {
                        val consolidatedWeatherList =
                            response.getJSONArray("consolidated_weather")
                        for (i in 0 until consolidatedWeatherList.length()) {
                            val oneDayWeather = WeatherReportEntity()
                            val firstDayFromApi =
                                consolidatedWeatherList[i] as JSONObject
                            oneDayWeather.setId(firstDayFromApi.getInt("id"))
                            oneDayWeather.setWeatherStateName(firstDayFromApi.getString("weather_state_name"))
                            oneDayWeather.setWeatherStateAbbr(firstDayFromApi.getString("weather_state_abbr"))
                            oneDayWeather.setWindDirectionCompass(firstDayFromApi.getString("wind_direction_compass"))
                            oneDayWeather.setCreated(firstDayFromApi.getString("created"))
                            oneDayWeather.setApplicableDate(firstDayFromApi.getString("applicable_date"))
                            oneDayWeather.setMinTemp(firstDayFromApi.getLong("min_temp"))
                            oneDayWeather.setMaxTemp(firstDayFromApi.getLong("max_temp"))
                            oneDayWeather.setTheTemp(firstDayFromApi.getLong("the_temp"))
                            oneDayWeather.setWindSpeed(firstDayFromApi.getLong("wind_speed"))
                            oneDayWeather.setWindDirection(firstDayFromApi.getLong("wind_direction"))
                            oneDayWeather.setAirPressure(firstDayFromApi.getLong("air_pressure"))
                            oneDayWeather.setHumidity(firstDayFromApi.getInt("humidity"))
                            oneDayWeather.setVisibility(firstDayFromApi.getLong("visibility"))
                            oneDayWeather.setPredictability(firstDayFromApi.getInt("predictability"))
                            weatherReportEntities.add(oneDayWeather)
                        }
                        //  forecastByIDResponse.onResponse(weatherReportEntities);
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }, // get the property called "consolidated_weather" which is an array
                // get each item in the array and assign it to a new WeatherReportEntity object.
                Response.ErrorListener { error -> error.printStackTrace() })
             VolleySingleton.getInstance(context).addToRequestQueue(objectRequest)
        }
    }
}