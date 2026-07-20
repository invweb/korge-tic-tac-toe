plugins {
    id("com.soywiz.korge") version "6.0.0"
}

korge {
    targetAndroid()
}

afterEvaluate {
    tasks.matching { it.name == "lintVitalAnalyzeRelease" }.configureEach {
        enabled = false
    }
}
