<template>
  <div id="popular">
    <div id="popular-title">
        <div id="span-cat">
            <span> {{ nameCat }}</span>
        </div>
        <div id="hr-cat">
            <hr>
        </div>
    </div>
    <div id="popular-general">
        <div id="popular-music" v-for="music in musics" :key="music.id">
            <CarteMusique :img="music.img" :music="music.name" :artist="music.artist" :nbLike="music.nbLikes" :id="music.id" :musicLink="music.music"/>
        </div>
    </div>
  </div>
</template>

<script>

import CarteMusique from './CarteMusique.vue'
import {onMounted, ref} from 'vue'
import {useQueryStore} from '../store/queryStore'
import {useToast} from 'vue-toastification'

export default {
    setup(props) {
        const toast = useToast();
        const queryStore = useQueryStore();
        const musics = ref([]);

        const fetchingData = async () => {
            const response = await queryStore.fetchJwtJson(props.fetchLink);
            if(queryStore.HttpCode !== 200)
                toast.error("Erreur lors de la récupération des musiques");
           
           else {
                for(let music of response){
                    musics.value.push({
                        id: music.id,
                        img: await queryStore.fetchImage(music.image),
                        name: music.name,
                        artist: music.artist,
                        nbLikes: music.nbLikes,
                        music: await queryStore.fetchAudio(music.musicLink),
                    });
                }
            }
        }

        //onServerPrefetch(async () => {await fetchingData()});
        onMounted(async () => {
            await fetchingData();
            }); 


      return {musics}
    },
    name:  "PopularSong",
    components: {
        CarteMusique,
    },
    props: {
        nameCat : String,
        fetchLink: String
    }
}
</script>

<style scoped>

    #popular{
        margin-left: 50px;
        margin-top: 8vh;
        text-align: left;
        z-index: 1;
    }
    #popular-title hr{
        border: none;
        height: 2px;
        background-color: #b9d1db;
        width: 40vw;
        display: flex;
        min-width: 300px;
    }
    #popular-title span{
        color: #b9d1db;
        background-color: #3b4762;
        font-size: 20px;
        margin-left: 3vw;
        padding: 10px;
    }
    #span-cat{
        width: 40vw;
    }
    #hr-cat{
        margin-top: -10px;
    }

    #popular-music{
        margin-top: 6vh;
        text-align: center;
    }

    #popular-general{
        flex-wrap: wrap;
        display: flex;
        justify-content: space-around;
    }
</style>