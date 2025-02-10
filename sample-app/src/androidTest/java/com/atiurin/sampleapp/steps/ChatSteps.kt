package com.atiurin.sampleapp.steps

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.atiurin.sampleapp.constants.TestConstants
import com.atiurin.sampleapp.helper.waitUntilVisible
import com.atiurin.sampleapp.pages.ChatPage
import com.atiurin.sampleapp.pages.DashboardPage
import com.atiurin.ultron.core.espresso.UltronEspresso.closeSoftKeyboard
import com.atiurin.ultron.extensions.assertMatches
import com.atiurin.ultron.extensions.click
import com.atiurin.ultron.extensions.perform
import com.atiurin.ultron.extensions.typeText

object ChatSteps {

    /**
     * Verifies that the dashboard is loaded by checking that the drawer layout and toolbar are displayed.
     */
    fun verifyDashboardLoaded() {
        DashboardPage.drawerLayout.assertMatches(isDisplayed())
        DashboardPage.toolbar.assertMatches(isDisplayed())
        onView(withText(TestConstants.FRIEND_NAME)).waitUntilVisible(TestConstants.WAIT_TIMEOUT)
    }


    fun openChatWithFriend(friendName: String) {
        DashboardPage.friendItem(friendName).click()
    }


    fun verifyChatOpenWithFriend(friendName: String) {
        ChatPage.toolbarTitle.assertMatches(withText(friendName))
    }


    fun sendMessage(message: String) {
        ChatPage.inputMessageText.typeText(message)
        closeSoftKeyboard() // Ensure the send button is clickable.
        ChatPage.sendMessageBtn.click()
    }

    /**
     * Verifies that the sent message appears in the messages list.
     *
     * @param message The text message that should be displayed.
     */
    fun verifyMessageSent(message: String) {
        ChatPage.messagesList.assertMatches(hasDescendant(withText(message)))
    }
}
