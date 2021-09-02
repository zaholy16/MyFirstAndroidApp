package com.PAudc.myfirstandroidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameText = findViewById<EditText>(R.id.name)
        val touchButton = findViewById<Button>(R.id.touch_button)
        val ageNumber = findViewById<EditText>(R.id.age)
        val string: String = getString(R.string.main_message)

        touchButton.setOnClickListener(){
            if(nameText.text.isEmpty() || ageNumber.text.isEmpty() || ageNumber.text.toString().toInt() > 99){
                Toast.makeText(this, string, Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }else
            {
                val message = nameText.text
                val number: Int = ageNumber.text.toString().toInt()
                var sum = 0

                //Function to get the length of a number//
                fun getLength(number: Number): Int {
                    return number.toString().length
                }

                //if is one digit
                if(getLength(number) == 1 ){
                    var newNumber = number * 7
                    if(getLength(newNumber) == 1) //if the result of multiplication is the one digit
                    {
                        Toast.makeText(this, "Welcome $message your lucky number is $newNumber", Toast.LENGTH_LONG).show()
                    }else
                    {
                        do {
                            for(i in newNumber.toString().toCharArray()) { //go through the result of the multiplication to add the numbers
                                var num = i.toString().toInt()
                                sum += num
                            }
                            newNumber = sum //update with the result of sum
                            sum = 0 //reset to sum
                        }while (newNumber>9) //while the result of multiplication not greater than 9

                        Toast.makeText(this, "Welcome $message your lucky number is $newNumber", Toast.LENGTH_LONG).show()
                    }
                }else
                {
                    for(i in number.toString().toCharArray()){
                        var num = i.toString().toInt()
                        sum += num
                    }
                    if(getLength(sum) == 2){
                        var newTwo = 0
                        do {
                            for(i in newTwo.toString().toCharArray()) {
                                var num = i.toString().toInt()
                                sum += num
                            }
                            newTwo = sum
                            sum = 0
                        }while (newTwo>9)

                        Toast.makeText(this, "Welcome $message your lucky number is $newTwo", Toast.LENGTH_LONG).show()

                    }else{
                        Toast.makeText(this, "Welcome $message your lucky number is $sum", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}