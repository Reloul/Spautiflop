<template>
  <div id="carteM">
    <div id="imgM">
        <img :src="img" alt="Picture of the music">
    </div>
    <div id="PresM">
        <p>{{ music }} - {{ artist.name }}</p>
    </div>
    <div id="bottomCard">
        <div id="like">
            {{ likes }}
            <img :src="require('../../../static/heart.png')" alt="Picture of like" :style="{ filter: (isLike ||userStore.musiqueLike.includes(id)) ? 'saturate(100%)':'saturate(0%)' }" @click="cliqueLike(id)">
        </div>
        <div id="button">
            <v-icon icon="mdi-play" color="green" @click="cliquePlay"></v-icon>
            <div id="para-song" v-if="!isLike">
                <ParaSong :items="items" :suppr="suppr" :id="id" :color="color"/>
            </div>
        </div>
    </div>
  </div>
</template>

<script>
import ParaSong from '../components/ParaSong.vue';
import { onMounted, ref } from 'vue';
import {useUserStore} from '../store/userStore';
import {useQueryStore} from "../store/queryStore";
import { useMusicStore } from '../stores/MusicStore.js'

export default {
    setup(props) {
        const userStore = useUserStore();
        const queryStore = useQueryStore();
        const items = ref([]);
        const suppr = ref([]);
        const likes = ref(props.nbLike)

        const cliqueLike = async (index) => {
            if(props.isLike)
                return

            if(!userStore.musiqueLike.includes(index)) {
                await userStore.like(index)
                likes.value++;
            }
                
            else{
                await userStore.dislike(index)
                likes.value--;
            }
        }

        onMounted(async () => {
            if(props.isLike)
                return 
            let tmpI = [];
            let tmpS = await queryStore.getPlaylistWithMusic(props.id);
            userStore.playlist.forEach((val) => tmpI.push({id: val.id, name: val.name}));
            
            for(let album of tmpS) 
                tmpI = tmpI.filter((item) => item.id !== album.id);

            if(userStore.musiqueLike.includes(props.id))
                tmpS.push({id: "like", name: "Favoris"});
            else
                tmpI.push({id: "like", name: "Favoris"});

            for(let item of tmpI)
                items.value.push(item);
            
            for(let item of tmpS)
                suppr.value.push({id: item.id, name: item.name});

        });

        const musicStore = useMusicStore();
        const cliquePlay = function(){
            const musicData = {
                img: props.img,
                music: props.music,
                artist: props.artist.name,
                src: props.musicLink,
            };
            musicStore.changeSong(musicData);
        };


      return {
        cliqueLike,
        userStore,
        likes,
        items,
        suppr,
        cliquePlay,
        musicStore
        }
    },
    name : 'CarteMusique',
    components:{
        ParaSong,
    },
    props : {
        img: String,
        music: String,
        artist: String,
        nbLike: Number,
        isLike: {
            type: Boolean,
            default: false,
        },
        id: {
            type: Number,
            required: true,
        },
        musicLink: String,
    },
}

</script>


<style scoped>
    #carteM{
        background-color: #ead2ac;
        width: 217px;
        height: 217px;
        border-radius: 10px;
        color: #273043;
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
        margin-right: 15px;
        margin-left: 15px;
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
