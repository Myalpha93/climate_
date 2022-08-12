package com.z.climate.controller

import com.z.climate.model.Location
import com.z.climate.model.Logs
import com.z.climate.service.BasicCrud
import com.z.climate.service.LocationService
import com.z.climate.service.LogsService
import okhttp3.*
import org.json.JSONArray
import org.json.JSONObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController
import java.util.*

class Requests() {
    private val apiClimateEndPoint : String? = System.getenv("https://api.weatherbit.io/v2.0/current")
    private val keyApiClimateEndPoint : String? = System.getenv("ff8e83a0d6a844a2b209cae6f8a5ce0b")


    var client: OkHttpClient = OkHttpClient()

    fun obtenerDatosPorLocation(id:Integer): Request {
        val request: Request = Request.Builder()
            .header("key", "$keyApiClimateEndPoint")
            .header("city_id", "$id")
            .url("$apiClimateEndPoint")
            .build()
        return request
    }

    companion object {
//        private val apiSchemeEndPoint : String? = System.getenv("scheme")
//        private val apiHostEndPoint : String? = System.getenv("host")
//        private val apiSegment1EndPoint : String? = System.getenv("segment1")
//        private val apiSegment2EndPoint : String? = System.getenv("segment2")
//        private val keyApiClimateEndPoint : String? = System.getenv("apiKey")
        //https://api.weatherbit.io/v2.0/current
        var client: OkHttpClient = OkHttpClient()

        fun obtenerDatosPorLocation(i: String): Any {
            val httpUrl: HttpUrl = HttpUrl.Builder()
                .scheme("https")
                .host("api.weatherbit.io")
                .addPathSegment("v2.0")
                .addPathSegment("current")
                .addQueryParameter(
                    "key",
                    "ff8e83a0d6a844a2b209cae6f8a5ce0b"

                ).addQueryParameter(
                    "city_id",
                    "$i" )
                .build()
            val request: Request = Request.Builder()
                .url(httpUrl)
                .build()
            val call: Call = client.newCall(request)
            val response: Response = call.execute()
            val resStr = response.body!!.string()
            var status = response.code
            if (status == 200 ){
                var logNew = Logs(
                    logID= UUID.randomUUID().toString(),
                    error="error",
                    timestamp = java.sql.Timestamp(System.currentTimeMillis())
                )

            }

            val obj = JSONObject(resStr)
            val arr: JSONArray = obj.getJSONArray("data")
            for (i in 0 until arr.length()) {
                val row: JSONObject = arr.getJSONObject(i)
                return row
            }
            //{"data":[
            // {"wind_cdir":"N","rh":76,"pod":"n","lon":-70.64827,"pres":961,"timezone":"America\/Santiago",
            // "ob_time":"2022-08-11 02:00","country_code":"CL","clouds":81,"ts":1660183200,"solar_rad":0,
            // "state_code":"12","city_name":"Santiago","wind_spd":1,"slp":1018,"wind_cdir_full":"north",
            // "sunrise":"11:25","app_temp":9,"dni":0,"vis":16,"sources":["SCEL"],"h_angle":-90,"dewpt":5,
            // "snow":0,"aqi":168,"dhi":0,"wind_dir":0,"elev_angle":-47.99,"ghi":0,"precip":0,"sunset":"22:11",
            // "lat":-33.45694,"uv":0,"datetime":"2022-08-11:02","temp":9,"weather":{"icon":"c03n","code":803,
            // "description":"Broken clouds"},"station":"SCEL"}
            // ],"count":1}
            return request
        }

        fun llamarApi(): Response {
            val httpUrl: HttpUrl = HttpUrl.Builder()
                .scheme("http")
                .host("localhost")
                .port(8080)
                .addPathSegment("location")
                .build()
            val request: Request = Request.Builder()
                .url(httpUrl)
                .build()
            val call: Call = Companion.client.newCall(request)
            val response: Response = call.execute()
            return response
        }
    }
}