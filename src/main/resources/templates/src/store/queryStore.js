import {defineStore} from 'pinia'
<<<<<<< HEAD
import { API_URL as URL } from '@/util/global'
=======
import { API_URL } from '@/util/global'
>>>>>>> 9a83f58 (starting to do some stuff on pinia)

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
        return true;
      }

      return false;
    },

    async fetchJwt(request, body = null, method = "get") {
      const response = await fetch(URL + request, {method: method, credentials: 'include', headers: this.getHeaders(), body: body});
      this.setHttpCode(response.status);
      this.setResponse(null);
      return response.ok;
    },


    async fetchJwtMultifile(request, body = null, method = "get") {
      const response = await fetch(URL + request, {method: method, credentials: 'include', headers: this.getHeaders(), body: body});
      this.setHttpCode(response.status);
      this.setResponse(response.formData())
      return response.ok;
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
    }
  },
});