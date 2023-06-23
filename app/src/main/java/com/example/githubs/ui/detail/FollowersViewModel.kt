package com.example.githubs.ui.detailimport android.content.ContentValues.TAGimport android.util.Logimport androidx.lifecycle.LiveDataimport androidx.lifecycle.MutableLiveDataimport androidx.lifecycle.ViewModelimport com.example.githubs.api.ApiConfigimport com.example.githubs.model.ListUsersimport retrofit2.Callimport retrofit2.Callbackimport retrofit2.Responseclass FollowersViewModel:ViewModel() {    private val _listFollowes = MutableLiveData<List<ListUsers>>()    val listFollowers: LiveData<List<ListUsers>> = _listFollowes    fun getFollowers(username: String){        ApiConfig.getApiService().getFollowers(username)            .enqueue(object : Callback<List<ListUsers>>{                override fun onResponse(call: Call<List<ListUsers>>, response: Response<List<ListUsers>>                ) {                    if (response.isSuccessful){                        _listFollowes.value = response.body()                    }                }                override fun onFailure(call: Call<List<ListUsers>>, t: Throwable) {                    Log.e(TAG, "onFailure ${t.message.toString()}")                }            })    }}