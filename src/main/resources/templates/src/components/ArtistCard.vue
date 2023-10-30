<template>
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
</template>

<script>
export default {
    name: "ArtistCard",
    props:{
        img : String,
        name : String,
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
    }
    #profilPicture img{
        height: 100px;
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