<template>
    <div id="top-search">
        <div id="title">
            <div id="span-title">
                <span>Meilleure Recherche</span>
            </div>
            <div id="hr-title">
                <hr>
            </div>
        </div>
        <div id="top-search-card">
            <div id="img-search">
                <img :src="img" alt="">
            </div>
            <div id="text-card">
                <div id="song-name">
                    <span> {{ music }}</span>
                </div>
                <div id="artist-name">
                    <span>{{ artist }}</span>
                </div>
            </div>
            <div id="play">
                <v-icon icon="mdi-play-circle-outline" color="#87bceb" size="70" id="icon-play"  @click="cliquePlay"></v-icon>
            </div>
        </div>
    </div>
</template>

<script>
import { useMusicStore } from '../stores/MusicStore'

export default {
    name: 'TopSearch',
    props: {
        img: String,
        music: String,
        artist: String,
        src: String,
        isLike: Boolean,
        time: String,
    },
    setup(props){
        const musicStore = useMusicStore();
        const cliquePlay = function(){
            const musicData = {
                img: props.img,
                music: props.music,
                artist: props.artist,
                src: props.src, 
            };
            musicStore.changeSong(musicData);
        }

        return{musicStore, cliquePlay};
    }
}
</script>

<style scoped>
    #top-search{
        width: 25vw;
        text-align: left;
        min-width: 350px;
    }
    #span-title span{
        background-color: #3b4762;
        color: #b9d1db;
        font-size: 20px;
        margin-left: 3vw;
        padding: 10px;
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

    #top-search-card{
        background-color: #ead2ac;
        height: 150px;
        border-radius: 10px;
        margin-top: 5vh;
        display: flex;
    }

    #img-search{
        margin-top: 25px;
        margin-left: 20px;
    }
    #img-search img{
        height: 100px;
        border-radius: 10px;
    }

    #text-card{
        margin-left: 15px;
        margin-top: 25px;
        color: #3b4762;
    }

    #song-name{
        font-size: 22px;
    }
    #play{
        text-align: right;
        margin-top: 60px;
        margin-left: 5vw;
    }
</style>