<template>
  <PageAccueil />
</template>

<script>
import PageAccueil from './view/PageAccueil.vue'

export default {
  name: 'App',
  components: {
    PageAccueil,
  }
}
</script>

<style>
  #app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    top: -2vh;
    color: #a7bed3;
  }
  body{
    background-color: #273043;
  }

</style>
