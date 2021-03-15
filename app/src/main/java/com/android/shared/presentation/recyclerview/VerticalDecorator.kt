package com.android.shared.presentation.recyclerview

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class VerticalDecorator(
    private val margin: Int
) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)

        outRect.bottom = margin
        outRect.left = margin
        outRect.right = margin

        if (position == 0)
            outRect.top = margin
    }
}