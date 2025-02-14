package com.atiurin.sampleapp.steps

import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.atiurin.sampleapp.pages.ChatPage
import com.atiurin.sampleapp.pages.DashboardPage
import com.atiurin.ultron.core.espresso.UltronEspresso
import com.atiurin.ultron.core.espresso.UltronEspresso.closeSoftKeyboard
import com.atiurin.ultron.extensions.assertMatches
import com.atiurin.ultron.extensions.click
import com.atiurin.ultron.extensions.typeText

object ChatSteps {

    fun openChatWithFriend(friendName: String) = with(DashboardPage) {
        friendItem(friendName).click()
    }

    fun verifyChatOpenWithFriend(friendName: String) = with(ChatPage) {
        toolbarTitle.assertMatches(
            withText(friendName)
        )
    }

    fun sendMessage(message: String) = with(ChatPage) {
        inputMessageText.typeText(message)
        closeSoftKeyboard()
        sendMessageBtn.click()
    }

    fun verifyMessageSent(message: String) = with(ChatPage) {
        messagesList.assertMatches(
            hasDescendant(withText(message))
        )
    }

    fun clearHistory() = with(ChatPage) {
        UltronEspresso.openContextualActionModeOverflowMenu()
        clearHistoryBtn.click()
        messagesList.assertEmpty()
    }
}
