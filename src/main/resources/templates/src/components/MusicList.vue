<template>
    <div id="list-music">
        <div id="img-music">
            <img :src="img">
        </div>
        <div id="pres-song">
            <div id="music-name">
                <span> {{ music }}</span>
            </div>
            <div id="artist-name">
                <span> {{ artist }}</span>
            </div>
        </div>
        <div id="icon-play">
            
            <v-icon icon="mdi-play" color="#ead2ac" @click="cliquePlay"></v-icon>
        </div>
        <div id="like">
            <img :src="require('../../../static/heart.png')" alt="Picture of like" :style="{ filter: like ? 'saturate(100%)':'saturate(0%)' }" @click="cliqueLike">
        </div>
        <div id="time">
            <span> {{ time }} </span>
        </div>
    </div>
</template>

<script>

import {ref} from 'vue';
import { useMusicStore } from '../stores/MusicStore.js';

export default {
    name: 'MusicList',
    props:{
        img: String,
        music: String,
        artist: String,
        isLike: Boolean,
        time: String,
        src: String,
    },
   
    setup(props) {
        const like = ref(props.isLike);
        const musicStore = useMusicStore();
        const cliquePlay = function(){
            const musicData = {
                img: props.img,
                music: props.music,
                artist: props.artist,
                isLike: props.isLike,
                time: props.time,
                src: props.src,
            };
            musicStore.changeSong(musicData);
        };

    
        const cliqueLike = () => {
            like.value = !like.value; // Inversez la valeur de isLike lors du clic

        }

        return {cliqueLike, cliquePlay, musicStore, like}
    },
}
</script>

<style scoped>
    #list-music{
        display: flex;
        margin-top: 10px;
    }

    #img-music img{
        height: 60px;
        widows: 60px;
        border-radius: 10px;
        margin-right: 20px;
        object-fit: cover;
    }

    #like img{
        height: 30px;
        cursor: pointer;
    }

    #pres-song{
        text-align: left;
        margin-top: 8px;
        color: #b9d1db;
        margin-right: 20px;
        display: block;
    }
    #icon-play{
        margin-right: 16vw;
        margin-top: 10px;
    }
    #music-name{
        font-size: 18px;
        width: 150px;
    }
    #artist-name{
        font-size: 15px;
    }

    #like{
        margin-top: 10px;
        margin-right: 40px;
    }

    #time{
        margin-top: 15px;
        color: #b9d1db;
        text-align: right;  
    }
</style>