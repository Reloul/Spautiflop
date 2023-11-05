<template>
    <div>
        <router-link :to="'/artist/' + id" style="text-decoration: none; color: inherit;">
            <div id="artist-card">
                    <div id="profilPicture">
                        <img :src="img">
                    </div>
                    <div id="text-artist">
                        <div id="name">
                            <span> {{ name }}</span>
                        </div>
                        <div id="type-artist">
                            <span>Artiste</span>
                        </div>
                    </div>
            </div>
        </router-link>
    </div>
</template>

<script>
export default {
    name: "ArtistCard",
    props:{
        img : String,
        name : String,
        id: Number,
    }
}
</script>

<style scoped>
    #artist-card{
        background-color: #ead2ac;
        border-radius: 10px;
        height: 200px;
        width: 200px;
        color: #273043;
        cursor: pointer;
    }
    #profilPicture img{
        height: 100px;
        width: 100px;
        object-fit: cover;
        border-radius: 50%;
    }
    #profilPicture{
        padding-top: 20px;
    }
    #text-artist{
        text-align: left;
        margin-left: 20px;
    }
    #name{
        font-size: 18px;
    }

    #type-artist{
        font-size: 15px;
    }
</style>