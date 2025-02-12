package com.atiurin.sampleapp.steps

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.DrawerActions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.atiurin.sampleapp.helper.swiper
import com.atiurin.sampleapp.pages.DashboardPage
import com.atiurin.sampleapp.pages.DashboardPage.friendNameTextView
import com.atiurin.ultron.extensions.assertMatches
import com.atiurin.ultron.extensions.click
import com.atiurin.ultron.extensions.perform
import org.hamcrest.Matchers.allOf

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

    fun openNavigationDrawer() = with(DashboardPage) {
        drawerLayout.perform(DrawerActions.open())
    }

    fun selectCustomClicksOption() = with(DashboardPage) {
        customClicksOption.click()
    }
    fun selectUIElementsOption() = with(DashboardPage) {
        uiElementsOption.click()
    }

    fun findFriend(friendName: String) = with(DashboardPage) {
        onView(recyclerView)
            .perform(
                RecyclerViewActions.scrollTo<RecyclerView.ViewHolder>(
                    hasDescendant(allOf(friendNameTextView, withText(friendName)))
                )
            )
    }

    fun scrollAndClickFriend(friendName: String) {
        for (i in 1..6) {
            try {
                findFriend(friendName)
                onView(allOf(friendNameTextView, withText(friendName))).perform(click())
                return
            } catch (e: Exception) {
                swiper(400, 200, 10)
            }
        }
        throw AssertionError("Friend '$friendName' not found after 7 attempts")
    }
}
