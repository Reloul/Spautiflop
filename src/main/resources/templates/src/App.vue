<template>
  <v-app>
    <v-main class="main">
<<<<<<< HEAD
      <router-view/>
=======
      <PageConnexionVue />
>>>>>>> 01dcf40 (starting to do some stuff on pinia)
    </v-main>
  </v-app>
</template>

<script>
import PageConnexionVue from './view/PageConnexion.vue';

export default {
  name: "App",
  components: {
    PageConnexionVue,
  },
};
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
body, .main {
  background-color: #273043;
}
</style>
