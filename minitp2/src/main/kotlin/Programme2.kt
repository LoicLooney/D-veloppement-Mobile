// ============================================================================
// Mini-TP 2 — Programme 2 : async / await (version fournie)
// AVANT d'exécuter : prédisez l'ordre EXACT des affichages et la durée totale.
//
// TRANSFORMATION 1 (après vérification) : rendez ce programme SÉQUENTIEL
// en déplaçant les await, ré-exécutez et notez la nouvelle durée
// en commentaire ci-dessous.
// Durée mesurée après transformation : 2525 ms
// ============================================================================
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val duree = measureTimeMillis {
        // --- Version de base ---
         /*val produits = async {
             delay(1000)
             "12 produits"
         }
         val collectes = async {
             delay(1500)
             "8 collectes"
         }
        println("Synchronisé : " + produits.await() + " et " + collectes.await())*/

        // --- Transformation 1 : version SÉQUENTIELLE --- 2525 ms Apres transformation
        val produits = async {
            delay(1000)
            "12 produits"
        }.await()
        val collectes = async {
            delay(1500)
            "8 collectes"
        }.await()
        println("Synchronisé : $produits et $collectes")
    }
    println("Durée totale : environ $duree ms")
}
