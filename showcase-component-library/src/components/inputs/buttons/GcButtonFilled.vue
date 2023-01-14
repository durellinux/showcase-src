// Vue3 implementation of GcButtonFilled.
// GcButtonFilled uses GcButtonBase component and provides a filled style.
// The button accepts a text prop that can be appended to 'color-' and 'color-text-' to get the color from the design system tokens scss variables.
// When disabled it has a disabled background color and a text light color from the design system tokens.

<template>
  <GcButtonBase
    :disabled="disabled"
    @click="$emit('click')"
    :style="cssVars"
  >
    <slot />
  </GcButtonBase>
</template>

<script lang="ts" setup>
import GcButtonBase from './GcButtonBase.vue';
import {computed} from "vue";

// Props of GcButtonFilled
const { disabled, color } = defineProps({
  disabled: {
    type: Boolean,
    default: false,
  },
  color: {
    type: String,
    default: 'primary',
  },
});

const cssVars = computed(() => {
  return {
    '--filled-bg-color': `var(--color-${color})`,
    '--filled-text-color': `var(--color-${color}-text)`,
  }
});
</script>

<style lang="scss" scoped>
@import '../../design_system_tokens';

.gc-button {
  background-color: var(--filled-bg-color);
  color: var(--filled-text-color);
}

.gc-button--disabled {
  background-color: $color-divider-lightest;
  color: $color-text-light;
}
</style>
