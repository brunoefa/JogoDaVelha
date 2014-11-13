package com.senai.jogodavelha;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class JogoActivity extends Activity {

	enum Status {Vazio, X, O};
	Status statusAtual = Status.X;
	int n = 3, movimentos;
	Integer vitoriax = 0, vitoriao = 0, empate = 0;
	Status[][] matriz = new Status[n][n];
	Intent appIntent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jogo);
		setupJogo();
	}
	
	private void setupJogo() {
		appIntent = getIntent();
		String ganhador = appIntent.getStringExtra("ganhador");
		if (ganhador != null) {
			vitoriax = Integer.parseInt(appIntent.getStringExtra("vitoriax"));
			vitoriao = Integer.parseInt(appIntent.getStringExtra("vitoriao"));
			empate = Integer.parseInt(appIntent.getStringExtra("empate"));
		}
	}
	
	public void setupBotao(Button b) {
		b.setText(statusAtual.toString());
		b.setEnabled(Boolean.FALSE);
	}
	
	public void trocaStatus() {
		statusAtual = (statusAtual == Status.X ? Status.O : Status.X);
	}
	
	private void movimento(int x, int y, Status s) {
		matriz[x][y] = s;
		trocaStatus();
		movimentos++;
		
		// verficação de colunas
		for (int i = 0; i < n; i++){
			if (matriz[x][i] != s) break;
			if (i == n - 1) {
				mostrarEstatistica(s);
			}
		}
		
		// verficação de linhas
		for (int i = 0; i < n; i++){
			if (matriz[i][y] != s) break;
			if (i == n - 1) {
				mostrarEstatistica(s);
			}
		}
		
		// verficação de diagonal
		if (x == y) {
			for (int i = 0; i < n; i++){
				if (matriz[i][i] != s) break;
				if (i == n - 1) {
					mostrarEstatistica(s);
				}
			}
		}
		
		// verificação da antidiagonal
		for (int i = 0; i < n; i++){
			if (matriz[i][(n - 1) - i] != s) break;
			if (i == n - 1) {
				mostrarEstatistica(s);
			}
		}
		
		// verifica se deu velha
		if (movimentos == (Math.pow(n, 2)) - 1) {
			mostrarEstatistica(Status.Vazio);
		}
	}
	
	private void mostrarEstatistica(Status s) {
		appIntent.setClass(this, EstatisticaActivity.class);
		
		if (s == Status.X) {
			vitoriax++;
		} else if (s == Status.O) {
			vitoriao++;
		} else {
			empate++;
		}
		
		appIntent.putExtra("vitoriax", vitoriax.toString());
		appIntent.putExtra("vitoriao", vitoriao.toString());
		appIntent.putExtra("empate", empate.toString());
		appIntent.putExtra("ganhador", s.toString());
		
		startActivity(appIntent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.jogo, menu);
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
	
	public void click1(View view){
		Button button = (Button)findViewById(R.id.button1);
		setupBotao(button);
		movimento(0, 0, statusAtual);
	}
	
	public void click2(View view){
		Button button = (Button)findViewById(R.id.button2);
		setupBotao(button);
		movimento(0, 1, statusAtual);
	}
	
	public void click3(View view){
		Button button = (Button)findViewById(R.id.button3);
		setupBotao(button);
		movimento(0, 2, statusAtual);
	}
	
	public void click4(View view){
		Button button = (Button)findViewById(R.id.button4);
		setupBotao(button);
		movimento(1, 0, statusAtual);
	}
	
	public void click5(View view){
		Button button = (Button)findViewById(R.id.button5);
		setupBotao(button);
		movimento(1, 1, statusAtual);
	}
	
	public void click6(View view){
		Button button = (Button)findViewById(R.id.button6);
		setupBotao(button);
		movimento(1, 2, statusAtual);
	}
	
	public void click7(View view){
		Button button = (Button)findViewById(R.id.button7);
		setupBotao(button);
		movimento(2, 0, statusAtual);
	}
	
	public void click8(View view){
		Button button = (Button)findViewById(R.id.button8);
		setupBotao(button);
		movimento(2, 1, statusAtual);
	}
	
	public void click9(View view){
		Button button = (Button)findViewById(R.id.button9);
		setupBotao(button);
		movimento(2, 2, statusAtual);
	}
}
