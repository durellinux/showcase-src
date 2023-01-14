// Vue3 implementation of GcButtonText.
// GcButtonText uses GcButtonBase component and provides a text only button style.
// The button accepts a text prop that can be appended to 'color-' to get the color from the design system tokens scss variables.
// The background is transparent, while the text is obtained by using the variable generated using 'color-'.
// When disabled it uses color-divider from the design system tokens for the text.

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

// Props of GcButtonText
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
    '--text-text-color': `var(--color-${color})`,
  }
});
</script>

<style lang="scss" scoped>
@import '../../design_system_tokens';

.gc-button {
  background-color: transparent;
  color: var(--text-text-color);
}

.gc-button--disabled {
  color: $color-divider;
}
</style>
