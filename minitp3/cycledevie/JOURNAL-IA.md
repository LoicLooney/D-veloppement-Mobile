# JOURNAL-IA — Mini-TP 3 (Voie ouverte)

## 1. Diagnostic soumis à l’IA (réponse type)

**Ligne :** `MainActivity.kt:29` (`mg.itu.cycledevie.MainActivity.onCreate`).

**Cause :** `findViewById(R.id.btnPartage)` renvoie `null` → NPE. L’id `btnPartage` n’existe pas dans le layout gonflé.

**Correction :** aligner le code et le XML — utiliser l’id réel du layout (`btnPartager`), ou renommer l’id XML en `btnPartage`.

---

## 2. Verdict en 3 lignes (à coller dans le formulaire)

Bonne ligne : oui, c’est bien `MainActivity.kt` ligne 29, dans notre paquet.

Bonne cause : oui, le bouton `btnPartage` n’existe pas dans le layout, donc `findViewById` renvoie null.

Correction OK : oui, il faut écrire `btnPartager` comme dans `activity_main.xml`.
