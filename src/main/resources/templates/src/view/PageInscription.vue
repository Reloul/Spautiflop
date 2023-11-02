<template>
  <div id="inscription">
    <h1>Inscription</h1>
        <div id="input-group">
            <form action="">
                <div id="label">
                    <label for="pseudonym">Pseudonyme</label>
                </div>
                <div id="input">
                    <input type="text" id="pseudonym">
                    <div id="Erreur">
                        <span id="pseudoError">Erreur, pseudo déjà pris !</span>
                    </div>
                </div>
                <div id="label">
                    <label for="password">Mot de Passe</label>
                </div>
                <div id="input">
                    <input type="password" id="password">
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
                        <input type="file" id="profilPic">
                    </div>
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
    
</style>

<style>
#main-progress{
    display: none;
}
</style>