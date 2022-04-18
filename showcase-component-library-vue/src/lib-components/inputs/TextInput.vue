<template>
  <input-wrapper type="text" :disabled="wrapperDisabled" v-model="value" />
</template>

<script lang="ts">
import {defineComponent} from "vue";
import {DisabledType, InputData} from "./InputConstants";
import InputWrapper from "./InputWrapper.vue";

export default defineComponent({
  name: "TextInput",
  components: {
    InputWrapper,
  },
  data(): InputData {
    return {
      value: "",
    }
  },
  props: {
    disabled: {
      type: Boolean,
      default: false,
    }
  },
  computed: {
    wrapperDisabled(): DisabledType {
      console.log(this.disabled);
      return this.disabled ? "disabled" : undefined;
    }
  }
});
</script>

<style scoped>

</style>