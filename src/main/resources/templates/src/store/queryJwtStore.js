import {defineStore} from 'pinia'

export const useQueryJwtStore = defineStore( 'queryJwtStore', {
  state: () => ({
    jwt: null,
    response: null,
    HttpCode: null,
  }),
  actions: {
    setJwt(jwt) {
      this.jwt = jwt;
    },

    setResponse(response) {
      this.response = response;
    },

    setHttpCode(HttpCode) {
      this.HttpCode = HttpCode;
    },


    fetchJwtJson(request, Content_Type = "application/json", body = null) {
       return fetch(request, {
        headers: {
          "Content-Type": "application/json",
          "Authorization": `Bearer ${this.jwt}`,
        },
        body: body,
       }).
       then((response) => {
        this.setHttpCode(response.status);
        if (response.ok) {
          return response.json();
        }

          throw new Error("Network response was not ok.");
        }
      ).then((data) => {
        this.setResponse(data.jwt);
        return data;
      })
      .catch((error) => {
        console.error("There has been a problem with your fetch operation:", error);
      });
    }
  },
});