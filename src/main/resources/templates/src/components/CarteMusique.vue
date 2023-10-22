<template>
  <div id="carteM">
    <div id="imgM">
        <img :src="img" alt="Picture of the music">
    </div>
    <div id="PresM">
        <p>{{ music }} - {{ artist }}</p>
    </div>
    <div id="like">
        {{ nbLike }}
        <img :src="imgL" alt="Picture of like">
    </div>
    <div id="bouton">
        <ion-icon name="play-circle-outline"></ion-icon>
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
        imgL: String,
    },
}

</script>


<style scoped>
    #carteM{
        background-color: #ead2ac;
        width: 217px;
        height: 217px;
        border-radius: 10px;
        color: #273043;
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
