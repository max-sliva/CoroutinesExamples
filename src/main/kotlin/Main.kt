package org.example

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
//https://kotlinlang.org/docs/coroutines-basics.html#coroutines-are-light-weight
//https://kotlinlang.ru/docs/coroutines-basics.html
fun main() = runBlocking { // this: CoroutineScope
//    launch { doWorld() }
//    println("Hello")
    val job = launch { // launch a new coroutine and keep a reference to its Job
        delay(1000L)
        println("World!")
    }
    println("Hello")
    job.join() // wait until child coroutine completes
    println("Done")
//    doWorld3()
//    println("Done")
}

// this is your first suspending function
suspend fun doWorld() {
    delay(1000L)
    println("World!")
}

suspend fun doWorld2() = coroutineScope {  // this: CoroutineScope
    launch {
        delay(1000L)
        println("World!")
    }
    println("Hello")
}

suspend fun doWorld3() = coroutineScope { // this: CoroutineScope
    launch {
        delay(2000L)
        println("World 2")
    }
    launch {
        delay(1000L)
        println("World 1")
    }
    println("Hello")
}