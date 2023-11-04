<template>
  <div id="inscription">
    <h1>Inscription</h1>
        <div id="input-group">
            <form action="/auth/register" method="post" enctype="multipart/form-data">
                <div id="label">
                    <label for="pseudonym">Pseudonyme</label>
                </div>
                <div id="input">
                    <input ref=pseudo type="text" id="pseudonym">
                    <div id="Erreur">
                        <span id="pseudoError">Erreur, pseudo déjà pris !</span>
                    </div>
                </div>
                <div id="label">
                    <label for="password">Mot de Passe</label>
                </div>
                <div id="input">
                    <input ref=pwd type="password" id="password">
                    <div id="Erreur">
                        <span id="mdpIError">Erreur, mot de passe non valide !</span>
                    </div>
                </div>
                <div id="label">
                    <label for="ConfirmPassword">Confirmer le Mot de Passe</label>
                </div>
                <div id="input">
                    <input type="password" id="ConfirmPassword">
                    <div id="Erreur">
                        <span id="confirmError">Erreur, pas le même mot de passe !</span>
                    </div>
                </div>
                <div id="basForm">
                    <div id="label">
                        <label for="profilPic">Photo de Profil</label>
                    </div>
                    <div id="input">
                        <input ref=photo type="file" id="profilPic">
                    </div>
                    <div id="input-temp">
                        <div id="input">
                            <v-btn id="submit" @click=register>Envoyer</v-btn>
                        </div>
                    </div>
                </div>
                <div id="sign-up"><router-link to="/connexion">Connexion</router-link></div>
            </form>
    </div>
  </div>
</template>

<script>
import { useQueryStore } from '../store/queryStore'
import {ref} from 'vue'
import {  useToast } from 'vue-toastification'
import { useRouter } from 'vue-router'
import * as global from '../util/global'

export default {
    name: 'PageInscription',
    setup() {
        const router = useRouter();
        const queryStore = useQueryStore();
        const toast = useToast();
        const pseudo = ref(null);
        const pwd = ref(null);
        const photo = ref(null);
 

        const register = async () => {
            if (pseudo.value.value === '' || pwd.value.value === '') {
                toast.error('Veuillez remplir tous les champs !');
                return;
            }

            const formData = new FormData();
            formData.append('pseudo', pseudo.value.value);
            formData.append('password', pwd.value.value);
            if(photo.value.files[0]){
                formData.append('photo', photo.value.files[0]);
            }
            
            const response = await queryStore.registerUser(formData);

            if (queryStore.HttpCode === global.OK) {
                toast.success('Inscription réussie !');
                
                setTimeout(() => {
                    router.push('/connexion');
                }, 1000);
            } else {
                if (queryStore.HttpCode === global.CONFLICT) {
                    toast.error('Nom d\'utilisateur déjà utilisé !');
                } else {
                    toast.error('Erreur dans l\'inscription !');
                }
            }

        }
        return {toast, register, pseudo, pwd, photo}
    }
}
</script>

<style scoped>
     #inscription{
        width: 30vw;
        height: 80vh;
        margin: auto;
        margin-top: 10vh;
        background-color: #3b4762;
        border-radius: 10px;
        color:#A7BED3;
    }
    #inscription h1{
        padding-top: 7vh;
        padding-bottom: 5vh;
    }
    #input-group{
        position: inherit;
        display: inline-block;
    }
    #input-group input{
        background-color: #A7BED3;
        outline: 2px solid #A7BED3;
        border: none;
        border-radius: 4px;
        width: 20vw;
        color:#3b4762;
    }

    #input-group #input{
        margin-bottom: 2vh;
    }
    #label{
        margin-bottom: 2vh;
        text-align: left;
    }
    #input #submit {
        width: 80px;
        float: left;
        padding: 5px;
        margin-top: 6vh;
    }
    #sign-up a{
        color: #A7BED3;
        float: right;
        font-size: 18px;
        margin-top: 7vh;
    }
    #input #profilPic{
        width: 98px;
        float: left;
    }
    input::file-selector-button{
        background-color: #A7BED3;
        color:#3b4762;
        border: none;
    }
    #basForm{
        display: block;
    }
    #input-temp{
        width: 5vw;
    }

     #input-group #Erreur{
        margin-top: 5px;
        color: red;
        text-align: left;
        visibility: hidden;
    }   
    #submit{
        background-color: #A7BED3;
        color:#3b4762;
        border: none;
        padding: 5rem;
    }
    

#main-progress{
    display: none;
}
    #submit{
        background-color: #A7BED3;
        color:#3b4762;
        border: none;
        padding: 5rem;
    }
</style>
