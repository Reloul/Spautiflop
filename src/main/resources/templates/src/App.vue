<template>
  <v-app>
    <v-main class="main">
      <router-view/>
      <div>
        <SongProgress />
      </div>
>>>>>>> 4f2b384 (starting to do some stuff on pinia)
    </v-main>
  </v-app>
</template>

<script>
import PageAccueil from "./view/PageAccueil.vue";
import SongProgress from "./components/SongProgress.vue";

export default {
  name: "App",
  components: {
    PageAccueil,
    SongProgress,
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
