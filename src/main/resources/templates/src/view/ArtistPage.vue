<template>
    <div id="artist-page" >
        <div id="left-side">
            <LeftMain />
        </div>
        <div id="main-artist" v-if="response.image">
            <div id="top-main-content">
                <UserTop />
            </div>
            <div id="top-artist-page">
                <div id="img-artist">
                    <img :src="response.image">
                </div>
                <div id="artist-name">
                    <span> {{ response.name }} </span>
                </div>
            </div>
            <div id="artist-content">
                <div id="artist-top-music">
                    <TableMusic :musics="response.bestSongs"/>
                </div>
                <div id="artist-album">
                    <AlbumPart :albums="response.albums" />
                </div>
            </div>
        </div>
    </div>
</template>

<script>

import AlbumPart from '../components/AlbumPart.vue';
import LeftMain from '../components/LeftMain.vue';
import TableMusic from '../components/TableMusic.vue';
import UserTop from "../components/UserTop.vue";
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
        
        const fetchingData = async () => {
            
            if( !route.params.id) {
                route.push('/pagePrincipale')
                toast.error("Erreur lors de la récupération de l'artiste : artiste inexistante");
                return;
            }

            let tmp =  await queryStore.fetchArtist(route.params.id);
            response.value = {id: tmp.id, name: tmp.name, image: tmp.image, bestSongs: [], albums: tmp.albums};

            for(let item of tmp.bestSongs) {
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

                response.value.bestSongs.push({id: item.id, name: item.name, artist: item.artist, album: item.album, time: item.time, items: items, suppr: suppr, photo: item.photo, music: item.music, nbLikes: item.nbLikes});
            }
        }

        onServerPrefetch(async () => {await fetchingData()});
    
        onBeforeMount( async () => {
            await fetchingData();    
            });
        

        return {
            response,
            updateStore
            };
    },
    name:"ArtistPage",
    components:{
        LeftMain,
        UserTop,
        TableMusic,
        AlbumPart,
    },
    data() {
        return{
            img: require('../../../static/ppCouz.jpg'),
            name: "Fl3r",
            musics: [
                {
                    music: "Moonless",
                    photo: require("../../../static/V4.jpg"),
                    artist: "Fl3r",
                    album: "Moonless",
                    date: "22 oct. 2023",
                    time: "2:34",
                    isLike: true,
                },
                {
                    music: "Random",
                    photo: require("../../../static/heart.png"),
                    artist: "Moi",
                    album: "Random",
                    date: "21 sept. 2023",
                    time: "2:25",
                    isLike: true,
                },
                {
                    music: "Moonless",
                    photo: require("../../../static/V4.jpg"),
                    artist: "Fl3r",
                    album: "Moonless",
                    date: "22 oct. 2023",
                    time: "2:34",
                    isLike: true,
                },
                {
                    music: "Moonless",
                    photo: require("../../../static/V4.jpg"),
                    artist: "Fl3r",
                    album: "Moonless",
                    date: "22 oct. 2023",
                    time: "2:34",
                    isLike: true,
                },
            ]
        }
    }

}
</script>

<style scoped>
    #artist-page{
        display: flex;
        overflow: auto;
        margin-bottom: 100px;
    }

    #main-artist{
        background-color: #3b4762;
        width: 81vw;
        min-width: 1100px;
        margin-left: 20px;
        margin-top: 4vh;
        border-radius: 10px;
    }

    #top-artist-page{
        display: flex;
        background-color: #344c83;
        padding: 50px;
        background: linear-gradient(to bottom, #344c83, #3b4762);
    }

    #top-artist-page img{
        height: 300px;
        border-radius: 50%;
        box-shadow: 0px 0px 60px #273043;
    }

    #artist-album{
        margin-left: 50px;
        margin-top: 3vh;
    }

    #artist-name{
        color: #a7bed3;
        font-size: 80px;
        font-weight: bold;
        margin: auto;
        margin-left: 50px;
    }
</style>