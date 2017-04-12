package com.campspot.kotular

import com.campspot.kotular.*
import org.junit.Test


/**
 * Created by bradensteffaniak on 4/11/17.
 */

class ControllerTest {
    val scope: Scope = Scope()

    val controller: TodoController = TodoController(scope, Location(), TodoStorage(), {x, y -> JsArray()})

    @Test fun emptyTodos() {
        assert(controller.todos.isEmpty())
    }

    @Test fun asdf() {
        assert(!controller.allChecked)
    }
}