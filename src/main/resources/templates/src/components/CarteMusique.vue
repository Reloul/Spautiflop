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
            {{ nbLike }}
            <img :src="require('../../../static/heart.png')" alt="Picture of like" :style="{ filter: (userStore.musiqueLike.includes(id)) ? 'saturate(100%)':'saturate(0%)' }" @click="cliqueLike(id)">
        </div>
        <div id="button">
            <a href="##"><v-icon icon="mdi-play" color="green"></v-icon></a>
            <div id="para-song">
                <ParaSong :items="items" :suppr="suppr "/>
            </div>
        </div>
    </div>
  </div>
</template>

<script>
import { onMounted, ref } from 'vue';

import ParaSong from '../components/ParaSong'
import {useUserStore} from '../store/userStore';
import {useRoute} from 'vue-router';

export default {
    setup(props) {
        const route = useRoute();
        const userStore = useUserStore();
        const items = ref([]);
        const suppr = ref([]);

        const cliqueLike = async (index) => {
            if(!userStore.musiqueLike.includes(index)) {
                await userStore.like(index)
                props.nbLike++;
            }
                
            else{
                await userStore.dislike(index)
                props.nbLike--;
            }
                
            if(route.query.id === 'like')
                props.musics.filter((item) => item.id !== index);
        }

        const fetchingData = async () => {
            for(let pl of userStore.playlist){
                items.value.push({title: pl.name});
                suppr.value.push({title: pl.name});
            }
        }

        onMounted(async () => {
            await fetchingData();
        });
      
      return {cliqueLike, userStore}
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
        flex-basis: 200px;
    }
    #carteM #imgM img{
        margin-top: 2vh;
        height: 110px;
        border-radius: 10px;
    }
    #PresM{
        font-size: 20px;
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
