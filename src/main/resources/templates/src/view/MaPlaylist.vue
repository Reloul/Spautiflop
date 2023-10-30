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
                            <span>{{ user }} - </span>
                            <span>{{ nbSong }} musiques</span>
                        </div>
                    </div>
                </div>
                <div id="content-playlist">
                    <v-table id="table-music" color="#3b4762" theme="dark">
                        <thead id="head-table">
                            <tr>
                                <th class="text-left" id="head-table-music">Musique</th>
                                <th class="text-left" id="head-table-music">Album</th>
                                <th class="text-left" id="head-table-music">Date</th>
                                <th class="text-left" id="head-table-music"></th>
                                <th class="text-left" id="head-table-music"> <v-icon icon="mdi-clock-time-five-outline"></v-icon></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr v-for="item in musics" :key="item.name" id="row-music">
                                <td> 
                                    <div id="colum-music">
                                        <img :src="item.photo" >
                                        <div id="text-music">
                                            <div id="music-colum-music">
                                                <span>{{ item.music }}</span> 
                                            </div>
                                            <div id="artist-colum-music">
                                                <span>{{ item.artist }} </span>
                                            </div>
                                        </div>
                                        <div id="play-button">
                                                <v-icon icon="mdi-play" color="#ead2ac"></v-icon>
                                        </div>
                                    </div>
                                </td>
                                <td>{{ item.album }}</td>
                                <td>{{ item.date }}</td>
                                <td>
                                    <div id="time-row">
                                        <img :src="require('../../../static/heart.png')" alt="Picture of like" :style="{ filter: item.isLike ? 'saturate(100%)':'saturate(0%)' }" id="img-like" >
                                    </div>
                                </td>
                                <td>                                       
                                    {{ item.time }}            
                                </td>
                            </tr>
                        </tbody>
                    </v-table>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import LeftMain from '../components/LeftMain.vue';
import UserTop from '../components/UserTop.vue';


export default {
    name:"MaPlaylist",
    components: {
        LeftMain,
        UserTop,
    },
    data() {
        return{
            image: require("../../../static/heart.png"),
            name: "Favoris",
            user: "Le Couz",
            nbSong: 2,
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
    #playlist-page{
        display:flex;
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
    td img{
        height: 60px;
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
        border-top-color: #b9d1db !important;
    }
    #img-like{
        height: 30px;
    }

    #time-row{
        margin-top: -5px;
        float: right;
    }
    #time-row-music{
        margin-top: 8px;
    }
    #content-playlist{
        margin-top: 4vh;
    }
    #play-button{
        margin: auto;
        margin-left: 20px;
    }
</style>