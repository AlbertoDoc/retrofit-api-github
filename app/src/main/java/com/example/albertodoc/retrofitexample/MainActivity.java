package com.example.albertodoc.retrofitexample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.albertodoc.retrofitexample.Retrofit.RetrofitConfig;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends Activity {

	private Disposable disposable;
	private TextView cepTxtView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button btnBuscarCep = findViewById(R.id.buscarButton);
		final EditText campoCep = findViewById(R.id.cepEditText);
		cepTxtView = findViewById(R.id.cepTextView);


		btnBuscarCep.setOnClickListener(v -> {
			String userInput = campoCep.getText().toString();

			if (!userInput.isEmpty()){
				getGithubUser(userInput);
			}
		});
	}

	private void getGithubUser(String userName) {
		disposable = RetrofitConfig.getInstance()
				.getUser(userName)
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(user -> {
					String texto = user.toString();
					cepTxtView.setText(texto);
				}, throwable -> {
					cepTxtView.setText("Usuário não encontrado");
				});
	}
}
