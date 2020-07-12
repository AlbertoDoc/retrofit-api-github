package com.example.albertodoc.retrofitexample.Retrofit;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {

	private final Retrofit retrofit;

	public RetrofitConfig(){
		this.retrofit = new Retrofit.Builder()
				.baseUrl("https://jsonplaceholder.typicode.com/")
				.addCallAdapterFactory(RxJava3CallAdapterFactory.create())
				.addConverterFactory(GsonConverterFactory.create())
				.build();
	}

	public Retrofit getRetrofit() {
		return retrofit;
	}
}
