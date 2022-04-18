<script lang="ts">
import { defineComponent } from 'vue';
// Uncomment import and local "components" registration if library is not registered globally.
// import { ShowcaseComponentLibraryVueSample } from '@/entry.esm';

export default defineComponent({
  name: 'ServeDev',
  // components: {
  //  ShowcaseComponentLibraryVueSample,
  // }
});
</script>

<template>
  <div id="app">
    <showcase-component-library-vue-sample />
  </div>
</template>
