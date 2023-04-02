package com.example.dynamiclayout

import android.content.res.ColorStateList
import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.Editable
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.view.Gravity.CENTER_HORIZONTAL
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.PARENT_ID
import androidx.constraintlayout.widget.ConstraintSet
import androidx.constraintlayout.widget.Constraints.*
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.setPadding
import com.google.android.material.button.MaterialButton
import com.google.android.material.shape.ShapeAppearanceModel
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.textfield.TextInputLayout.END_ICON_CLEAR_TEXT
import com.google.android.material.textfield.TextInputLayout.EndIconMode
import kotlin.math.roundToInt


class MainActivity : AppCompatActivity() {
    private lateinit var baseLayoutC: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dynamicLayout()

    }

    private fun dynamicLayout() {
        baseLayoutC.findViewById<ConstraintLayout>(R.id.baseLayout)
        val constraintSet = ConstraintSet()

        val constraintLayout = ConstraintLayout(this@MainActivity)

        val layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT)


        val progressBar = ProgressBar(this)
        val editText = EditText(this)
        constraintLayout.addView(createTextView(layoutParams, "Sign Up"))
        baseLayoutC.addView(constraintLayout)

    }

    private fun createEditText(
        layoutParams: ConstraintLayout.LayoutParams,
        layoutWidth: Int = MATCH_PARENT,
        layoutHeight: Int = WRAP_CONTENT
    ) {


        with(layoutParams) {
            width = layoutWidth
            height = layoutHeight
            width
            startToStart = 0
            endToEnd = PARENT_ID
            topToTop = 0
            bottomToBottom = 0
            topToBottom = 0
            bottomToTop = 0
            startToEnd = 0
            endToStart = 0
            rightToRight = 0
            leftToLeft = 0
            leftToRight = 0
            rightToLeft = 0
            marginEnd =0
            marginStart =0


        }

        val textInputLayout = TextInputLayout(this)
        with(textInputLayout) {
            id = View.generateViewId()
//            hintTextColor =
            startIconDrawable =ResourcesCompat.getDrawable(resources, R.drawable.ic_launcher_background, null)
            endIconDrawable=ResourcesCompat.getDrawable(resources, R.drawable.ic_launcher_background, null)
            //setTextInputAccessibilityDelegate()
            endIconMode = END_ICON_CLEAR_TEXT //END_ICON_NONE END_ICON_CUSTOM
            counterMaxLength =10
            isCounterEnabled =true
            isHelperTextEnabled =true
            isErrorEnabled =true
            minWidth =10
            maxWidth =10
            placeholderText =""
            suffixText =""
            prefixText =""
            helperText =""
            errorContentDescription =""
            hint =""
            startIconContentDescription =""

            //Container Attribute
            boxBackgroundColor =Color.BLACK
            boxStrokeColor =Color.BLACK
            isEnabled =true
//            shapeAppearanceModel =
            isStartIconCheckable =true
            isEndIconCheckable =true
            isHintAnimationEnabled =true
            isExpandedHintEnabled =true
//            setEndIconTintList(ColorStateList([Color.BLACK][Color.BLACK]))


       }
        val editText = TextInputEditText(textInputLayout.context)
        with(editText)
        {
            id = View.generateViewId()
        }
        textInputLayout.addView(editText)


    }

    private fun createTextView(
        layoutParams: ConstraintLayout.LayoutParams,
        textString: String,
        textGravity: Int = CENTER_HORIZONTAL,
        visible: Int = VISIBLE,
        maxLine: Int = 1,
        textColor: Int = Color.BLACK,
        ems: Int = 2

    ): TextView {
        //how a view want to be laid out inside a ConstraintLayout.
        layoutParams.topToTop = PARENT_ID
        layoutParams.startToStart = PARENT_ID
        layoutParams.endToEnd = PARENT_ID
        layoutParams.topMargin = 10

        val textView = TextView(this)
        with(textView) {
            width = WRAP_CONTENT
            height = WRAP_CONTENT

            id = View.generateViewId()//2147483647
            text = textString
            gravity = textGravity
            visibility = visible
            maxLines = maxLine
            setTextColor(textColor)
            maxEms = ems
        }
        textView.layoutParams = layoutParams
        return textView
    }

    private fun createImageView(layoutParams: ConstraintLayout.LayoutParams) {
        val image = ImageView(this)
        with(image) {
            id = View.generateViewId()
            maxWidth = WRAP_CONTENT
            maxHeight = WRAP_CONTENT
            scaleType = ImageView.ScaleType.CENTER_CROP
            background =
                ResourcesCompat.getDrawable(resources, R.drawable.ic_launcher_background, null)
            contentDescription = ""
        }
    }

    private fun createCardView(
        layoutWidth: Int = MATCH_PARENT,
        layoutHeight: Int = WRAP_CONTENT,
        elevation: Float = 10f

    ): CardView {
        val cardView = CardView(this)
        with(cardView) {
            id = View.generateViewId()
            layoutParams.width = layoutWidth
            layoutParams.height = layoutHeight
            cardElevation = elevation
            radius = 20f
        }
        return cardView
    }

    private fun createButtonView(
        buttonText: String,
        textColor: Int = Color.BLACK,
        backGroundColor: Int = Color.WHITE,
        buttonGravity: Int = CENTER_HORIZONTAL,
        paddingLeft: Int = 0,
        paddingRight: Int = 0,
        paddingTop: Int = 0,
        paddingBottom: Int = 0,
        enabled: Boolean = true,
        clickable: Boolean = true,
        visible: Int = View.VISIBLE

    ): Button {

        val button = Button(this)



        with(button) {
            id = View.generateViewId()
            width = WRAP_CONTENT
            height = WRAP_CONTENT
            gravity = buttonGravity
            text = buttonText
            isClickable = clickable
            isEnabled = enabled
            visibility = visible
            setTextColor(textColor)
            setBackgroundColor(backGroundColor)
            setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom)


        }

        //button.background =getDrawable(R.color.black)


        val buttonM = MaterialButton(this)


        return button

    }

    private fun convertDpToPixel(dp: Float): Int {
        val metrics: DisplayMetrics = Resources.getSystem().displayMetrics
        val px = dp * (metrics.densityDpi / 160f)
        return px.roundToInt() //Math.round(px)
    }

    private fun addLineSeperator(): LinearLayout {
        val lineLayout = LinearLayout(this)
        lineLayout.setBackgroundColor(Color.GRAY)
        val params = LinearLayout.LayoutParams(
            MATCH_PARENT,
            2
        )
        params.setMargins(0, convertDpToPixel(10.0f), 0, convertDpToPixel(10f))
        lineLayout.layoutParams = params
        return lineLayout
    }
}