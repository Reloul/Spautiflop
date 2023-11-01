<template>
    <div id="artist-page">
        <div id="left-side">
            <LeftMain />
        </div>
        <div id="main-artist">
            <div id="top-main-content">
                <UserTop />
            </div>
            <div id="top-artist-page">
                <div id="img-artist">
                    <img :src="img">
                </div>
                <div id="artist-name">
                    <span> {{ name }} </span>
                </div>
            </div>
            <div id="artist-content">
                <div id="artist-top-music">
                    <TableMusic :musics="musics"/>
                </div>
                <div id="artist-album">
                    <AlbumPart />
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


export default {
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