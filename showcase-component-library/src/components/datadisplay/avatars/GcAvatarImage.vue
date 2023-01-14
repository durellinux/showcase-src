// Component to show a user avatar
// The component accepts an image src and a name.
// The name is optional and defaults to "Image".
// The name is used for accessibility purposes.
// The component adapts to the size of the container.
// The component keeps a 1:1 aspect ratio.
// The component is implemented using setup script and composition API.

<template>
<div class="avatar-container">
    <img class="avatar" :src="src" :alt="alt" />
  </div>
</template>

<script lang="ts" setup>
import {computed, defineProps} from "vue";

const { src, name } = defineProps<{
  src: string;
  name?: string;
}>();

const alt = computed(() => {
  if (name) {
    return name;
  } else {
    return "Image";
  }
});

</script>

<style lang="scss" scoped>
.avatar-container {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;
}

.avatar {
  width: 100%;
  height: 100%;
  object-fit: cover;
  border-radius: 50%;
}

</style>
