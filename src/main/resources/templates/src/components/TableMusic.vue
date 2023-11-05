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
            <tr v-for="item in musics" :key="item.id" id="row-music">
                <td> 
                    <div id="colum-music">
                        <img :src="item.photo" id="img-pres">
                        <div id="text-music">
                            <div id="music-colum-music">
                                <span>{{ item.name }}</span> 
                            </div>
                            <div id="artist-colum-music">
                                <router-link @click="updateStore.update()" :to="'/artist/' + item.artist.id" style="text-decoration: none; color: inherit;"><span>{{ item.artist.name }}</span></router-link>
                            </div>
                        </div>
                        <div id="play-button"  @click="togglePlayPause(item.id)">
                                <v-icon v-if="!isPlaying[item.id]" icon="mdi-play" color="#ead2ac"></v-icon>
                                <v-icon v-else icon="mdi-pause" color="#ead2ac"></v-icon>
                        </div>
                    </div>
                </td>
                <td><router-link @click="updateStore.update()" :to="'/album/' + item.album.id" style="text-decoration: none; color: inherit;">{{ item.album.name }}{{ item.date }}</router-link></td>
                <td>
                    <div id="time-row">
                        <img :src="require('../../../static/heart.png')" alt="Picture of like" :style="{ filter: userStore.musiqueLike.includes(item.id) ? 'saturate(100%)':'saturate(0%)' }" @click="cliqueLike(item.id)" :id="item.id">
                    </div>
                </td>
                <td>                                       
                    {{ item.time }}            
                </td>
                <td id="td-para">
                    <ParaSong :items="item.items" :suppr="item.suppr" :id="item.id"/>
                </td>
            </tr>
        </tbody>
    </v-table>
</div>
</template>

<script>
import {ref} from 'vue'
import ParaSong from '../components/ParaSong.vue';
import {useUserStore} from '../store/userStore';
import {useUpdateStore} from '../store/updateStore';
import {useRoute} from 'vue-router';

export default {
    name:"TableMusic",
    components:{
        ParaSong,
    },
    setup(props) {
        const userStore = useUserStore();
        const updateStore = useUpdateStore();
        const like = ref(Array());
        const route = useRoute();

        props.musics.forEach((item) => {
            like.value[item.id] = userStore.musiqueLike.includes(item.id);
        });
        const isPlaying = ref(Array(props.musics.length).fill(false));
        
        const cliqueLike = async (index) => {
            if(!userStore.musiqueLike.includes(index))
                await userStore.like(index)

            else
                await userStore.dislike(index)

            if(route.query.id === 'like')
                props.musics.filter((item) => item.id !== index);
        }

        const togglePlayPause = (index) => {
            isPlaying.value = isPlaying.value.map((_, i) => i === index);
        }
        
        return { cliqueLike, like, isPlaying, togglePlayPause, userStore , updateStore};
    },
    props: {
        musics: Array,
    },
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
