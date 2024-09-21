package com.ismailmesutmujde.kotlinalertview

import android.content.DialogInterface
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.ismailmesutmujde.kotlinalertview.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var bindingMain : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMain = ActivityMainBinding.inflate(layoutInflater)
        val view = bindingMain.root
        setContentView(view)

        bindingMain.buttonNormal.setOnClickListener {

            val alertDialog = AlertDialog.Builder(this@MainActivity)
            alertDialog.setMessage("Message")
            alertDialog.setTitle("Title")
            alertDialog.setIcon(R.drawable.image)

            alertDialog.setPositiveButton("OK") { dialogInterface, i ->
                Toast.makeText(applicationContext,"OK was clicked.", Toast.LENGTH_SHORT).show()
            }
            alertDialog.setNegativeButton("CANCEL") { dialogInterface, i ->
                Toast.makeText(applicationContext,"CANCEL was clicked.", Toast.LENGTH_SHORT).show()
            }

            alertDialog.create().show()

        }

        bindingMain.buttonPrivate.setOnClickListener {

            val design = layoutInflater.inflate(R.layout.alert_design, null)
            val editTextAlert = design.findViewById(R.id.editTextAlert) as EditText
            val alertDialog = AlertDialog.Builder(this@MainActivity)
            alertDialog.setMessage("Message")
            alertDialog.setTitle("Title")
            alertDialog.setIcon(R.drawable.image)

            alertDialog.setView(design)

            alertDialog.setPositiveButton("SAVE") { dialogInterface, i ->
                val incomingData = editTextAlert.text.toString()

                Toast.makeText(applicationContext,"Incoming Data : $incomingData", Toast.LENGTH_SHORT).show()
            }
            alertDialog.setNegativeButton("CANCEL") { dialogInterface, i ->
                Toast.makeText(applicationContext,"CANCEL was clicked.", Toast.LENGTH_SHORT).show()
            }

            alertDialog.create().show()

        }

    }
}