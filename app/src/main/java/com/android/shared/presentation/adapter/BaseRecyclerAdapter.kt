package com.android.shared.presentation.adapter

import androidx.recyclerview.widget.RecyclerView

/**
 * BaseRecyclerView class for all adapters and remove code duplication.
 */
abstract class BaseRecyclerAdapter<T> : RecyclerView.Adapter<BaseViewHolder<T>>() {

    protected val _items = mutableListOf<T>()

    fun setItems(items: List<T>) {
        _items.clear()
        _items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.bind(_items[position])
    }

    override fun getItemCount(): Int {
        return _items.size
    }

}