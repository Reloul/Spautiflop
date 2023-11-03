<template>
    <div id="playlist-page">
        <div id="left-side">
            <LeftMain />
        </div>
        <div id="main-playlist">
            <div id="top-main-content">
                <UserTop />
            </div>
            <div id="playlist-content">
                <div id="top-content-playlist">
                    <div id="picture">
                        <img :src='image' alt="">
                    </div>
                    <div id="text">
                        <div id="name">
                            <span> {{ name }}</span>
                        </div>
                        <div id="user">
                            <span>{{ userStore.pseudo }} - </span>
                            <span>{{ nbSong }} musiques</span>
                        </div>
                    </div>
                </div>
                <div id="music">
                    <TableMusic :musics="response" />
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import LeftMain from '../components/LeftMain.vue';
import UserTop from '../components/UserTop.vue';
import TableMusic from '../components/TableMusic.vue';
import { onBeforeMount, onServerPrefetch, ref } from 'vue';
import { useRoute } from 'vue-router';
import { useUserStore } from '../store/userStore';
export default {
    setup() {
        const userStore = useUserStore();
        const route = useRoute();
        
        const response = ref([]);
        const nbSong = ref(0);
        const name = ref('');
        const image = ref('');

        const fetchingData = async () => {
            let tmp;
            
            if(route.params.id != 'like') {
                tmp = await userStore.getPlaylist(route.params.id);
                image.value = tmp.image;
            }
                
            else{
                tmp = await userStore.getFavoris();
                image.value = require("../../../static/heart.png");
            }
            response.value = tmp.musique;
            name.value = tmp.name;
            nbSong.value = response.value.length;
        }

        onServerPrefetch(async () => {await fetchingData()});
    
        onBeforeMount( async () => {
            if(name.value != '')
                return;
            await fetchingData();    
            });
        

        return {response, nbSong, userStore, name, image, nbSong};
    },
    name:"MaPlaylist",
    components: {
        LeftMain,
        UserTop,
        TableMusic,
    },
}
</script>

<style scoped>
    #playlist-page{
        display:flex;
        margin-bottom: 100px;
    }
    #playlist-content{
        background-color: #3b4762;
        width: 81vw;
        margin-left: 20px;
        margin-top: 4vh;
        border-radius: 10px;
        height: 93vh;
        min-height: 825px;
    }
    img{
        height: 300px;
        border-radius: 10px;
    }
    #top-content-playlist{
        text-align: left;
        margin-left: 50px;
        display: flex;
    }
    #text{
        display: block;
        color: #b9d1db;
        margin-top: auto;
        margin-left: 25px;
    }
    #text #name{
        font-size: 100px;
    }
    #text #user{
        font-size: 25px;
        margin-left: 7px;
    }
    #music{
        margin-top: 30px;
    }

</style>