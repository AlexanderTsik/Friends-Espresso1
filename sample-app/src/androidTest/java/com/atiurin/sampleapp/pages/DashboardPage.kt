package com.atiurin.sampleapp.pages

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.*
import com.atiurin.sampleapp.R
import org.hamcrest.Matcher
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.CoreMatchers.`is`


object DashboardPage {
    // Selector for the main drawer layout.
    val drawerLayout: Matcher<View> by lazy { withId(R.id.drawer_layout) }

    // Selector for the toolbar.
    val toolbar: Matcher<View> by lazy { withId(R.id.toolbar) }

    // Selector for a friend item with a given name.
    fun friendItem(friendName: String): Matcher<View> = withText(friendName)

    // Selector for the "Custom Clicks" menu option.
    val customClicksOption: Matcher<View> by lazy { withId(R.id.custom_clicks_nav_item) }

    val uiElementsOption: Matcher<View> by lazy { withId(R.id.ui_elements) }
}

