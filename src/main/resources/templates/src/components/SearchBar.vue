<template>
    <div id="input-main-search">
        <v-icon icon="mdi-magnify" color="#3b4762" size="x-large" id="button-search-main"></v-icon>
        <input type="text" id="music-seach" placeholder="Recherchez votre musique ici !" @keydown.enter="handleEnter" v-model="searchInput">
    </div>
</template>

<script>
import { useRouter } from 'vue-router';
import { ref, onMounted } from 'vue';
import { useSearchStore } from '../stores/SearchStore'
export default {
    name: "SearchBar",
    setup() {
        const router = useRouter();
        const searchInput = ref('');
        const searchStore = useSearchStore();

        onMounted(() => {
            searchInput.value = searchStore.currentSearch.myResearch;
        });

        const handleEnter = (event) => {
            const searchData = {
                myResearch: searchInput.value,
            };
            if (event.key === 'Enter') {
                router.push({ path: '/recherche' });
            };
            searchStore.madeSearch(searchData);
        };

        return {
            searchInput,
            handleEnter,
            searchStore,
        };
    },
}
</script>

<style scoped>
    #input-main-search{
        background-color: #b9d1db;
        border-radius: 50px;
        width: 40vw;
        text-align: left;
        margin-left: 50px;
        margin-top: 2vh;
        height: 40px;
        min-width: 300px;
    }
    #input-main-search input{
        background-color: #b9d1db;
        width: 35vw;
        margin-left: 50px;
        border: none;
        margin: auto;
        margin-top: 8px;
        color: #3b4762;
    }

    input:focus{
        outline: none;
    }

    #input-main-search #button-search-main{
        margin-left: 20px;
        margin-right: 10px;
    }
</style>