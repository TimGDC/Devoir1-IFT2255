# README

## Description

Ce projet Robotix est conçu pour répondre à la demande de gestion de robots utilisés dans divers secteurs. Avec de plus en plus de robots, une bonne gestion de ceux-cis est clé.
On vise à developper une application complète permettant notamment une la construction de robots, l'achat de composantes robotiques, le contrôle des mouvements, la création d'actions et la gestion des tâches. 
Le logiciel favorise l'echange et la communication avec l'implementation d'un systeme de suiveurs, ainsi que la possibilité de participer en groupe a des activités avec ses robots.
Finalement, avec de nombreux outils pour évaluer/monitorer les états et performances des robots, Robotix permet aux utilisateurs de mieux gérer leurs robots.

## Fonctionnalités

// Requêtes publiques
  - Récupérer la liste des utilisateurs
  - Rechercher un utilisateur
    - avec son pseudo
    - faire defiler la liste des utilisateurs et choisir parmi celle-ci
  - Voir le profil d'un utilisateur
    - voir ses suiveurs
  - Récupérer la liste des activités
  - Récupérer la liste des intérêts
  - Récupérer la liste des fournisseurs
  - Rechercher un fournisseur (par nom, adresse ou types de composantes)
  - Voir le profil d'un fournisseur
  - Rechercher une composante (par nom de la composante, type ou nom du fournisseur)
    - voir si composante disponible
    - voir son prix et description
    - voir le fournisseur associé
// Fonctionnalités pour utilisateurs
  - Modifier son profil
  - Gérer sa flotte (robots et composantes)
  - Gérer ses suiveurs
  - Gérer ses activités
  - Gérer ses intérêts
  - Suivre un utilisateur
  - S'inscrire à une activité
  - Se souscrire à un intérêt
  - Voir l'état de ses robots
    - voir leur batterie
    - voir leur consommation CPU & mémoire
    - voir leur position
  - Voir les métriques
    - voir la consommation globale de sa flotte
  - Voir ses notifications
// Fonctionnalités pour fournisseurs
  - Modifier son profil
  - Gérer ses composantes
    - voir son inventaire
    - retirer une composante
  - Enregistrer une composante


## Organisation des fichiers

Le projet est origanisé selon la structure suivante

```
/ 
├── Exigences/
│   ├── Rapport du devoir 1
│   └── Diagramme des cas d'utilisations (fichiers vpp et images)
|   └── Image des insights du devoir 1
├── Analyse/
│   ├── Analyse.pdf
│   └── Images des diagrammes d'activités
│   └── Fichiers vpp des diagrammes d'activités
├── Conception/
│   ├── DiagrammClasses/
|       ├── Image du diagramme de classes
|       └── Fichier vpp du diagramme de classes
│   └── DiagrammeSéquence/
|       ├── Images des diagrammes de sequence
|       └── Fichiers vpp du diagramme de classes
├── Implémentation/
│   ├── Code source de l'application/ -- code source
├── Rapport du devoir 2
└── README.md
```
