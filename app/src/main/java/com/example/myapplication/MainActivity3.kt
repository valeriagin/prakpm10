package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity3 : AppCompatActivity() {
    lateinit var bottom_sh: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        // присваиваем значение нашей переменной для кнопки
        bottom_sh = findViewById(R.id.bottom_sh);

        // добавляем обработчик события для кнопки
        bottom_sh.setOnClickListener {

            // создаем диалог
            val dialog = BottomSheetDialog(this)

            // наполняем файл макета который уже создали
            val view = layoutInflater.inflate(R.layout.bottom_sheet, null)

            // создаем переменную для кнопки, чтоб закрыть диалог
            val btnClose = view.findViewById<TextView>(R.id.butt_sheet)

            // добавляем обработчик для закрытия кнопки диалога
            btnClose.setOnClickListener {
                // тут мы вызываем отклонения
            dialog.dismiss()
            }
            // данная строка - для отмены
            dialog.setCancelable(false)
            dialog.setContentView(view)
            dialog.show()
        }
    }
}