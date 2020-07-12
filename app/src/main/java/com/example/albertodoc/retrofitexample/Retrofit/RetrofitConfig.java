package com.example.albertodoc.retrofitexample.Retrofit;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {

	private static final String BASE_URL = "https://api.github.com/";
	private final Retrofit retrofit;
	private static RetrofitConfig instance;

	public RetrofitConfig(){
		this.retrofit = new Retrofit.Builder()
				.baseUrl(BASE_URL)
				.addCallAdapterFactory(RxJava3CallAdapterFactory.createWithScheduler(Schedulers.io()))
				.addConverterFactory(GsonConverterFactory.create())
				.build();
	}

	public static RetrofitConfig getInstance() {
		if(instance == null){
			instance = new RetrofitConfig();
		}
		return instance;
	}

	public Retrofit getRetrofit() {
		return retrofit;
	}
}
