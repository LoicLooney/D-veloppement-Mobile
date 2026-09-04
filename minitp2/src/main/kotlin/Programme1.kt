// ============================================================================
// Mini-TP 2 — Programme 1 : launch
// AVANT d'exécuter : prédisez l'ordre EXACT des affichages et la durée totale.
// (Vos prédictions se soumettent sur Moodle — Test « S2 · Prédictions ».)
// ============================================================================
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val duree = measureTimeMillis {
        println("A - début de la synchronisation")
        val job = launch {
            delay(500)
            println("B - collectes reçues")
        }
        println("C - interface prête")
        job.join()
    }
    println("Durée totale : environ $duree ms")
}
