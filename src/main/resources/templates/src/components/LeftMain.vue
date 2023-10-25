<template>
  <div id="left-side">
        <div id="button-search">
            <v-icon icon="mdi-magnify" color="#b9d1db" size="x-large"></v-icon>
            <div id="text-search-button">Rechercher</div>
        </div>
        <div id="left-playlist">
            <div id="title-left-playlist">
                <v-icon icon="mdi-music-box-multiple" color="#b9d1db" size="x-large"> </v-icon>
                <div id="text-library-left">Bibliothèque</div>
            </div>
            <hr>
            <div id="playlist">
                <PlaylistReduce :img="img" :name="name" :user="user"/>
                <PlaylistReduce :img="img" :name="name" :user="user"/>
            </div>
        </div>
    </div>
</template>

<script>
import PlaylistReduce from './PlaylistReduce.vue'

export default {
    name : "LeftMain",
    components : {
        PlaylistReduce,
    },
    data (){
        return{
            img : require('../../../static/heart.png'),
            name : "Liked",
            user : "Le Couz",
        }
    }
}
</script>

<style scoped>
    #button-search{
        background-color: #3b4762;
        width: 250px;
        height: 60px;
        margin-left: 2vw;
        margin-top: 4vh;
        border-radius: 10px;
        text-align: left;
        padding: 11px;
        display: flex;
        font-size: 20px;
        min-width: 200px;
    }   
    #text-search-button{
        color: #b9d1db;
        padding: 5px;
        margin-left: 10px;
    }

    #left-playlist{
        background-color: #3b4762;
        width: 250px;
        height: 85vh;
        margin-left: 2vw;
        margin-top: 15px;
        border-radius: 10px;
        min-width: 200px;
        text-align: left;
        padding: 11px;
        font-size: 20px;
    }

    #title-left-playlist{
        display: flex;
    }
    #text-library-left{
        color: #b9d1db;
        padding: 5px;
        margin-left: 10px;
    }
    hr{
        background-color: #b9d1db;
        border: none;
        height: 2px;
        margin-top: 20px;
    }

    #left-side{
        display: block;
    }
    #playlist{
        margin-top: 30px;
    }

</style>