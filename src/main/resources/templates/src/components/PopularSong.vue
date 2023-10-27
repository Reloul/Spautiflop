<template>
  <div id="popular">
    <div id="popular-title">
        <div id="span-cat">
            <span> {{ nameCat }}</span>
        </div>
        <div id="hr-cat">
            <hr>
        </div>
    </div>
    <div id="popular-music">
        <CarteMusique :img="img" :music="music" :artist="artist" :nbLike="nbLike" :isLike="isLike"/>
        <CarteMusique :img="img" :music="music" :artist="artist" :nbLike="nbLike" :isLike="isLike" />
        <CarteMusique :img="img" :music="music" :artist="artist" :nbLike="nbLike" :isLike="isLike" />
        <CarteMusique :img="img" :music="music" :artist="artist" :nbLike="nbLike" :isLike="isLike" />
        <CarteMusique :img="img" :music="music" :artist="artist" :nbLike="nbLike" :isLike="isLike" />
    </div>
  </div>
</template>

<script>

import CarteMusique from './CarteMusique.vue'

export default {
    name:  "PopularSong",
    components: {
        CarteMusique,
    },
    props: {
        nameCat : String
    },
    data(){
        return{
            img: 'https://upload.wikimedia.org/wikipedia/commons/thumb/9/91/Bruce_McCandless_II_during_EVA_in_1984.jpg/1200px-Bruce_McCandless_II_during_EVA_in_1984.jpg',
            music: 'Moonless',
            artist: 'Fl3r',
            nbLike: 8900,
            isLike: false,
        }
    }
}
</script>

<style scoped>

    #popular{
        margin-left: 50px;
        margin-top: 8vh;
        text-align: left;
        z-index: 1;
    }
    #popular-title hr{
        border: none;
        height: 2px;
        background-color: #b9d1db;
        width: 40vw;
        display: flex;
        min-width: 300px;
    }
    #popular-title span{
        color: #b9d1db;
        background-color: #3b4762;
        font-size: 20px;
        margin-left: 3vw;
        padding: 10px;
    }
    #span-cat{
        width: 40vw;
    }
    #hr-cat{
        margin-top: -10px;
    }

    #popular-music{
        margin-top: 6vh;
        width: 70vw;
        display: flex;
        justify-content: space-between;
        text-align: center;
        flex-wrap: wrap;
    }
</style>