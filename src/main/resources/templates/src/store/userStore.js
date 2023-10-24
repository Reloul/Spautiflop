import {defineStore} from 'pinia'
import { useQueryJwtStore } from './queryJwtStore.js';
const queryJwtStore = useQueryJwtStore();

export const useUserStore = defineStore( 'userStore', {
  state: () => ({
    name: null,
    image: null,
    musiqueLike : [],
    playlist : [],
  }),
  methods: {
    initialize() {
      if(!queryJwtStore.jwt)
        return;

      const data = queryJwtStore.fetchJwtJson("/auth/me");
      console.log(data);
      //this.name = data.name;
      //this.image = data.image;
    }
  }

});