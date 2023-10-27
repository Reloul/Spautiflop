<template>
    <div id="header">
        <h1 id="TitreSite">Spautiflop</h1>
        <h3>
            <router-link to="/inscription">Inscription</router-link> / 
            <router-link to="/connexion">Connexion</router-link>
        </h3>
    </div>
</template>

<script>
export default {
    name: 'TitreAccueil'
}
</script>

<style scoped>
    #TitreSite{
        color: white;
        text-align: left;
        margin-left: 2vw;
        margin-top: 4vh;
    }
    #header{
        display: flex;
    }
    #header h1{
        width: 50vw;
    }
    #header h3{
        color: #A7BED3;
        width: 50vw;
        text-align: right;
        float: right;
        margin-right: 2vw;
        margin-top: 5vh;
    }
    a{
        color: #A7BED3;
    }
</style>