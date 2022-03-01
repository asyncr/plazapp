package com.example.plazapp

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import com.example.plazapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.supportActionBar?.hide()
        getData()
    }


    fun getData(){
        binding.btnLogin.setOnClickListener {
            val one = binding.txtMil.text
            val two = binding.txtTresmil.text
            val number:Double

            if(!one.isEmpty() || !two.isEmpty()){

                if(!one.isEmpty() && !two.isEmpty()){
                    //Creas para cada uno
                    number = getResta(one.toString().toInt(),50.0)
                    Toast.makeText(this,"Future Flags",Toast.LENGTH_LONG).show()
                }else if (!one.isEmpty()){
                    number = getResta(one.toString().toInt(),50.0)
                    Toast.makeText(this,"Area T : $number",Toast.LENGTH_LONG).show()
                }else{
                    number = getResta(two.toString().toInt(),150.0)
                    Toast.makeText(this,"Area T : $number",Toast.LENGTH_LONG).show()
                }

            }else{
                Toast.makeText(this,"Ingresa Un Número Por Favor",Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun getArea(radio: Double): Double {
        return constants.PI * (radio * radio)
    }
    fun getResta(numero: Int, radius:Double):Double{
        return numero *  ((getArea(radius) - (7 * getArea(0.5))))
    }

    object constants {
        const val PI = 3.1416
    }

}           