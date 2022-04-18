<template>
  <input :type="type" :disabled="disabled" v-model="value" />
</template>

<script lang="ts">
import {DisabledType, InputData, InputType} from "@/lib-components/inputs/InputConstants";
import {defineComponent, PropType} from "vue";

export default defineComponent({
  name: "InputWrapper",
  data(): InputData {
    return {
      value: "",
    }
  },
  props: {
    type: {
      type: String as PropType<InputType>,
      required: true,
    },
    disabled: {
      type: String as PropType<DisabledType>,
    }
  }
});

</script>

<style scoped>

</style>