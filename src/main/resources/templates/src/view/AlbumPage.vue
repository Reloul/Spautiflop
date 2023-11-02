<template>
    <div id="album-page">
        <div id="left-side">
            <LeftMain />
        </div>
        <div id="main-album">
            <div id="top-main-content">
                <UserTop />
            </div>
            <div id="album-content">
                <div id="top-content-album">
                    <div id="picture">
                        <img :src='image'>
                    </div>
                    <div id="text">
                        <div id="name">
                            <span> {{ name }}</span>
                        </div>
                        <div id="user">
                            <router-link to="/artist" style="text-decoration: none; color: inherit;">
                                <span>{{ artist }}</span>
                            </router-link>
                            <span>{{ - date }} - </span>
                            <span>{{ nbSong }} musiques</span>
                        </div>
                    </div>
                </div>
                <div id="music">
                    <TableMusic :musics="musics" />
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import LeftMain from '../components/LeftMain.vue';
import TableMusic from '../components/TableMusic.vue';
import UserTop from '../components/UserTop.vue';

export default {
    name: "AlbumPage",
    components:{
        LeftMain,
        TableMusic,
        UserTop,
    },
    data(){
        return{
            image: require('../../../static/V4.jpg'),
            name: "Moonless",
            artist: "Fl3r",
            date: "2023",
            nbSong: "2",
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