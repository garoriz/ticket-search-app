package com.garif.core1.util

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class VerticalSpacesItemDecoration : RecyclerView.ItemDecoration() {
    private val topSpace = 70
    private val bottomSpace = 45

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State,
    ) {
        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.top = topSpace
        }
        outRect.bottom = bottomSpace
    }
}