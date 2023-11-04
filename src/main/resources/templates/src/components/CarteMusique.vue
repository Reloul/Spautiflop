<template>
  <div id="carteM">
    <div id="imgM">
        <img :src="img" alt="Picture of the music">
    </div>
    <div id="PresM">
        <p>{{ music }} - {{ artist }}</p>
    </div>
    <div id="bottomCard">
        <div id="like">
            {{ nbLike }}
            <img :src="require('../../../static/heart.png')" alt="Picture of like" :style="{ filter: like ? 'saturate(100%)':'saturate(0%)' }" @click="cliqueLike">
        </div>
        <div id="button">
            <v-icon icon="mdi-play" color="green" @click="cliquePlay"></v-icon>
            <div id="para-song">
                <ParaSong :items="items" :suppr="suppr "/>
            </div>
        </div>
    </div>
  </div>
</template>

<script>
import {ref} from 'vue'
import ParaSong from '../components/ParaSong'
import { useMusicStore } from '../stores/MusicStore.js'

export default {
    name : 'CarteMusique',
    components:{
        ParaSong,
    },
    setup(props) {
        const like = ref(props.isLike);
        
        const cliqueLike = () => {
            like.value = !like.value; // Inversez la valeur de isLike lors du clic
        };

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

        return {cliqueLike, like, musicStore, cliquePlay}
    },
    props : {
        img: String,
        music: String,
        artist: String,
        nbLike: Number,
        isLike: Boolean,
        src: String,
        time: String,
    },
    data(){
        return{
            items: [
                { title: 'Favoris' },
                { title: 'playlist couz' },
            ],
            suppr: [
                { title: 'Favorises' },
                { title: 'playlist de couz' },
            ]
        }
    }
}

</script>


<style scoped>
    #carteM{
        background-color: #ead2ac;
        width: 217px;
        height: 217px;
        border-radius: 10px;
        color: #273043;
        flex-basis: 200px;
    }
    #carteM #imgM img{
        margin-top: 2vh;
        height: 110px;
        border-radius: 10px;
    }
    #PresM{
        font-size: 20px;
         white-space: nowrap; /* Empêche le texte de revenir à la ligne */
        overflow: hidden; /* Cache le texte qui dépasse la div */
        text-overflow: ellipsis;
    }
    #like img{
        height: 20px;
    }
    #like {
        text-align: left;
        margin-left: 30px;
        margin-top: -10px;
    }
    #button{
        display: flex;
        margin-left: 90px;
    }
    #para-song{
        margin-left: 25px;
    }
</style>

<style>
    #para-add-song{
        color: #273043;
    }
</style>
