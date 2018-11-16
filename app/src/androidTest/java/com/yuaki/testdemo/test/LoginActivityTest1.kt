package com.yuaki.testdemo.test


import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.view.View
import android.view.ViewGroup
import com.yuaki.testdemo.LoginActivity
import com.yuaki.testdemo.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class LoginActivityTest1 {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(LoginActivity::class.java)

    @Test
    fun loginActivityTest1() {
        val editText = onView(
                allOf(withId(R.id.email),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(`is`("android.widget.ScrollView")),
                                        0),
                                2)))
        editText.perform(scrollTo(), replaceText("test"), closeSoftKeyboard())

        val editText2 = onView(
                allOf(withId(R.id.email), withText("test"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(`is`("android.widget.ScrollView")),
                                        0),
                                2)))
        editText2.perform(scrollTo(), click())

        val editText3 = onView(
                allOf(withId(R.id.email), withText("test"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(`is`("android.widget.ScrollView")),
                                        0),
                                2)))
        editText3.perform(scrollTo(), click())

        val editText4 = onView(
                allOf(withId(R.id.email), withText("test"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(`is`("android.widget.ScrollView")),
                                        0),
                                2)))
        editText4.perform(scrollTo(), replaceText("testtes"))

        val editText5 = onView(
                allOf(withId(R.id.email), withText("testtes"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(`is`("android.widget.ScrollView")),
                                        0),
                                2),
                        isDisplayed()))
        editText5.perform(closeSoftKeyboard())

        val editText6 = onView(
                allOf(withId(R.id.password),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(`is`("android.widget.ScrollView")),
                                        0),
                                3)))
        editText6.perform(scrollTo(), replaceText("test"), closeSoftKeyboard())

        val button = onView(
                allOf(withId(R.id.submit), withText("Submit"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(`is`("android.widget.ScrollView")),
                                        0),
                                4)))
        button.perform(scrollTo(), click())

        val editText7 = onView(
                allOf(withId(R.id.email), withText("testtes"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.instanceOf(android.widget.ScrollView::class.java),
                                        0),
                                1),
                        isDisplayed()))
        editText7.check(matches(withText("testtes")))
    }

    private fun childAtPosition(
            parentMatcher: Matcher<View>, position: Int): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
