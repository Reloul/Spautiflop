<template>
    <div id="main-add-artist">
        <div id="add-artist">
            <h2>Ajouter un Artiste</h2>
            <form @submit.prevent="handleSubmit">
                <v-text-field label="Nom de l'Artiste" required id="artist" v-model="nameArtist"></v-text-field>
                <v-file-input label="Photo de l'Artiste" variant="filled" accept="image/*" prepend-icon="mdi-camera" id="artist-picture" required v-model="pictureArtist"></v-file-input> 
                <div id="submit">
                    <input type="submit" value="Ajouter l'Artiste">                                           
                </div>
            </form>
        </div>
    </div>
</template>

<script>
export default {
    name: "AddArtist",
     data() {
        return {
            nameArtist: "",
            pictureArtist: [],
        };
    },
    methods: {
        handleSubmit() {
            // Effectuez les actions que vous souhaitez avec this.inputValue
            console.log("Valeur du champ de texte :", this.nameArtist);
            console.log("Valeur du champ de texte :", this.pictureArtist);
            // Appelez votre fonction ici
            this.maFonction(this.nameArtist);
            this.maFonction(this.pictureArtist);
        },
        maFonction(valeur) {
            // Faites quelque chose avec la valeur du champ de texte
            console.log("Fonction appelée avec la valeur :", valeur);
        }
    }


}
</script>

<style scoped>
    #add-artist{
        background-color: #3b4762;
        color: #b9d1db;
        width: 35vw;
        margin: auto;
        margin-top: 20vh;
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
</style>

