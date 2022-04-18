<template>
  <input :type="wrapperType" :disabled="wrapperDisabled" v-model="value" />
  <button @click="toggleVisibility">Show</button>
</template>


<script lang="ts">
import {defineComponent} from "vue";
import {DisabledType, InputData, InputType} from "./InputConstants";
import InputWrapper from "./InputWrapper.vue";

interface PasswordInputData extends InputData {
  visible: boolean;
}

export default defineComponent({
  name: "PasswordInput",
  components: {
    InputWrapper,
  },
  data(): PasswordInputData {
    return {
      value: "",
      visible: false,
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
      return this.disabled ? "disabled" : undefined;
    },
    wrapperType(): InputType {
      return this.visible ? "text" : "password";
    }
  },
  methods: {
    toggleVisibility(): void {
      this.visible = !this.visible;
    }
  }
});
</script>

<style scoped>

</style>