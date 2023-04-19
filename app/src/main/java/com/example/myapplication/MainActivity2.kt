package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import java.util.regex.Pattern

class MainActivity2 : AppCompatActivity() {
    lateinit var mail:EditText
    lateinit var pass:EditText
    lateinit var button:Button

   val pattern=("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,100}" + "\\@" + "[a-z][a-z\\-]{0,10}" + "(" + "\\." + "[a-z][a-z\\-]{0,4}" + ")+")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        mail = findViewById(R.id.mail)
        pass = findViewById(R.id.pass)
        button = findViewById(R.id.button)
        // заблокированная кнопка
        mail.addTextChangedListener(textWatcher)
        pass.addTextChangedListener(textWatcher)


    }
    private val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        //кнопка будет деактивирована при условии, пока не будет введен пароль и емайл
        val mail = mail.toString().trim()
        val password = pass.toString().trim()
        button.isEnabled = password.isNotEmpty()&&mail.isNotEmpty()
    }
        override fun afterTextChanged(s: Editable?) {}

    }
        //проверка валидации
    fun emailValid(text:String):Boolean {
       return Pattern.compile(pattern).matcher(text).matches()
    }
    fun next1(view: View) {
        if (mail.text.toString().isNotEmpty()&&pass.text.toString().isNotEmpty()) {
            if (emailValid(mail.text.toString())) {
                val intent = Intent(this@MainActivity2, MainActivity3::class.java)
                startActivity(intent)
                finish()
            }
            else {
                Toast.makeText(this, "Ошибка в заполнении поля E-mail", Toast.LENGTH_SHORT)
                    .show()
            }
        }
            //проверка заполнения полей
        else {
            val alert = AlertDialog.Builder(this)
                .setTitle("Заполните все текстовые поля")
                .setPositiveButton("ОК", null)
                .create()
                .show()
        }

        // спиннер
        // получаем доступ к файлу strings.xml
        val TypesOfTrains = resources.getStringArray(R.array.TypesOfTrains)

        // получаем доступ к счетчику и устанавливаем адаптер для управления списком
        val spinner = findViewById<Spinner>(R.id.Spinner)
        if (spinner != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, TypesOfTrains)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {

                }
                override fun onNothingSelected(parent: AdapterView<*>) {
                }
            }
        }



    }
}

