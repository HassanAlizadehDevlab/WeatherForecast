package com.android.shared.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * BaseView Holder class for all ViewHolders.
 */
abstract class BaseViewHolder<out T>(view: View) : RecyclerView.ViewHolder(view) {
    lateinit var listener: (BaseAction) -> Unit
    abstract fun bind(data: @UnsafeVariance T)
}