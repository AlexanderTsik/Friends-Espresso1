package com.atiurin.sampleapp.steps

import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.isChecked
import androidx.test.espresso.contrib.DrawerActions
import com.atiurin.sampleapp.pages.CustomClicksPage
import com.atiurin.ultron.extensions.assertMatches
import com.atiurin.ultron.extensions.click

object CustomClicksSteps {


    fun verifyCustomClicksPageLoaded() = with(CustomClicksPage) {
        frameLayout.assertMatches(isDisplayed())
        topLeftRadioButton.assertMatches(isDisplayed())
    }

    fun markCornerCircles() = with(CustomClicksPage) {
        topLeftRadioButton.click()
        topRightRadioButton.click()
        bottomLeftRadioButton.click()
        bottomRightRadioButton.click()
    }

    fun verifyCornerCirclesMarked() = with(CustomClicksPage) {
        topLeftRadioButton.assertMatches(isChecked())
        topRightRadioButton.assertMatches(isChecked())
        bottomLeftRadioButton.assertMatches(isChecked())
        bottomRightRadioButton.assertMatches(isChecked())
    }
}
