# Feuille Mini-TP 2 — Les coroutines — <Nom Prénom>

« Prédire puis vérifier » — suspend, launch, async/await

**Règle :** remplir les prédictions **AVANT** toute exécution. Pas d’IA pendant les étapes 1 à 3.

---

## Étape 1 — Lire et prédire (sur papier / ici, AVANT d’exécuter)

Ouvrir `Programme1.kt`, `Programme2.kt`, `Programme3.kt` dans Android Studio **sans les lancer**. Pour chacun : ordre exact des affichages, durée totale estimée, une phrase d’explication.


| Programme                        | Ordre EXACT des affichages prédits                                                      | Durée totale estimée | Pourquoi (une phrase)                                                                                                            |
| -------------------------------- | --------------------------------------------------------------------------------------- | -------------------- | -------------------------------------------------------------------------------------------------------------------------------- |
| Programme 1 (`launch`)           | 1) `A - début de la synchronisation` 2) `C - interface prête` 3) `B - collectes reçues` | ≈ 500 ms             | `launch` démarre la tâche en arrière-plan sans attendre : A puis C s’affichent tout de suite, B seulement après le `delay(500)`. |
| Programme 2 (`async` concurrent) | 1) `Synchronisé : 12 produits et 8 collectes` 2) `Durée totale : environ ~1500 ms`      | ≈ 1500 ms            | Les deux `async` démarrent ensemble ; les `await` sont à la fin → durée = **max**(1000, 1500).                                   |
| Programme 3 (le piège)           | 1) `Poids total : 10.5 kg` 2) `Durée totale : environ ~1800 ms`                         | ≈ 1800 ms            | Chaque `.await()` est collé à son `async` : la 2ᵉ tâche ne démarre qu’après la 1ʳᵉ → durée = **somme**(1000 + 800).              |


---



## Étape 2 — Exécuter et expliquer les écarts

Lancer chaque programme (flèche verte à côté de `main()`). Comparer sortie et durée à vos prédictions.


| Programme   | Sortie / durée observées                                                 | Écart constaté (ou « aucun ») | Explication en une phrase                                                                                    |
| ----------- | ------------------------------------------------------------------------ | ----------------------------- | ------------------------------------------------------------------------------------------------------------ |
| Programme 1 | `A` → `C` → `B` puis `Durée totale : 512 ms`                             | aucun                         | L’ordre A, C, B et ~500 ms confirment que `launch` n’attend pas : C passe avant B.                           |
| Programme 2 | `Synchronisé : 12 produits et 8 collectes` puis `Durée totale : 1527 ms` | aucun                         | Les deux `async` se déclenche ensemble ; la durée réelle est le **max**(1000, 1500) = ~1500 ms.              |
| Programme 3 | `Poids total : 10.5 kg` puis `Durée totale : 1835 ms`                    | aucun                         | Les `.await()` enchaînent ensembles les tâches : durée = 1000 + 800 ≈ 1800 ms ; poids = 4.5 + 6.0 = 10.5 kg. |


Un écart n’est pas une faute — c’est l’information la plus utile de la séance.

---



## Étape 3 — Transformer (un déplacement d’`await` chacun)

**Indice :** seule la **position** des `.await()` change. Rien d’autre à ajouter ou retirer.

### Transformation 1 — Programme 2 → séquentiel

- [x] Rendre `Programme2.kt` **séquentiel** (chaque tâche attend la fin de la précédente)
- [x] Ré-exécuter
- [x] Noter la durée dans le commentaire en tête du fichier **et** ci-dessous
- [x] Vérifier : durée ≈ **somme** des délais (1000 + 1500 ≈ 2500 ms)

**Durée mesurée après transformation :** 2525 ms

### Transformation 2 — Programme 3 → concurrent

- [x] Rendre `Programme3.kt` **concurrent** (les deux tâches courent en même temps)
- [x] Ré-exécuter
- [x] Noter la durée dans le commentaire en tête du fichier **et** ci-dessous
- [x] Vérifier : durée ≈ **maximum** des délais (max(1000, 800) ≈ 1000 ms)

**Durée mesurée après transformation :** 1026 ms

---



## Voie ouverte — Journal IA (brouillon)

À recopier ensuite dans le champ « JOURNAL-IA » du formulaire :  
[https://forms.gle/jaLym8tmaDcoHVCa6](https://forms.gle/jaLym8tmaDcoHVCa6)

- **Écart choisi** (programme et nature de l’écart) : Programme 3 — durée ≈ 1800 ms au lieu de ≈ 1000 ms (piège des `await`).
- **Explication reformulée avec mes mots** (3 lignes max, sans recopier l’IA) :
  Voir aussi `JOURNAL-IA.md` — chaque `await` collé à son `async` force le séquentiel (somme des délais) ; pour du concurrent, lancer les deux `async` avant d’appeler les `await`.

---



## Rappel livrables

1. `Programme2.kt` et `Programme3.kt` transformés (durées dans les commentaires)
2. Cette feuille remplie (photo / PDF) — tableaux d’écarts
3. Reformulation 3 lignes dans le formulaire

