package com.campspot.kotular

/**
 * Created by bradensteffaniak on 4/12/17.
 */

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION,
        AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.EXPRESSION,
        AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.SOURCE)
annotation class JsName(val s: String)

class JSON {
    companion object {
        inline fun <reified T> parse(s: String): JsArray<T> { return JsArray<Todo>() as JsArray<T> }
        fun <T> stringify(s: Array<T>): String { return "" }
    }
}

class LocalStorage {
    fun getItem(s: String): String? { return null }
    fun setItem(s: String, v: String) {}
}

val localStorage: LocalStorage = LocalStorage()
val angular: Angular = Angular()


class Angular {
    fun module(name: String, deps: JsArray<String>): Module { return Module() }
}

class Module {
    fun directive(name: String, injectsAndDef: JsArray<Any>): Unit { return }
    fun factory (name: String, injectsAndDef: JsArray<Any>): Unit {}
    fun controller(name: String, injectsAndDef: JsArray<Any>): Unit {}
    fun config(injectsAndDef: JsArray<Any>): Unit {}
    fun filter(name: String, lambda: Any): Unit {}
}

data class Route(val templateUrl: String, val controller: String, val controllerAs: String)

interface Router {
    @JsName("when") fun route(url: String, route: Route): Router
}

interface ElemNode {
    fun focus()
}

interface Elem {
    fun bind(name: String, func: () -> Unit)
    operator fun get(index: Int): ElemNode
}

class Directive {
    var link: (scope: Scope, elem: Elem, attrs: Any) -> Unit = {x,y,z->}
}

interface Timeout {
    operator fun invoke(func: () -> Unit, x: Int, y: Boolean)
}

class Location {
    fun path(): String { return "" }
    fun path(p: String) {}
}

class Scope {
    @JsName("\$watch") fun watch(exp: Any, todo: (Any?) -> Unit, deepWatch: Boolean) {}
    @JsName("\$watch") fun watch(exp: Any, todo: (Any?) -> Unit) {}
    @JsName("\$apply") fun apply(func: Any): Unit {}
}

typealias JsArray<T> = Array<T>

inline fun <reified X> JsArray(vararg x: X): JsArray<X> {
    val array: Array<X> = Array(x.size, {
        i ->
        x[i]
    })

    return array
}

fun <T> JsArray<T>.push(obj: T): T { return obj }
fun <T> JsArray<T>.splice(i1: Int, i2: Int): JsArray<T> { return this }
fun <T> JsArray<T>.indexOf(obj: T): Int { return 0 }
fun <T> JsArray<T>.forEach(action: (T) -> Unit) {}
inline fun <T, reified X> JsArray<T>.map(action: (T) -> X): JsArray<X> { return JsArray() }
fun<T> JsArray<T>. filter(action: (T) -> Boolean): JsArray<T> { return this }