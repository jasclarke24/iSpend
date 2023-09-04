<template>
  <div class="q-mt-xs">
    <q-table
      dark
      dense
      class="my-sticky-header-table"
      title="Plans"
      :rows="rows"
      :columns="columns"
      row-key="name"
    />
    <q-btn @click="loadData" dense round color="primary" icon="refresh" />
  </div>
</template>
<script>
import DataService from '../services/DataService'
import { onMounted, ref } from 'vue'

const columns = [
  {
    name: 'title',
    required: true,
    label: 'Plan Name',
    align: 'left',
    field: (row) => row.title,
    format: (val) => `${val}`,
    sortable: true
  },
  { 
    name: 'published',
    align: 'center', 
    label: 'Published', 
    field:(row) => row.published, 
    format: (val) => `${val}`,
    sortable: true },
  { 
    name: 'lastUpdated', 
    label: 'Last Updated',
    field: (row) => row.lastUpdated,
    sortable: true 
  }
]

export default {
  data: function () {
    return {
      rows: [],
      sendButtonDisable: false
    }
  },
  setup() {
    return {
      loading: ref(false),
      columns
    }
  },

  methods: {
    loadData() {
      console.log('Updating rows...')
      this.updateData()
      console.log('rows', this.rows)
    },
    updateData() {
      DataService.getAll().then((response) => {
        console.log('response', response)
        let i = 0
        while (i < response.data.length) {
          let item = response.data[i]
          let row = JSON.parse(JSON.stringify(item))
          console.log('row', row)
          this.rows[i] = row
          i++
        }
      })
    }
  }
}
</script>
<style lang="sass">
.my-sticky-header-table
  
  height: 550px 

  .q-table__top
    background-color: $primary,
  .q-table__bottom,
  thead tr:first-child th
    /* bg color is important for th; just specify one */
    background-color: $secondary
</style>
