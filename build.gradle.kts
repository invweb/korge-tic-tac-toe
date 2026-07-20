plugins {
    id("com.soywiz.korge") version "6.0.0"
}

korge {
    targetAndroid()
}

afterEvaluate {
    val jvmProcessResources = tasks.findByName("jvmProcessResources")
    if (jvmProcessResources != null) {
        tasks.matching { it.name.contains("Lint", ignoreCase = true) }.configureEach {
            dependsOn(jvmProcessResources)
        }
    }
}
