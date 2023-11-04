<template>
    <div id="song-list">
        <div id="title">
            <div id="span-title">
                <span>Musiques</span>
            </div>
            <div id="hr-title">
                <hr>
            </div>
        </div>
        <div id="list-song" v-for="(music, index) in musics" :key="index">
            <MusicList :img="music.img" :music="music.music" :artist="music.artist" :isLike="music.isLike" :time="music.time" :src="music.src"/>
        </div>
    </div>
</template>

<script>
import MusicList from '../components/MusicList.vue'
export default {
    name: "SongList",
    components: {
        MusicList,
    },
    data() {
        return{
            musics: [
                {
                   img: require('../../../static/V4.jpg'),
                   music: "Moonless",
                   artist: "Fl3r",
                   isLike: false,
                   time: "2:36", 
                   src: require('../../../static/Moonless.mp3'),
                },
                {
                   img: require('../../../static/ethereal.jpg'),
                   music: "Ethereal",
                   artist: "TOKYOPILL",
                   isLike: false,
                   time: "1:38", 
                   src: require('../../../static/ethereal.mp3'),
                },
                {
                   img: require('../../../static/V4.jpg'),
                   music: "Moonless",
                   artist: "Fl3r",
                   isLike: false,
                   time: "2:36", 
                   src: require('../../../static/Moonless.mp3'),
                },
                {
                   img: require('../../../static/V4.jpg'),
                   music: "Moonless",
                   artist: "Fl3r",
                   isLike: false,
                   time: "2:36", 
                   src: require('../../../static/Moonless.mp3'),
                },
            ]
        }
    }
}
</script>

<style scoped>
     #span-title span{
        background-color: #3b4762;
        color: #b9d1db;
        margin-left: 3vw;
        font-size: 20px;
        padding: 10px;
    }
    #span-title{
        width: 150px;
    }
    #hr-title hr{
        border: none;
        height: 2px;
        background-color: #b9d1db;
        display: flex;
        min-width: 300px;
    }

    #hr-title{
        margin-top: -10px;
    }

    #song-list{
        margin-left: 10vw;
        width: 35vw;
    }
    #title{
        margin-bottom: 40px;
    }
</style>