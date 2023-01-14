// Vue3 implementation of GcButtonOutlined.
// GcButtonOutlined uses GcButtonBase component and provides an outlined button style.
// The button accepts a text prop that can be appended to 'color-' and 'color-text-' to get the color from the design system tokens scss variables.
// The background is obtained by using the variable generated using 'color-text-', while the text and the border are obtained by using the variable generated using 'color-'.
// When disabled it has a disabled background color using light color and a border and text using color-divider from the design system tokens.

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

// Props of GcButtonOutlined
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
    '--outlined-bg-color': `var(--color-${color}-text)`,
    '--outlined-text-color': `var(--color-${color})`,
    '--outlined-border-color': `var(--color-${color})`,
  }
});
</script>

<style lang="scss" scoped>
@import '../../design_system_tokens';

.gc-button {
  background-color: var(--outlined-bg-color);
  color: var(--outlined-text-color);
  border: 1px solid var(--outlined-border-color);
}

.gc-button--disabled {
  background-color: $color-text-light;
  color: $color-divider;
  border: 1px solid $color-divider;
}
</style>
