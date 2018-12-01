package com.tassel.ingambe.sudoku;


import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class SolverActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void solverActivityTest() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.bt_solver), withText("Solve"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.constraint.ConstraintLayout")),
                                        1),
                                3),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction editText = onView(
                childAtPosition(
                        childAtPosition(
                                withId(R.id.tb_sudoku_solver),
                                0),
                        2));
        editText.perform(scrollTo(), replaceText("5"), closeSoftKeyboard());

        ViewInteraction editText2 = onView(
                childAtPosition(
                        childAtPosition(
                                withId(R.id.tb_sudoku_solver),
                                0),
                        5));
        editText2.perform(scrollTo(), replaceText("7"), closeSoftKeyboard());

        ViewInteraction editText3 = onView(
                childAtPosition(
                        childAtPosition(
                                withId(R.id.tb_sudoku_solver),
                                0),
                        8));
        editText3.perform(scrollTo(), replaceText("1"), closeSoftKeyboard());

        ViewInteraction editText4 = onView(
                childAtPosition(
                        childAtPosition(
                                withId(R.id.tb_sudoku_solver),
                                1),
                        1));
        editText4.perform(scrollTo(), replaceText("7"), closeSoftKeyboard());

        ViewInteraction editText5 = onView(
                childAtPosition(
                        childAtPosition(
                                withId(R.id.tb_sudoku_solver),
                                1),
                        4));
        editText5.perform(scrollTo(), replaceText("9"), closeSoftKeyboard());

        ViewInteraction editText6 = onView(
                childAtPosition(
                        childAtPosition(
                                withId(R.id.tb_sudoku_solver),
                                1),
                        7));
        editText6.perform(scrollTo(), replaceText("3"), closeSoftKeyboard());

        ViewInteraction editText7 = onView(
                childAtPosition(
                        childAtPosition(
                                withId(R.id.tb_sudoku_solver),
                                2),
                        3));
        editText7.perform(scrollTo(), replaceText("6"), closeSoftKeyboard());

        ViewInteraction editText8 = onView(
                childAtPosition(
                        childAtPosition(
                                withId(R.id.tb_sudoku_solver),
                                3),
                        2));
        editText8.perform(scrollTo(), replaceText("3"), closeSoftKeyboard());

        ViewInteraction editText9 = onView(
                childAtPosition(
                        childAtPosition(
                                withId(R.id.tb_sudoku_solver),
                                3),
                        5));
        editText9.perform(scrollTo(), replaceText("1"), closeSoftKeyboard());

        ViewInteraction editText10 = onView(
                childAtPosition(
                        childAtPosition(
                                withId(R.id.tb_sudoku_solver),
                                3),
                        8));
        editText10.perform(scrollTo(), replaceText("5"), closeSoftKeyboard());

        ViewInteraction editText11 = onView(
                childAtPosition(
                        childAtPosition(
                                withId(R.id.tb_sudoku_solver),
                                4),
                        1));
        editText11.perform(scrollTo(), replaceText("9"), closeSoftKeyboard());

        ViewInteraction editText12 = onView(
                childAtPosition(
                        childAtPosition(
                                withId(R.id.tb_sudoku_solver),
                                4),
                        4));
        editText12.perform(scrollTo(), replaceText("8"), closeSoftKeyboard());

        ViewInteraction editText13 = onView(
                childAtPosition(
                        childAtPosition(
                                withId(R.id.tb_sudoku_solver),
                                4),
                        7));
        editText13.perform(scrollTo(), replaceText("2"), closeSoftKeyboard());

        ViewInteraction editText14 = onView(
                childAtPosition(
                        childAtPosition(
                                withId(R.id.tb_sudoku_solver),
                                5),
                        0));
        editText14.perform(scrollTo(), replaceText("1"), closeSoftKeyboard());

        ViewInteraction editText15 = onView(
                childAtPosition(
                        childAtPosition(
                                withId(R.id.tb_sudoku_solver),
                                5),
                        3));
        editText15.perform(scrollTo(), replaceText("2"), closeSoftKeyboard());

        ViewInteraction editText16 = onView(
                childAtPosition(
                        childAtPosition(
                                withId(R.id.tb_sudoku_solver),
                                5),
                        6));
        editText16.perform(scrollTo(), replaceText("4"), closeSoftKeyboard());

        ViewInteraction editText17 = onView(
                childAtPosition(
                        childAtPosition(
                                withId(R.id.tb_sudoku_solver),
                                6),
                        2));
        editText17.perform(scrollTo(), replaceText("2"), closeSoftKeyboard());

        ViewInteraction editText18 = onView(
                childAtPosition(
                        childAtPosition(
                                withId(R.id.tb_sudoku_solver),
                                6),
                        5));
        editText18.perform(scrollTo(), replaceText("6"), closeSoftKeyboard());

        ViewInteraction editText19 = onView(
                childAtPosition(
                        childAtPosition(
                                withId(R.id.tb_sudoku_solver),
                                6),
                        8));
        editText19.perform(scrollTo(), replaceText("9"), closeSoftKeyboard());

        ViewInteraction editText20 = onView(
                childAtPosition(
                        childAtPosition(
                                withId(R.id.tb_sudoku_solver),
                                7),
                        4));
        editText20.perform(scrollTo(), replaceText("4"), closeSoftKeyboard());

        ViewInteraction editText21 = onView(
                childAtPosition(
                        childAtPosition(
                                withId(R.id.tb_sudoku_solver),
                                7),
                        7));
        editText21.perform(scrollTo(), replaceText("8"), closeSoftKeyboard());

        ViewInteraction editText22 = onView(
                childAtPosition(
                        childAtPosition(
                                withId(R.id.tb_sudoku_solver),
                                8),
                        0));
        editText22.perform(scrollTo(), replaceText("8"), closeSoftKeyboard());

        ViewInteraction editText23 = onView(
                childAtPosition(
                        childAtPosition(
                                withId(R.id.tb_sudoku_solver),
                                8),
                        3));
        editText23.perform(scrollTo(), replaceText("1"), closeSoftKeyboard());

        ViewInteraction editText24 = onView(
                childAtPosition(
                        childAtPosition(
                                withId(R.id.tb_sudoku_solver),
                                8),
                        6));
        editText24.perform(scrollTo(), replaceText("5"), closeSoftKeyboard());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.bt_solver), withText("Solve"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        appCompatButton2.perform(click());

        pressBack();

        ViewInteraction editText25 = onView(
                allOf(withText("9"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        0),
                                0),
                        isDisplayed()));
        editText25.check(matches(withText("9")));

        ViewInteraction editText26 = onView(
                allOf(withText("8"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        0),
                                1),
                        isDisplayed()));
        editText26.check(matches(withText("8")));

        ViewInteraction editText27 = onView(
                allOf(withText("3"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        0),
                                3),
                        isDisplayed()));
        editText27.check(matches(withText("3")));

        ViewInteraction editText28 = onView(
                allOf(withText("2"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        0),
                                4),
                        isDisplayed()));
        editText28.check(matches(withText("2")));

        ViewInteraction editText29 = onView(
                allOf(withText("6"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        0),
                                6),
                        isDisplayed()));
        editText29.check(matches(withText("6")));

        ViewInteraction editText30 = onView(
                allOf(withText("4"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        0),
                                7),
                        isDisplayed()));
        editText30.check(matches(withText("4")));

        ViewInteraction editText31 = onView(
                allOf(withText("6"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        1),
                                0),
                        isDisplayed()));
        editText31.check(matches(withText("6")));

        ViewInteraction editText32 = onView(
                allOf(withText("1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        1),
                                2),
                        isDisplayed()));
        editText32.check(matches(withText("1")));

        ViewInteraction editText33 = onView(
                allOf(withText("5"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        1),
                                3),
                        isDisplayed()));
        editText33.check(matches(withText("5")));

        ViewInteraction editText34 = onView(
                allOf(withText("4"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        1),
                                5),
                        isDisplayed()));
        editText34.check(matches(withText("4")));

        ViewInteraction editText35 = onView(
                allOf(withText("2"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        1),
                                6),
                        isDisplayed()));
        editText35.check(matches(withText("2")));

        ViewInteraction editText36 = onView(
                allOf(withText("8"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        1),
                                8),
                        isDisplayed()));
        editText36.check(matches(withText("8")));

        ViewInteraction editText37 = onView(
                allOf(withText("3"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        2),
                                0),
                        isDisplayed()));
        editText37.check(matches(withText("3")));

        ViewInteraction editText38 = onView(
                allOf(withText("2"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        2),
                                1),
                        isDisplayed()));
        editText38.check(matches(withText("2")));

        ViewInteraction editText39 = onView(
                allOf(withText("4"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        2),
                                2),
                        isDisplayed()));
        editText39.check(matches(withText("4")));

        ViewInteraction editText40 = onView(
                allOf(withText("1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        2),
                                4),
                        isDisplayed()));
        editText40.check(matches(withText("1")));

        ViewInteraction editText41 = onView(
                allOf(withText("8"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        2),
                                5),
                        isDisplayed()));
        editText41.check(matches(withText("8")));

        ViewInteraction editText42 = onView(
                allOf(withText("9"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        2),
                                6),
                        isDisplayed()));
        editText42.check(matches(withText("9")));

        ViewInteraction editText43 = onView(
                allOf(withText("5"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        2),
                                7),
                        isDisplayed()));
        editText43.check(matches(withText("5")));

        ViewInteraction editText44 = onView(
                allOf(withText("7"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        2),
                                8),
                        isDisplayed()));
        editText44.check(matches(withText("7")));

        ViewInteraction editText45 = onView(
                allOf(withText("2"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        3),
                                0),
                        isDisplayed()));
        editText45.check(matches(withText("2")));

        ViewInteraction editText46 = onView(
                allOf(withText("4"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        3),
                                1),
                        isDisplayed()));
        editText46.check(matches(withText("4")));

        ViewInteraction editText47 = onView(
                allOf(withText("7"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        3),
                                3),
                        isDisplayed()));
        editText47.check(matches(withText("7")));

        ViewInteraction editText48 = onView(
                allOf(withText("6"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        3),
                                4),
                        isDisplayed()));
        editText48.check(matches(withText("6")));

        ViewInteraction editText49 = onView(
                allOf(withText("8"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        3),
                                6),
                        isDisplayed()));
        editText49.check(matches(withText("8")));

        ViewInteraction editText50 = onView(
                allOf(withText("9"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        3),
                                7),
                        isDisplayed()));
        editText50.check(matches(withText("9")));

        ViewInteraction editText51 = onView(
                allOf(withText("5"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        4),
                                0),
                        isDisplayed()));
        editText51.check(matches(withText("5")));

        ViewInteraction editText52 = onView(
                allOf(withText("7"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        4),
                                2),
                        isDisplayed()));
        editText52.check(matches(withText("7")));

        ViewInteraction editText53 = onView(
                allOf(withText("4"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        4),
                                3),
                        isDisplayed()));
        editText53.check(matches(withText("4")));

        ViewInteraction editText54 = onView(
                allOf(withText("3"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        4),
                                5),
                        isDisplayed()));
        editText54.check(matches(withText("3")));

        ViewInteraction editText55 = onView(
                allOf(withText("1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        4),
                                6),
                        isDisplayed()));
        editText55.check(matches(withText("1")));

        ViewInteraction editText56 = onView(
                allOf(withText("6"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        4),
                                8),
                        isDisplayed()));
        editText56.check(matches(withText("6")));

        ViewInteraction editText57 = onView(
                allOf(withText("6"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        5),
                                1),
                        isDisplayed()));
        editText57.check(matches(withText("6")));

        ViewInteraction editText58 = onView(
                allOf(withText("8"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        5),
                                2),
                        isDisplayed()));
        editText58.check(matches(withText("8")));

        ViewInteraction editText59 = onView(
                allOf(withText("5"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        5),
                                4),
                        isDisplayed()));
        editText59.check(matches(withText("5")));

        ViewInteraction editText60 = onView(
                allOf(withText("9"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        5),
                                5),
                        isDisplayed()));
        editText60.check(matches(withText("9")));

        ViewInteraction editText61 = onView(
                allOf(withText("7"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        5),
                                7),
                        isDisplayed()));
        editText61.check(matches(withText("7")));

        ViewInteraction editText62 = onView(
                allOf(withText("3"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        5),
                                8),
                        isDisplayed()));
        editText62.check(matches(withText("3")));

        ViewInteraction editText63 = onView(
                allOf(withText("4"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        6),
                                0),
                        isDisplayed()));
        editText63.check(matches(withText("4")));

        ViewInteraction editText64 = onView(
                allOf(withText("5"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        6),
                                1),
                        isDisplayed()));
        editText64.check(matches(withText("5")));

        ViewInteraction editText65 = onView(
                allOf(withText("8"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        6),
                                3),
                        isDisplayed()));
        editText65.check(matches(withText("8")));

        ViewInteraction editText66 = onView(
                allOf(withText("3"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        6),
                                4),
                        isDisplayed()));
        editText66.check(matches(withText("3")));

        ViewInteraction editText67 = onView(
                allOf(withText("7"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        6),
                                6),
                        isDisplayed()));
        editText67.check(matches(withText("7")));

        ViewInteraction editText68 = onView(
                allOf(withText("1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        6),
                                7),
                        isDisplayed()));
        editText68.check(matches(withText("1")));

        ViewInteraction editText69 = onView(
                allOf(withText("7"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        7),
                                0),
                        isDisplayed()));
        editText69.check(matches(withText("7")));

        ViewInteraction editText70 = onView(
                allOf(withText("1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        7),
                                1),
                        isDisplayed()));
        editText70.check(matches(withText("1")));

        ViewInteraction editText71 = onView(
                allOf(withText("6"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        7),
                                2),
                        isDisplayed()));
        editText71.check(matches(withText("6")));

        ViewInteraction editText72 = onView(
                allOf(withText("9"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        7),
                                3),
                        isDisplayed()));
        editText72.check(matches(withText("9")));

        ViewInteraction editText73 = onView(
                allOf(withText("5"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        7),
                                5),
                        isDisplayed()));
        editText73.check(matches(withText("5")));

        ViewInteraction editText74 = onView(
                allOf(withText("3"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        7),
                                6),
                        isDisplayed()));
        editText74.check(matches(withText("3")));

        ViewInteraction editText75 = onView(
                allOf(withText("2"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        7),
                                8),
                        isDisplayed()));
        editText75.check(matches(withText("2")));

        ViewInteraction editText76 = onView(
                allOf(withText("3"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        8),
                                1),
                        isDisplayed()));
        editText76.check(matches(withText("3")));

        ViewInteraction editText77 = onView(
                allOf(withText("9"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        8),
                                2),
                        isDisplayed()));
        editText77.check(matches(withText("9")));

        ViewInteraction editText78 = onView(
                allOf(withText("9"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        8),
                                2),
                        isDisplayed()));
        editText78.check(matches(withText("9")));

        ViewInteraction editText79 = onView(
                allOf(withText("7"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        8),
                                4),
                        isDisplayed()));
        editText79.check(matches(withText("7")));

        ViewInteraction editText80 = onView(
                allOf(withText("2"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        8),
                                5),
                        isDisplayed()));
        editText80.check(matches(withText("2")));

        ViewInteraction editText81 = onView(
                allOf(withText("6"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        8),
                                7),
                        isDisplayed()));
        editText81.check(matches(withText("6")));

        ViewInteraction editText82 = onView(
                allOf(withText("4"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        8),
                                8),
                        isDisplayed()));
        editText82.check(matches(withText("4")));

        ViewInteraction editText83 = onView(
                allOf(withText("5"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        0),
                                2),
                        isDisplayed()));
        editText83.check(matches(withText("5")));

        ViewInteraction editText84 = onView(
                allOf(withText("7"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        0),
                                5),
                        isDisplayed()));
        editText84.check(matches(withText("7")));

        ViewInteraction editText85 = onView(
                allOf(withText("1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        0),
                                8),
                        isDisplayed()));
        editText85.check(matches(withText("1")));

        ViewInteraction editText86 = onView(
                allOf(withText("3"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        1),
                                7),
                        isDisplayed()));
        editText86.check(matches(withText("3")));

        ViewInteraction editText87 = onView(
                allOf(withText("9"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        1),
                                4),
                        isDisplayed()));
        editText87.check(matches(withText("9")));

        ViewInteraction editText88 = onView(
                allOf(withText("7"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        1),
                                1),
                        isDisplayed()));
        editText88.check(matches(withText("7")));

        ViewInteraction editText89 = onView(
                allOf(withText("6"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        2),
                                3),
                        isDisplayed()));
        editText89.check(matches(withText("6")));

        ViewInteraction editText90 = onView(
                allOf(withText("3"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        3),
                                2),
                        isDisplayed()));
        editText90.check(matches(withText("3")));

        ViewInteraction editText91 = onView(
                allOf(withText("1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        3),
                                5),
                        isDisplayed()));
        editText91.check(matches(withText("1")));

        ViewInteraction editText92 = onView(
                allOf(withText("5"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        3),
                                8),
                        isDisplayed()));
        editText92.check(matches(withText("5")));

        ViewInteraction editText93 = onView(
                allOf(withText("9"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        4),
                                1),
                        isDisplayed()));
        editText93.check(matches(withText("9")));

        ViewInteraction editText94 = onView(
                allOf(withText("8"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        4),
                                4),
                        isDisplayed()));
        editText94.check(matches(withText("8")));

        ViewInteraction editText95 = onView(
                allOf(withText("2"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        4),
                                7),
                        isDisplayed()));
        editText95.check(matches(withText("2")));

        ViewInteraction editText96 = onView(
                allOf(withText("1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        5),
                                0),
                        isDisplayed()));
        editText96.check(matches(withText("1")));

        ViewInteraction editText97 = onView(
                allOf(withText("2"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        5),
                                3),
                        isDisplayed()));
        editText97.check(matches(withText("2")));

        ViewInteraction editText98 = onView(
                allOf(withText("4"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        5),
                                6),
                        isDisplayed()));
        editText98.check(matches(withText("4")));

        ViewInteraction editText99 = onView(
                allOf(withText("2"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        6),
                                2),
                        isDisplayed()));
        editText99.check(matches(withText("2")));

        ViewInteraction editText100 = onView(
                allOf(withText("6"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        6),
                                5),
                        isDisplayed()));
        editText100.check(matches(withText("6")));

        ViewInteraction editText101 = onView(
                allOf(withText("9"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        6),
                                8),
                        isDisplayed()));
        editText101.check(matches(withText("9")));

        ViewInteraction editText102 = onView(
                allOf(withText("4"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        7),
                                4),
                        isDisplayed()));
        editText102.check(matches(withText("4")));

        ViewInteraction editText103 = onView(
                allOf(withText("8"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        7),
                                7),
                        isDisplayed()));
        editText103.check(matches(withText("8")));

        ViewInteraction editText104 = onView(
                allOf(withText("8"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        8),
                                0),
                        isDisplayed()));
        editText104.check(matches(withText("8")));

        ViewInteraction editText105 = onView(
                allOf(withText("1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        8),
                                3),
                        isDisplayed()));
        editText105.check(matches(withText("1")));

        ViewInteraction editText106 = onView(
                allOf(withText("5"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        8),
                                6),
                        isDisplayed()));
        editText106.check(matches(withText("5")));

        ViewInteraction editText107 = onView(
                allOf(withText("5"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tb_sudoku_solver),
                                        8),
                                6),
                        isDisplayed()));
        editText107.check(matches(withText("5")));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
