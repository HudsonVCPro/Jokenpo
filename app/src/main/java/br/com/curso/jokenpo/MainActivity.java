package br.com.curso.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view) {
        this.opcaoSelecionada("pedra");
    }

    public void selecionadoPapel(View view) {
        this.opcaoSelecionada("papel");
    }

    public void selecionadoTesoura(View view) {
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String opcao) {
        int n = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoApp = opcoes[n];

        ImageView img = findViewById(R.id.imgResultado);
        TextView txt = findViewById(R.id.txtFrase);

        switch (opcaoApp) {
            case "pedra":
                img.setImageResource(R.drawable.pedra);
                break;

            case "papel":
                img.setImageResource(R.drawable.papel);
                break;

            case "tesoura":
                img.setImageResource(R.drawable.tesoura);
                break;
        }

        if ((opcaoApp == "pedra" && opcao == "papel") ||
                (opcaoApp == "papel" && opcao == "tesoura") ||
                (opcaoApp == "tesoura" && opcao == "pedra")
        ) {
            txt.setText("Você ganhou :D");

        } else if ((opcao == "pedra" && opcaoApp == "papel") ||
                (opcao == "papel" && opcaoApp == "tesoura") ||
                (opcao == "tesoura" && opcaoApp == "pedra")
        ) {
            txt.setText("Você perdeu :(");

        } else {
            txt.setText("Empate!");

        }
    }
}
