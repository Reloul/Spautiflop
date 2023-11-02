import {defineStore} from 'pinia'
import { useQueryStore } from './queryStore';
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
    }
  }

});