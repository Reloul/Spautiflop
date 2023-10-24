<template>
  <div id="connexion">
    <h1>Login</h1>
    <div id="input-group">
        <div id="label">
            <label for="pseudonym">Pseudonyme</label>
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
        <div id="sign-up"><a href="#">Sign-up</a></div>
    </div>
  </div>
</template>

<script>
export default {
    name : 'PageConnexion',
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
    }
    #connexion h1{
        padding-top: 10vh;
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
        margin-bottom: 3vh;
    }
    #label{
        margin-bottom: 2vh;
        text-align: left;
    }
    #input #submit {
        width: 80px;
        float: left;
        margin-top: 10vh;
        padding: 5px;
    }
    #sign-up a{
        color: #A7BED3;
        float: right;
        margin-top: 10vh;
        font-size: 18px;
    }

</style>