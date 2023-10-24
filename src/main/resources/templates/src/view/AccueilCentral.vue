<template>
  <div class="central">
    <div class="top">
        <h1>Bienvenu sur Spautiflop, le (presque) premier site de streaming de musique !</h1>
    <hr>
    <h2>Découvrez un large choix de musique et faites vos propres Playlist</h2>
        
    </div>
    <div class="cardDiapo">

        <v-carousel hide-delimiters>
            <v-carousel-item v-for="i in 3" :key=i>
                <div class="slide">

                <CarteMusique :img="img" :music="music" :artist="artist" :nbLike="nbLike" :isLike="isLike"/>
                <CarteMusique :img="img" :music="music" :artist="artist" :nbLike="nbLike" :isLike="isLike" />
                <CarteMusique :img="img" :music="music" :artist="artist" :nbLike="nbLike" :isLike="isLike" />
                </div>
            </v-carousel-item>

        </v-carousel>        

    </div>
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
            img: '../assets/imgFolder/heart.png',
            music: 'Moonless',
            artist: 'Fl3r',
            nbLike: 8900,
            isLike: true,
        }
    }
}
</script>

<style scoped>
    
    
    .central{
        display: flex;
        flex-direction: column;
        background-color: #3b4762;
        width: 70vw;
        height: auto;
        max-height: 80vh;
        border-radius: 10px;
        text-align: center;
        margin:auto;
    }

    hr{
        height: 3px;
        background-color: #A7BED3;
        border: none;
        width: 60vw;
        margin-top: 2rem;
        margin-bottom: 1rem ;
    }

    .top {
        position: relative;
        display: flex;
        flex-direction: column;
        gap: 2vh;
        margin: 5vh 5vw;
    }

    .top h1{
        font-size: 50px;
        color: #A7BED3;
        position: relative;
    }

    .top h2{
        font-size: 30px;
        color: #A7BED3;
        position: relative;
    }

    .cardDiapo{
        position: relative;
        width: 100%;
        padding: 0 5vw;
        margin-top: -4rem;
    }

    .slide {
        position: relative;
        display: flex;
        flex-direction: row;
        justify-content: space-evenly;
        align-items: center;
        height: 100%;
    }
    
   
</style>