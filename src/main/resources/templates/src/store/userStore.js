import {defineStore} from 'pinia'
import { useQueryStore } from './queryStore';
const queryStore = useQueryStore();

export const useUserStore = defineStore( 'userStore', {
  state: () => ({
    pseudo  : "Default username",
    profilPicture: "../../../static/images/1698356720228blonin.png",
    musiqueLike : [],
    playlist : [],
  }),
  actions: {

    async init() {
      if(!queryStore.jwt)
        return;

      await queryStore.fetchJwtJson("/auth/me");
      const data = await queryStore.response;
      this.pseudo = data.pseudo;
      this.profilPicture = data.photo;
      return true;
    }
  }

});