package com.senai.jogodavelha;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class EstatisticaActivity extends Activity {

	Intent appIntent;
	String ganhador;
	String jogador1;
	String jogador2;
	String vitoriax;
	String vitoriao;
	String empate;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_estatistica);
		appIntent = getIntent();
		obterEstatisticas();
		mostrarGanhador();
		mostrarJogadores();
		mostrarPlacar();
	}
	
	private void obterEstatisticas() {
		ganhador = appIntent.getStringExtra("ganhador");
		
		jogador1 = appIntent.getStringExtra("jogador1");
		jogador2 = appIntent.getStringExtra("jogador2");
		
		vitoriax = appIntent.getStringExtra("vitoriax");
		vitoriao = appIntent.getStringExtra("vitoriao");
		empate = appIntent.getStringExtra("empate");
	}
	
	private void mostrarGanhador() {
		TextView tvGanhador = (TextView) findViewById(R.id.tv_ganhador);
		
		if (ganhador.equals("X")) {
			tvGanhador.setText(jogador1 + " é o vencedor!");
		} else if (ganhador.equals("O")) {
			tvGanhador.setText(jogador2 + " é o vencedor!");
		} else {
			tvGanhador.setText("Jogo empatado");
		}
	}
	
	private void mostrarJogadores() {
		TextView tvJogador1 = (TextView) findViewById(R.id.tv_titulo_jogador1);
		TextView tvJogador2 = (TextView) findViewById(R.id.tv_titulo_jogador2);
		
		tvJogador1.setText(jogador1);
		tvJogador2.setText(jogador2);
	}
	
	private void mostrarPlacar() {
		TextView tvVitoriasX = (TextView) findViewById(R.id.tv_jogador1);
		TextView tvVitoriasO = (TextView) findViewById(R.id.tv_jogador2);
		TextView tvEmpates = (TextView) findViewById(R.id.tv_empates);
		
		tvVitoriasX.setText(vitoriax);
		tvVitoriasO.setText(vitoriao);
		tvEmpates.setText(empate);
	}
	
	public void jogarNovamente(View view) {
		appIntent.setClass(this, JogadorActivity.class);
		startActivity(appIntent);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.estatistica, menu);
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
