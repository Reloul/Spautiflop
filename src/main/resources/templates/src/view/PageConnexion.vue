<template>
  <div id="connexion">
    <h1>Connexion</h1>
        <div id="input-group">
            <div id="label">
                <label for="pseudonym">Pseudonyme</label>
            </div>
            <div id="input">
            <input ref="pseudo" type="text" id="pseudonym">
                <div id="Erreur">
                    <span id="pseudpError">Erreur, pseudo introuvable!</span>
                </div>
            </div>
            <div id="label">
                <label for="password">Mot de Passe</label>
            </div>
            <div id="input">
            <input ref="pwd" type="password" id="password">
                <div id="Erreur">
                    <span id="mdpError">Erreur, mauvais mot de passe!</span>
                </div>
            </div>
            <div id="input">
                <v-btn type="submit" id="submit" value="Envoyer" @click=login>Login</v-btn>
            </div>
            <div id="sign-up"><router-link to="/inscription"> Inscription </router-link></div>
        </div>
    </div>
</template>

<script>
import { useQueryStore } from '../store/queryStore'
import {ref} from 'vue'
import {  useToast } from 'vue-toastification'
import { useRouter } from 'vue-router'

export default {
    name : 'PageConnexion',
    setup() {
        const router = useRouter();
        const queryStore = useQueryStore();
        const toast = useToast();
        const pseudo = ref(null);
        const pwd = ref(null);

        const login = async () => {
            if(pseudo.value.value === '' || pwd.value.value === ''){
                toast.error('Veuillez remplir tous les champs !');
                return;
            }
            const response = await queryStore.loginUser(pseudo.value.value, pwd.value.value);

            if (queryStore.HttpCode === 200) {
                toast.success('Connexion réussie !');

                setTimeout(() => {
                    router.push('/pagePrincipale');
                }, 1150);
                const res = await queryStore.fetchJwtJson("/auth/me");
                console.log(await queryStore.jwt);
                console.log(await queryStore.response);
            } else {
                toast.error('Connexion échouée !');
            }
        }
        return { login, pseudo, pwd }
    }
}
</script>

<style scoped>
    #connexion{
        width: 30vw;
        height: 60vh;
        margin: auto;
        margin-top: 20vh;
        background-color: #3b4762;
        border-radius: 10px;
        color: #A7BED3;
        min-height: 500px;
        min-width: 300px;
    }
    #connexion h1{
        padding-top: 8vh;
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
    #input{
        margin-bottom: 3vh;
    }

    #label{
        margin-bottom: 2vh;
        text-align: left;
    }
    #input #submit {
        width: 120px;
        float: left;
        margin-top: 6vh;
        padding: 5px;
    }
    #sign-up a{
        color: #A7BED3;
        float: right;
        margin-top: 7vh;
        font-size: 18px;
    }
    #input-group #Erreur{
        margin-top: 5px;
        color: red;
        text-align: left;
        visibility: hidden  ;
    }

</style>