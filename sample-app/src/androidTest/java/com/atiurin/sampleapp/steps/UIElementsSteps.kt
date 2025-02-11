package com.atiurin.sampleapp.steps

import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.isNotChecked
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.atiurin.sampleapp.pages.UIElementsOptionsPage
import com.atiurin.ultron.extensions.assertMatches
import com.atiurin.ultron.extensions.click
import org.hamcrest.CoreMatchers.not

object UIElementsSteps {
    fun verifyUIElementsPageLoaded() = UIElementsOptionsPage.simpleButton.assertMatches(isDisplayed())

    fun unmarkEnableAndClickable() = with(UIElementsOptionsPage) {
        enableCheckBox.click()
        clickableCheckBox.click()
    }

    fun validateUnmarkStatuses() = with(UIElementsOptionsPage) {
        enableCheckBox.assertMatches(isNotChecked())
        clickableCheckBox.assertMatches(isNotChecked())
    }

    fun chooseInvisibleOption() = UIElementsOptionsPage.radioInvisible.click()

    fun validateButtonNotVisible() = UIElementsOptionsPage.simpleButton.assertMatches(not(isDisplayed()))

    fun clickButtonMultipleTimes(clickCount: Int) = repeat(clickCount) {
        UIElementsOptionsPage.simpleButton.click()
    }

    fun validateClickCount(expectedClicks: Int) {
        UIElementsOptionsPage.lastEventStatus.assertMatches(
            withText("CLICK: Click $expectedClicks")
        )
    }


    // Step 7: Choose "Gone" option and validate button is gone
    fun chooseGoneOption() = UIElementsOptionsPage.radioGone.click()

    fun validateButtonGone() {
        UIElementsOptionsPage.simpleButton.assertMatches(not(isDisplayed()))
    }
}