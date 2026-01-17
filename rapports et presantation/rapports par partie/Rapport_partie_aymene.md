# Développement des unités et du système de jeu
## 1. Présentation du rôle

Dans le cadre du projet de développement du jeu stratégique en Java, mon rôle principal a été la conception et l’implémentation des unités du jeu ainsi que du système de jeu.
Ce travail s’inscrit dans l’application des principes de la Programmation Orientée Objet, notamment l’héritage, le polymorphisme et l’encapsulation.

## 2. Conception des unités

Une classe abstraite Unit a été conçue afin de représenter une unité générique du jeu.
Elle regroupe les attributs et comportements communs à toutes les unités, tels que :

- health,
- attackPower,
- defense,
- arme name,
- position sur la carte (positionX, positionY).

À partir de cette classe abstraite, plusieurs classes concrètes ont été implémentées :

- Soldier
- Archer
- cavalier
- magicien
- tank

Chaque type d’unité possède des caractéristiques spécifiques, ce qui permet de différencier leur comportement en combat et d’introduire une dimension stratégique dans le jeu.

L’utilisation de l’héritage permet d’ajouter facilement de nouvelles unités sans modifier la structure existante, garantissant ainsi une architecture extensible.

## 3. Implémentation du système de jeu

Le système de jeu repose sur des règles simples et cohérentes avec un jeu de stratégie en console.
Il prend en charge les fonctionnalités suivantes :

- vérification de la portée d’attaque,
- calcul des dégâts infligés,
- prise en compte de la défense de l’unité ciblée,
- gestion de la mort d’une unité et son retrait du jeu.

La formule de dégâts permet de simuler des combats équilibrés tout en conservant un aspect imprévisible, ce qui renforce l’intérêt stratégique du jeu.

## 4. Gestion des interactions avec la carte

Les unités interagissent directement avec la carte du jeu :

- elles occupent une case donnée,
- leurs déplacements sont soumis aux règles d’accessibilité des terrains,
- les attaques ne sont possibles que si la cible est valide et accessible.

Cette interaction garantit une cohérence entre la logique des unités et celle de la carte.

## 5. Tests et validation

Des tests ont été réalisés afin de vérifier :

- le bon fonctionnement des attaques,
- la diminution correcte des points de vie,
- la suppression des unités mortes,
- la cohérence des combats entre différents types d’unités.

Ces tests ont permis de corriger plusieurs incohérences et d’améliorer la stabilité du système de jeu.

## 6. Conclusion

Le travail réalisé sur les unités et le système de jeu constitue un élément central du jeu stratégique.



