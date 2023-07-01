package com.fntechma.mycustomcomponent.components

import android.content.Context
import android.util.AttributeSet
import com.fntechma.mycustomcomponent.R
import com.google.android.material.button.MaterialButton

class ButtonPrimary : MaterialButton {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    fun setEnabled(onClick: () -> Unit) {
        this.isEnabled = true
        this.setBackgroundColor(context.resources.getColor(R.color.verde, null))
        this.setTextColor(context.resources.getColor(R.color.branco, null))
        this.elevation = 8f
        this.setOnClickListener {
            onClick()
        }
    }

    fun setDesabled(onClick: () -> Unit) {
        this.isEnabled = false
        this.setBackgroundColor(context.resources.getColor(R.color.branco, null))
        this.setTextColor(context.resources.getColor(R.color.cinza, null))
        this.elevation = 8f
        this.setOnClickListener {
            onClick()
        }
    }


}