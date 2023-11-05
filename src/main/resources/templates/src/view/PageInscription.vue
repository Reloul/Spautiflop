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
                 <v-file-input label="Photo de Profil" variant="filled" accept="image/*" prepend-icon="mdi-camera" id="profil-picture" required v-model="profilPicture"></v-file-input>
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
export default {
    name: 'PageInscription',
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
        handleSubmit() {
                // Effectuez les actions que vous souhaitez avec this.inputValue
                console.log("Valeur du champ de texte :", this.pseudonyme);
                console.log("Valeur du champ de texte :", this.password);
                console.log("Valeur du champ de texte :", this.confirmPassword);
                console.log("Valeur du champ de texte :", this.profilPicture);
                if(this.password === this.confirmPassword){
                    console.log("good");
                    this.passwordMismatch = false;
                }else{
                    this.passwordMismatch = true;
                    console.log("not good");
                }

                const regexp = /^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\S+$).{8,}$/;
                const isPasswordValid = regexp.test(this.password);

                if(isPasswordValid){
                    console.log("Tout est bon");
                    this.passwordValid = true;
                }else{
                    this.passwordValid = false;
                    console.log("Tout est pas bon");
                }
                
                // Appelez votre fonction ici
                this.maFonction(this.pseudonyme);
                this.maFonction(this.password);
                this.maFonction(this.confirmPassword);
                this.maFonction(this.profilPicture);
            },
            maFonction(valeur) {
                // Faites quelque chose avec la valeur du champ de texte
                console.log("Fonction appelée avec la valeur :", valeur);
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
    
    #pseudoError{
        visibility: hidden;
    }
</style>
