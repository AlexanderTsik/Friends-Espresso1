package com.atiurin.sampleapp.steps

import androidx.test.espresso.contrib.DrawerActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import com.atiurin.sampleapp.pages.DashboardPage
import com.atiurin.ultron.extensions.assertMatches
import com.atiurin.ultron.extensions.click
import com.atiurin.ultron.extensions.perform

object DashboardSteps {

    // ase ar mashvebinebs ratomghac titqmis arcert funqcias tolobis nishani tu ar miweria
//    fun verifyDashboardLoaded() {
//        with(DashboardPage) {
//            drawerLayout.assertMatches(isDisplayed())
//            toolbar.assertMatches(isDisplayed())
//        }
//    }
    fun verifyDashboardLoaded() = with(DashboardPage) {
        drawerLayout.assertMatches(isDisplayed())
        toolbar.assertMatches(isDisplayed())
    }

    fun openNavigationDrawer() = DashboardPage.drawerLayout.perform(DrawerActions.open())

    fun selectCustomClicksOption() = DashboardPage.customClicksOption.click()
    fun selectUIElementsOption() = DashboardPage.uiElementsOption.click()
}