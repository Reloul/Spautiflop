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
    <div id="popular-general">
        <div id="popular-music" v-for="music in musics" :key="music">
            <CarteMusique :img="music.img" :music="music.music" :artist="music.artist" :nbLike="music.nbLike" :isLike="music.isLike" :src="music.src" :time="music.time"/>
        </div>
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
            musics: [
                {
                    img: require('../../../static/V4.jpg'),
                    music: 'Moonless',
                    artist: 'Fl3r',
                    nbLike: 8900,
                    isLike: false,
                    src: require("../../../static/Moonless.mp3"),
                    time: "2:34",
                },
                {
                    img: require('../../../static/ethereal.jpg'),
                    music: 'E t h e r e a l',
                    artist: 'TOKYOSHIFT',
                    nbLike: 1264,
                    isLike: false,
                    src: require("../../../static/ethereal.mp3")
                },
                {
                    img: 'https://upload.wikimedia.org/wikipedia/commons/thumb/9/91/Bruce_McCandless_II_during_EVA_in_1984.jpg/1200px-Bruce_McCandless_II_during_EVA_in_1984.jpg',
                    music: 'Moonless',
                    artist: 'Fl3r',
                    nbLike: 8900,
                    isLike: false,
                    src: require("../../../static/Moonless.mp3"),
                    time: "2:34",
                },
                {
                    img: 'https://upload.wikimedia.org/wikipedia/commons/thumb/9/91/Bruce_McCandless_II_during_EVA_in_1984.jpg/1200px-Bruce_McCandless_II_during_EVA_in_1984.jpg',
                    music: 'Moonless',
                    artist: 'Fl3r',
                    nbLike: 8900,
                    isLike: false,
                    src: require("../../../static/Moonless.mp3"),
                    time: "2:34",
                },
                {
                    img: 'https://upload.wikimedia.org/wikipedia/commons/thumb/9/91/Bruce_McCandless_II_during_EVA_in_1984.jpg/1200px-Bruce_McCandless_II_during_EVA_in_1984.jpg',
                    music: 'Moonless',
                    artist: 'Fl3r',
                    nbLike: 8900,
                    isLike: false,
                    src: require("../../../static/Moonless.mp3"),
                    time: "2:34",
                },
            ]
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

    #popular-general{
        display: flex;
        justify-content: space-between;
    }
</style>