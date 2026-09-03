plugins {
    kotlin("jvm") version "2.1.10"
}

kotlin {
     jvmToolchain(17)
}

repositories { mavenCentral() }

// Aucune dépendance : Kotlin pur.
// Pour lancer : ouvrir src/main/kotlin/Collectes.kt dans Android Studio
// et cliquer sur la flèche verte à côté de fun main().
