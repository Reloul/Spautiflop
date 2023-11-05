<template>
  <div id="connexion">
    <h1>Connexion</h1>
    <form @submit.prevent="handleSubmit"> 
        <div id="input-group">
            <v-text-field label="Rentrez votre Pseudonyme" required id="pseudo" v-model="pseudonyme"></v-text-field>
            <div id="Erreur">
                <span id="pseudpError">Erreur, pseudo introuvable!</span>
            </div>
            <v-text-field label="Entrez votre Mot de Passe" required id="password" type="password" v-model="password"></v-text-field>
            <div id="Erreur">
                <span id="mdpError">Erreur, mauvais mot de passe!</span>
            </div>
            <div id="input">
                 <input type="submit" id="submit" value="Se Connecter">
            </div>
            <div id="sign-up"><router-link to="/inscription"> Inscription </router-link></div>
        </div>
    </form>
    </div>
</template>

<script>
import { useQueryStore } from '../store/queryStore'
import {  useToast } from 'vue-toastification'
import { useRouter } from 'vue-router'

export default {
    name : 'PageConnexion',
    setup() {
        const router = useRouter();
        const queryStore = useQueryStore();
        const toast = useToast();

        return { queryStore, toast, router }
    },
    data(){
        return{
            pseudonyme: "",
            password: "",
        }
    },
    methods: {
        async handleSubmit() {

                if(this.pseudonyme === '' || this.password === ''){
                    toast.error('Veuillez remplir tous les champs !');
                    return;
                }
                const response = await this.queryStore.loginUser(this.pseudonyme, this.password);

                if (this.queryStore.HttpCode === 200) {
                    this.toast.success('Connexion réussie !');

                    setTimeout(() => {
                        this.router.push('/pagePrincipale');
                    }, 450);
                    const res = await this.queryStore.fetchJwtJson("/auth/me");
                } else {
                    this.toast.error('Connexion échouée !');
                }
            },

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
        padding: 30px;
    }
    #input-group input{
        background-color: #A7BED3;
        outline: 2px solid #A7BED3;
        border: none;
        border-radius: 4px;
        color:#3b4762; 
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
        margin-top: 6vh;
        font-size: 18px;
    }
    #input-group #Erreur{
        margin-top: -10px;
        color: red;
        text-align: left;
        visibility: hidden ;
        margin-bottom: 20px;
    }

</style>