package com.alaaeddinalbarghoth.selectitemdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.alaaeddinalbarghoth.selectitemdialog.databinding.ActivityMainBinding
import com.alaaeddinalbarghoth.selectitemdialog.dialog.ItemClickListener
import com.alaaeddinalbarghoth.selectitemdialog.dialog.SelectItemDialog

class MainActivity : AppCompatActivity(), ItemClickListener {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvText.setOnClickListener {
            SelectItemDialog(
                this,
                listOf(
                    "Alaa",
                    "Sara",
                    "Mhd",
                    "Yousuf"
                )
            ).show()
        }
    }

    override fun onItemClickListener(data: String) {
        Toast.makeText(this, data, Toast.LENGTH_LONG).show()
    }
}
