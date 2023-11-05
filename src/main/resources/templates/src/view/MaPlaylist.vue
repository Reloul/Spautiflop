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
                <div id="music">
                    <TableMusic :musics="musics" />
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import LeftMain from '../components/LeftMain.vue';
import UserTop from '../components/UserTop.vue';
import TableMusic from '../components/TableMusic.vue';


export default {
    name:"MaPlaylist",
    components: {
        LeftMain,
        UserTop,
        TableMusic,
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
                    time: "2:34",
                    isLike: true,
                    src: require("../../../static/Moonless.mp3")
                },
                {
                    music: "E t h e r e a l",
                    photo: require("../../../static/ethereal.jpg"),
                    artist: "TOKYOSHIFT",
                    album: "Ethereal",
                    time: "1:37",
                    isLike: true,
                    src: require("../../../static/ethereal.mp3"),
                },
            ]
        }
    }
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