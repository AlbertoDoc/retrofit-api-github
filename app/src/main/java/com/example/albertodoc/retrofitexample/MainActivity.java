package com.example.albertodoc.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.example.albertodoc.retrofitexample.Model.User;
import com.example.albertodoc.retrofitexample.Retrofit.GitHubService;
import com.example.albertodoc.retrofitexample.Retrofit.RetrofitConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button btnBuscarCep = findViewById(R.id.buscarButton);
		final EditText campoCep = findViewById(R.id.cepEditText);
		final TextView cepTxtView = findViewById(R.id.cepTextView);


		btnBuscarCep.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// buscar o cep

				String userInput = campoCep.getText().toString();

				RetrofitConfig retrofit = new RetrofitConfig();

				GitHubService service = retrofit.getRetrofit().create(GitHubService.class);

				Call<User> call = service.getUser(userInput);

				call.enqueue(new Callback<User>() {
					@Override
					public void onResponse(Call<User> call, Response<User> response) {
						if(!response.isSuccessful()){
							cepTxtView.setText("usuário não encontrado, código de erro -> " + response.code());
							return;
						}

						User user = new User(response.body().getName(), response.body().getBio(), response.body().getLocation());

						cepTxtView.setText(user.toString());
					}

					@Override
					public void onFailure(Call<User> call, Throwable t) {
						campoCep.setText("Erro ao buscar usuário: " + t.getMessage());
					}
				});
			}
		});
	}
}
