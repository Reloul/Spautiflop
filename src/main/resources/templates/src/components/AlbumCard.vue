<template>
    <div>
        <router-link :to="'/album/' + id" id="routerLink" style="text-decoration: none; color: inherit;">
            <div id="album-card">
                <div id="album-photo">
                    <img :src="image">
                </div>
                <div id="text-album">
                    <div id="name">
                        <span> {{ name }}</span>
                    </div>
                    <div id="type-album">
                        <span>{{ date }} - <router-link :to="'/artist/' + artist.id" id="routerLink" style="text-decoration: none; color: inherit;">{{ artist.name }}</router-link></span>
                    </div>
                </div>
            </div>
        </router-link>
    </div>
</template>

<script>
export default {
    name: "AlbumCard",
    props: {
        image: String,
        name: String,
        date: String,
        artist: String,
        id: Number,
    }
}
</script>

<style scoped>
    #album-card{
        background-color: #ead2ac;
        border-radius: 10px;
        height: 200px;
        width: 200px;
        color: #273043;
        cursor: pointer;
    }
    #album-photo img{
        height: 100px;
        width: 100px;
        object-fit: cover;
        border-radius: 50%;
    }
    #album-photo{
        padding-top: 20px;
    }
    #text-album{
        text-align: left;
        margin-left: 20px;
    }
    #name{
        font-size: 18px;
    }

    #type-album{
        font-size: 15px;
    }
    span{
        text-decoration: none;
    }

</style>