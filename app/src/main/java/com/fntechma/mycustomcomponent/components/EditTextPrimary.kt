package com.fntechma.mycustomcomponent.components

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.AttributeSet
import android.util.TypedValue
import androidx.core.content.res.ResourcesCompat
import com.fntechma.mycustomcomponent.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class EditTextPrimary : TextInputLayout {

    private var showPasswordToggle: Int = 0
    private var colorTextHint: Int = 0
    private var textHint: String = ""
    private var boxStrokeColor: Int = 0
    private var boxStrokeWidth: Int = 0
    private var textInputType: Int = 0

    init {
        inflate(context, R.layout.edittext_primary, this)
    }

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.EditTextPrimary)
        showPasswordToggle = attributes.getInt(R.styleable.EditTextPrimary_showPasswordToggle, 0)
        colorTextHint = attributes.getColor(R.styleable.EditTextPrimary_colorTextHint, Color.BLUE)
        textHint = attributes.getString(R.styleable.EditTextPrimary_textHint).toString()
        boxStrokeColor = attributes.getColor(R.styleable.EditTextPrimary_boxStrokeColor, Color.BLUE)
        boxStrokeWidth =
            attributes.getDimension(R.styleable.EditTextPrimary_boxStrokeWidth, 2f).toInt()
        textInputType = attributes.getInt(R.styleable.EditTextPrimary_textInputType, 0)
        attributes.recycle()
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttrs: Int) : super(
        context,
        attrs,
        defStyleAttrs
    ) {
        // obtendo typearray de um contexto
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.EditTextPrimary)

        //obtendo valor do atributo  especifico
        showPasswordToggle = attributes.getInt(R.styleable.EditTextPrimary_showPasswordToggle, 0)
        colorTextHint =
            attributes.getColor(
                R.styleable.EditTextPrimary_colorTextHint,
                getDefaultColor(R.attr.colorTextHint)
            )
        textHint = attributes.getString(R.styleable.EditTextPrimary_textHint).toString()
        boxStrokeColor =
            attributes.getColor(
                R.styleable.EditTextPrimary_boxStrokeColor,
                getDefaultColor(R.attr.boxStrokeColor)
            )
        boxStrokeWidth =
            attributes.getDimension(R.styleable.EditTextPrimary_boxStrokeWidth, 2f).toInt()
        textInputType = attributes.getInt(R.styleable.EditTextPrimary_textInputType, 0)

        //reciclando/limpando o typearray
        attributes.recycle()

        //criando layout
        init()
    }

    private fun init() {

        //region components layout
        val edtLayout = this.findViewById<TextInputLayout>(R.id.edt_input_layout)
        val edt = this.findViewById<TextInputEditText>(R.id.edt_input)

        // region Textinputedittext
        edt.inputType = textInputType

        // region textinputedittextlayout
        edtLayout.hint = textHint
        edtLayout.hintTextColor = ColorStateList.valueOf(colorTextHint)
        edtLayout.boxStrokeWidth = boxStrokeWidth
        edtLayout.boxStrokeColor = Color.valueOf(boxStrokeColor).toArgb()
        edtLayout.endIconMode = showPasswordToggle
    }

    private fun getDefaultColor(attr: Int): Int {
        when (attr) {
            R.attr.boxStrokeColor -> {
                val typedValue = TypedValue()
                context.theme.resolveAttribute(R.attr.boxStrokeColor, typedValue, true)
                return typedValue.data
            }

            R.attr.colorTextHint -> {
                val typedValue = TypedValue()
                context.theme.resolveAttribute(R.attr.colorTextHint, typedValue, true)
                return typedValue.data
            }
        }
        return 0
    }


}