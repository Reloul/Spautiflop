import {defineStore} from 'pinia'
import { API_URL as URL } from '@/util/global'

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
      const response = await fetch(URL + request, {method: method, credentials: 'include', headers: this.getHeaders(), body: body});
      this.setHttpCode(response.status);
      this.setResponse(null);
      return response.ok;
    },


    async fetchFile(request, body = null, method = "get") {
      const reponse = await fetch(URL + request, {method: method, credentials: 'include', headers: this.getHeaders(), body: body});
      this.setHttpCode(reponse.status);
      this.setResponse(null);

      if(!reponse.ok) {
        console.log("Error while fetching file : " + reponse.status + " " + reponse.statusText);
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
  
  },
});