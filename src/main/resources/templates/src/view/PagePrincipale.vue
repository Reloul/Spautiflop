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
        <div id="mid-main-content">
            <PopularSong />
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
}
</script>

<style scoped>

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