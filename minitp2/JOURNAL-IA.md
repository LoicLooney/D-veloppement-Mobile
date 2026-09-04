# Brouillon — à rédiger ici puis recopier dans le champ du formulaire

- Écart choisi (programme et nature de l'écart) : Programme 3 — j'ai cru à une durée proche de 1000 ms (comme programme 2), mais on observe = 1835 ms.
- Explication reformulée avec mes mots (3 lignes max) :
  Dans le programme 3, chaque `await` est collé juste après l' `async`, donc la deuxième tâche ne démarre qu’une fois la première terminée.
  Les délais (1000 + 800) que de tourner ensemble.
  C’est la place de `await` qui décide : seulement si les deux `async` sont lancés avant les `await`.
