<template>
  <div id="main-page">
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
        </div>
    </div>
    <div id="main-content">
        <div id="top-main-content">
            <SearchBar />
            <UserTop />
        </div>
    </div>
  </div>
</template>

<script>

import UserTop from "../components/UserTop.vue";
import SearchBar from "../components/SearchBar.vue";

export default {
    name: "PagePrincipale",
    components : {
        SearchBar,
        UserTop,
    },
}
</script>

<style scoped>
    #button-search{
        background-color: #3b4762;
        width: 13vw;
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
        width: 13vw;
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
        margin-top: 15px;
    }

    #left-side{
        display: block;
    }

    #main-page{
        display: flex;
    }
    #main-content{
        background-color: #3b4762;
        width: 81vw;
        margin-left: 20px;
        margin-top: 4vh;
        border-radius: 10px;
    }

    #top-main-content{
        display: flex;
    }

</style>