package com.atiurin.sampleapp.tests.espresso

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.atiurin.sampleapp.activity.MainActivity
import com.atiurin.sampleapp.data.constants.TestConstants.NUMBER_OF_CLICKS
import com.atiurin.sampleapp.steps.DashboardSteps
import com.atiurin.sampleapp.steps.UIElementsSteps
import com.atiurin.sampleapp.tests.BaseTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class UIElementsTests : BaseTest() {

    @get:Rule
    val activityTestRule = ActivityScenarioRule(MainActivity::class.java)

/*1 TC
 - create kotlin test - fun
- 1. check that the dashboard is loaded
2. open Main Menu (Burger Manu)
3. choose "UIElements" Option and open it
4. check "UIElements" page is open
5. Unmark - Enable button and Clickable button
6. Validate unmark statuses on the buttons.
7. choose option - INVISIBLE and validate that the button is not visible.
 - install the App and execute the test on an emulator
*/
    @Test
    fun uiElementsTest1() {
        with(DashboardSteps) {
            verifyDashboardLoaded()
            openNavigationDrawer()
            selectUIElementsOption()
        }

        with(UIElementsSteps) {
            verifyUIElementsPageLoaded()
            unmarkEnableAndClickable()
            validateUnmarkStatuses()
            chooseInvisibleOption()
            validateButtonNotVisible()
        }
    }

    /*2 TC
 - create kotlin test - fun
- 1. check that the dashboard is loaded
2. open Main Menu (Burger Manu)
3. choose "UIElements" Option and open it
4. check "UIElements" page is open
5. click on the simple button 8 times
6. check the number of clicks is correct.
7. choose option - GONE and validate that the Simple button is gone.
 - install the App and execute the test on an emulator
*/
    @Test
    fun uiElementsTest2() {
        with(DashboardSteps) {
            verifyDashboardLoaded()
            openNavigationDrawer()
            selectUIElementsOption()
        }

        with(UIElementsSteps) {
            verifyUIElementsPageLoaded()
            clickButtonMultipleTimes(NUMBER_OF_CLICKS)
            validateClickCount(NUMBER_OF_CLICKS)
            chooseGoneOption()
            validateButtonGone()
        }
    }
}
