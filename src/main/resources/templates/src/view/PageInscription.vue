<template>
  <div id="inscription">
    <h1>Inscription</h1>
        <div id="input-group">
            <form @submit.prevent="handleSubmit">
                <v-text-field label="Rentrez votre Pseudonyme" required id="pseudo" v-model="pseudonyme"></v-text-field>
                <div id="Erreur">
                    <span id="pseudoError">Erreur, pseudo déjà pris !</span>
                </div>

                <v-text-field label="Entrez votre Mot de Passe" required id="password" type="password" v-model="password"></v-text-field>
                <div id="Erreur">
                    <span id="mdpIError" v-show="!passwordValid">Erreur, mot de passe non valide !</span>
                </div>
                <v-text-field label="Confirmez votre Mot de Passe" required id="confirmPassword" type="password" v-model="confirmPassword"></v-text-field>       
                <div id="Erreur">
                    <span id="confirmError" v-show="passwordMismatch" >Erreur, pas le même mot de passe !</span>
                </div>
                 <v-file-input ref=image label="Photo de Profil" variant="filled" accept="image/*" prepend-icon="mdi-camera" id="profil-picture" required v-model="profilPicture"></v-file-input>
                <div id="basForm">
                    <div id="input-temp">
                        <div id="input">
                            <input type="submit" id="submit" value="S'inscrire">
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
import {  useToast } from 'vue-toastification'
import { useRouter } from 'vue-router'
import * as global from '../util/global'
import { ref } from 'vue'
export default {
    name: 'PageInscription',
    setup() {
        const router = useRouter();
        const queryStore = useQueryStore();
        const toast = useToast();
        const image = ref(null);
 

        return {toast, queryStore, image, router}
    },
    data(){
        return{
            pseudonyme: "",
            password: "",
            confirmPassword: "",
            profilPicture: [],
            passwordMismatch: false,
            passwordValid: true,
        }
    },
    methods: {
        async handleSubmit() {
                if (this.pseudonyme === '' || this.password === '') {
                    toast.error('Veuillez remplir tous les champs !');
                    return;
                }

                if(this.password === this.confirmPassword){
                    this.passwordMismatch = false;
                }else{
                    this.passwordMismatch = true;
                    this.toast.warning('Les mots de passe ne correspondent pas !');
                    return;
                }

                const regexp = /^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\S+$).{8,}$/;
                const isPasswordValid = regexp.test(this.password);

                if(!isPasswordValid){
                    this.toast.warning('Mot de passe non valide ! (8 caractères minimum, 1 majuscule, 1 minuscule, 1 chiffre)');
                    this.passwordValid = false;
                    return;
                }
                    
                this.passwordValid = true;
                  
                const formData = new FormData();
                formData.append('pseudo', this.pseudonyme);
                formData.append('password', this.password);
                if(this.image.files[0]){
                    formData.append('photo', this.image.files[0]);
                }
                
                const response = await this.queryStore.registerUser(formData);

                if (this.queryStore.HttpCode === global.OK) {
                    this.toast.success('Inscription réussie !');
                    
                    setTimeout(() => {
                        this.router.push('/connexion');
                    }, 1000);
                } else {
                    if (this.queryStore.HttpCode === global.CONFLICT) {
                        this.toast.error('Nom d\'utilisateur déjà utilisé !');
                    } else {
                        this.toast.error('Erreur dans l\'inscription !');
                    }
                }
            },
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
        padding: 5px;
        margin-top: 6vh;
    }
    #sign-up a{
        color: #A7BED3;
        float: right;
        font-size: 18px;
        margin-top: 6vh;
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
        margin-top: -10px;
        color: red;
        text-align: left;
        margin-bottom: 20px;
    }   
    #submit{
        background-color: #A7BED3;
        color:#3b4762;
        border: none;
        padding: 5rem;
    }
    
    #pseudoError{
        visibility: hidden;
    }
</style>
