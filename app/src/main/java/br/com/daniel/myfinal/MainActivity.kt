package br.com.daniel.myfinal

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        //Inicializing a String Array
        val colors = arrayOf("Sexo:", "Masculino", "Feminino")

        //Inicializing an ArrayAdapter
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item, //Layout
        colors // Array
        )

        //Set the drop down view resource
        adapter.setDropDownViewResource (android.R.layout.simple_dropdown_item_1line)

        //Finally, data bind the spinner object with adapter
        spinner.adapter = adapter;

        // Set an on item selected listener for spinner object
        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                //Display the selected item text on text view
                //text_view.text = "Spinner selected: ${parent.getItemAtPosition(position)..toString()}"

            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                //Another interface callback
            }
        }

        //Aparecer numero no text peso
        seekBar.setOnSeekBarChangeListener (object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                txtPeso.text = " " + p1
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })

        //Aparecer número no txtAltura
        seekBar2.setOnSeekBarChangeListener (object : SeekBar.OnSeekBarChangeListener{
            override  fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean){
                txtAltura.text = " " + p1
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })


        //Botão tabela
        btnTabela.setOnClickListener {
            startActivity(Intent(this@MainActivity, activity_tabela::class.java))
            finishAffinity()
        }

        //Botão Calcular
        btnCalcular.setOnClickListener {

            val peso: Float = txtPeso.text.toString().toFloat()
            val altura: Float = txtAltura.text.toString().toFloat()

            val imc = (altura * altura) / peso

            val resultado = String.format("%.4f", imc)

            AlertDialog.Builder(this@MainActivity)

                .setTitle("Resultado")
                .setMessage("Seu IMC é de : $resultado")
                .setPositiveButton("OK") { _, _ ->
                }
                .create()
                .show()
        }
    }

}
