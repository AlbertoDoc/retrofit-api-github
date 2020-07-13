package com.example.albertodoc.retrofitexample.Retrofit;

import com.example.albertodoc.retrofitexample.Model.User;

import io.reactivex.rxjava3.core.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubService {
	@GET("users/{user}")
	Flowable<User> getUser(@Path("user") String userName);
}
