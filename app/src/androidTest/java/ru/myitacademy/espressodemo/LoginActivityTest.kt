package ru.myitacademy.espressodemo

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {
    @Rule
    @JvmField
    var activityRule = ActivityTestRule(LoginActivity::class.java)

    @Test
    fun emptyLoginField_causesError() {

    }

    @Test
    fun shortPassword_causesError() {

    }

    @Test
    fun passwordsDoNotMatch_causesError() {

    }

    @Test
    fun properInputs_activitySwitches() {

    }
}