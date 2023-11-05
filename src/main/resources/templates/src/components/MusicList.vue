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
                <router-link :to="'/artist/' + artist.id" style="text-decoration: none; color: inherit;">
                    <span> {{ artist.name }}</span>
                </router-link>
            </div>
        </div>
        <div id="icon-play">
            
            <v-icon icon="mdi-play" color="#ead2ac" @click="cliquePlay"></v-icon>
        </div>
        <div id="like">
            <img :src="require('../../../static/heart.png')" alt="Picture of like" :style="{ filter: userStore.musiqueLike.includes(id) ? 'saturate(100%)':'saturate(0%)' }" @click="cliqueLike(id)">
        </div>
        <div id="time">
            <span> {{ time }} </span>
        </div>
    </div>
</template>

<script>
import { useUserStore } from "../store/userStore";
import { useMusicStore } from '../stores/MusicStore.js';
export default {
    setup(props) {
        const userStore = useUserStore();


        const musicStore = useMusicStore();
        const cliquePlay = function(){
            const musicData = {
                img: props.img,
                music: props.music,
                artist: props.artist.name,
                src: props.link,
            };
            musicStore.changeSong(musicData);
        };

        const cliqueLike = async (index) => {
            if(!userStore.musiqueLike.includes(index))
                await userStore.like(index)

            else
                await userStore.dislike(index)
        }

        return {
            cliqueLike,
            cliquePlay,
            userStore,
            musicStore            
        }
    
    },
    name: 'MusicList',
    props:{
        img: String,
        music: String,
        artist: String,
        time: String,
        link: String,
        id: Number,
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
        width: 60px;
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