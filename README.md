# Robotix

## Description

Ce projet Robotix est conçu pour répondre à la demande de gestion de robots utilisés dans divers secteurs. Avec de plus en plus de robots, une bonne gestion de ceux-cis est clé.
On vise à developper une application permettant notamment la gestion/enregistrement de robots, l'achat de composantes robotiques, et pour les fournisseur la gestion de ses composantes. 
Le logiciel favorise l'echange et la communication avec la possibilité d'entrer en contact avec un fournisseur, ainsi que la possibilité de participer a des activités avec ses robots.
Finalement, avec de nombreux outils pour évaluer/monitorer les états et performances des robots, Robotix permet aux utilisateurs de mieux gérer leurs robots.

## Fonctionnalités
// Fonctionnalités communes aux utilisateurs et fournisseurs
  - Creer un compte
  - Se connecter
  - modifier son profil

// Fonctionnalités pour utilisateurs
  - Gérer ses robots
    - Afficher ses robots
    - Enregistrer un robot
    - Supprimer un robot
  - Gérer ses activités
    - Afficher ses activités
    - Supprimer (se déinscrire) une activité
    - Ajouter (s'inscrire) à une activité
  - Voir l'état de ses robots
    - vue générale
    - vue complète 
  - Voir ses notifications
  - Acheter une composante
  - Trouver une composante
  - Trouver un fournisseur

// Fonctionnalités pour fournisseurs
  - Afficher ses composantes
  - Supprimer une composante de son inventaire
  - Modifier une composante
  - Enregistrer une composante

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
  - Voir le profil d'un fournisseur


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
|       ├── Image du diagramme de classes (révisé)
|       └── Fichier vpp du diagramme de classes (révisé)
│   └── DiagrammeSéquence/
|       ├── Images des diagrammes de sequence (révisé)
|       └── Fichiers vpp du diagramme de classes (révisé)
├── Implémentation/
│   ├── Code source de l'application/ -- code source
├── Rapport du devoir 3
└── README.md
```
## Description des données de départ
10 utilisateurs, 5 fournisseurs, 2 robots, 5 composantes, 5 activites
## Instructions pour installer le projet
Download as zip, utiliser maven
## Instructions pour exécuter l'application
-java -jar robotix.jar

