<template>
  <button type="button" :class="['btn', buttonClass]" @click="onClick">
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

// Add ripple effect the btn class. The effect starts from the click position and expands to the button's border with a radial gradient.
@mixin ripple-effect {
  position: relative;
  overflow: hidden;
  transition: transform 0.3s;

  &::after {
    content: "";
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    border-radius: inherit;
    background-image: radial-gradient(circle, #000 10%, transparent 10.01%);
    background-repeat: no-repeat;
    background-position: 50%;
    transform: scale(10, 10);
    opacity: 0;
    transition: transform 0.5s, opacity 1s;
  }

  &:active::after {
    transform: scale(0, 0);
    opacity: 0.2;
    transition: 0s;
  }
}

.btn {
  @include ripple-effect;
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
