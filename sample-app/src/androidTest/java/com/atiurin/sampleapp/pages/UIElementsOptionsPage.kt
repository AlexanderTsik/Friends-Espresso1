package com.atiurin.sampleapp.pages

import androidx.test.espresso.matcher.ViewMatchers.withId
import com.atiurin.sampleapp.R

object UIElementsOptionsPage {
    val enableCheckBox by lazy { withId(R.id.checkbox_enable) }
    val clickableCheckBox by lazy { withId(R.id.checkbox_clickable) }
    val radioInvisible by lazy { withId(R.id.radio_invisible) }
    val simpleButton by lazy { withId(R.id.button1) }

    val lastEventStatus by lazy { withId(R.id.last_event_status)}
    val radioGone by lazy { withId(R.id.radio_gone)}
}