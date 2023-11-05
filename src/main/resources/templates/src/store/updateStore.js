import {defineStore} from 'pinia'

export const useUpdateStore = defineStore( 'updateStore', {
  state: () => ({
    render: true,
  }),
  actions: {
    update() {
      this.render = false;

      setTimeout(() => {
        this.render = true;
      }
      , 5);

    },
  },
})