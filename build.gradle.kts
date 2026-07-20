plugins {
    id("com.soywiz.korge") version "6.0.0"
}

korge {
    targetAndroid()
}

afterEvaluate {
    val jvmProcessResources = tasks.findByName("jvmProcessResources")
    if (jvmProcessResources != null) {
        tasks.matching { it.name.contains("Lint", ignoreCase = true) || it.name.contains("lint", ignoreCase = false) }.configureEach {
            dependsOn(jvmProcessResources)
        }
    }
    tasks.matching { it.name == "lintDebug" || it.name == "lintRelease" || it.name == "lintAnalyzeDebug" || it.name == "lintAnalyzeRelease" || it.name == "lintVitalAnalyzeRelease" }.configureEach {
        enabled = false
    }
}
