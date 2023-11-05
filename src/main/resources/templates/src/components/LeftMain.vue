<template>
  <div id="left-side">
        <div id="button-search">
            <router-link to="/pagePrincipale" style="text-decoration: none; color: inherit;">
                <div id="icon-button1">
                    <v-icon icon="mdi-magnify" color="#b9d1db" size="x-large"></v-icon>
                    <div id="text-search-button">Rechercher</div>
                </div>
            </router-link>
            <router-link to="/ajoutMusique" style="text-decoration: none; color: inherit;">
                <div id="icon-button2">
                    <v-icon icon="mdi-music-note-plus" color="#b9d1db" size="x-large"></v-icon>
                    <div id="text-search-button">Ajouter Musique</div>
                </div>
            </router-link>
        </div>
        <div id="left-playlist">
            <div id="title-left-playlist">
                <v-icon icon="mdi-music-box-multiple" color="#b9d1db" size="x-large"> </v-icon>
                <div id="text-library-left">Bibliothèque</div>
                <div id="add-playlist">
                    <AddPlaylist />
                </div>
            </div>
            <hr>
            <div id="playlist">
                <div @click="update()">
                    <router-link to="/playlist/like" id="playlist-router">
                        <PlaylistReduce :img="require('../../../static/heart.png')" name="Favoris" :user="userStore.pseudo" @toggle-active="handleToggleActive" :isActive="activePlaylistIndex === -1" :index="-1"/>
                    </router-link>
                    
                </div>  
                <div v-for="pl in userStore.playlist" :key="pl.id" @click="update()">
                   <router-link :to="'/playlist/' + pl.id" id="playlist-router">
                        <PlaylistReduce :img="pl.image" :name="pl.name" :user="userStore.pseudo" @toggle-active="handleToggleActive" :isActive="activePlaylistIndex === pl.id" :index="pl.id"/>
                    </router-link>
                    
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import AddPlaylist from '../components/AddPlaylist.vue';
import PlaylistReduce from './PlaylistReduce.vue'
import {useUserStore} from '../store/userStore'
import {useQueryStore} from '../store/queryStore'
import { useUpdateStore } from '@/store/updateStore';
export default {
    setup() {
        const userStore = useUserStore();
        const queryStore = useQueryStore();
        const updateStore = useUpdateStore();
        const update = () => {
            updateStore.update();
        }

        return { userStore, queryStore, update};
    },
    name : "LeftMain",
    components : {
        PlaylistReduce,
        AddPlaylist,
    },
    data (){
        return{
        activePlaylistIndex: null,
        };
    },
    methods: {
        handleToggleActive(index, isActive) {
            this.activePlaylistIndex = isActive ? index : null;
        },
    },
};
</script>

<style scoped>
    #button-search{
        background-color: #3b4762;
        width: 250px;
        height: 120px;
        margin-left: 2vw;
        margin-top: 4vh;
        border-radius: 10px;
        text-align: left;
        padding: 11px;
        display: block;
        font-size: 20px;
        min-width: 200px;
    }   
    router-link{
        text-decoration: none !important;
    }
    #text-search-button{
        color: #b9d1db;
        padding: 5px;
        margin-left: 10px;
    }

    #left-playlist{
        background-color: #3b4762;
        width: 250px;
        height: 690px;
        margin-left: 2vw;
        margin-top: 15px;
        border-radius: 10px;
        min-width: 200px;
        text-align: left;
        padding: 11px;
        font-size: 20px;
    }

    #title-left-playlist{
        display: flex;
    }
    #text-library-left{
        color: #b9d1db;
        padding: 5px;
        margin-left: 10px;
    }
    hr{
        background-color: #b9d1db;
        border: none;
        height: 2px;
        margin-top: 20px;
    }

    #left-side{
        display: block;
    }
    #playlist{
        margin-top: 30px;
    }
    #playlist-router{
        text-decoration: none;
    }

    #add-playlist{
        margin: auto;
    }

    #icon-button1{
        display: flex;
    }

    #icon-button2{
        display: flex;
        margin-top: 15px;
    }
</style>