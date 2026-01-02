

Implémentation des Bâtiments et de l’Interface Utilisateur

1) RÔLE ET RESPONSABILITÉS :

Développement du système de bâtiments.
Gestion de la construction, des coûts et de la production.
Implémentation de l’interface utilisateur en console.
Affichage des informations du joueur : ressources, bâtiments, unités, messages système.

2) CHOIX TECHNIQUE :
Langage : Java 11
Type d’interface : Console (Terminal)
Paradigme : Programmation Orientée Objet
Collections utilisées : Map<String, Integer> pour les ressources, List pour les bâtiments, List pour les unités.
Architecture respectant encapsulation, héritage, extensibilité.


3) CONCEPTION DU SYSTÈME BÂTIMENT:
    3.1 Classe abstraite Building:


Attributs : name, constructionCost, buildTime, isConstructed
Méthodes : build(), produce(), getCost()

    3.2 Types de bâtiments implémentés:

Centre de commandement : permet la construction des autres bâtiments, stocke l’état global de la base, un seul centre par joueur.
Camp d’entraînement : création des unités militaires, consomme des ressources, ajout des unités à la liste du joueur.
Bâtiments de production : Mine (Or), Ferme (Nourriture), Scierie (Bois), production automatique à chaque tour.

4) GESTION DES SOURCES :

Ressources : Or, Bois, Pierre, Nourriture
Structure : Map<String, Integer>
Fonctionnalités : ajout automatique après production, vérification avant construction ou entraînement, affichage en temps réel.

5) INTERFACE UTILISATEUR (Console): 
                         
  5.1 Menu principal : Nouvelle partie, Charger, Quitter 
  5.2 Affichage du jeu : carte ASCII, ressources, bâtiments, unités
  5.3 Messages et notifications : construction réussie, manque de ressources, création d’unités, fin de tour

6) INTERFACE AVEC LES AUTRES MODULES :

Communication avec module Ressources (Membre 1), Unités & Combat (Membre 3), Carte (Membre 2)
Utilisation de méthodes publiques, respect de la séparation des responsabilités.

7) TESTE RÉALISÉS :

Tests manuels : construction valide/invalide, production correcte, création d’unités selon les ressources
Vérification : absence de crash, cohérence des affichages.

8) DIFFICULTÉS RENCONTRÉS :

Synchronisation production / consommation des ressources
Organisation du code pour éviter les dépendances fortes
Lisibilité de l’interface texte

9) SOLUTIONS APPORTES:

Utilisation de classes abstraites
Centralisation de l’affichage
Méthodes claires pour chaque action utilisateur

10) CONCLUSION: 
Le travail du membre 4 a permis de fournir un système de bâtiments fonctionnel,
 une gestion claire des ressources et une interface console jouable
 cette parti  constitue  un pilier central de l’expérience utilisateur
 et s’intègre correctement avec les autres modules du projet.
