<template>
    <div id="artist">
        <div id="title">
            <div id="span-title">
                <span>Artistes</span>
            </div>
            <div id="hr-title">
                <hr>
            </div>
        </div>
        <div id="resume-artist">
            <div id="artist" v-for="artist in artists" :key="artist">
                <ArtistCard :img="artist.img" :name="artist.name" />
            </div>

        </div>
    </div>
</template>

<script>
    import ArtistCard from '../components/ArtistCard.vue'

export default {
    name:"ArtistPart",
    components: {
        ArtistCard,
    },
    data(){
        return{
            artists: [
                {
                    img: require('../../../static/ppCouz.jpg'),
                    name: "DJ Couscous",
                },
                {
                    img: require('../../../static/ppCouz.jpg'),
                    name: "DJ Couscous",
                },
                {
                    img: require('../../../static/ppCouz.jpg'),
                    name: "DJ Couscous",
                },
                {
                    img: require('../../../static/ppCouz.jpg'),
                    name: "DJ Couscous",
                },
                {
                    img: require('../../../static/ppCouz.jpg'),
                    name: "DJ Couscous",
                },
            ]
        }
    }
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
    #resume-artist{
        display: flex;
        justify-content: space-between;
        width: 75vw;
        flex-wrap: wrap;

    }
    #artist{
        margin-bottom: 20px;
    }
</style>