// Vue implementation of GcButtonBase.
// The parent component can style the button from the outside.
// The button will emit a click event when clicked.
// The button accepts a prop to set whether the button is enabled or not.
// The button has a gc-button class, and depending on the disabled prop, it will have a gc-button--disabled or gc-button-enabled class.

// Template of GcButton
<template>
  <button
    :disabled="disabled"
    class="gc-button"
    :class="disabled ? 'gc-button--disabled' : 'gc-button--enabled'"
    @click="onClick"
  >
    <slot />
  </button>
</template>

// Script of GcButton
<script lang="ts" setup>

// Props of GcButton
const props = defineProps({
  disabled: {
    type: Boolean,
    default: false,
  }
});

// Emits of GcButton
const emits = defineEmits(['click']);
const onClick = () => emits('click');
</script>

<style lang="scss" scoped>
@import '../../design_system_tokens';

.gc-button {
  display: inline-flex;
  align-items: center;
  justify-content: center;
  min-width: 30px;
  height: 32px;
  padding: 0 16px;
  border-radius: 8px;
  border: none;
  cursor: pointer;
  @include typography-button;

  &--disabled {
    cursor: not-allowed;
  }

  &--enabled {
    @include ripple($color-divider);
  }
}

</style>
