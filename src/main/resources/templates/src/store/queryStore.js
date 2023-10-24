import {defineStore} from 'pinia'
import { API_URL } from '@/util/global'

export const useQueryStore = defineStore( 'queryStore', {
  state: () => ({
    response: null,
    HttpCode: null,
  }),

  actions: {

    setResponse(response) {
      this.response = response;
    },

    setHttpCode(HttpCode) {
      this.HttpCode = HttpCode;
    },

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
    }
  },
});