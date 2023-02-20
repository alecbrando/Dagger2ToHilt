pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    // defaultLibrariesExtensionName.set("projectLibs")
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
    /*versionCatalogs {
        create("libs") {
            from(files("../Dagger2ToHilt/gradle/libs.versions.toml"))
        }
    }*/
}
enableFeaturePreview("VERSION_CATALOGS")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "Dagger2ToHilt"
include(":app", ":network", ":database")
