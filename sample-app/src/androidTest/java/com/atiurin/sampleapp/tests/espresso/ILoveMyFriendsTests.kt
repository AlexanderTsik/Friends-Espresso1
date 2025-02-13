package com.atiurin.sampleapp.tests.espresso

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.atiurin.sampleapp.data.constants.TestConstants
import com.atiurin.sampleapp.steps.ChatSteps
import com.atiurin.sampleapp.steps.DashboardSteps
import com.atiurin.sampleapp.tests.MyBaseTest
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class ILoveMyFriendsTests : MyBaseTest() {

    @Test
    fun testOpenChatAndSendMessage() {
        with(TestConstants) {
            with(DashboardSteps) {
                verifyDashboardLoaded()
                scrollAndClickFriend(EMMET_BROWN)
            }
            with(ChatSteps) {
                verifyChatOpenWithFriend(EMMET_BROWN)
                sendMessage(MESSAGE_TO_EB)
                verifyMessageSent(MESSAGE_TO_EB)
            }
        }
    }

    @Test
    fun testClearChatHistoryAndSendMessage() {
        with(TestConstants) {
            with(DashboardSteps) {
                verifyDashboardLoaded()
                scrollAndClickFriend(F17)
            }
            with(ChatSteps) {
                verifyChatOpenWithFriend(F17)
                clearHistory()
                sendMessage(MESSAGE_TO_F17)
                verifyMessageSent(MESSAGE_TO_F17)
            }
        }
    }

    // this fails since there is no friend25
    @Test
    fun testSendMessageToFriend25() {
        with(TestConstants) {
            with(DashboardSteps) {
                verifyDashboardLoaded()
                scrollAndClickFriend(F25)
            }

            with(ChatSteps) {
                verifyChatOpenWithFriend(F25)
                sendMessage(MESSAGE_TO_F25)
                verifyMessageSent(MESSAGE_TO_F25)
            }
        }
    }
}
