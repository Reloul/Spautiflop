<template>
  <div id="main-page">
    <div id="left-side">
        <LeftMain />
    </div>
    <div id="main-content">
        <div id="top-main-content">
            <SearchBar />
            <UserTop />
        </div>
        <div id="mid-main-content" v-for="name in nameCat" :key=name>
            <PopularSong :nameCat="name"/>
        </div>
    </div>
  </div>
</template>

<script>

import UserTop from "../components/UserTop.vue";
import SearchBar from "../components/SearchBar.vue";
import LeftMain from '../components/LeftMain.vue';
import PopularSong from "../components/PopularSong.vue";

export default {
    name: "PagePrincipale",
    components : {
        SearchBar,
        UserTop,
        LeftMain,
        PopularSong,
    },
    data(){
        return{
            nameCat : ["Musiques Populaires","Découverte de Musique"],
        }
    }
}
</script>

<style scoped>

    #main-page{
        display: flex;
        overflow: auto;
        margin-bottom: 100px;
        overflow-x:inherit
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

    #left-size{
        position: fixed;
    }

</style>