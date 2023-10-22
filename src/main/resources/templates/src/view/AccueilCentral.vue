<template>
  <div id="Central">
    <h1>Bienvenu sur Spautiflop, le (presque) premier site de streaming de musique !</h1>
    <hr>
    <h2>Découvrez un large choix de musique et faites vos propres Playlist</h2>
    <CarteMusique :img="img" :music="music" :artist="artist" :nbLike="nbLike" :isLike="isLike" :imgL="imgL"/>
  </div>
</template>

<script>
import CarteMusique from '../components/CarteMusique.vue'
export default {
    name: 'AccueilCentral',
    components: {
        CarteMusique,
    },
    data() {
        return{
            img: 'https://upload.wikimedia.org/wikipedia/commons/thumb/9/91/Bruce_McCandless_II_during_EVA_in_1984.jpg/1200px-Bruce_McCandless_II_during_EVA_in_1984.jpg',
            music: 'Moonless',
            artist: 'Fl3r',
            nbLike: '8900',
            isLike: 'true',
            imgL: 'https://upload.wikimedia.org/wikipedia/commons/thumb/f/f1/Heart_coraz%C3%B3n.svg/800px-Heart_coraz%C3%B3n.svg.png',
        }
    }
}
</script>

<style scoped>
    #Central{
        background-color: #3b4762;
        width: 70vw;
        height: 70vh;
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
</style>