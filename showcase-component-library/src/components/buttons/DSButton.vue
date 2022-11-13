<template>
  <button type="button" :class="buttonClass" @click="onClick">
    {{ label }}
  </button>
</template>

<script setup lang="ts">
import { computed, defineProps } from "vue";

interface ButtonProps {
  label: string;
  variant: "contained" | "outlined" | "text";
}

const props = defineProps<ButtonProps>();
console.log(JSON.stringify(props));

const buttonClass = computed(() => {
  console.log(props);
  switch (props.variant) {
    case "contained":
      return "btn-contained";
    case "outlined":
      return "btn-outlined";
    case "text":
      return "btn-text";
  }
  return "";
});

const onClick = () => {
  console.log("Clicked");
};
</script>

<style lang="scss">
@import "../design_system.scss";

@mixin button-auto-layout {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  padding: 11px 16px;
  gap: 10px;
}

@mixin rounded-button($border-color) {
  border: 1px solid $border-color;
  border-radius: 4px;
}

.btn-contained {
  @include button-auto-layout;
  @include typography-button;
  @include dp2;
  @include rounded-button(var(--color-primary));
  background-color: var(--color-primary);
  color: var(--color-text-light);
}

.btn-outlined {
  @include button-auto-layout;
  @include typography-button;
  @include dp2;
  @include rounded-button(var(--color-primary));
  background-color: var(--color-text-light);
  color: var(--color-primary);
}

.btn-text {
  @include button-auto-layout;
  @include typography-button;
  @include rounded-button(transparent);
  background-color: transparent;
  color: var(--color-primary);
}
</style>
