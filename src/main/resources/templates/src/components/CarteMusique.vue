<template>
  <div id="cardM">
    <div id="imgM">
        <img :src="img" alt="Picture of the music">
    </div>
    <div id="PresM">
        <p>{{ music }} - {{ artist }}</p>
    </div>
    <div id="bottomCard">
        <div id="like">
            {{ nbLike }}
            <img :src="imgL" alt="Picture of like" :style="{ filter: isLike ? 'saturate(100%)':'saturate(0%)' }" >
        </div>
        <div id="button">
            <a href="#"><img src="../../../static/IconPlayCircle.png"></a>
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
        imgL: String,
    },
}

</script>


<style scoped>
    #cardM{
        background-color: #ead2ac;
        width: 217px;
        height: 217px;
        border-radius: 10px;
        color: #273043;
    }
    #cardM #imgM img{
        margin-top: 2vh;
        height: 110px;
        border-radius: 10px;
    }
    #PresM{
        font-size: 20px;
        margin-top: -10px;
    }
    #like img{
        height: 25px;
        
    }
    #like {
        text-align: left;
        margin-left: 30px;
        margin-top: -15px;
        width: 100px;
        margin-left: 50px;
    }
    #button img{
        height: 45px;
    }
    #button{
        text-align: center;
        margin-top: -20px;
    }
    #bottomCard{
        display: flex;
    }
</style>
