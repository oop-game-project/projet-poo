# Ton rôle (rappel)

Tu es responsable de :

- la classe abstraite Unit

- les unités concrètes (Soldat, Archer, Cavalier…)

- le système de combat

- la logique de mort / retrait des unités

👉 Tu travailles surtout sur la logique, pas l’interface.

## ✅ Étape 1 — Créer la classe abstraite Unit (PRIORITÉ)

C’est la base de tout.

À faire :

**Attributs communs :**

- hp (points de vie)

- attack

- defense   

- range

- cost

- position (x, y)   

**Méthodes :**

- attack(Unit target)

- takeDamage(int damage)

- isAlive()

📌 Cette classe doit être abstraite.

## ✅ Étape 2 — Créer les unités concrètes

Chaque unité hérite de Unit.

Exemples :

Soldier

Archer

Cavalier

Chaque classe :

fixe ses propres statistiques

peut redéfinir certaines méthodes (polymorphisme)

## ✅ Étape 3 — Définir la règle de combat

Décide UNE règle simple et claire.

Exemple :

degats = attaque_attquant - défense_cible + aléatoire


Utilise Random

Empêche les dégâts négatifs

Mets à jour les points de vie

## ✅ Étape 4 — Gérer la mort d’une unité

Quand :

hp <= 0


Alors :

isAlive() retourne false

l’unité est supprimée de la liste du joueur

la case devient libre

👉 Ici tu travailleras avec des List<Unit>

## ✅ Étape 5 — Tester sans interface graphique

Fais une classe de test :

crée 2 unités

fais-les combattre

affiche les résultats dans la console

⚠️ Très important pour éviter les bugs plus tard.