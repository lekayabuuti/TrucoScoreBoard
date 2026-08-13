package br.edu.ifsp.scl.sc3047733.trucoscoreboard

import android.os.Bundle
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

                if (contadorPontosTimeA == 12) {
                    zerarComponentes(this@MainActivity, this@with)
                }
                if (contadorPontosTimeA == 11) {
                    mostrarMaoDeOnze("Time A")
                }
                pontuacaoTimeA.text = contadorPontosTimeA.toString()
            }

            btn1TimeB.setOnClickListener {
                contadorPontosTimeB++
                if (contadorPontosTimeB == 12) {
                    zerarComponentes(this@MainActivity, this@with)
                }
                if (contadorPontosTimeB == 11) {
                    mostrarMaoDeOnze("Time B")
                }

                pontuacaoTimeB.text = contadorPontosTimeB.toString()
            }

            btn3TimeA.setOnClickListener {
                contadorPontosTimeA += 3

                if (contadorPontosTimeA >= 12) {
                    zerarComponentes(this@MainActivity, this@with)
                }
                if (contadorPontosTimeA == 11) {
                    mostrarMaoDeOnze("Time A")
                }
                pontuacaoTimeA.text = contadorPontosTimeA.toString()
            }

            btn3TimeB.setOnClickListener {
                contadorPontosTimeB += 3
                if (contadorPontosTimeB >= 12) {
                    zerarComponentes(this@MainActivity, this@with)
                }
                if (contadorPontosTimeB == 11) {
                    mostrarMaoDeOnze("Time B")
                }

                pontuacaoTimeB.text = contadorPontosTimeB.toString()
            }

        }


    }
    private fun mostrarMaoDeOnze(time: String) {
        androidx.appcompat.app.AlertDialog.Builder(this)
            .setTitle("Mão de 11")
            .setMessage("$time está na mão de 11!")
            .setPositiveButton("OK", null)
            .show()
    }

    private fun zerarComponentes(activity: MainActivity, binding: ActivityMainBinding) {
        activity.contadorPontosTimeA = 0
        activity.contadorPontosTimeB = 0
        binding.pontuacaoTimeA.text = activity.contadorPontosTimeA.toString()
        binding.pontuacaoTimeB.text = activity.contadorPontosTimeB.toString()
    }
}

