<template>
    <div id="playlist-reduce">
        <div id="picture-playlist">
            <img :src="img" alt="">
        </div>
        <div id="text-playlist">
            <div id="playlist-name">
                <span>{{ name }}</span>
            </div>
            <div id="playlist-user">
                <span>Playlist - {{ user }} </span>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: "PlaylistReduce",
    props :{
        img : String,
        name : String,
        user : String,
    }
}
</script>

<style scoped>
    #playlist-reduce{
        width: 225px;
        background-color: #b9d1db;
        height: 60px;
        border-radius: 10px;
        margin-top: 10px;
        display: flex;
        color: #273043;
    }
    img{
        height: 55px;
        border-radius: 10px;
        margin-left: 5px;
    }
    #playlist-name{
        font-size: 22px;
        padding-top: 7px;
    }
    #playlist-user{
        font-size: 14px;
        margin-top: -5px;
        padding-bottom: 5px;
    }
    #text-playlist{
        display: block;
        margin-left: 8px;
    }

</style>