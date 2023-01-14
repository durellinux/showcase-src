// Card component named GcCard.
// The component has an image and content provided by slots.
// The image is displayed on the top of the card and the content on the bottom.
// The component has a 20px bottom padding.
// The component has rounded edges.
// The image is scaled to fit the width of the image container, but the ratio is kept.
// The card has a width of 250px.
// The content has 10px top padding, and 10px horizontal padding.
// The content min-height is 100px.
// The component is implemented in Vue3 with setup script and Composition API.

<template>
  <div class="gc-card">
    <div class="gc-card__image">
      <slot name="image" />
    </div>
    <div class="gc-card__content">
      <slot name="content"/>
    </div>
  </div>
</template>

<script lang="ts" setup>
</script>

<style lang="scss" scoped>
  @import "../../design_system_tokens.scss";

  .gc-card {
    width: 250px;
    padding-bottom: 20px;
    border-radius: 10px;
    overflow: hidden;
    border: 1px solid $color-divider-lightest;
  }

  .gc-card__image {
    width: 250px;
    height: 150px;
    overflow: hidden;
  }

  .gc-card__content {
    padding: 10px 10px 0 10px;
    min-height: 100px;
  }
</style>
