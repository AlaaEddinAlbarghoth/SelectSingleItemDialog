package com.alaaeddinalbarghoth.selectitemdialog.dialog

import android.app.Dialog
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.alaaeddinalbarghoth.selectitemdialog.MainActivity
import com.alaaeddinalbarghoth.selectitemdialog.R
import com.alaaeddinalbarghoth.selectitemdialog.databinding.DialogSingleSelectionBinding

class SelectItemDialog(
    private val listener: MainActivity,
    private val items: List<String>
) : Dialog(listener, R.style.DialogStyle) {

    private lateinit var dataListAdapter: DataListAdapter
    private lateinit var binding: DialogSingleSelectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DialogSingleSelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT)

        setCanceledOnTouchOutside(true)
        setCancelable(true)

        dataListAdapter = DataListAdapter(
            listener,
            layoutInflater,
            items
        )

        binding.rvItems.layoutManager = LinearLayoutManager(listener)
        binding.rvItems.adapter = dataListAdapter
    }
}
