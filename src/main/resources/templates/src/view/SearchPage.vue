<template>
    <div id="search-page">
        <div id="left-side">
            <LeftMain />
        </div>
        <div id="main-search">
            <div id="top-main-content">
                <SearchBar />
                <UserTop />
            </div>
            <div id="search-result">
                <div id="mid-top-search">
                    <div>
                        <TopSearch />
                    </div>
                    <div>
                        <SongList />
                    </div>
                </div>
                <div id="bottom-search">
                    <ArtistPart />
                    <AlbumPart />
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import UserTop from "../components/UserTop.vue";
    import SearchBar from "../components/SearchBar.vue";
    import LeftMain from '../components/LeftMain.vue';
    import TopSearch from '../components/TopSearch.vue';
    import SongList from '../components/SongList.vue';
    import ArtistPart from '../components/ArtistPart.vue'
    import AlbumPart from '../components/AlbumPart.vue';

import {useUserStore} from '../store/userStore'
import { onMounted } from 'vue';
export default {
    setup() {
        const userStore = useUserStore();
        
        onMounted( async () => {
            await userStore.init();
        });
        
        return;
    },
    name: "SearchPage",
    components : {
        SearchBar,
        UserTop,
        LeftMain,
        TopSearch,
        SongList,
        ArtistPart,
        AlbumPart,
    },
}
</script>

<style scoped>

    #search-page{
        display: flex;
        overflow: auto;
        margin-bottom: 100px;
    }
    #main-search{
        background-color: #3b4762;
        width: 81vw;
        min-width: 1100px;
        margin-left: 20px;
        margin-top: 4vh;
        border-radius: 10px;
    }

    #top-main-content{
        display: flex;
    }

    #search-result{
        margin-top: 6vh;
        margin-left: 50px;
        display: flex;
    }

    #span-title span{
        background-color: #3b4762;
        color: #b9d1db;
        margin-left: 3vw;
        font-size: 20px;
        padding: 10px;
    }
    #span-title{
        width: 150px;
    }
    #hr-title hr{
        border: none;
        height: 2px;
        background-color: #b9d1db;
        display: flex;
        min-width: 300px;
    }

    #hr-title{
        margin-top: -10px;
        width: 40vw;
    }

    #mid-top-search{
        display: flex;
    }
    #search-result{
        display: block;
    }
    #title{
        margin-top: 20px;
        margin-bottom: 50px;
    }

</style>