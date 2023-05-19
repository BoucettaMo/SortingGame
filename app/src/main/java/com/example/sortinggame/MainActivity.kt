package com.example.sortinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.sortinggame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val alphabet= arrayOf("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P"
    ,"Q","R","S","T","U","V","W","X","Y","Z")
    private val listButton = arrayListOf<Button>()
    private lateinit var binding:ActivityMainBinding
    private val emoji = "🦄"
    private var position=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listButton.addAll(arrayListOf<Button>(binding.button0,binding.button1,binding.button2,binding.button3,binding.button4,
            binding.button5,
            binding.button6,binding.button7,binding.button8,binding.button9,binding.button10,binding.button11,
            binding.button12,binding.button13,binding.button14,binding.button15,binding.button16,binding.button17,
            binding.button18,binding.button19,binding.button20,binding.button21,binding.button22,
            binding.button23,binding.button24,binding.button25,binding.button26))

        binding.start.setOnClickListener {

            alphabet.shuffle()
            listButton[0].text=emoji
            for (i in alphabet.indices) listButton[i+1].text=alphabet[i]
            position=0
        }

        binding.right.setOnClickListener {
            if (position==26) {

            }
            else if (position % 5 != 4) {
                listButton[position].text=listButton[position+1].text.toString()
                position++;
                listButton[position].text=emoji

            }
        }

       binding.left.setOnClickListener {
           if (position % 5 != 0) {
               listButton[position].text=listButton[position-1].text.toString()
               position--;
               listButton[position].text=emoji
           }
       }

        binding.down.setOnClickListener {
            if (position==25 || position==26) {

            }
            else if (position==20) {
                listButton[position].text=listButton[25].text.toString()
                listButton[25].text=emoji
                position=25
            }
            else if (position==21) {
                listButton[position].text=listButton[26].text.toString()
                listButton[26].text=emoji
                position=26
            }
            else if (position + 5 <= 24) {
                listButton[position].text=listButton[position+5].text.toString();
                position+=5;
                listButton[position].text=emoji
            }
        }


        binding.up.setOnClickListener {
            if (position - 5 >= 0) {
                listButton[position].text=listButton[position-5].text.toString()
                position-=5;
                listButton[position].text=emoji
            }
        }
        binding.diagonalLeft.setOnClickListener {
            val permittedPositions= arrayOf(6,7,8,9,11,12,13,14,16,17,18,19,21,22,23,24,26)
            if (permittedPositions.contains(position)) {
                listButton[position].text=listButton[position-6].text.toString()
                position-=6;
                listButton[position].text=emoji
            }
        }

        binding.diagonalRight.setOnClickListener {
            val permittedPositions= arrayOf(5,6,7,8,10,11,12,13,15,16,17,18,20,21,22,23,25,26)
            if (permittedPositions.contains(position)) {
                listButton[position].text=listButton[position-4].text.toString()
                position-=4;
                listButton[position].text=emoji
            }
        }

    }
}