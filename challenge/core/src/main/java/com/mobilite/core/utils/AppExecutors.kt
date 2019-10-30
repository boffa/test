package com.mobilite.core.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlin.coroutines.CoroutineContext

const val THREAD_COUNT = 1

open class AppExecutors @ObsoleteCoroutinesApi constructor(
    val ioContext: CoroutineContext = Dispatchers.Default,
    val networkContext: CoroutineContext = newFixedThreadPoolContext(THREAD_COUNT, "networkIO"),
    val uiContext: CoroutineContext = Dispatchers.Main
)