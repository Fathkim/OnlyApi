package com.fathkim.onlyapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.fathkim.onlyapi.Api.ApiConfig
import com.fathkim.onlyapi.data.ItemUserResponse
import com.fathkim.onlyapi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    private val adapterUser = AdapterUser()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //get Api
        getApi()

        //set layout manager dan adapter
    }

    fun setData(data: ArrayList<ItemUserResponse>){
        binding.rvList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = adapterUser
            adapterUser.setUser(data)
        }
    }
    fun getApi(){
        ApiConfig.getApiService().getListUser().enqueue(object :
            Callback<ArrayList<ItemUserResponse>> {
            override fun onResponse(
                call: Call<ArrayList<ItemUserResponse>>,
                response: Response<ArrayList<ItemUserResponse>>
            ) {
                response.body()?.let {
//                   adapterUser.setUser(it)
                    setData(it)
                }
            }

            override fun onFailure(call: Call<ArrayList<ItemUserResponse>>, t: Throwable) {
                Log.e("TAG", "onFailure: $t",)
            }

        })
    }

}