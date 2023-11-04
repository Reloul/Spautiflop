<template>
    <div id="main-add-music">
        <router-link to="/pagePrincipale" style="text-decoration: none; color: inherit;">
            <div id="accueil">
                    <v-icon icon="mdi-home" color="#b9d1db" size="40"></v-icon>
                    <div id="span-principal">
                        <span>Page Principale</span>
                    </div>
            </div>
        </router-link>
        <div id="ajout">
            <span>
                Vous ne trouvez pas votre artiste ou l'album de la musique? Rajoutez les
                <router-link to="/ajoutAll" style="text-decoration: none; color: inherit;">
                    <u>ici</u>
                </router-link> !
            </span>
        </div>
        <div id="add-music">
            <h2>Ajouter votre Musique</h2>
            <form @submit.prevent="handleSubmit">
                <v-text-field label="Nom de la Musique" required id="music" v-model="inputMusicName"></v-text-field>
                <v-text-field label="Nom de l'Artiste" required id="artist-song" v-model="inputMusicArtist"></v-text-field>
                <v-text-field label="Nom de l'Album/Single" required id="album-song" v-model="inputMusicAlbum"></v-text-field>
                <v-text-field label="Genre de la musique" required id="genre-song" v-model="inputMusicGenre"></v-text-field>
                <v-file-input label="Image de la Musique" variant="filled" accept="image/*" prepend-icon="mdi-camera" id="song-picture" required v-model="inputMusicPicture"></v-file-input>
                <v-file-input label="Fichier de la Musique" variant="filled" accept="audio/*" prepend-icon="mdi-camera" id="song-file" required @change="handleFileChange" v-model="inputMusicLink"></v-file-input>  
                <div id="submit">
                    <input type="submit" value="Ajouter Musique">                                           
                </div>
            </form>
        </div>
    </div>
</template>

<script>
export default {
    name: "AddMusic",
     data() {
        return {
            inputMusicName: "",
            inputMusicArtist: "",
            inputMusicAlbum: "",
            inputMusicGenre: "",
            inputMusicPicture: [],
            inputMusicLink: [],
            audioDuration: null,
        };
    },
    methods: {
        handleSubmit() {
            // Effectuez les actions que vous souhaitez avec this.inputValue
            console.log("nom de la musique :", this.inputMusicName);
            console.log("nom de l'artiste :", this.inputMusicArtist);
            console.log("nom de l'album :", this.inputMusicAlbum);
            console.log("genre de la musique :", this.inputMusicGenre);
            console.log("image de la musique :", this.inputMusicPicture);
            console.log("fichier de la musique :", this.inputMusicLink);

            this.maFonction(this.inputMusicName);
            this.maFonction(this.inputMusicArtist);
            this.maFonction(this.inputMusicAlbum);
            this.maFonction(this.inputMusicGenre);
            this.maFonction(this.inputMusicPicture);
            this.maFonction(this.inputMusicLink);
        },
        handleFileChange(event) { //
            const file = event.target.files[0];
            const reader = new FileReader();

            reader.onload = (event) => {
                const audio = new Audio(event.target.result);
                audio.onloadedmetadata = () => {
                    this.audioDuration = audio.duration;
                    console.log("Durée du fichier audio (en secondes) :", this.audioDuration);
                    this.maFonction(this.audioDuration);
                };
            };
            // Lisez le fichier audio sélectionné (File)
            reader.readAsDataURL(file);
        },
        maFonction(valeur) {
            // Faites quelque chose avec la valeur du champ de texte
            console.log("Fonction appelée avec la valeur :", valeur);
        }
    }


}
</script>

<style scoped>
    #add-music{
        background-color: #3b4762;
        color: #b9d1db;
        width: 50vw;
        margin: auto;
        margin-top: 8vh;
        border-radius: 10px;
    }
    form{
        padding: 50px;
    }
    h2{
        padding-top: 30px;
    }
    #submit{
        text-align: center;
        width: 130px;
        background-color: #465475d8;
        padding: 5px;
        border-radius: 5px;

    }

    #ajout{
        color: #b9d1db;
        text-align: right;
        margin-top: 40px;
        margin-right: 50px;
    }

    #ajout span{
        font-size: 20px;
    }

    #ajout-span span{
        font-size: 18px;
        text-decoration: #b9d1db;
    }
    #accueil{
        float: left;
        margin-left: 50px;
        display: flex;
        background-color: #3b4762;
        border-radius: 10px;
        padding: 10px;
        padding-left: 15px;
    }
    #accueil span{
        margin-left: 20px;
        color: #b9d1db;
        font-size: 20px;
    }
    #span-principal{
        margin: auto;
        padding-right: 5px;
    }
</style>
