import { defineStore } from "pinia";

export const useSearchStore = defineStore('searchStore', {
    state: () => ({
        currentSearch: {
            myResearch: '',
        }
    }),
    actions: {
        madeSearch(search){
            this.currentSearch = {
                myResearch:  search.myResearch,
            }
        }
        
    }
})