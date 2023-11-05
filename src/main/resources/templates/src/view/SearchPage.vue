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
                        <TopSearch :song=response.bestSongs />
                    </div>
                    <div>
                        <SongList  :musics="response.songs"/>
                    </div>
                </div>
                <div id="bottom-search">
                    <ArtistPart :artists="response.artists"/>
                    <AlbumPart :albums="response.albums"/>
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
import { onBeforeMount, ref } from 'vue';
import { useRoute } from 'vue-router';
import { useToast } from 'vue-toastification';
import { useQueryStore } from '@/store/queryStore';
import { useUserStore } from '@/store/userStore';



export default {
    setup(){
        const queryStore = useQueryStore();
        const userStore = useUserStore();
        const route = useRoute();
        const response = ref([]);

        const fetchingData = async () => {
            if( !route.params.query) {
                route.push('/pagePrincipale')
                toast.error("Erreur lors de la recherche");
                return;
            }

            response.value = await queryStore.getSearch(route.params.query);
        }

        onBeforeMount(async () => {
            await fetchingData();
        });

        return {
            response
        }

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
    data() {
        return{
            img: require('../../../static/V4.jpg'),
            music: "Moonless",
            artist: "Fl3r",
            src: require('../../../static/Moonless.mp3'),
            isLike: false,
            time: "2:34",
        }
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