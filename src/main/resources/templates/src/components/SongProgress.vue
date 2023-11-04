<template>
    <div id="main-progress">
        <div id="pres-song">
            <div id="img-song">
                <img :src="current.img">
            </div>
            <div id="music-text-progress">
                <div id="name-song">
                    {{ current.nameSong }}
                </div>
                <div id="artist-song">
                    {{ current.artistSong }}
                </div>
            </div>
            <div class="control">
                <v-icon class="play" v-if="!isPlaying" @click="play" icon="mdi-play" color="#b9d1db" size="50"></v-icon>
                <v-icon class="pause" v-else @click="pause" icon="mdi-pause" color="#b9d1db" size="50"></v-icon>
                <div class="active-music-status">
                    <div class="music-times">
                        <div>
                            <span class="active-time" ref="currentTime"> {{ getCurrentTime(currentTime) }}</span>
                        </div>
                        <input type="range" value="0" class="music-range" ref="music_range">
                        <div>
                            <span class="all-music-time" ref="duration"> {{ getCurrentTime(durationTime) }}</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>

import eventBus from "../main.js";

export default {
    name: "SongProgress",
    data(){
        return{
            current: {},
            index: 0,
            isPlaying: false,
            songs: [
                {
                    src: require('../../../static/Moonless.mp3'),
                    nameSong: "Moonless",
                    artistSong: "Fl3r",
                    img: require('../../../static/V4.jpg'),
                },
                {
                    src: require('../../../static/ethereal.mp3'),
                    nameSong: "Ethereal",
                    artistSong: "TOKYOPILL",
                    img: require('../../../static/ethereal.jpg'),
                },
            ],
            player: new Audio(),
            currentTime: 0,
            durationTime: 0,
        };
    },
 
    methods:{
        play(song) {
            if (typeof song.src != "undefined"){
                this.current = song;
                this.player.src = this.current.src;
            }
            this.player.play();
            this.isPlaying = true;
        },
        pause(){
            this.player.pause();
            this.isPlaying = false;
        },
        restarMusic(){
            this.player.currentTime = 0;
        },
        handleMusicProgress(){
            if(this.isMusicOver()){
                this.pause();
                this.restarMusic();
            }
            let percent = (this.player.currentTime / this.durationTime) * 100;
            let musicRange = this.$refs.music_range;
            musicRange.value = percent;
            this.updateProgressBColor(musicRange, percent);
            this.currentTime = this.player.currentTime;
        },
        updateProgressBColor(input, percent){
            input.style.background = `linear-gradient(to right, rgb(255,255,255) 0%, rgb(255,255,255) ${percent}%, rgba(255,255,255,0.2) ${percent}%, rgba(255,255,255,0.2) 100%)`;
        },
        updateMusicProgress(event){
            let value = event.target.value;
            this.updateProgressBColor(event.target, value);
            this.updateCurrentTime(value);
        },
        updateCurrentTime(value){
            const scrubTime = (value * this.durationTime) / 100;
            this.player.currentTime = scrubTime;
        },
        isMusicOver(){
            return Math.floor(this.currentTime) == Math.floor(this.durationTime);
        },
        getCurrentTime(time){
            let hour = Math.floor(time / 3600);
            let minute = Math.floor(time / 60);
            let second = Math.floor(time - (hour * 3600 + minute * 60));
            hour = hour > 9 ? hour : `0${hour}`;
            second = second > 9 ? second : `0${second}`;
            minute = minute > 9 ? minute : `0${minute}`;
            let formatTime = hour > 0 ? `${hour}:${minute}:${second}` : `${minute}:${second}`;
            return formatTime;
        },
        addEventListeners() {
            this.player.addEventListener('timeupdate', this.handleMusicProgress);
            this.player.addEventListener('loadedmetadata', () => {
                this.durationTime = this.player.duration;
            });
        },
        playMusic(musicData) {
            // Mettez à jour les données de la musique avec les nouvelles données
            this.current = {
                src: musicData.link, // Le chemin de la musique
                nameSong: musicData.music,
                artistSong: musicData.artist,
                img: musicData.img
            };
            // Mettez à jour le lecteur audio avec la nouvelle musique
            this.player.src = this.current.src;
            // Lancer la musique
            this.player.play();
            this.isPlaying = true;
        },
    },
    created () {
        this.current = this.songs[this.index];
        this.player.src = this.current.src;
        this.addEventListeners();
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
        position: fixed;
        width: 100vw;
        bottom: 0px;
        background-color: #273043;
    }
    #pres-song{
        display: flex;
    }

    #audio-balise{
        margin: auto;
    }

    #music-text-progress{
        margin: auto;
        margin-left: 20px;
        color: #b9d1db;
        text-align: left;
    }

    #name-song{
        font-size: 20px;
        font-weight: bold;
    }

    #audio-player{
        background-color: #273043;
    }

    .control{
        margin: auto;
        margin-left: 13vw;
    }

    .control input{
        width: 40vw;
    }

    .control span{
        color: #b9d1db;
        margin-right: 20px;
        margin-left: 20px;
    }

    .music-times{
        display: flex;
    }

</style>