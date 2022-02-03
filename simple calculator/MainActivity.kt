package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception


class MainActivity : AppCompatActivity() {



//   lateinit var display:Button
//    lateinit var del:Button
//    lateinit var ans:Button
//    lateinit var one:Button
//    lateinit var two:Button
//    lateinit var three:Button
//    lateinit var four:Button
//    lateinit var five:Button
//    lateinit var six:Button
//    lateinit var seven:Button
//    lateinit var eight:Button
//    lateinit var nine:Button
//    lateinit var zero:Button
//    lateinit var sub :Button
   // lateinit var add: Button
    //lateinit var \u221a: Button



 lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     binding= ActivityMainBinding.inflate(layoutInflater)
     setContentView(binding.root)

        binding.one.setOnClickListener {
            appendDisplay(binding.one.text as String)
        }
        binding.two.setOnClickListener{
            appendDisplay(binding.two.text as String)
        }
        binding.three.setOnClickListener{
            appendDisplay(binding.three.text as String)
        }
        binding.four.setOnClickListener{
            appendDisplay(binding.four.text as String)
        }
        binding.five.setOnClickListener{
            appendDisplay(binding.five.text as String)
        }
        binding.six.setOnClickListener{
            appendDisplay(binding.six.text as String)
        }
        binding.seven.setOnClickListener{
            appendDisplay(binding.seven.text as String)
        }
        binding.eight.setOnClickListener{
            appendDisplay(binding.eight.text as String)
        }
        binding.nine.setOnClickListener{
            appendDisplay(binding.nine.text as String)
        }
        binding.zero.setOnClickListener{
            appendDisplay(binding.zero.text as String)
        }
        binding.plus.setOnClickListener {
            appendDisplay(binding.plus.text as String)
        }
        binding.minus.setOnClickListener {
            appendDisplay(binding.minus.text as String)
        }
        binding.multiply.setOnClickListener {
            appendDisplay(binding.multiply.text as String)
        }
        binding.div.setOnClickListener {
            appendDisplay(binding.div.text as String)
        }
        binding.mode.setOnClickListener {
            appendDisplay(binding.mode.text as String)
        }
        binding.del.setOnClickListener {
            binding.display.text=""
        }
        binding.dot.setOnClickListener{
            // TODO do it for others as well
            binding.one.text = if( binding.one.text=="1") ">" else "1"
            binding.two.text = if( binding.two.text=="2") "." else "2"
        }


        binding.ans.setOnClickListener{
            try {
                var result = ExpressionBuilder(binding.display.text.toString()).build()
                binding.display.text = result.evaluate().toString()
            }catch (e:Exception){
                binding.display.text="Wrong Maths equation"
            }
        }
    }

 private fun appendDisplay(text: String)
 {
         if(binding.display.text.toString()=="Wrong Maths equation") {
             binding.display.text = ""
         }
         binding.display.append(text)
 }
}
