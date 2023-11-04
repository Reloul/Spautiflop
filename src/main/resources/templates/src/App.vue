<template>
  <v-app>
    <v-main class="main">
      <router-view/>
      <div v-if="!hideSongProgress">
        <SongProgress/>
      </div>
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
  computed: {
    hideSongProgress() {
      // Récupérer la route actuelle à partir du routeur
      const currentRoute = this.$route;

      // Vérifier si la meta-information hideSongProgress est définie et à true
      return currentRoute.meta.hideSongProgress === true;
    }
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
