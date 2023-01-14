// Container of a block of content that is centered on the page.
// Occupies the full width available.
// The component has a 120px horizontal padding and 40px vertical padding.
// The background color is given by the parent component via the container-color class.
// The component min-height is 200px.
// The component is implemented in Vue3 with setup script and Composition API.
// The component is named GcContainer.


// Template for GcContainer component
<template>
  <div class="gc-container">
    <slot />
  </div>
</template>

// Script for GcContainer component
<script lang="ts" setup>
</script>

// Style for GcContainer component
<style lang="scss" scoped>
  .gc-container {
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 40px 120px;
    gap: 40px;
    min-height: 200px;
  }
</style>
