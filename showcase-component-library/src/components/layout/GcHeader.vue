// Page header component.
// It is used in the layout to display the page title and the page actions.
// Page title and page actions are passed as slots.
// The background is set to the primary color as defined in the design system.
// The title is aligned to the left, while the actions are aligned to the right.
// The minimum height of the header is 100px.

<template>
  <header class="header">
    <div class="header__title">
      <slot name="title" />
    </div>
    <div class="header__actions">
      <slot name="actions" />
    </div>
  </header>
</template>

<script lang="ts" setup>
</script>

<style lang="scss" scoped>
@import "../design_system_tokens.scss";

.header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0 1rem;
  background-color: $color-primary-darkest;
  color: $color-text-light;
  height: 100px;
}

.header__title {
  @include typography-heading-3;
}

.header__actions {
  display: flex;
  align-items: center;
  gap: 1rem;
}
</style>
