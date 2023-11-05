import { defineStore } from 'pinia'

export const useMusicStore = defineStore('musicStore', {
    state: () => ({
        currentSong: {
            img: require('../../../static/ethereal.jpg'),
            music: 'E t h e r e a l',
            artist: 'TOKYOPILL',
            src: require('../../../static/ethereal.mp3'),
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
                isLike: song.isLike,
            }
        }
    }
})