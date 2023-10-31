import {defineStore} from 'pinia'
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import { API_URL as URL } from '@/util/global'
=======
import { API_URL } from '@/util/global'
>>>>>>> 9a83f58 (starting to do some stuff on pinia)
=======
import { URL } from '@/util/global'
>>>>>>> ff36a3a (register + login)
=======
import { API_URL as URL } from '@/util/global'
>>>>>>> 2d97c74 (linking front and backend)

export const useQueryStore = defineStore( 'queryStore', {
  state: () => ({
    response: null,
    HttpCode: null,
<<<<<<< HEAD
    jwt: null,
  }),
  actions: {

    getHeaders() {
      return {"Authorization": `Bearer ${this.jwt}`}
    },
=======
  }),

  actions: {
>>>>>>> 9a83f58 (starting to do some stuff on pinia)

    setResponse(response) {
      this.response = response;
    },

    setHttpCode(HttpCode) {
      this.HttpCode = HttpCode;
    },

<<<<<<< HEAD
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
<<<<<<< HEAD
<<<<<<< HEAD
      const response = await fetch(URL + request, {method: method, credentials: 'include', headers: this.getHeaders(), body: body});
=======
      const response = await fetch(URL + request, {method: method, credentials: 'include', headers: this.getHeaders(), body: body}).
>>>>>>> ff36a3a (register + login)
=======
      const response = await fetch(URL + request, {method: method, credentials: 'include', headers: this.getHeaders(), body: body});
>>>>>>> 6f3d7c8 (last finition)
      this.setHttpCode(response.status);
      this.setResponse(null);
      return response.ok;
    },


<<<<<<< HEAD
    async fetchJwtMultifile(request, body = null, method = "get") {
      const response = await fetch(URL + request, {method: method, credentials: 'include', headers: this.getHeaders(), body: body});
      this.setHttpCode(response.status);
      this.setResponse(response.formData())
      return response.ok;
<<<<<<< HEAD
=======
    fetchPost(request, Content_Type = "application/json", body = null, requestType = "POST") {
      return fetch(API_URL + request, {
        method: requestType,
        headers: {
          "Content-Type": Content_Type,
        },
        body: body,
      })
      .then((response) => {
        this.setHttpCode(response.status);
        if (response.ok) {
          return response.json();
        }

        throw new Error("Network response was not ok.");
      })
      .then((data) => {
        this.setResponse(data);
        return data;
      })
      .catch((error) => {
        console.error("There has been a problem with your fetch operation:", error);
      });
>>>>>>> 9a83f58 (starting to do some stuff on pinia)
=======
>>>>>>> 6f3d7c8 (last finition)
    }
=======
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
>>>>>>> 86315c1 (load correctly user image and can request song / image)
  },
});