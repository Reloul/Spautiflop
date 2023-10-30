<template>
    <div id="list-music">
        <div id="img-music">
            <img :src="img">
        </div>
        <div id="pres-song">
            <div id="music-name">
                <span> {{ music }} </span>
            </div>
            <div id="artist-name">
                <span> {{ artist }}</span>
            </div>
        </div>
        <div id="icon-play">
            <v-icon icon="mdi-play" color="#ead2ac"></v-icon>
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

export default {
    name: 'MusicList',
    setup(props) {
        const like = ref(props.isLike);
        
        const cliqueLike = () => {
            like.value = !like.value; // Inversez la valeur de isLike lors du clic
        }

        return {cliqueLike, like}
    },
    props:{
        img: String,
        music: String,
        artist: String,
        isLike: Boolean,
        time: String,
    }
}
</script>

<style scoped>
    #list-music{
        display: flex;
        margin-top: 10px;
    }

    #img-music img{
        height: 60px;
        border-radius: 10px;
        margin-right: 20px;
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
    }
    #icon-play{
        margin-right: 20vw;
        margin-top: 10px;
    }
    #music-name{
        font-size: 18px;
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