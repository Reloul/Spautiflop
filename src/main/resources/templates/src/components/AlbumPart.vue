<template>
  <div id="album">
        <div id="title">
            <div id="span-title">
                <span>Albums</span>
            </div>
            <div id="hr-title">
                <hr>
            </div>
        </div>
        <div id="resume-album">
            <div id="album" v-for="album in albums" :key="album">
                <routerLink :to="'/album/' + album.id" style="text-decoration: none; color: inherit;">
                    <AlbumCard :image="album.image" :name="album.name" :date="album.date" :artist="album.artist" :id="album.id"/>
                </routerLink>
            </div>

        </div>
    </div>
</template>

<script>

import AlbumCard from "../components/AlbumCard.vue"
export default {
    name: "AlbumPart",
    components: {
        AlbumCard,
    },
    props: {
        albums: Array,
    },
}
</script>

<style scoped>
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
    #title{
        margin-top: 20px;
        margin-bottom: 50px;
    }
    #resume-album{
        display:flex;
        justify-content: space-between;
        width: 75vw;
        flex-wrap: wrap;
    }
    #album{
        margin-bottom: 20px;
        
    }
    
</style>