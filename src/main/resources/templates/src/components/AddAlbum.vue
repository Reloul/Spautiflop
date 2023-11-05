<template>
    <div id="main-add-album">
        <div id="add-album">
            <h2>Ajouter un Album</h2>
            <div id="form-album">
                <form @submit.prevent="handleSubmit">
                    <v-text-field label="Nom de l'Album" required id="album" v-model="inputAlbumName"></v-text-field>
                    <v-text-field label="Nom de l'Artiste" required id="artist-song" v-model="inputAlbumArtist"></v-text-field>
                    <div id="input-date">
                        <input type="date" required id="album-date" v-model="inputAlbumDate">
                        <hr>
                    </div>
                    <v-file-input ref=image label="Image de l'Album" variant="filled" accept="image/*" prepend-icon="mdi-camera" id="song-picture" required v-model="inputAlbumPicture"></v-file-input> 
                    <div id="submit">
                        <input type="submit" value="Ajouter l'Album">                                           
                    </div>
                </form>
            </div>
        </div>
    </div>
</template>

<script>
import { VDatePicker } from 'vuetify/labs/VDatePicker'
import { ref } from "vue";
import { useToast } from "vue-toastification";
import { useQueryStore } from "../store/queryStore";


export default {
    setup() {
        const image = ref(null)
        const toast = useToast();
        const queryStore = useQueryStore();

        return {
            image,
            toast,
            queryStore,
        }
    },
    name: "AddAlbum",
     components: {
        VDatePicker,
    },
     data() {
        return {
            inputAlbumName: "",
            inputAlbumArtist: "",
            inputAlbumDate: "",
            inputAlbumPicture : [],
        };
    },
    methods: {
        handleSubmit() {
            console.log(this.inputAlbumDate);

            const formData = new FormData();
            formData.append("name", this.inputAlbumName);
            formData.append("artist", this.inputAlbumArtist);
            formData.append("release", this.inputAlbumDate.split("-").reverse().join("-"));
            formData.append("cover", this.image.files[0]);

            if(this.queryStore.createAlbum(formData))
                this.toast.success("Album ajouté avec succès");
            else
                this.toast.error("Erreur lors de l'ajout de l'album");
            
        },
    }


}
</script>

<style scoped>
    #add-album{
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

    #input-date{
        text-align: left;
        background-color: #67759934;
        border-radius: 2px;
        margin-bottom: 20px;
        opacity: 60%;
    }
    #input-date hr{
        border-color: #b9d1db;
        border-width: 1px;
    }

    #input-date input{
        color: #b9d1db;
        padding: 13px;
        color-scheme: dark;
    }

    #input-date input:focus{
        outline: none;
    }

    #input-date img{
        color: #b9d1db;
    }
   
</style>
