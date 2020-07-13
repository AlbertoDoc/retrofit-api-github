package com.example.albertodoc.retrofitexample.Retrofit;

import com.example.albertodoc.retrofitexample.Model.User;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {

	private static final String BASE_URL = "https://api.github.com/";
	private final Retrofit retrofit;
	private static RetrofitConfig instance;
	private GitHubService service;

	public RetrofitConfig(){
		this.retrofit = new Retrofit.Builder()
				.baseUrl(BASE_URL)
				.addCallAdapterFactory(RxJava3CallAdapterFactory.createWithScheduler(Schedulers.io()))
				.addConverterFactory(GsonConverterFactory.create())
				.build();

		service = retrofit.create(GitHubService.class);
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

	public Flowable<User> getUser(@NonNull String userName){
		return service.getUser(userName);
	}
}
