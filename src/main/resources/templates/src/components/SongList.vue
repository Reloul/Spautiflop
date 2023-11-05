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
        <div id="list-song" v-for="music in musics" :key="music.name">
            <MusicList :img="music.img" :music="music.music" :artist="music.artist" :time="music.time" :link="music.link" :id="music.id" />
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
    props: {
        musics: Array,
    },
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