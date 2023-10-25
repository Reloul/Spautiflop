<template>
    <div id="input-main-search">
        <v-icon icon="mdi-magnify" color="#3b4762" size="x-large" id="button-search-main"></v-icon>
        <input type="text" id="music-seach" placeholder="Recherchez votre musique ici !">
    </div>
</template>

<script>
export default {
    name: "SearchBar",
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