package com.senai.jogodavelha;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class JogadorActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jogador);
	}
	
	public void iniciarJogo(View view) {
		EditText etJogador1 = (EditText)findViewById(R.id.et_jogador1);
		EditText etJogador2 = (EditText)findViewById(R.id.et_jogador2);
		
		String jogador1 = etJogador1.getText().toString();
		String jogador2 = etJogador2.getText().toString();
		
		Intent intent = new Intent(this, JogoActivity.class);
		intent.putExtra("jogador1", jogador1);
		intent.putExtra("jogador2", jogador2);
		
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.jogador, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
