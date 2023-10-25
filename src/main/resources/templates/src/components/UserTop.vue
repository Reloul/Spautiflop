<template>
    <div id="user-resume">
        <span id="pseudo-main"> {{ pseudo }} </span>
        <img id="photo-main" :src="profilPicture">
    </div>
</template>

<script>
export default {
    name: 'UserTop',
    data() {
        return{
            profilPicture : require('../../../static/ppCouz.jpg'),
            pseudo : "Le Couz",
        }
    }
}
</script>

<style scoped>
    #user-resume img{
        height: 70px;
        border-radius: 50%;
        z-index: 3;
    }

    #user-resume{
        position: absolute;
        right: 5rem;
        top: 3rem;
        display: flex;
    }
    
    #user-resume #pseudo-main{
        color: #b9d1db;
        font-size: 25px;
        margin-right: 20px;
        margin-top: 20px;
    }
</style>