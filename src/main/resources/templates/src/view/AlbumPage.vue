<template>
    <div id="album-page">
        <div id="left-side">
            <LeftMain />
        </div>
        <div id="main-album" v-if="response.image">
            <div id="top-main-content">
                <UserTop />
            </div>
            <div id="album-content">
                <div id="top-content-album">
                    <div id="picture">
                        <img :src='response.image'>
                    </div>
                    <div id="text">
                        <div id="name">
                            <span> {{ response.name }}</span>
                        </div>
                        <div id="user">
                            <router-link :to="'/artist/' + response.artist.id" style="text-decoration: none; color: inherit;" @click=updateStore.update()>
                                <span>{{ response.artist.name }}</span>
                            </router-link>
                            <span>{{ - response.date }} - </span>
                            <span>{{ nbSong }} musiques</span>
                        </div>
                    </div>
                </div>
                <div id="music">
                    <TableMusic :musics="response.songs" />
                </div>
            </div>
        </div>
    </div>
</template>

<script>
      
import LeftMain from '../components/LeftMain.vue';
import TableMusic from '../components/TableMusic.vue';
import UserTop from '../components/UserTop.vue';
import { onBeforeMount, ref, onServerPrefetch } from 'vue';
import { useRoute } from 'vue-router';
import { useToast } from 'vue-toastification';
import { useQueryStore } from '@/store/queryStore';
import { useUserStore } from '@/store/userStore';
import { useUpdateStore } from '@/store/updateStore';

export default {
    setup() {
        const queryStore = useQueryStore();
        const userStore = useUserStore();
        const updateStore = useUpdateStore();
        const route = useRoute();
        const toast = useToast();
        
        const response = ref({});
        const nbSong = ref(0);
        
        const fetchingData = async () => {
            
            if( !route.params.id) {
                route.push('/pagePrincipale')
                toast.error("Erreur lors de la récupération de la playlist : playlist inexistante");
                return;
            }

            let tmp = await queryStore.fetchAlbum(route.params.id);
            response.value = {id: tmp.id, name: tmp.name, artist: tmp.artist, date: tmp.date, image: tmp.image, songs: []}

            for(let item of tmp.songs) {
                let suppr = [];
                let items = [];
                //item.time = Math.floor(item.time / 60) + ':' + (item.time % 60 < 10 ? '0' : '') + item.time % 60;
                suppr = await queryStore.getPlaylistWithMusic(item.id);
                items = [];
                userStore.playlist.forEach((val) => items.push({id: val.id, name: val.name}));
            
                for(let album of suppr) 
                    items = items.filter((val) => val.id !== album.id);

                if(userStore.musiqueLike.includes(item.id))
                    suppr.push({id: "like", name: "Favoris"});
                else
                    items.push({id: "like", name: "Favoris"});

                response.value.songs.push({id: item.id, name: item.name, artist: item.artist, album: item.album, time: item.time, items: items, suppr: suppr, photo: item.photo, music: item.music, nbLikes: item.nbLikes});
            }

            nbSong.value = response.value.songs.length; 
        }

        onServerPrefetch(async () => {await fetchingData()});
    
        onBeforeMount( async () => {
            await fetchingData();    
            });
        

        return {response, nbSong, updateStore};
    },
    name: "AlbumPage",
    components:{
        LeftMain,
        TableMusic,
        UserTop,
    },
    data(){
    }
}
</script>

<style scoped>
    #album-page{
        display:flex;
        margin-bottom: 100px;
        overflow: auto;
    }
    #album-content{
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
    #top-content-album{
        text-align: left;
        margin-left: 50px;
        display: flex;
        padding-top: 30px;
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