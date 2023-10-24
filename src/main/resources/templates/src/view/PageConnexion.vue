<template>
  <div id="connexion">
    <h1>Connexion</h1>
    <form action=""> 
        <div id="input-group">
            <div id="label">
                <label for="pseudonym">Pseudonyme</label>
            </div>
            <div id="input">
                <input type="text" id="pseudonym">
                <div id="Erreur">
                    <span id="pseudpError">Erreur, pseudo introuvable!</span>
                </div>
            </div>
            <div id="label">
                <label for="password">Mot de Passe</label>
            </div>
            <div id="input">
                <input type="password" id="password">
                <div id="Erreur">
                    <span id="mdpError">Erreur, mauvais mot de passe!</span>
                </div>
            </div>
            <div id="input">
                <input type="submit" id="submit" value="Se Connecter">
            </div>
            <div id="sign-up"><router-link to="/inscription"> Inscription </router-link></div>
        </div>
        <div id="input">
            <input type="text" id="pseudonym">
        </div>
        <div id="label">
            <label for="password">Mot de Passe</label>
        </div>
        <div id="input">
            <input type="password" id="password">
        </div>
        <div id="input">
            <input type="submit" id="submit" value="Envoyer">
        </div>
        <div id="sign-up"><router-link to="/inscription"> Sign Up </router-link></div>
    </div>
    <v-icon icon="mdi-chevron-left" color="red"></v-icon>
    <v-btn @click="test">CLICK ME</v-btn>
    </form>
  </div>
</template>

<script>
import { useQueryStore } from '../store/queryStore'

export default {
    name : 'PageConnexion',
    setup() {
        const queryStore = useQueryStore();

        const test = () => {
            let formData = new FormData();
            formData.append("pseudo", "test");
            formData.append("password", "Password1");
            queryStore.fetchPost("/auth/register","multipart/form-data" , formData );
            console.log(queryStore.response);
            console.log(queryStore.status);
        }
        return { test }
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