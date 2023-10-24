<template>
  <div id="inscription">
    <h1>Sign-Up</h1>
        <div id="input-group">
            <form action="">
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
                <div id="label">
                    <label for="ConfirmPassword">Confirmer le Mot de Passe</label>
                </div>
                <div id="input">
                    <input type="password" id="ConfirmPassword">
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
                            <input type="submit" id="submit" value="Envoyer">
                        </div>
                    </div>
                </div>
                <div id="sign-up"><a href="#">Login</a></div>
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
    }
    #inscription h1{
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
        padding: 5px;
        margin-top: 10vh;
    }
    #sign-up a{
        color: #A7BED3;
        float: right;
        font-size: 18px;
        margin-top: 10vh;
    }
    #input #profilPic{
        width: 83px;
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
</style>