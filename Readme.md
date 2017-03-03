# TP Architecture Logicielle Java / INF4043 - 2017 - Jeux de Lettres
*À rendre pour le 03/03/2017

## Composition de l'équipe
**Florent Cosson** | **Adrien Hayotte**
Étudiant 4A | ESIEA | TCSI2

## Introduction
**Jeux de Lettres** *(LetterGame)* est un projet Java, développé sous Eclipse, dans le cadre du cours d'architecture logiciel dispensé par M. Labusquiere.

## But du Jeu
Tour à tour, vous devez faire le plus de mots possibles avant votre adversaire. Le premier qui arrive à dix remporte la partie. Mais attention, vous pouvez facilement vous faire voler des mots si votre rival arrive à ajouter des lettres du pot commun dans l'un de vos mots :D. Êtes-vous prêt à relever le défi?

## Comment lancer le programme Java ?
**Il faut au préalable avoir une version Java récente installée sur votre ordinateur.**
Ensuite, il vous suffit de saisir la commande suivante dans votre terminal pour lancer le Jeu après avoir importé le projet sur votre ordinateur.
**> mvn package; sudo java -cp target/LetterGame-0.0.0-SNAPSHOT.jar fr.esiea.unique.cosson_hayotte.game.main**

## Règles du Jeu
Les règles du Jeu sont consultables [ici](https://github.com/MLabusquiere/TP_4A_2017_Letter_Game/blob/master/Readme.md).

## Mode du Jeu
Le joueur peut choisir de jouer seul contre une IA ou affronter jusqu'à 5 joueurs sur la même écran.
L'IA est assez diffcile mais ne peut pas voler de mots, vous avez toutes vos chances de gagner :D !

## Structure du code
Nous avons trois "packages" regroupant par catégories l'ensemble de nos classes :
### game
- main (permet de lancer le Jeu)
- Game (moteur du Jeu)
- Display (permet de gérer l'affichage système du Jeu)
### players
- Player (permet de gérer les informations sur le joueur)
- InputPlayer (permet de gérer toutes les entrées claviers d'un joueur)
- IA (relatif au fonctionnement de l'IA)
### letters
- CommonPot (permet de gérer le pot commun)
- Dictionnary (permet l'interface avec le dictionnaire)
- LetterBag (permet de gérer le sac de lettres)

Le dictionnaire se situe dans le dossier "ressources" du projet (src/main/ressources) et le fichier contenant l'ensemble des tests se situe dans le dossier "tests" (src/test/java).

## Consignes
- [x] Réaliser un programme sous Java
- [x] Implémenter toutes les fonctionnalités attendues par l'enseignant
- [x] Réaliser des tests unitaires (ces tests couvrent actuellement plus de 70% du l'ensemble du code, vérifiés par le plug-in EclEmma)
- [x] Utilisation de Maven pour compiler et lancer le programme
- [x] Utlisation du plug-in FindBugs pour établir une analyse statique du code

## Fonctionnalités
- [x] Mode Multi-joueurs (2-5)
- [x] Mode IA | Solo
- [x] Tests unitaires JUnit
- [x] Possibilité de voler un mot à l'adversaire ou à soi-même (en complétant avec une/plusieurs lettres du pot commun) ou en anagramme
