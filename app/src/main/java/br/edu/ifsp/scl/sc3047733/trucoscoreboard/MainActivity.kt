package br.edu.ifsp.scl.sc3047733.trucoscoreboard

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.scl.sc3047733.trucoscoreboard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val activityMainBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private var contadorPontosTimeA: Int = 0
    private var contadorPontosTimeB: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityMainBinding.root)

        with (activityMainBinding) {
            btn1TimeA.setOnClickListener {
                contadorPontosTimeA++
                verificaPontos("Time A", contadorPontosTimeA, pontuacaoTimeA)
            }

            btn1TimeB.setOnClickListener {
                contadorPontosTimeB++
                verificaPontos("Time B", contadorPontosTimeB, pontuacaoTimeB)
            }

            btn3TimeA.setOnClickListener {
                contadorPontosTimeA += 3
                verificaPontos("Time A", contadorPontosTimeA, pontuacaoTimeA)
            }

            btn3TimeB.setOnClickListener {
                contadorPontosTimeB += 3
                verificaPontos("Time B", contadorPontosTimeB, pontuacaoTimeB)
            }

            btnReiniciarJogo.setOnClickListener {
                zerarComponentes()
            }
        }

    }

    private fun verificaPontos(time: String, pontuacao: Int, texto: TextView) {
        texto.text = pontuacao.toString()

        if (pontuacao >= 12) {
            avisarVencedor(time)
            zerarComponentes()
            return
        }

        if (pontuacao == 11) {
            mostrarMaoDeOnze(time)
        }
    }
    private fun mostrarMaoDeOnze(time: String) {
        androidx.appcompat.app.AlertDialog.Builder(this)
            .setTitle("Mão de 11")
            .setMessage("$time está na mão de 11!")
            .setPositiveButton("OK", null)
            .show()
    }

    private fun avisarVencedor(time: String) {
        androidx.appcompat.app.AlertDialog.Builder(this)
            .setTitle("Fim de Jogo")
            .setMessage("$time venceu! Parabéns!")
            .setPositiveButton("Finalizar partida", null)
            .show()
    }

    private fun zerarComponentes() {
        contadorPontosTimeA = 0
        contadorPontosTimeB = 0
        activityMainBinding.pontuacaoTimeA.text = "0"
        activityMainBinding.pontuacaoTimeB.text = "0"
    }
}

