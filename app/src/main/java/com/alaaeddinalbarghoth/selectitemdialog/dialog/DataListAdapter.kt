package com.alaaeddinalbarghoth.selectitemdialog.dialog

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alaaeddinalbarghoth.selectitemdialog.databinding.ItemDataBinding

class DataListAdapter(
    private val listener: ItemClickListener,
    private val layoutInflater: LayoutInflater,
    private val items: List<String>
) :
    RecyclerView.Adapter<DataListAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder(ItemDataBinding.inflate(layoutInflater))

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        items[position].run {
            holder.itemDataBinding.data = items[position]
            holder.itemDataBinding.tvData.setOnClickListener {
                listener.onItemClickListener(this)
            }
        }
    }

    override fun getItemCount(): Int = items.size


    inner class ItemViewHolder(val itemDataBinding: ItemDataBinding) :
        RecyclerView.ViewHolder(itemDataBinding.root)

}