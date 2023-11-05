import {defineStore} from 'pinia'
import { API_URL as URL } from '@/util/global'
import * as API from '@/util/global'

export const useQueryStore = defineStore( 'queryStore', {
  state: () => ({
    response: null,
    HttpCode: null,
    jwt: null,
  }),
  actions: {

    getHeaders() {
      return {"Authorization": `Bearer ${this.jwt}`}
    },

    setResponse(response) {
      this.response = response;
    },

    setHttpCode(HttpCode) {
      this.HttpCode = HttpCode;
    },

    setJwt(jwt) {
      this.jwt = jwt;
    },

    async registerUser(formData) {
      const response =  await fetch(URL + "/auth/register", {method: "post",body: formData});
      this.setHttpCode(await response.status);
      this.setResponse(null);
      return response.ok;
    },


    async loginUser(pseudo, pwd) {
      let formData = new FormData();
      formData.append("pseudo", pseudo);
      formData.append("password", pwd);

      const response = await fetch(URL + "/auth/login", {method: "post",body: formData})
      this.setHttpCode(response.status);
      this.setResponse(null);

      if(response.ok){
        this.setResponse(JSON.stringify( await response.json()))
        this.setJwt(await JSON.parse(this.response).jwt);
        return true;
      }

      return false
    },


    async fetchJwtJson(request, body = null, method = "get") {
      if(!this.jwt) 
        return null;
      
      const response = await fetch(URL + request, {method: method, credentials: 'include', headers: this.getHeaders(), body: body});
      this.setHttpCode(response.status);
      this.setResponse(null);
      if (response.ok) {
        this.setResponse(JSON.parse (JSON.stringify (await (response.json()))));
        return this.response;
      }

      return false;
    },

    async fetchJwt(request, body = null, method = "get") {
      if(!this.jwt)
        return null;

      const response = await fetch(URL + request, {method: method, credentials: 'include', headers: this.getHeaders(), body: body});
      this.setHttpCode(response.status);
      this.setResponse(null);
      return response.ok;
    },


    async fetchFile(request, body = null, method = "get") {
      const reponse = await fetch(URL + request, {method: method, body: body});
      this.setHttpCode(reponse.status);
      this.setResponse(null);

      if(!reponse.ok) {
        return null
      }
        
      return window.URL.createObjectURL(await reponse.blob());
    },

    async fetchImage(request, body = null, method = "get") {
      return await this.fetchFile("/api/file/image/" + request, body, method);
    },

    async fetchAudio(request, body = null, method = "get") {
      return await this.fetchFile("/api/file/audio/" + request, body, method);
    },
  

    async getTopSongs(nb) {
      const response = await fetch(URL + "/api/song/top/" + nb, {method: "get"});
      this.setHttpCode(response.status);
      this.setResponse(null);
      if (response.ok) {
        const data = (JSON.parse (JSON.stringify (await (response.json()))));
        
        let res = [];
        for(let musique of data) {
          const image = await this.fetchImage(musique.image);
          const music = await this.fetchAudio(musique.musicLink);
          res.push({id: musique.id, name: musique.name, artist: musique.artist, album: musique.album, image: image,  music: music, nbLikes: musique.nbLikes});
        }

        this.setResponse(res);
        return this.response;
      }

      return false;
    },

    async fetchAlbum(id) {
      const data = await this.fetchJwtJson("/api/album/" + id);
      
      if (this.HttpCode !== API.OK) 
        return false;
        
      let res = {id: data.id, name: data.name, artist: data.artist, image: await this.fetchImage(data.image), songs: [], date: data.release};

      for(let musique of data.songs) {
        res.songs.push({id: musique.id, name: musique.name, artist: musique.artist, album: musique.album, photo: await this.fetchImage(musique.image),  music: await this.fetchAudio(musique.musicLink), time: 0});
      }

      return res;
    },

    async fetchArtist(id) {
      const data = await this.fetchJwtJson("/api/artist/" + id);
      
      if (this.HttpCode !== API.OK) 
        return false;
        
      let res = {id: data.id, name: data.name, image: await this.fetchImage(data.photo), albums: [], bestSongs: []};

      for(let album of data.albums) {
        res.albums.push({id: album.id, name: album.name, artist: album.artist, image: await this.fetchImage(album.image), date: album.release});
      }

      for(let musique of data.bestSongs) {
        res.bestSongs.push({id: musique.id, name: musique.name, artist: musique.artist, album: musique.album, photo: await this.fetchImage(musique.image),  music: await this.fetchAudio(musique.musicLink), time: 0});
      }

      return res;
    },

    async getPlaylistWithMusic(id) {
      const data = await this.fetchJwtJson("/api/playlist/containsSong/" + id );
      
      if (this.HttpCode !== API.OK) 
        return false;
      
      let res = [];
      for(let album of data) 
        res.push({id: album.id, name: album.name});

      return res;
    }
  
  },
});