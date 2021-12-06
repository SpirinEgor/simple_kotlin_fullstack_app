package com.example

import kotlinx.browser.document
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.html.InputType
import kotlinx.html.id
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.HTMLParagraphElement
import react.Props
import react.dom.*
import react.fc

private val scope = MainScope()

private fun setError(paragraph: HTMLParagraphElement, message: String) {
    paragraph.innerText = message
    paragraph.style.color = "red"
}

private fun setCorrect(paragraph: HTMLParagraphElement, message: String) {
    paragraph.innerText = message
    paragraph.style.color = "black"
}

private fun onButtonClick() {
    val inputElement = document.getElementById("name") as HTMLInputElement
    val outputElement = document.getElementById("output") as HTMLParagraphElement
    val name = inputElement.value
    if (name.isEmpty()) setError(outputElement, "Provide your name, please!")
    else scope.launch {
        val result = withContext(Dispatchers.Default) { apiRequest(name) }
        when (result) {
            null -> setError(outputElement, "Something went wrong :(")
            else -> setCorrect(outputElement, result)
        }
    }
}

val app = fc<Props> {
    h1 {
        +"Hello!"
    }
    div(classes = "form-row align-items-end") {
        div(classes = "form-group col") {
            input(type = InputType.text, name = "name", classes = "form-control") {
                attrs {
                    id = "name"
                    placeholder = "What is your name?"
                }
            }
        }
        div(classes = "form-group col-auto") {
            button(classes = "btn btn-success") {
                +"GO!"
                attrs {
                    onClickFunction = { onButtonClick() }
                }
            }
        }
    }
    br { }
    p {
        attrs {
            id = "output"
        }
    }
}