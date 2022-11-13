<template>
  <button type="button" :class="buttonClass" @click="onClick">
    {{ label }}
  </button>
</template>

<script setup lang="ts">
import { computed, defineProps } from "vue";
import "../design_system.css";

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

<style lang="css">
.btn-contained {
  background-color: var(--color-primary);
  color: var(--color-text-light);
}

.btn-outlined {
  background-color: var(--color-text-light);
  border-width: 1px;
  border-radius: 50px;
  border-color: var(--color-primary);
  color: var(--color-primary);
}

.btn-text {
  background-color: transparent;
  color: var(--color-primary);
}
</style>
