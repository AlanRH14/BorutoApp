package com.aarh.borutoapp.presentation.screen.search

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.aarh.borutoapp.presentation.screens.search.widgets.SearchWidget
import org.junit.Rule
import org.junit.Test

class SearchWidgetTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun openSearchWidget_addInputText_assertInputText() {
        val text = mutableStateOf("")
        composeTestRule.setContent {
            SearchWidget(
                text = text.value,
                onTextChange = {
                    text.value = it
                },
                onCloseClicked = {},
                onSearchClicked = {},
            )
        }
        composeTestRule.onNodeWithContentDescription("TextField")
            .performTextInput("LordMiau")
        composeTestRule.onNodeWithContentDescription("TextField")
            .assertTextEquals("LordMiau")
    }

    @Test
    fun onSearchWidget_addInputText_pressCloseButtonOnce_assertEmptyInputText() {
        val text = mutableStateOf("")
        composeTestRule.setContent {
            SearchWidget(
                text = text.value,
                onTextChange = {
                    text.value = it
                },
                onCloseClicked = {},
                onSearchClicked = {}
            )
        }
        composeTestRule.onNodeWithContentDescription("TextField")
            .performTextInput("LordMiau")
        composeTestRule.onNodeWithContentDescription("CloseButton")
            .performClick()
        composeTestRule.onNodeWithContentDescription("TextField")
            .assertTextContains("")
    }

    @Test
    fun onSearchWidget_addInputText_pressCloseButtonTwice_assertClosedState() {
        val text = mutableStateOf("")
        val searchWidgetShown = mutableStateOf(true)

        composeTestRule.setContent {
            if (searchWidgetShown.value) {
                SearchWidget(
                    text = text.value,
                    onTextChange = { text.value = it },
                    onCloseClicked = { searchWidgetShown.value = false },
                    onSearchClicked = {}
                )
            }
        }
        composeTestRule.onNodeWithContentDescription("TextField")
            .performTextInput("LordMiau")
        composeTestRule.onNodeWithContentDescription("CloseButton")
            .performClick()
        composeTestRule.onNodeWithContentDescription("CloseButton")
            .performClick()
        composeTestRule.onNodeWithContentDescription("SearchWidget")
            .assertDoesNotExist()
    }

    @Test
    fun openSearchWidget_pressCloseButtonOnceWhenInputIsEmpty_assertClosedState() {
        val text = mutableStateOf("")
        val searchWidgetShown = mutableStateOf(true)

        composeTestRule.setContent {
            if (searchWidgetShown.value) {
                SearchWidget(
                    text = text.value,
                    onTextChange = { text.value = it },
                    onCloseClicked = { searchWidgetShown.value = false },
                    onSearchClicked = {}
                )
            }
        }

        composeTestRule.onNodeWithContentDescription("CloseButton")
            .performClick()
        composeTestRule.onNodeWithContentDescription("SearchWidget")
            .assertDoesNotExist()
    }
}