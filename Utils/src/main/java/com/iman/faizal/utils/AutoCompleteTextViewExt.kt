package com.iman.faizal.utils

import android.view.View
import android.widget.AutoCompleteTextView
import androidx.core.content.res.ResourcesCompat

fun AutoCompleteTextView.setupDropdownUI() {
//        dropDownVerticalOffset = 10
//        setDropDownBackgroundResource(R.drawable.bg_circle_white_r20)

    onFocusChangeListener =
        View.OnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                showDropDown()
                this.setCompoundDrawablesWithIntrinsicBounds(
                    null,
                    null,
                    ResourcesCompat.getDrawable(resources, R.drawable.ic_arrow_up, this.context.theme),
                    null
                )
            } else {
                dismissDropDown()
            }
        }

    setOnDismissListener {
        this.setCompoundDrawablesWithIntrinsicBounds(
            null,
            null,
            ResourcesCompat.getDrawable(resources, R.drawable.ic_arrow_down, this.context.theme),
            null
        )
    }

    setOnClickListener {
        showDropDown()
        this.setCompoundDrawablesWithIntrinsicBounds(
            null,
            null,
            ResourcesCompat.getDrawable(resources, R.drawable.ic_arrow_up, this.context.theme),
            null
        )
    }
}
