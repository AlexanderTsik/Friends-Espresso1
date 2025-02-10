package com.atiurin.sampleapp.pages

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.hamcrest.Matcher
import com.atiurin.sampleapp.R

object CustomClicksPage {
    // Selector for the main container (e.g., ConstraintLayout) of the Custom Clicks page.
    val frameLayout: Matcher<View> by lazy { withId(R.id.frameLayout) }

    // Selectors for the corner radio buttons.
    val topLeftRadioButton: Matcher<View> by lazy { withId(R.id.rB_top_left) }
    val topRightRadioButton: Matcher<View> by lazy { withId(R.id.rB_top_right) }
    val bottomLeftRadioButton: Matcher<View> by lazy { withId(R.id.rB_bottom_left) }
    val bottomRightRadioButton: Matcher<View> by lazy { withId(R.id.rB_bottom_right) }
}
