<template>
  <div class="central">
    <div class="top">
        <h1>Bienvenu sur Spautiflop, le (presque) premier site de streaming de musique !</h1>
    <hr>
    <h2>Découvrez un large choix de musique et faites vos propres Playlist</h2>
    </div>
    <div class="cardDiapo">
        <v-carousel hide-delimiters ref=carousel>
            <v-carousel-item>
                <div class="slide">
                    <h1> Les musiques les plus like a porté de click  </h1>
                </div>
            </v-carousel-item>
            <v-carousel-item v-for="music in response" :key=music[0].id>
                <div class="slide">
                    <CarteMusique :img="music[0].image" :music="music[0].name" :artist="music[0].artist.name" :nbLike="music[0].nbLikes" :isLike="true" :id="music[0].id" :musicLink="music[0].music"/>
                    <CarteMusique :img="music[1].image" :music="music[1].name" :artist="music[1].artist.name" :nbLike="music[1].nbLikes" :isLike="true" :id="music[1].id" :musicLink="music[1].music" />
                    <CarteMusique :img="music[2].image" :music="music[2].name" :artist="music[2].artist.name" :nbLike="music[2].nbLikes" :isLike="true" :id="music[2].id" :musicLink="music[2].music" />
                </div>
            </v-carousel-item>

        </v-carousel>        

    </div>
  </div>
</template>

<script>
import CarteMusique from '../components/CarteMusique.vue'
import {onMounted, ref} from 'vue'
import {useQueryStore} from '../store/queryStore'
import {useToast} from 'vue-toastification'

export default {
    name: 'AccueilCentral',
    components: {
        CarteMusique,
    },
    setup() {
        const queryStore = useQueryStore();
        const response = ref([]);
        const toast = useToast();
        let nbSong = 0;

        const fetchingData = async () => {
            let tmp = await queryStore.getTopSongs(9);
            if(!tmp)
                toast.error("Erreur lors de la récupération des musiques");
            else {
                let nb = ((tmp.length - (tmp.length % 3)) / 3);
                while(nb > 0) 
                {
                    let page = [];
                    page.push(tmp.pop());
                    page.push(tmp.pop());
                    page.push(tmp.pop());

                    response.value.push(page);
                    nb--;
                }
            }
        }

        //onServerPrefetch(async () => {await fetchingData()});
        onMounted(async () => {
            await fetchingData();
            }); 


      return {response, nbSong}
    },
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