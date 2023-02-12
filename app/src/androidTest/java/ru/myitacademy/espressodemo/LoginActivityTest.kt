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
        onView(withId(R.id.button_register))
            .perform(ViewActions.click())
        onView(withId(R.id.login_edit_text))
            .check(ViewAssertions.matches(hasErrorText("Login must not be empty")))
    }

    @Test
    fun shortPassword_causesError() {
        onView(withId(R.id.button_register))
            .perform(ViewActions.click())
        onView(withId(R.id.password_edit_text))
            .check(ViewAssertions.matches(hasErrorText("Password must be at least 8 characters long")))
    }

    @Test
    fun passwordsDoNotMatch_causesError() {

        onView(withId(R.id.login_edit_text))
            .perform(ViewActions.typeText("login"))

        onView(withId(R.id.password_edit_text))
            .perform(ViewActions.typeText("password"))

        onView(withId(R.id.repeat_password_edit_text))
            .perform(ViewActions.typeText("another password"))

        Espresso.closeSoftKeyboard()

        onView(withId(R.id.button_register))
            .perform(ViewActions.click())

        onView(withId(R.id.repeat_password_edit_text))
            .check(ViewAssertions.matches(hasErrorText("Passwords do not match")))
    }

    @Test
    fun properInputs_activitySwitches() {
        onView(withId(R.id.login_edit_text))
            .perform(ViewActions.typeText("login"))

        onView(withId(R.id.password_edit_text))
            .perform(ViewActions.typeText("password"))

        onView(withId(R.id.repeat_password_edit_text))
            .perform(ViewActions.typeText("password"))

        Espresso.closeSoftKeyboard()

        onView(withId(R.id.button_register))
            .perform(ViewActions.click())

        onView(withId(R.id.users_rv))
            .check(ViewAssertions.matches(isDisplayed()))
    }
}