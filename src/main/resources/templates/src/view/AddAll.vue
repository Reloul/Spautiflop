<template>
  <div id="main-add-all">
    <div id="add-music">
         <router-link to="/ajoutMusique" style="text-decoration: none; color: inherit;">
            <span>
                <u>Ajouter votre Musique</u>
            </span>
         </router-link>
    </div>
    <div id="add-all">
        <div id="album">
            <AddAlbum />
        </div>
        <div id="artist">
            <AddArtist />
        </div>
    </div>
  </div>
</template>

<script>
import AddAlbum from '../components/AddAlbum.vue'
import AddArtist from '../components/AddArtist.vue'

export default {
    name:"AddAll",
    components:{
        AddAlbum,
        AddArtist,
    }
}
</script>

<style scoped>
    #add-all{
        display: flex;
    }
    #add-music{
        float: left;
        color: #b9d1db;
        padding: 20px;
        font-size: 20px;
    }
    #artist{
        margin-left: 150px;
        margin: auto;
    }
</style>
