<template>
  <q-layout view="lHh lpr lFf"  class="shadow-2 rounded-borders">
    <q-header elevated>
      <q-toolbar>
        <q-avatar>
          <img src="../assets/logo.jpg" />
        </q-avatar>
        <q-toolbar-title> iSpend </q-toolbar-title>
        <q-btn flat round dense icon="menu" />
      </q-toolbar>
    </q-header>
    <q-page-container >
      <ExampleView />
    </q-page-container>
  </q-layout>
</template>

<script>
import ExampleView from './ExampleView.vue'
export default {
  name: 'MainLayout',
  components: {
    ExampleView
  },
  setup() {}
}
</script>

<style scoped>
img {
  width: 5em;
}
</style>
