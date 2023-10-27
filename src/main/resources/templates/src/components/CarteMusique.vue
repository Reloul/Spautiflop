<template>
  <div id="carteM">
    <div id="imgM">
        <img :src="img" alt="Picture of the music">
    </div>
    <div id="PresM">
        <p>{{ music }} - {{ artist }}</p>
    </div>
    <div id="bottomCard">
        <div id="like">
            {{ nbLike }}
            <img :src="require('../assets/imgFolder/heart.png')" alt="Picture of like" :style="{ filter: isLike ? 'saturate(100%)':'saturate(0%)' }" @click="cliqueLike(isLike)">
        </div>
        <div id="button">
            <a href="##"><v-icon icon="mdi-play" color="green"></v-icon></a>
        </div>
    </div>
  </div>
</template>

<script>
export default {
    name : 'CarteMusique',
    props : {
        img: String,
        music: String,
        artist: String,
        nbLike: Number,
        isLike: Boolean,
    },
    methods :{
        cliqueLike(isLike){
            if (isLike == true){
                isLike = false;
            }else{
                isLike = true;
            }
            console.log(isLike);
        }
    }
}

</script>


<style scoped>
    #carteM{
        background-color: #ead2ac;
        width: 217px;
        height: 217px;
        border-radius: 10px;
        color: #273043;
        flex-basis: 200px;
    }
    #carteM #imgM img{
        margin-top: 2vh;
        height: 110px;
        border-radius: 10px;
    }
    #PresM{
        font-size: 20px;
    }
    #like img{
        height: 20px;
    }
    #like {
        text-align: left;
        margin-left: 30px;
        margin-top: -10px;
    }
</style>
