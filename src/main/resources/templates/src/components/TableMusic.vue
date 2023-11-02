<template>
    <div id="content">
    <v-table id="table-music" color="#3b4762" theme="dark">
        <thead id="head-table">
            <tr>
                <th class="text-left" id="head-table-music">Musique</th>
                <th class="text-left" id="head-table-music">Album</th>
                <th class="text-left" id="head-table-music">Date</th>
                <th class="text-left" id="head-table-music"></th>
                <th class="text-left" id="head-table-music"> <v-icon icon="mdi-clock-time-five-outline"></v-icon></th>
                <th class="text-left" id="head-table-music-para"></th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="(item, index) in musics" :key="item" id="row-music">
                <td> 
                    <div id="colum-music">
                        <img :src="item.photo" id="img-pres">
                        <div id="text-music">
                            <div id="music-colum-music">
                                <span>{{ item.music }}</span> 
                            </div>
                            <div id="artist-colum-music">
                                <span>{{ item.artist }} </span>
                            </div>
                        </div>
                        <div id="play-button"  @click="togglePlayPause(index)">
                                <v-icon v-if="!isPlaying[index]" icon="mdi-play" color="#ead2ac"></v-icon>
                                <v-icon v-else icon="mdi-pause" color="#ead2ac"></v-icon>
                        </div>
                    </div>
                </td>
                <td> <router-link to="/album" style="text-decoration: none; color: inherit;">{{ item.album }}</router-link></td>
                <td>{{ item.date }}</td>
                <td>
                    <div id="time-row">
                        <img :src="require('../../../static/heart.png')" alt="Picture of like" :style="{ filter: like[index] ? 'saturate(100%)':'saturate(0%)' }" @click="cliqueLike(index)" :id="index">
                    </div>
                </td>
                <td>                                       
                    {{ item.time }}            
                </td>
                <td id="td-para">
                    <ParaSong :items="items" :suppr="suppr" />
                </td>
            </tr>
        </tbody>
    </v-table>
</div>
</template>

<script>
import {ref} from 'vue'
import ParaSong from '../components/ParaSong.vue';

export default {
    name:"TableMusic",
    components:{
        ParaSong,
    },
    setup(props) {
        const like = ref(Array(props.musics.length).fill(props.isLike));
        const isPlaying = ref(Array(props.musics.length).fill(false));
        
        const cliqueLike = (index) => {
            like.value[index] = !like.value[index]; // Inversez la valeur de isLike lors du clic
        }

        const togglePlayPause = (index) => {
            isPlaying.value = isPlaying.value.map((_, i) => i === index);
        }

        return { cliqueLike, like, isPlaying, togglePlayPause };
    },
    props: {
        music: String,
        photo: String,
        artist: String,
        album: String,
        date: String,
        time: String,
        isLike: Boolean,
        musics: Array,
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
    
    #table-music{
        background-color: #3b4762 !important;
        color: #b9d1db;
        margin-left: 50px;
        text-align: left;
        margin-right: 50px;
    }
    #head-table-music{
        color: #b9d1db;
    }
     #img-pres{
        height: 60px;
        width: 60px;
        object-fit: cover;
    }
    #colum-music{
        display: flex;
    }
    #text-music{
        margin-top: 20px;
        margin-left: 10px;
    }
    #artist-colum-music{
        font-size: 12px;
    }
    #row-music{
        height: 90px;
    }
   
    #time-row img{
        height: 30px;
    }

    #time-row{
        margin-top: -5px;
        float: right;
    }
    #time-row-music{
        margin-top: 8px;
    }
    #playlist{
        margin-top: 4vh;
    }
    #play-button{
        margin: auto;
        margin-left: 20px;
    }

    #td-para{
        width: 5px;   
    }
</style>

<style>
    #para-add-song{
        color: #b9d1db;
    }
</style>
