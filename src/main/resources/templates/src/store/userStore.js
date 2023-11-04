import {defineStore} from 'pinia'
import { useQueryStore } from './queryStore';
import * as API from '@/util/global'
const queryStore = useQueryStore();

export const useUserStore = defineStore( 'userStore', {
  state: () => ({
    pseudo  : "Default username",
    profilPicture: null,
    musiqueLike : [],
    playlist : [],
    finishLoad: false,
  }),
  actions: {

    async init() {
      
      if(!queryStore.jwt || this.finishLoad)
        return;

      const data = await queryStore.fetchJwtJson("/auth/me");
      this.pseudo = data.pseudo;
      this.profilPicture = await queryStore.fetchImage(data.photo);
      this.musiqueLike = data.likes;
      for(let playlist of data.playlists) {
        this.playlist.push({ id: playlist.first, name: playlist.second.first, image: await queryStore.fetchImage(playlist.second.second) });
      }
      this.finishLoad = true;
      return true;
    },

    async getPlaylist(id) {
      const data = await queryStore.fetchJwtJson("/api/playlist/" + id);
      
      let response = {id: data.id, name: data.name, image: await queryStore.fetchImage(data.image), musique: []};
      for(let musique of data.songs) {
        response.musique.push({id: musique.id, name: musique.name, artist: musique.artist, album: musique.album, photo: await queryStore.fetchImage(musique.image),  music: await queryStore.fetchAudio(musique.musicLink)});
      }
      return response;
    },

    async getFavoris() {
      const data = await queryStore.fetchJwtJson("/api/user/fav");
      let response = {name: 'favoris', musique: []};
      for(let musique of data) {
        response.musique.push({id: musique.id, name: musique.name, artist: musique.artist, album: musique.album, photo: await queryStore.fetchImage(musique.image),  music: await queryStore.fetchAudio(musique.musicLink)});
      }
      return response;
    },


    async like(idMusic) {
      console.log(idMusic);
      const response = await queryStore.fetchJwt("/api/user/like/" + idMusic, null, "PUT");
      
      if (! response) {
        console.log("Erreur lors du like : " + queryStore.HttpCode);
      } else {
        this.musiqueLike.push(idMusic);
      }
    },

    async dislike(idMusic) {
      const response = await queryStore.fetchJwt("/api/user/dislike/" + idMusic, null, "PUT");
      
      if (!response) {
        console.log("Erreur lors du dislike : " + queryStore.HttpCode);
      } else {
        this.musiqueLike.splice(this.musiqueLike.indexOf(idMusic), 1);
      }
    },

    async addPlaylist(formData) {
      const response = await queryStore.fetchJwtJson("/api/playlist/add", formData, "POST");
      if (! queryStore.HttpCode == API.OK) {
        console.log("Erreur lors de la création de la playlist : " + queryStore.HttpCode);
      }
      else {
        this.playlist.push({id: response.id, name: response.name, image: await queryStore.fetchImage(response.image)});
      }
    },

    async addSongToPlaylist(idPlaylist, idSong) {
      const response = await queryStore.fetchJwt("/api/playlist/" + idPlaylist + "/addSong/" + idSong, null, "POST");
      if (! response) {
        console.log("Erreur lors de l'ajout de la musique à la playlist : " + queryStore.HttpCode);
      }
    },

    async removeSongFromPlaylist(idPlaylist, idSong) {
      const response = await queryStore.fetchJwt("/api/playlist/" + idPlaylist + "/removeSong/" + idSong, null, "DELETE");
      if (! response) {
        console.log("Erreur lors de la suppression de la musique de la playlist : " + queryStore.HttpCode);
      }
    },

    async removePlaylist(idPlaylist) {
      const response = await queryStore.fetchJwt("/api/playlist/" + idPlaylist, null, "DELETE");
      if (! response) {
        console.log("Erreur lors de la suppression de la playlist : " + queryStore.HttpCode);
      }
      else {
        this.playlist.splice(this.playlist.indexOf(idPlaylist), 1);
      }
    },

    
}
}); 