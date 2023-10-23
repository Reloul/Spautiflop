<template>
  <div id="Central">
    <h1>Bienvenu sur Spautiflop, le (presque) premier site de streaming de musique !</h1>
    <hr>
    <h2>Découvrez un large choix de musique et faites vos propres Playlist</h2>
    <div id="CardDiapo">
        <swiper :slides-per-view="3" :space-between="50" v-bind:navigation="true" :pagination="true" :scrollbar="true" @progress="onProgress" @swiper="onSwiper" @slideChange="onSlideChange">
            <swiper-slide><CarteMusique :img="img" :music="music" :artist="artist" :nbLike="nbLike" :isLike="isLike" :imgL="imgL"/></swiper-slide>
            <swiper-slide><CarteMusique :img="img" :music="music" :artist="artist" :nbLike="nbLike" :isLike="isLike" :imgL="imgL"/></swiper-slide>
            <swiper-slide><CarteMusique :img="img" :music="music" :artist="artist" :nbLike="nbLike" :isLike="isLike" :imgL="imgL"/></swiper-slide>
            <swiper-slide><CarteMusique :img="img" :music="music" :artist="artist" :nbLike="nbLike" :isLike="isLike" :imgL="imgL"/></swiper-slide>
            <swiper-slide><CarteMusique :img="img" :music="music" :artist="artist" :nbLike="nbLike" :isLike="isLike" :imgL="imgL"/></swiper-slide>
            <swiper-slide><CarteMusique :img="img" :music="music" :artist="artist" :nbLike="nbLike" :isLike="isLike" :imgL="imgL"/></swiper-slide>
            <swiper-slide><CarteMusique :img="img" :music="music" :artist="artist" :nbLike="nbLike" :isLike="isLike" :imgL="imgL"/></swiper-slide>

        </swiper> 

    </div>
  </div>
</template>

<script>
import CarteMusique from '../components/CarteMusique.vue'
import { Swiper, SwiperSlide } from 'swiper/vue';
import SwiperCore, { Navigation, Pagination, Scrollbar, A11y } from 'swiper/core';
import 'swiper/css';
import 'swiper/css/navigation';
import 'swiper/css/pagination';
import 'swiper/css/scrollbar';

SwiperCore.use([Navigation, Pagination, Scrollbar, A11y]);


export default {
    name: 'AccueilCentral',
    components: {
        CarteMusique,
        Swiper,
        SwiperSlide,
    },
    data() {
        return{
            img: require('../../../static/V4.jpg'),
            music: 'Moonless',
            artist: 'Fl3r',
            nbLike: 8900,
            isLike: true,
            imgL: require('../../../static/heart.png'),
            swiperOptions: {
                navigation: true,
                pagination: { clickable: true },
                scrollbar: { draggable: true },
            },
        }
    },

}
</script>

<style scoped>
    #Central{
        background-color: #3b4762;
        width: 70vw;
        height: 600px;
        border-radius: 10px;
        text-align: center;
        margin:auto;
    }
    #Central h1{
        top: 4vh;
        font-size: 50px;
        color: #A7BED3;
        position: relative;
    }
    #Central h2{
        bottom: 4vh;
    }
    hr{
        height: 3px;
        background-color: #A7BED3;
        border: none;
        width: 60vw;
        margin-top: 8vh;
        margin-bottom: 5vh;
    }
    #CardDiapo{
        background-color: red;
        margin-top: 50px;
        margin-right: 5vw;
        margin-left: 5vw;
    }

    
   
</style>