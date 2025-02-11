package com.atiurin.sampleapp.tests.espresso

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.atiurin.sampleapp.activity.MainActivity
import com.atiurin.sampleapp.constants.TestConstants

import com.atiurin.sampleapp.steps.ChatSteps
import com.atiurin.sampleapp.steps.CustomClicksSteps
import com.atiurin.sampleapp.steps.DashboardSteps

import com.atiurin.sampleapp.tests.BaseTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class GreetingTests: BaseTest() {

    @get:Rule
    val activityTestRule = ActivityScenarioRule(MainActivity::class.java)

    /*1 TC

        create kotlin test - fun
            check that the dashboard is loaded
            open chat with your friend (choose addressee who you wish ) 3.Check the chat is open with the right addressee
            Greet a friend with your text (text what you wish)
            assert your sent text in the chat
        install the App and execute the test on an emulator
    */
    @Test
    fun testChatFlow() {
        with(DashboardSteps) {
            verifyDashboardLoaded()
        }
        with(ChatSteps) {
            openChatWithFriend(TestConstants.FRIEND_NAME)
            verifyChatOpenWithFriend(TestConstants.FRIEND_NAME)
            sendMessage(TestConstants.GREETING_MESSAGE)
            verifyMessageSent(TestConstants.GREETING_MESSAGE)
        }
    }


    /*2 TC

        create kotlin test - fun
            check that the dashboard is loaded
            open Main Menu (Burger Manu)
            choose "Custom Clicks" Option and open it
            check "Custom Clicks" page is open
            Mark all corner circles
            Validate all corner circles are marked.
        install the App and execute the test on an emulator
    */
    @Test
    fun testCustomClicksFlow() {
        with(DashboardSteps) {
            verifyDashboardLoaded()
            openNavigationDrawer()
            selectCustomClicksOption()
        }
        with(CustomClicksSteps) {
            verifyCustomClicksPageLoaded()
            markCornerCircles()
            verifyCornerCirclesMarked()
        }
    }
}