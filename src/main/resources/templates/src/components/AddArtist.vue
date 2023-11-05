<template>
    <div id="main-add-artist">
        <div id="add-artist">
            <h2>Ajouter un Artiste</h2>
            <form @submit.prevent="handleSubmit">
                <v-text-field label="Nom de l'Artiste" required id="artist" v-model="nameArtist"></v-text-field>
                <v-file-input ref=image label="Photo de l'Artiste" variant="filled" accept="image/*" prepend-icon="mdi-camera" id="artist-picture" required v-model="pictureArtist"></v-file-input> 
                <div id="submit">
                    <input type="submit" value="Ajouter l'Artiste">                                           
                </div>
            </form>
        </div>
    </div>
</template>

<script>
import { ref } from "vue";
import { useToast } from "vue-toastification";
import { useQueryStore } from "../store/queryStore";

export default {
    setup(){
        const image = ref(null)
        const toast = useToast()
        const queryStore = useQueryStore()

        return {
            image,
            toast,
            queryStore,
        }
    },
    name: "AddArtist",
     data() {
        return {
            nameArtist: "",
            pictureArtist: [],
        };
    },
    methods: {
        handleSubmit() {
            const formData = new FormData();
            formData.append("name", this.nameArtist);
            formData.append("cover", this.image.files[0]);

            if(this.queryStore.createArtist(formData))
                this.toast.success("Artiste ajouté avec succès");
            else
                this.toast.error("Erreur lors de l'ajout de l'artiste");
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

