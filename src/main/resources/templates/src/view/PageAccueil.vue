<template>
  <div class="page">
    <TitreAccueil />
    <AccueilCentral />
  </div>
</template>

<script>
import TitreAccueil from '../components/TitreAccueil.vue'
import AccueilCentral from './AccueilCentral.vue'

export default {
  name: 'PageAccueil',
  components: {
    TitreAccueil,
    AccueilCentral,
  }

}
</script>

<style scoped>
    
</style>