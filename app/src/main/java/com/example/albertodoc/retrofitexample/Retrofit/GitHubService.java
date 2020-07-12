package com.example.albertodoc.retrofitexample.Retrofit;

import com.example.albertodoc.retrofitexample.Model.User;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubService {
	@GET("users")
	Flowable<List<User>> getUsers();
}
