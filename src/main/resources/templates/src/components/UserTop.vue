<template>
    <div id="user-resume">
        <span id="pseudo-main"> {{ userStore.pseudo }} </span>
        <img id="photo-main" :src="userStore.profilPicture" alt="user-img">
    </div>
</template>

<script>
import {useUserStore} from '../store/userStore'
import { onMounted} from 'vue'

export default {
    name: 'UserTop',
    setup() {

        const userStore = useUserStore();

        onMounted( async () => {
            await userStore.init();
        });

        return { userStore };
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