package com.atiurin.sampleapp.steps

import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.isChecked
import androidx.test.espresso.contrib.DrawerActions
import com.atiurin.sampleapp.pages.CustomClicksPage
import com.atiurin.sampleapp.pages.DashboardPage
import com.atiurin.ultron.extensions.assertMatches
import com.atiurin.ultron.extensions.click
import com.atiurin.ultron.extensions.perform

object CustomClicksSteps {


    fun verifyDashboardLoaded() {
        DashboardPage.drawerLayout.assertMatches(isDisplayed())
        DashboardPage.toolbar.assertMatches(isDisplayed())
    }


    fun openNavigationDrawer() {
        DashboardPage.drawerLayout.perform(DrawerActions.open())
    }


    fun selectCustomClicksOption() {
        DashboardPage.customClicksOption.click()
    }


    fun verifyCustomClicksPageLoaded() {
        CustomClicksPage.frameLayout.assertMatches(isDisplayed())
        CustomClicksPage.topLeftRadioButton.assertMatches(isDisplayed())
    }


    fun markCornerCircles() {
        CustomClicksPage.topLeftRadioButton.click()
        CustomClicksPage.topRightRadioButton.click()
        CustomClicksPage.bottomLeftRadioButton.click()
        CustomClicksPage.bottomRightRadioButton.click()
    }


    fun verifyCornerCirclesMarked() {
        CustomClicksPage.topLeftRadioButton.assertMatches(isChecked())
        CustomClicksPage.topRightRadioButton.assertMatches(isChecked())
        CustomClicksPage.bottomLeftRadioButton.assertMatches(isChecked())
        CustomClicksPage.bottomRightRadioButton.assertMatches(isChecked())
    }
}
