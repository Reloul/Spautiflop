<template>
    <div id="user-resume">
        <span id="pseudo-main"> {{ userStore.pseudo }} </span>
        <img id="photo-main" :src="require('../../../static/images/ppCouzi.jpg')" alt="user-img">
    </div>
</template>

<script>
import {useUserStore} from '../store/userStore'
import { onMounted, storeToRefs } from 'vue'
import {useToast} from 'vue-toastification'
import * as global from '../util/global'

export default {
    name: 'UserTop',
    setup() {

        const userStore = useUserStore();
        const toast = useToast();

        onMounted( async () => {
            const response =  await userStore.init();
            if(await userStore.HttpCode !== global.OK)
                setTimeout(() => {
                    //  toast.error('Erreur lors de la récupération des données de l\'utilisateur ! code : ' + userStore.HttpCode);
                }, 1000);
            }
        );

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