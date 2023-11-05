<template>
    <div id="main-progress">
        <div id="pres-song">
            <div id="img-song">
                <img :src="musicStore.currentSong.img">
            </div>
            <div id="music-text-progress">
                <div id="name-song">
                    {{ musicStore.currentSong.music }}
                </div>
                <div id="artist-song">
                    {{ musicStore.currentSong.artist }}
                </div>
            </div>
        </div>
        <div id="audio">
            <audio controls :src="musicStore.currentSong.src" ></audio>
        </div>
    </div>
</template>

<script>
import { useMusicStore } from '../stores/MusicStore.js';

export default {
    name: "SongProgress",
    setup(){
        const musicStore = useMusicStore();
        
        return { 
            musicStore, 
        };
        
    },
    
}
</script>

<style>

    #img-song img{
        height: 80px;
        width: 80px;
        object-fit: cover;
        border-radius: 10px;
        margin-left: 50px;
    }
    #img-song{
        margin-top: 10px;
    }
    #main-progress{
        display: flex;
        width: 100vw;
        bottom: 0px;
        position: fixed;
        background-color: #273043;
    }
    #pres-song{
        display: flex;
    }


    #music-text-progress{
        margin: auto;
        margin-left: 20px;
        color: #b9d1db;
        text-align: left;
        width: 17vw;
    }

    #name-song{
        font-size: 20px;
        font-weight: bold;
    }

    #audio{
        margin-left: 11.5vw;
        margin-top: 22px;
    }

    #audio audio{
        color-scheme: dark;
        width: 500px;
    }
    #source-song{
        width: 500px;
    }

</style>