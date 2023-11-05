# Spautiflop
Site web de streaming de musique en JEE avec Spring et VueJS.

## Initialiser le projet

-Pour initialiser les dockers tapez la commande :
```bash
sudo docker-compose up -d
```
-Pour lancer le serveur Java vous pouvez le faire via le fichier ``src/main/java/com/project/jee/spautiflop/SpautiflopApplication.java`` depuis votre IDE préféré.

-Pour initialiser les valeurs dans la base de données:
```bash
cat ./bdd.sql | sudo docker exec -i postgres_container psql -U cytech -d spautiflop
```

## Naviguer sur Spautiflop

Ouvrir le navigateur à l'adresse : [http://localhost:8080/](http://localhost:8080/)

Un compte est déjà disponible dans la BDD, vous pouvez vous connecter en tant que pseudo : BigFlop et mdp : Password1.
Vous êtes désormais sur l'accueil de notre site Spautiflop. Pour accèder au site vous devez vous connectez/inscrire. Vous serez, une fois connectez, redirigez vers la page principale où vous aurez accès à vos playlist, à l'ajout de vos musiques, d'album ou d'artiste qui ne sont pas encore présent sur notre site. Vous pourrez créer vos playlist et y ajouter les musiques que vous voulez ou allant les chercher grâce à notre barre de recherche. 
Vous pourrez également consulter les différents artistes disponibles sur la plateforme en écoutant leurs musiques et en découvrant leurs albums.


© 2023, CY Tech ING2
