package com.uso.guia3

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class FormActivity : AppCompatActivity() {
    lateinit var progressFormulario:ProgressBar
    lateinit var progressText: TextView
    lateinit var btnGuardarNombre: Button
    lateinit var editNombre:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        progressFormulario = findViewById(R.id.progressFormulario)
        progressText = findViewById(R.id.progressText)
        btnGuardarNombre = findViewById(R.id.btnGuardarNombre)
        editNombre = findViewById(R.id.editNombre)
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (currentFocus != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
        return super.dispatchTouchEvent(ev)
    }

    fun progressFormularioOnClick(view: View){
        if(editNombre.text.toString().isEmpty()){
            Toast.makeText(this, R.string.error, Toast.LENGTH_SHORT).show()
        }else{
            btnGuardarNombre.isEnabled = false
            btnGuardarNombre.setBackgroundColor(resources.getColor(android.R.color.darker_gray))
            progressFormulario.visibility = View.VISIBLE
            progressText.visibility = View.VISIBLE
            processData()
        }
    }

    fun saveData(){
        var textFromEdit = editNombre.text.toString()
        MainActivity.list.add(textFromEdit)
        Toast.makeText(this, R.string.success, Toast.LENGTH_SHORT).show()
        finish()
    }

    fun processData(){
        progressFormulario.progress = 0
        progressFormulario.max = 100
        var handler: Handler = Handler()

        Thread(Runnable {
            run {
                var progress: Int = 0
                while (progress < 100) {
                    try {
                        Thread.sleep(75)
                    } catch (ex: InterruptedException) {
                        ex.printStackTrace()
                    }
                    progress += 1

                    var finalProgress: Int = progress
                    handler.post(Runnable {
                        run {
                            progressText.text = finalProgress.toString()
                            progressFormulario.progress = finalProgress
                        }
                    })
                }
                runOnUiThread() {
                    saveData()
                }
            }
        }).start()
    }
}