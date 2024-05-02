pluginManagement {
    repositories {
        google ()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Shelves"
include(":app")
include(":feature:books")
include(":feature:profile")
