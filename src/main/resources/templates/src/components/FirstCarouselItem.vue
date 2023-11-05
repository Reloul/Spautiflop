<template>
  <div id="first-item">
    <div id="test">
        <v-icon icon="mdi-arrow-left" color="#a7bed3" size="20" id="icon-left"></v-icon>
        <span>Faites défiler pour découvrir des musiques</span>
        <v-icon icon="mdi-arrow-right" color="#a7bed3" size="20" id="icon-right"></v-icon>
    </div>
    <div id="carte">
        <CarteMusique :img="img" :music="music" :artist="artist" :nbLike="nbLike" :isLike="isLike" :src="src" :time="time" :home="home"/>
        <CarteMusique :img="img" :music="music" :artist="artist" :nbLike="nbLike" :isLike="isLike" :src="src" :time="time" :home="home" />
        <CarteMusique :img="img" :music="music" :artist="artist" :nbLike="nbLike" :isLike="isLike" :src="src" :time="time" :home="home" />
    </div>

  </div>
</template>

<script>
import CarteMusique from './CarteMusique.vue'
export default {
    name: "FirstCarouselItem",
    components: {
        CarteMusique,
    },
    data (){
        return{
            img: require("../../../static/V4.jpg"),
            music: 'Moonless',
            artist: 'Fl3r',
            nbLike: 8900,
            isLike: true,
            src: require('../../../static/Moonless.mp3'),
            time: '2:34',
            home: true,
        }
    }
}
</script>

<style scoped>
    #first-item{
        margin-top: -60px;
    }
    #test{
        margin-bottom: 30px;
        color: #A7BED3;
        font-size: 20px;
        text-align: center;
    }
    #carte{
        justify-content: space-around;
        display: flex;
    }

    #icon-left{
        padding-right: 50px;
    }
    #icon-right{
        padding-left: 50px;
    }
</style>