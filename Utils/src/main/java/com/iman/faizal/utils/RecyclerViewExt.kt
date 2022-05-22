package com.iman.faizal.utils

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.addVerticalItemDecoration() {
    addItemDecoration(
        DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
    )
}

fun RecyclerView.addHorizontalItemDecoration() {
    addItemDecoration(
        DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL)
    )
}