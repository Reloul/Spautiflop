<template>
    <div id="main-progress">
        <div id="img-song">
            <img :src="img">
        </div>
        <audio controls>
            <source :src='linkSong' type="audio/mpeg">
        </audio>
    </div>
</template>

<script>
export default {
    name: "SongProgress",
    props: {
        img: String,
        linkSong: String,
    },
    data(){
        img: require('../../../static/V4.jpg');
        linkSong: require('../../../static/Moonless.mp3');
    },
}
</script>

<style scoped>

</style>