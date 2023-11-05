import { defineStore } from 'pinia'

export const useMusicStore = defineStore('musicStore', {
    state: () => ({
        currentSong: {
            img: require('../../../static/V4.jpg'),
            music: 'Moonless',
            artist: 'FL3R',
            src: require('../../../static/Moonless.mp3'),
            isLike: false,
        },
    }),
    actions: {
        changeSong(song){
            this.currentSong = {
                img: song.img,
                music: song.music,
                artist: song.artist,
                src: song.src,
            }
        }
    }
})