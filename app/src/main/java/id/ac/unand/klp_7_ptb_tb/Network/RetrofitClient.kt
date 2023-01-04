package id.ac.unand.klp_7_ptb_tb.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "http://ptb-api.husnilkamil.my.id/"

    val instance : KpClient by lazy{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(KpClient::class.java)
    }
}