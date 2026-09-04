# Feuille Mini-TP 3 — Anatomie Android — <Nom Prénom>

« Observer le cycle de vie » — cycle de vie, Intents, Logcat

**Règle :** remplir les prédictions (étape 1) **AVANT** de lancer l’application. Pas d’IA pendant les étapes 1 à 3.

Filtre Logcat : `tag:CYCLE`

---

## Étape 1 — Lire et prédire (AVANT tout lancement)

Lire `MainActivity.kt` sans lancer l’app. Remplir les deux scénarios.


| Scénario                                                                                   | Séquence EXACTE prédite (dans l’ordre)                                         | Réponse à la question « + » (une phrase)                                                                                       |
| ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------ |
| **A — Rotation** (portrait → paysage) + *que devient un compteur stocké dans l’Activity ?* | `onPause` → `onStop` → `onDestroy` → `onCreate` → `onStart` → `onResume`       | Le compteur est **perdu** : l’Activity est détruite puis recréée, donc tout état stocké dans l’instance disparaît.             |
| **B — Accueil, puis retour** + *quelle différence essentielle avec la rotation ?*          | Accueil : `onPause` → `onStop` ; retour : `onRestart` → `onStart` → `onResume` | Pas de destruction : **pas** de `onDestroy`/`onCreate` — l’instance survit, donc un compteur dans l’Activity est **conservé**. |


Callbacks possibles : `onCreate`, `onStart`, `onResume`, `onPause`, `onStop`, `onRestart`, `onDestroy`

---

## Étape 2 — Observer au Logcat

Lancer l’app, filtrer `tag:CYCLE`, jouer les scénarios.


| Scénario             | Séquence observée                                                                                                         | Écart avec ma prédiction + explication                                          |
| -------------------- | ------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- |
| Rotation de l’écran  | `onPause` → `onStop` → `onDestroy` (instance **174188751**) → `onCreate` (instance **80908465**) → `onStart` → `onResume` | aucun — conforme à la prédiction ; le `hashCode` change (174188751 → 80908465). |
| Accueil, puis retour | Accueil : `onPause` → `onStop` ; retour : `onRestart` → `onStart` → `onResume`                                            | aucun — conforme ; **pas** de `onDestroy`/`onCreate` (instance conservée).      |


### Question d’observation

À la rotation, le numéro d’instance (`hashCode`) affiché par `onCreate` change.

**Qu’est-ce que cela prouve — et qu’arriverait-il à un compteur stocké dans l’Activity ?**

> Cela prouve que le système a **détruit** l’ancienne Activity et en a **créé une nouvelle**. Un compteur stocké dans l’Activity serait **réinitialisé / perdu**.

### Bonus — Second écran

Ouvrir le second écran (bouton). Observer l’entrelacement `CYCLE` et `CYCLE-2`.

**Séquence observée (aller + retour) :**
`CYCLE onPause` → `CYCLE-2 onCreate` → `onStart` → `onResume` → `CYCLE onStop` → (retour) `CYCLE-2 onPause` → `CYCLE onRestart` → `onStart` → `onResume` → `CYCLE-2 onStop` → `onDestroy`

**Qui se met en pause avant que qui ne se crée ?**

> `MainActivity` (`CYCLE`) se met en **pause** (`onPause`) **avant** que `SecondActivity` (`CYCLE-2`) ne se **crée** (`onCreate`).

---

## Étape 3 — Compléter le partage

Dans `MainActivity.partagerCollecte()` : Intent implicite `ACTION_SEND`, type `text/plain`, texte « Collecte du jour : 4,5 kg de vanille », lancé via `Intent.createChooser`.

- [x] Code complété
- [x] Le sélecteur de partage s’ouvre sur l’émulateur / appareil

---

## Voie ouverte — Journal IA (brouillon)

Stack trace fournie (crash `btnPartage` / NPE). Demander à l’IA :  
« Diagnostique ce crash : quelle ligne, quelle cause, quelle correction ? »

Puis **juger** en 3 lignes (comparer avec `activity_main.xml`).

- **Bonne ligne (notre paquet) ?** Oui, c’est bien `MainActivity.kt` ligne 29, dans notre paquet.
- **Bonne cause ?** Oui, le bouton `btnPartage` n’existe pas dans le layout, donc `findViewById` renvoie null.
- **Correction proposée OK ? Mon verdict :** Oui, il faut écrire `btnPartager` comme dans `activity_main.xml`.

*(À recopier dans le champ JOURNAL-IA du formulaire S3.)*

---

## Rappel livrables

1. Cette feuille remplie (photo / PDF)
2. Captures Logcat filtrées (une par scénario), annotées
3. Projet avec partage fonctionnel (lien GIT public)
4. Verdict 3 lignes dans le formulaire « S3 · Dépôt des livrables »

